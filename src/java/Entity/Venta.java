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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZAYRA
 */
@Entity
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")
    , @NamedQuery(name = "Venta.findByIdVent", query = "SELECT v FROM Venta v WHERE v.idVent = :idVent")
    , @NamedQuery(name = "Venta.findByFechaReal", query = "SELECT v FROM Venta v WHERE v.fechaReal = :fechaReal")
    , @NamedQuery(name = "Venta.findByFechaEntreg", query = "SELECT v FROM Venta v WHERE v.fechaEntreg = :fechaEntreg")
    , @NamedQuery(name = "Venta.findByDirEnvio", query = "SELECT v FROM Venta v WHERE v.dirEnvio = :dirEnvio")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVent")
    private Integer idVent;
    @Size(max = 20)
    @Column(name = "fechaReal")
    private String fechaReal;
    @Size(max = 20)
    @Column(name = "fechaEntreg")
    private String fechaEntreg;
    @Size(max = 50)
    @Column(name = "dirEnvio")
    private String dirEnvio;
    @JoinColumn(name = "idPed", referencedColumnName = "idPed")
    @ManyToOne(optional = false)
    private Pedido idPed;
    @JoinColumn(name = "idmed", referencedColumnName = "idmed")
    @ManyToOne(optional = false)
    private Mediopago idmed;
    @JoinColumn(name = "idmet", referencedColumnName = "idmet")
    @ManyToOne(optional = false)
    private Metodoenvio idmet;

    public Venta() {
    }

    public Venta(Integer idVent) {
        this.idVent = idVent;
    }

    public Integer getIdVent() {
        return idVent;
    }

    public void setIdVent(Integer idVent) {
        this.idVent = idVent;
    }

    public String getFechaReal() {
        return fechaReal;
    }

    public void setFechaReal(String fechaReal) {
        this.fechaReal = fechaReal;
    }

    public String getFechaEntreg() {
        return fechaEntreg;
    }

    public void setFechaEntreg(String fechaEntreg) {
        this.fechaEntreg = fechaEntreg;
    }

    public String getDirEnvio() {
        return dirEnvio;
    }

    public void setDirEnvio(String dirEnvio) {
        this.dirEnvio = dirEnvio;
    }

    public Pedido getIdPed() {
        return idPed;
    }

    public void setIdPed(Pedido idPed) {
        this.idPed = idPed;
    }

    public Mediopago getIdmed() {
        return idmed;
    }

    public void setIdmed(Mediopago idmed) {
        this.idmed = idmed;
    }

    public Metodoenvio getIdmet() {
        return idmet;
    }

    public void setIdmet(Metodoenvio idmet) {
        this.idmet = idmet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVent != null ? idVent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVent == null && other.idVent != null) || (this.idVent != null && !this.idVent.equals(other.idVent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Venta[ idVent=" + idVent + " ]";
    }
    
}
