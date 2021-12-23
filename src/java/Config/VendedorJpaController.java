/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Config.exceptions.IllegalOrphanException;
import Config.exceptions.NonexistentEntityException;
import Config.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entity.Usuario;
import Entity.Factura;
import Entity.Vendedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author ZAYRA
 */
public class VendedorJpaController implements Serializable {

    public VendedorJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vendedor vendedor) throws RollbackFailureException, Exception {
        if (vendedor.getFacturaList() == null) {
            vendedor.setFacturaList(new ArrayList<Factura>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario idUsu = vendedor.getIdUsu();
            if (idUsu != null) {
                idUsu = em.getReference(idUsu.getClass(), idUsu.getIdUsu());
                vendedor.setIdUsu(idUsu);
            }
            List<Factura> attachedFacturaList = new ArrayList<Factura>();
            for (Factura facturaListFacturaToAttach : vendedor.getFacturaList()) {
                facturaListFacturaToAttach = em.getReference(facturaListFacturaToAttach.getClass(), facturaListFacturaToAttach.getIdfac());
                attachedFacturaList.add(facturaListFacturaToAttach);
            }
            vendedor.setFacturaList(attachedFacturaList);
            em.persist(vendedor);
            if (idUsu != null) {
                idUsu.getVendedorList().add(vendedor);
                idUsu = em.merge(idUsu);
            }
            for (Factura facturaListFactura : vendedor.getFacturaList()) {
                Vendedor oldIdVenOfFacturaListFactura = facturaListFactura.getIdVen();
                facturaListFactura.setIdVen(vendedor);
                facturaListFactura = em.merge(facturaListFactura);
                if (oldIdVenOfFacturaListFactura != null) {
                    oldIdVenOfFacturaListFactura.getFacturaList().remove(facturaListFactura);
                    oldIdVenOfFacturaListFactura = em.merge(oldIdVenOfFacturaListFactura);
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

    public void edit(Vendedor vendedor) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Vendedor persistentVendedor = em.find(Vendedor.class, vendedor.getIdVen());
            Usuario idUsuOld = persistentVendedor.getIdUsu();
            Usuario idUsuNew = vendedor.getIdUsu();
            List<Factura> facturaListOld = persistentVendedor.getFacturaList();
            List<Factura> facturaListNew = vendedor.getFacturaList();
            List<String> illegalOrphanMessages = null;
            for (Factura facturaListOldFactura : facturaListOld) {
                if (!facturaListNew.contains(facturaListOldFactura)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Factura " + facturaListOldFactura + " since its idVen field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idUsuNew != null) {
                idUsuNew = em.getReference(idUsuNew.getClass(), idUsuNew.getIdUsu());
                vendedor.setIdUsu(idUsuNew);
            }
            List<Factura> attachedFacturaListNew = new ArrayList<Factura>();
            for (Factura facturaListNewFacturaToAttach : facturaListNew) {
                facturaListNewFacturaToAttach = em.getReference(facturaListNewFacturaToAttach.getClass(), facturaListNewFacturaToAttach.getIdfac());
                attachedFacturaListNew.add(facturaListNewFacturaToAttach);
            }
            facturaListNew = attachedFacturaListNew;
            vendedor.setFacturaList(facturaListNew);
            vendedor = em.merge(vendedor);
            if (idUsuOld != null && !idUsuOld.equals(idUsuNew)) {
                idUsuOld.getVendedorList().remove(vendedor);
                idUsuOld = em.merge(idUsuOld);
            }
            if (idUsuNew != null && !idUsuNew.equals(idUsuOld)) {
                idUsuNew.getVendedorList().add(vendedor);
                idUsuNew = em.merge(idUsuNew);
            }
            for (Factura facturaListNewFactura : facturaListNew) {
                if (!facturaListOld.contains(facturaListNewFactura)) {
                    Vendedor oldIdVenOfFacturaListNewFactura = facturaListNewFactura.getIdVen();
                    facturaListNewFactura.setIdVen(vendedor);
                    facturaListNewFactura = em.merge(facturaListNewFactura);
                    if (oldIdVenOfFacturaListNewFactura != null && !oldIdVenOfFacturaListNewFactura.equals(vendedor)) {
                        oldIdVenOfFacturaListNewFactura.getFacturaList().remove(facturaListNewFactura);
                        oldIdVenOfFacturaListNewFactura = em.merge(oldIdVenOfFacturaListNewFactura);
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
                Integer id = vendedor.getIdVen();
                if (findVendedor(id) == null) {
                    throw new NonexistentEntityException("The vendedor with id " + id + " no longer exists.");
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
            Vendedor vendedor;
            try {
                vendedor = em.getReference(Vendedor.class, id);
                vendedor.getIdVen();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Factura> facturaListOrphanCheck = vendedor.getFacturaList();
            for (Factura facturaListOrphanCheckFactura : facturaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vendedor (" + vendedor + ") cannot be destroyed since the Factura " + facturaListOrphanCheckFactura + " in its facturaList field has a non-nullable idVen field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Usuario idUsu = vendedor.getIdUsu();
            if (idUsu != null) {
                idUsu.getVendedorList().remove(vendedor);
                idUsu = em.merge(idUsu);
            }
            em.remove(vendedor);
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

    public List<Vendedor> findVendedorEntities() {
        return findVendedorEntities(true, -1, -1);
    }

    public List<Vendedor> findVendedorEntities(int maxResults, int firstResult) {
        return findVendedorEntities(false, maxResults, firstResult);
    }

    private List<Vendedor> findVendedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedor.class));
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

    public Vendedor findVendedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedor> rt = cq.from(Vendedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
