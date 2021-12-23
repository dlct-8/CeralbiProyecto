/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Config.exceptions.IllegalOrphanException;
import Config.exceptions.NonexistentEntityException;
import Config.exceptions.RollbackFailureException;
import Entity.Metodoenvio;
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
public class MetodoenvioJpaController implements Serializable {

    public MetodoenvioJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Metodoenvio metodoenvio) throws RollbackFailureException, Exception {
        if (metodoenvio.getVentaList() == null) {
            metodoenvio.setVentaList(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : metodoenvio.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdVent());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            metodoenvio.setVentaList(attachedVentaList);
            em.persist(metodoenvio);
            for (Venta ventaListVenta : metodoenvio.getVentaList()) {
                Metodoenvio oldIdmetOfVentaListVenta = ventaListVenta.getIdmet();
                ventaListVenta.setIdmet(metodoenvio);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldIdmetOfVentaListVenta != null) {
                    oldIdmetOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldIdmetOfVentaListVenta = em.merge(oldIdmetOfVentaListVenta);
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

    public void edit(Metodoenvio metodoenvio) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Metodoenvio persistentMetodoenvio = em.find(Metodoenvio.class, metodoenvio.getIdmet());
            List<Venta> ventaListOld = persistentMetodoenvio.getVentaList();
            List<Venta> ventaListNew = metodoenvio.getVentaList();
            List<String> illegalOrphanMessages = null;
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaListOldVenta + " since its idmet field is not nullable.");
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
            metodoenvio.setVentaList(ventaListNew);
            metodoenvio = em.merge(metodoenvio);
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Metodoenvio oldIdmetOfVentaListNewVenta = ventaListNewVenta.getIdmet();
                    ventaListNewVenta.setIdmet(metodoenvio);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldIdmetOfVentaListNewVenta != null && !oldIdmetOfVentaListNewVenta.equals(metodoenvio)) {
                        oldIdmetOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldIdmetOfVentaListNewVenta = em.merge(oldIdmetOfVentaListNewVenta);
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
                Integer id = metodoenvio.getIdmet();
                if (findMetodoenvio(id) == null) {
                    throw new NonexistentEntityException("The metodoenvio with id " + id + " no longer exists.");
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
            Metodoenvio metodoenvio;
            try {
                metodoenvio = em.getReference(Metodoenvio.class, id);
                metodoenvio.getIdmet();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The metodoenvio with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Venta> ventaListOrphanCheck = metodoenvio.getVentaList();
            for (Venta ventaListOrphanCheckVenta : ventaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Metodoenvio (" + metodoenvio + ") cannot be destroyed since the Venta " + ventaListOrphanCheckVenta + " in its ventaList field has a non-nullable idmet field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(metodoenvio);
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

    public List<Metodoenvio> findMetodoenvioEntities() {
        return findMetodoenvioEntities(true, -1, -1);
    }

    public List<Metodoenvio> findMetodoenvioEntities(int maxResults, int firstResult) {
        return findMetodoenvioEntities(false, maxResults, firstResult);
    }

    private List<Metodoenvio> findMetodoenvioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Metodoenvio.class));
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

    public Metodoenvio findMetodoenvio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Metodoenvio.class, id);
        } finally {
            em.close();
        }
    }

    public int getMetodoenvioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Metodoenvio> rt = cq.from(Metodoenvio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
