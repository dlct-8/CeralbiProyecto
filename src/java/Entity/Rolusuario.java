/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZAYRA
 */
@Entity
@Table(name = "rolusuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rolusuario.findAll", query = "SELECT r FROM Rolusuario r")
    , @NamedQuery(name = "Rolusuario.findByIdRolUsu", query = "SELECT r FROM Rolusuario r WHERE r.idRolUsu = :idRolUsu")})
public class Rolusuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRolUsu")
    private Integer idRolUsu;
    @JoinColumn(name = "idRol", referencedColumnName = "idRol")
    @ManyToOne(optional = false)
    private Rol idRol;
    @JoinColumn(name = "idUsu", referencedColumnName = "idUsu")
    @ManyToOne(optional = false)
    private Usuario idUsu;

    public Rolusuario() {
    }

    public Rolusuario(Integer idRolUsu) {
        this.idRolUsu = idRolUsu;
    }

    public Integer getIdRolUsu() {
        return idRolUsu;
    }

    public void setIdRolUsu(Integer idRolUsu) {
        this.idRolUsu = idRolUsu;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Usuario getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuario idUsu) {
        this.idUsu = idUsu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRolUsu != null ? idRolUsu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rolusuario)) {
            return false;
        }
        Rolusuario other = (Rolusuario) object;
        if ((this.idRolUsu == null && other.idRolUsu != null) || (this.idRolUsu != null && !this.idRolUsu.equals(other.idRolUsu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Rolusuario[ idRolUsu=" + idRolUsu + " ]";
    }
    
}
