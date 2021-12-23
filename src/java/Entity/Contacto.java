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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZAYRA
 */
@Entity
@Table(name = "contacto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contacto.findAll", query = "SELECT c FROM Contacto c")
    , @NamedQuery(name = "Contacto.findByIdCon", query = "SELECT c FROM Contacto c WHERE c.idCon = :idCon")
    , @NamedQuery(name = "Contacto.findByNombres", query = "SELECT c FROM Contacto c WHERE c.nombres = :nombres")
    , @NamedQuery(name = "Contacto.findByApellidos", query = "SELECT c FROM Contacto c WHERE c.apellidos = :apellidos")
    , @NamedQuery(name = "Contacto.findByAsunto", query = "SELECT c FROM Contacto c WHERE c.asunto = :asunto")
    , @NamedQuery(name = "Contacto.findByMensaje", query = "SELECT c FROM Contacto c WHERE c.mensaje = :mensaje")})
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCon")
    private Integer idCon;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "mensaje")
    private String mensaje;

    public Contacto() {
    }

    public Contacto(Integer idCon) {
        this.idCon = idCon;
    }

    public Contacto(Integer idCon, String nombres, String apellidos, String asunto, String mensaje) {
        this.idCon = idCon;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public Integer getIdCon() {
        return idCon;
    }

    public void setIdCon(Integer idCon) {
        this.idCon = idCon;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCon != null ? idCon.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contacto)) {
            return false;
        }
        Contacto other = (Contacto) object;
        if ((this.idCon == null && other.idCon != null) || (this.idCon != null && !this.idCon.equals(other.idCon))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Contacto[ idCon=" + idCon + " ]";
    }
    
}
