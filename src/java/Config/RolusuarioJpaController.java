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
import Entity.Rol;
import Entity.Rolusuario;
import Entity.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author ZAYRA
 */
public class RolusuarioJpaController implements Serializable {

    public RolusuarioJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rolusuario rolusuario) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Rol idRol = rolusuario.getIdRol();
            if (idRol != null) {
                idRol = em.getReference(idRol.getClass(), idRol.getIdRol());
                rolusuario.setIdRol(idRol);
            }
            Usuario idUsu = rolusuario.getIdUsu();
            if (idUsu != null) {
                idUsu = em.getReference(idUsu.getClass(), idUsu.getIdUsu());
                rolusuario.setIdUsu(idUsu);
            }
            em.persist(rolusuario);
            if (idRol != null) {
                idRol.getRolusuarioList().add(rolusuario);
                idRol = em.merge(idRol);
            }
            if (idUsu != null) {
                idUsu.getRolusuarioList().add(rolusuario);
                idUsu = em.merge(idUsu);
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

    public void edit(Rolusuario rolusuario) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Rolusuario persistentRolusuario = em.find(Rolusuario.class, rolusuario.getIdRolUsu());
            Rol idRolOld = persistentRolusuario.getIdRol();
            Rol idRolNew = rolusuario.getIdRol();
            Usuario idUsuOld = persistentRolusuario.getIdUsu();
            Usuario idUsuNew = rolusuario.getIdUsu();
            if (idRolNew != null) {
                idRolNew = em.getReference(idRolNew.getClass(), idRolNew.getIdRol());
                rolusuario.setIdRol(idRolNew);
            }
            if (idUsuNew != null) {
                idUsuNew = em.getReference(idUsuNew.getClass(), idUsuNew.getIdUsu());
                rolusuario.setIdUsu(idUsuNew);
            }
            rolusuario = em.merge(rolusuario);
            if (idRolOld != null && !idRolOld.equals(idRolNew)) {
                idRolOld.getRolusuarioList().remove(rolusuario);
                idRolOld = em.merge(idRolOld);
            }
            if (idRolNew != null && !idRolNew.equals(idRolOld)) {
                idRolNew.getRolusuarioList().add(rolusuario);
                idRolNew = em.merge(idRolNew);
            }
            if (idUsuOld != null && !idUsuOld.equals(idUsuNew)) {
                idUsuOld.getRolusuarioList().remove(rolusuario);
                idUsuOld = em.merge(idUsuOld);
            }
            if (idUsuNew != null && !idUsuNew.equals(idUsuOld)) {
                idUsuNew.getRolusuarioList().add(rolusuario);
                idUsuNew = em.merge(idUsuNew);
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
                Integer id = rolusuario.getIdRolUsu();
                if (findRolusuario(id) == null) {
                    throw new NonexistentEntityException("The rolusuario with id " + id + " no longer exists.");
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
            Rolusuario rolusuario;
            try {
                rolusuario = em.getReference(Rolusuario.class, id);
                rolusuario.getIdRolUsu();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rolusuario with id " + id + " no longer exists.", enfe);
            }
            Rol idRol = rolusuario.getIdRol();
            if (idRol != null) {
                idRol.getRolusuarioList().remove(rolusuario);
                idRol = em.merge(idRol);
            }
            Usuario idUsu = rolusuario.getIdUsu();
            if (idUsu != null) {
                idUsu.getRolusuarioList().remove(rolusuario);
                idUsu = em.merge(idUsu);
            }
            em.remove(rolusuario);
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

    public List<Rolusuario> findRolusuarioEntities() {
        return findRolusuarioEntities(true, -1, -1);
    }

    public List<Rolusuario> findRolusuarioEntities(int maxResults, int firstResult) {
        return findRolusuarioEntities(false, maxResults, firstResult);
    }

    private List<Rolusuario> findRolusuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rolusuario.class));
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

    public Rolusuario findRolusuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rolusuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolusuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rolusuario> rt = cq.from(Rolusuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
