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
import Entity.Vendedor;
import java.util.ArrayList;
import java.util.List;
import Entity.Rolusuario;
import Entity.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author ZAYRA
 */
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws RollbackFailureException, Exception {
        if (usuario.getVendedorList() == null) {
            usuario.setVendedorList(new ArrayList<Vendedor>());
        }
        if (usuario.getRolusuarioList() == null) {
            usuario.setRolusuarioList(new ArrayList<Rolusuario>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            List<Vendedor> attachedVendedorList = new ArrayList<Vendedor>();
            for (Vendedor vendedorListVendedorToAttach : usuario.getVendedorList()) {
                vendedorListVendedorToAttach = em.getReference(vendedorListVendedorToAttach.getClass(), vendedorListVendedorToAttach.getIdVen());
                attachedVendedorList.add(vendedorListVendedorToAttach);
            }
            usuario.setVendedorList(attachedVendedorList);
            List<Rolusuario> attachedRolusuarioList = new ArrayList<Rolusuario>();
            for (Rolusuario rolusuarioListRolusuarioToAttach : usuario.getRolusuarioList()) {
                rolusuarioListRolusuarioToAttach = em.getReference(rolusuarioListRolusuarioToAttach.getClass(), rolusuarioListRolusuarioToAttach.getIdRolUsu());
                attachedRolusuarioList.add(rolusuarioListRolusuarioToAttach);
            }
            usuario.setRolusuarioList(attachedRolusuarioList);
            em.persist(usuario);
            for (Vendedor vendedorListVendedor : usuario.getVendedorList()) {
                Usuario oldIdUsuOfVendedorListVendedor = vendedorListVendedor.getIdUsu();
                vendedorListVendedor.setIdUsu(usuario);
                vendedorListVendedor = em.merge(vendedorListVendedor);
                if (oldIdUsuOfVendedorListVendedor != null) {
                    oldIdUsuOfVendedorListVendedor.getVendedorList().remove(vendedorListVendedor);
                    oldIdUsuOfVendedorListVendedor = em.merge(oldIdUsuOfVendedorListVendedor);
                }
            }
            for (Rolusuario rolusuarioListRolusuario : usuario.getRolusuarioList()) {
                Usuario oldIdUsuOfRolusuarioListRolusuario = rolusuarioListRolusuario.getIdUsu();
                rolusuarioListRolusuario.setIdUsu(usuario);
                rolusuarioListRolusuario = em.merge(rolusuarioListRolusuario);
                if (oldIdUsuOfRolusuarioListRolusuario != null) {
                    oldIdUsuOfRolusuarioListRolusuario.getRolusuarioList().remove(rolusuarioListRolusuario);
                    oldIdUsuOfRolusuarioListRolusuario = em.merge(oldIdUsuOfRolusuarioListRolusuario);
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

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsu());
            List<Vendedor> vendedorListOld = persistentUsuario.getVendedorList();
            List<Vendedor> vendedorListNew = usuario.getVendedorList();
            List<Rolusuario> rolusuarioListOld = persistentUsuario.getRolusuarioList();
            List<Rolusuario> rolusuarioListNew = usuario.getRolusuarioList();
            List<String> illegalOrphanMessages = null;
            for (Vendedor vendedorListOldVendedor : vendedorListOld) {
                if (!vendedorListNew.contains(vendedorListOldVendedor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vendedor " + vendedorListOldVendedor + " since its idUsu field is not nullable.");
                }
            }
            for (Rolusuario rolusuarioListOldRolusuario : rolusuarioListOld) {
                if (!rolusuarioListNew.contains(rolusuarioListOldRolusuario)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Rolusuario " + rolusuarioListOldRolusuario + " since its idUsu field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Vendedor> attachedVendedorListNew = new ArrayList<Vendedor>();
            for (Vendedor vendedorListNewVendedorToAttach : vendedorListNew) {
                vendedorListNewVendedorToAttach = em.getReference(vendedorListNewVendedorToAttach.getClass(), vendedorListNewVendedorToAttach.getIdVen());
                attachedVendedorListNew.add(vendedorListNewVendedorToAttach);
            }
            vendedorListNew = attachedVendedorListNew;
            usuario.setVendedorList(vendedorListNew);
            List<Rolusuario> attachedRolusuarioListNew = new ArrayList<Rolusuario>();
            for (Rolusuario rolusuarioListNewRolusuarioToAttach : rolusuarioListNew) {
                rolusuarioListNewRolusuarioToAttach = em.getReference(rolusuarioListNewRolusuarioToAttach.getClass(), rolusuarioListNewRolusuarioToAttach.getIdRolUsu());
                attachedRolusuarioListNew.add(rolusuarioListNewRolusuarioToAttach);
            }
            rolusuarioListNew = attachedRolusuarioListNew;
            usuario.setRolusuarioList(rolusuarioListNew);
            usuario = em.merge(usuario);
            for (Vendedor vendedorListNewVendedor : vendedorListNew) {
                if (!vendedorListOld.contains(vendedorListNewVendedor)) {
                    Usuario oldIdUsuOfVendedorListNewVendedor = vendedorListNewVendedor.getIdUsu();
                    vendedorListNewVendedor.setIdUsu(usuario);
                    vendedorListNewVendedor = em.merge(vendedorListNewVendedor);
                    if (oldIdUsuOfVendedorListNewVendedor != null && !oldIdUsuOfVendedorListNewVendedor.equals(usuario)) {
                        oldIdUsuOfVendedorListNewVendedor.getVendedorList().remove(vendedorListNewVendedor);
                        oldIdUsuOfVendedorListNewVendedor = em.merge(oldIdUsuOfVendedorListNewVendedor);
                    }
                }
            }
            for (Rolusuario rolusuarioListNewRolusuario : rolusuarioListNew) {
                if (!rolusuarioListOld.contains(rolusuarioListNewRolusuario)) {
                    Usuario oldIdUsuOfRolusuarioListNewRolusuario = rolusuarioListNewRolusuario.getIdUsu();
                    rolusuarioListNewRolusuario.setIdUsu(usuario);
                    rolusuarioListNewRolusuario = em.merge(rolusuarioListNewRolusuario);
                    if (oldIdUsuOfRolusuarioListNewRolusuario != null && !oldIdUsuOfRolusuarioListNewRolusuario.equals(usuario)) {
                        oldIdUsuOfRolusuarioListNewRolusuario.getRolusuarioList().remove(rolusuarioListNewRolusuario);
                        oldIdUsuOfRolusuarioListNewRolusuario = em.merge(oldIdUsuOfRolusuarioListNewRolusuario);
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
                Integer id = usuario.getIdUsu();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsu();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Vendedor> vendedorListOrphanCheck = usuario.getVendedorList();
            for (Vendedor vendedorListOrphanCheckVendedor : vendedorListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Vendedor " + vendedorListOrphanCheckVendedor + " in its vendedorList field has a non-nullable idUsu field.");
            }
            List<Rolusuario> rolusuarioListOrphanCheck = usuario.getRolusuarioList();
            for (Rolusuario rolusuarioListOrphanCheckRolusuario : rolusuarioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Rolusuario " + rolusuarioListOrphanCheckRolusuario + " in its rolusuarioList field has a non-nullable idUsu field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(usuario);
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

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
