/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Config.exceptions.IllegalOrphanException;
import Config.exceptions.NonexistentEntityException;
import Config.exceptions.RollbackFailureException;
import Entity.Mediopago;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entity.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author ZAYRA
 */
public class MediopagoJpaController implements Serializable {

    public MediopagoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mediopago mediopago) throws RollbackFailureException, Exception {
        if (mediopago.getVentaList() == null) {
            mediopago.setVentaList(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : mediopago.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdVent());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            mediopago.setVentaList(attachedVentaList);
            em.persist(mediopago);
            for (Venta ventaListVenta : mediopago.getVentaList()) {
                Mediopago oldIdmedOfVentaListVenta = ventaListVenta.getIdmed();
                ventaListVenta.setIdmed(mediopago);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldIdmedOfVentaListVenta != null) {
                    oldIdmedOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldIdmedOfVentaListVenta = em.merge(oldIdmedOfVentaListVenta);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mediopago mediopago) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Mediopago persistentMediopago = em.find(Mediopago.class, mediopago.getIdmed());
            List<Venta> ventaListOld = persistentMediopago.getVentaList();
            List<Venta> ventaListNew = mediopago.getVentaList();
            List<String> illegalOrphanMessages = null;
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaListOldVenta + " since its idmed field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdVent());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            mediopago.setVentaList(ventaListNew);
            mediopago = em.merge(mediopago);
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Mediopago oldIdmedOfVentaListNewVenta = ventaListNewVenta.getIdmed();
                    ventaListNewVenta.setIdmed(mediopago);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldIdmedOfVentaListNewVenta != null && !oldIdmedOfVentaListNewVenta.equals(mediopago)) {
                        oldIdmedOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldIdmedOfVentaListNewVenta = em.merge(oldIdmedOfVentaListNewVenta);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mediopago.getIdmed();
                if (findMediopago(id) == null) {
                    throw new NonexistentEntityException("The mediopago with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Mediopago mediopago;
            try {
                mediopago = em.getReference(Mediopago.class, id);
                mediopago.getIdmed();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mediopago with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Venta> ventaListOrphanCheck = mediopago.getVentaList();
            for (Venta ventaListOrphanCheckVenta : ventaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mediopago (" + mediopago + ") cannot be destroyed since the Venta " + ventaListOrphanCheckVenta + " in its ventaList field has a non-nullable idmed field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(mediopago);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mediopago> findMediopagoEntities() {
        return findMediopagoEntities(true, -1, -1);
    }

    public List<Mediopago> findMediopagoEntities(int maxResults, int firstResult) {
        return findMediopagoEntities(false, maxResults, firstResult);
    }

    private List<Mediopago> findMediopagoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mediopago.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Mediopago findMediopago(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mediopago.class, id);
        } finally {
            em.close();
        }
    }

    public int getMediopagoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mediopago> rt = cq.from(Mediopago.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
