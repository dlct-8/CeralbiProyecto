/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ZAYRA
 */
@Entity
@Table(name = "mediopago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mediopago.findAll", query = "SELECT m FROM Mediopago m")
    , @NamedQuery(name = "Mediopago.findByIdmed", query = "SELECT m FROM Mediopago m WHERE m.idmed = :idmed")
    , @NamedQuery(name = "Mediopago.findByMedioPago", query = "SELECT m FROM Mediopago m WHERE m.medioPago = :medioPago")})
public class Mediopago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmed")
    private Integer idmed;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "medioPago")
    private String medioPago;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmed")
    private List<Venta> ventaList;

    public Mediopago() {
    }

    public Mediopago(Integer idmed) {
        this.idmed = idmed;
    }

    public Mediopago(Integer idmed, String medioPago) {
        this.idmed = idmed;
        this.medioPago = medioPago;
    }

    public Integer getIdmed() {
        return idmed;
    }

    public void setIdmed(Integer idmed) {
        this.idmed = idmed;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmed != null ? idmed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mediopago)) {
            return false;
        }
        Mediopago other = (Mediopago) object;
        if ((this.idmed == null && other.idmed != null) || (this.idmed != null && !this.idmed.equals(other.idmed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Mediopago[ idmed=" + idmed + " ]";
    }
    
}
