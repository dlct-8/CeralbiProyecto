/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import Config.exceptions.IllegalOrphanException;
import Config.exceptions.NonexistentEntityException;
import Config.exceptions.RollbackFailureException;
import Entity.Rol;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Entity.Rolusuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author ZAYRA
 */
public class RolJpaController implements Serializable {

    public RolJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Rol rol) throws RollbackFailureException, Exception {
        if (rol.getRolusuarioList() == null) {
            rol.setRolusuarioList(new ArrayList<Rolusuario>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Rolusuario> attachedRolusuarioList = new ArrayList<Rolusuario>();
            for (Rolusuario rolusuarioListRolusuarioToAttach : rol.getRolusuarioList()) {
                rolusuarioListRolusuarioToAttach = em.getReference(rolusuarioListRolusuarioToAttach.getClass(), rolusuarioListRolusuarioToAttach.getIdRolUsu());
                attachedRolusuarioList.add(rolusuarioListRolusuarioToAttach);
            }
            rol.setRolusuarioList(attachedRolusuarioList);
            em.persist(rol);
            for (Rolusuario rolusuarioListRolusuario : rol.getRolusuarioList()) {
                Rol oldIdRolOfRolusuarioListRolusuario = rolusuarioListRolusuario.getIdRol();
                rolusuarioListRolusuario.setIdRol(rol);
                rolusuarioListRolusuario = em.merge(rolusuarioListRolusuario);
                if (oldIdRolOfRolusuarioListRolusuario != null) {
                    oldIdRolOfRolusuarioListRolusuario.getRolusuarioList().remove(rolusuarioListRolusuario);
                    oldIdRolOfRolusuarioListRolusuario = em.merge(oldIdRolOfRolusuarioListRolusuario);
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

    public void edit(Rol rol) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Rol persistentRol = em.find(Rol.class, rol.getIdRol());
            List<Rolusuario> rolusuarioListOld = persistentRol.getRolusuarioList();
            List<Rolusuario> rolusuarioListNew = rol.getRolusuarioList();
            List<String> illegalOrphanMessages = null;
            for (Rolusuario rolusuarioListOldRolusuario : rolusuarioListOld) {
                if (!rolusuarioListNew.contains(rolusuarioListOldRolusuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Rolusuario " + rolusuarioListOldRolusuario + " since its idRol field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Rolusuario> attachedRolusuarioListNew = new ArrayList<Rolusuario>();
            for (Rolusuario rolusuarioListNewRolusuarioToAttach : rolusuarioListNew) {
                rolusuarioListNewRolusuarioToAttach = em.getReference(rolusuarioListNewRolusuarioToAttach.getClass(), rolusuarioListNewRolusuarioToAttach.getIdRolUsu());
                attachedRolusuarioListNew.add(rolusuarioListNewRolusuarioToAttach);
            }
            rolusuarioListNew = attachedRolusuarioListNew;
            rol.setRolusuarioList(rolusuarioListNew);
            rol = em.merge(rol);
            for (Rolusuario rolusuarioListNewRolusuario : rolusuarioListNew) {
                if (!rolusuarioListOld.contains(rolusuarioListNewRolusuario)) {
                    Rol oldIdRolOfRolusuarioListNewRolusuario = rolusuarioListNewRolusuario.getIdRol();
                    rolusuarioListNewRolusuario.setIdRol(rol);
                    rolusuarioListNewRolusuario = em.merge(rolusuarioListNewRolusuario);
                    if (oldIdRolOfRolusuarioListNewRolusuario != null && !oldIdRolOfRolusuarioListNewRolusuario.equals(rol)) {
                        oldIdRolOfRolusuarioListNewRolusuario.getRolusuarioList().remove(rolusuarioListNewRolusuario);
                        oldIdRolOfRolusuarioListNewRolusuario = em.merge(oldIdRolOfRolusuarioListNewRolusuario);
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
                Integer id = rol.getIdRol();
                if (findRol(id) == null) {
                    throw new NonexistentEntityException("The rol with id " + id + " no longer exists.");
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
            Rol rol;
            try {
                rol = em.getReference(Rol.class, id);
                rol.getIdRol();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The rol with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Rolusuario> rolusuarioListOrphanCheck = rol.getRolusuarioList();
            for (Rolusuario rolusuarioListOrphanCheckRolusuario : rolusuarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Rol (" + rol + ") cannot be destroyed since the Rolusuario " + rolusuarioListOrphanCheckRolusuario + " in its rolusuarioList field has a non-nullable idRol field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(rol);
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

    public List<Rol> findRolEntities() {
        return findRolEntities(true, -1, -1);
    }

    public List<Rol> findRolEntities(int maxResults, int firstResult) {
        return findRolEntities(false, maxResults, firstResult);
    }

    private List<Rol> findRolEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Rol.class));
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

    public Rol findRol(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Rol.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Rol> rt = cq.from(Rol.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
