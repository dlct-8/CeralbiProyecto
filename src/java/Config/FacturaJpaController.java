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
import Entity.Cliente;
import Entity.Factura;
import Entity.Pedido;
import Entity.Vendedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author ZAYRA
 */
public class FacturaJpaController implements Serializable {

    public FacturaJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Factura factura) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Cliente idCli = factura.getIdCli();
            if (idCli != null) {
                idCli = em.getReference(idCli.getClass(), idCli.getIdCli());
                factura.setIdCli(idCli);
            }
            Pedido idPed = factura.getIdPed();
            if (idPed != null) {
                idPed = em.getReference(idPed.getClass(), idPed.getIdPed());
                factura.setIdPed(idPed);
            }
            Vendedor idVen = factura.getIdVen();
            if (idVen != null) {
                idVen = em.getReference(idVen.getClass(), idVen.getIdVen());
                factura.setIdVen(idVen);
            }
            em.persist(factura);
            if (idCli != null) {
                idCli.getFacturaList().add(factura);
                idCli = em.merge(idCli);
            }
            if (idPed != null) {
                idPed.getFacturaList().add(factura);
                idPed = em.merge(idPed);
            }
            if (idVen != null) {
                idVen.getFacturaList().add(factura);
                idVen = em.merge(idVen);
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

    public void edit(Factura factura) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Factura persistentFactura = em.find(Factura.class, factura.getIdfac());
            Cliente idCliOld = persistentFactura.getIdCli();
            Cliente idCliNew = factura.getIdCli();
            Pedido idPedOld = persistentFactura.getIdPed();
            Pedido idPedNew = factura.getIdPed();
            Vendedor idVenOld = persistentFactura.getIdVen();
            Vendedor idVenNew = factura.getIdVen();
            if (idCliNew != null) {
                idCliNew = em.getReference(idCliNew.getClass(), idCliNew.getIdCli());
                factura.setIdCli(idCliNew);
            }
            if (idPedNew != null) {
                idPedNew = em.getReference(idPedNew.getClass(), idPedNew.getIdPed());
                factura.setIdPed(idPedNew);
            }
            if (idVenNew != null) {
                idVenNew = em.getReference(idVenNew.getClass(), idVenNew.getIdVen());
                factura.setIdVen(idVenNew);
            }
            factura = em.merge(factura);
            if (idCliOld != null && !idCliOld.equals(idCliNew)) {
                idCliOld.getFacturaList().remove(factura);
                idCliOld = em.merge(idCliOld);
            }
            if (idCliNew != null && !idCliNew.equals(idCliOld)) {
                idCliNew.getFacturaList().add(factura);
                idCliNew = em.merge(idCliNew);
            }
            if (idPedOld != null && !idPedOld.equals(idPedNew)) {
                idPedOld.getFacturaList().remove(factura);
                idPedOld = em.merge(idPedOld);
            }
            if (idPedNew != null && !idPedNew.equals(idPedOld)) {
                idPedNew.getFacturaList().add(factura);
                idPedNew = em.merge(idPedNew);
            }
            if (idVenOld != null && !idVenOld.equals(idVenNew)) {
                idVenOld.getFacturaList().remove(factura);
                idVenOld = em.merge(idVenOld);
            }
            if (idVenNew != null && !idVenNew.equals(idVenOld)) {
                idVenNew.getFacturaList().add(factura);
                idVenNew = em.merge(idVenNew);
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
                Integer id = factura.getIdfac();
                if (findFactura(id) == null) {
                    throw new NonexistentEntityException("The factura with id " + id + " no longer exists.");
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
            Factura factura;
            try {
                factura = em.getReference(Factura.class, id);
                factura.getIdfac();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The factura with id " + id + " no longer exists.", enfe);
            }
            Cliente idCli = factura.getIdCli();
            if (idCli != null) {
                idCli.getFacturaList().remove(factura);
                idCli = em.merge(idCli);
            }
            Pedido idPed = factura.getIdPed();
            if (idPed != null) {
                idPed.getFacturaList().remove(factura);
                idPed = em.merge(idPed);
            }
            Vendedor idVen = factura.getIdVen();
            if (idVen != null) {
                idVen.getFacturaList().remove(factura);
                idVen = em.merge(idVen);
            }
            em.remove(factura);
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

    public List<Factura> findFacturaEntities() {
        return findFacturaEntities(true, -1, -1);
    }

    public List<Factura> findFacturaEntities(int maxResults, int firstResult) {
        return findFacturaEntities(false, maxResults, firstResult);
    }

    private List<Factura> findFacturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Factura.class));
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

    public Factura findFactura(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Factura.class, id);
        } finally {
            em.close();
        }
    }

    public int getFacturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Factura> rt = cq.from(Factura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
