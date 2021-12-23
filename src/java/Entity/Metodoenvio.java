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
@Table(name = "metodoenvio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Metodoenvio.findAll", query = "SELECT m FROM Metodoenvio m")
    , @NamedQuery(name = "Metodoenvio.findByIdmet", query = "SELECT m FROM Metodoenvio m WHERE m.idmet = :idmet")
    , @NamedQuery(name = "Metodoenvio.findByMetdEnvio", query = "SELECT m FROM Metodoenvio m WHERE m.metdEnvio = :metdEnvio")})
public class Metodoenvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmet")
    private Integer idmet;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "metdEnvio")
    private String metdEnvio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idmet")
    private List<Venta> ventaList;

    public Metodoenvio() {
    }

    public Metodoenvio(Integer idmet) {
        this.idmet = idmet;
    }

    public Metodoenvio(Integer idmet, String metdEnvio) {
        this.idmet = idmet;
        this.metdEnvio = metdEnvio;
    }

    public Integer getIdmet() {
        return idmet;
    }

    public void setIdmet(Integer idmet) {
        this.idmet = idmet;
    }

    public String getMetdEnvio() {
        return metdEnvio;
    }

    public void setMetdEnvio(String metdEnvio) {
        this.metdEnvio = metdEnvio;
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
        hash += (idmet != null ? idmet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Metodoenvio)) {
            return false;
        }
        Metodoenvio other = (Metodoenvio) object;
        if ((this.idmet == null && other.idmet != null) || (this.idmet != null && !this.idmet.equals(other.idmet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Metodoenvio[ idmet=" + idmet + " ]";
    }
    
}
