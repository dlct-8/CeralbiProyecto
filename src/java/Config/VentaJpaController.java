/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Config.exceptions.NonexistentEntityException;
import Config.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entity.Pedido;
import Entity.Mediopago;
import Entity.Metodoenvio;
import Entity.Venta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author ZAYRA
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Pedido idPed = venta.getIdPed();
            if (idPed != null) {
                idPed = em.getReference(idPed.getClass(), idPed.getIdPed());
                venta.setIdPed(idPed);
            }
            Mediopago idmed = venta.getIdmed();
            if (idmed != null) {
                idmed = em.getReference(idmed.getClass(), idmed.getIdmed());
                venta.setIdmed(idmed);
            }
            Metodoenvio idmet = venta.getIdmet();
            if (idmet != null) {
                idmet = em.getReference(idmet.getClass(), idmet.getIdmet());
                venta.setIdmet(idmet);
            }
            em.persist(venta);
            if (idPed != null) {
                idPed.getVentaList().add(venta);
                idPed = em.merge(idPed);
            }
            if (idmed != null) {
                idmed.getVentaList().add(venta);
                idmed = em.merge(idmed);
            }
            if (idmet != null) {
                idmet.getVentaList().add(venta);
                idmet = em.merge(idmet);
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

    public void edit(Venta venta) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Venta persistentVenta = em.find(Venta.class, venta.getIdVent());
            Pedido idPedOld = persistentVenta.getIdPed();
            Pedido idPedNew = venta.getIdPed();
            Mediopago idmedOld = persistentVenta.getIdmed();
            Mediopago idmedNew = venta.getIdmed();
            Metodoenvio idmetOld = persistentVenta.getIdmet();
            Metodoenvio idmetNew = venta.getIdmet();
            if (idPedNew != null) {
                idPedNew = em.getReference(idPedNew.getClass(), idPedNew.getIdPed());
                venta.setIdPed(idPedNew);
            }
            if (idmedNew != null) {
                idmedNew = em.getReference(idmedNew.getClass(), idmedNew.getIdmed());
                venta.setIdmed(idmedNew);
            }
            if (idmetNew != null) {
                idmetNew = em.getReference(idmetNew.getClass(), idmetNew.getIdmet());
                venta.setIdmet(idmetNew);
            }
            venta = em.merge(venta);
            if (idPedOld != null && !idPedOld.equals(idPedNew)) {
                idPedOld.getVentaList().remove(venta);
                idPedOld = em.merge(idPedOld);
            }
            if (idPedNew != null && !idPedNew.equals(idPedOld)) {
                idPedNew.getVentaList().add(venta);
                idPedNew = em.merge(idPedNew);
            }
            if (idmedOld != null && !idmedOld.equals(idmedNew)) {
                idmedOld.getVentaList().remove(venta);
                idmedOld = em.merge(idmedOld);
            }
            if (idmedNew != null && !idmedNew.equals(idmedOld)) {
                idmedNew.getVentaList().add(venta);
                idmedNew = em.merge(idmedNew);
            }
            if (idmetOld != null && !idmetOld.equals(idmetNew)) {
                idmetOld.getVentaList().remove(venta);
                idmetOld = em.merge(idmetOld);
            }
            if (idmetNew != null && !idmetNew.equals(idmetOld)) {
                idmetNew.getVentaList().add(venta);
                idmetNew = em.merge(idmetNew);
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
                Integer id = venta.getIdVent();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getIdVent();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Pedido idPed = venta.getIdPed();
            if (idPed != null) {
                idPed.getVentaList().remove(venta);
                idPed = em.merge(idPed);
            }
            Mediopago idmed = venta.getIdmed();
            if (idmed != null) {
                idmed.getVentaList().remove(venta);
                idmed = em.merge(idmed);
            }
            Metodoenvio idmet = venta.getIdmet();
            if (idmet != null) {
                idmet.getVentaList().remove(venta);
                idmet = em.merge(idmet);
            }
            em.remove(venta);
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

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
