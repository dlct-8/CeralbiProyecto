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
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdfac", query = "SELECT f FROM Factura f WHERE f.idfac = :idfac")
    , @NamedQuery(name = "Factura.findByEmision", query = "SELECT f FROM Factura f WHERE f.emision = :emision")
    , @NamedQuery(name = "Factura.findByVencimiento", query = "SELECT f FROM Factura f WHERE f.vencimiento = :vencimiento")
    , @NamedQuery(name = "Factura.findByImpuestos", query = "SELECT f FROM Factura f WHERE f.impuestos = :impuestos")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfac")
    private Integer idfac;
    @Size(max = 20)
    @Column(name = "Emision")
    private String emision;
    @Size(max = 20)
    @Column(name = "Vencimiento")
    private String vencimiento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "impuestos")
    private Double impuestos;
    @JoinColumn(name = "idCli", referencedColumnName = "idCli")
    @ManyToOne(optional = false)
    private Cliente idCli;
    @JoinColumn(name = "idPed", referencedColumnName = "idPed")
    @ManyToOne(optional = false)
    private Pedido idPed;
    @JoinColumn(name = "idVen", referencedColumnName = "idVen")
    @ManyToOne(optional = false)
    private Vendedor idVen;

    public Factura() {
    }

    public Factura(Integer idfac) {
        this.idfac = idfac;
    }

    public Integer getIdfac() {
        return idfac;
    }

    public void setIdfac(Integer idfac) {
        this.idfac = idfac;
    }

    public String getEmision() {
        return emision;
    }

    public void setEmision(String emision) {
        this.emision = emision;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(Double impuestos) {
        this.impuestos = impuestos;
    }

    public Cliente getIdCli() {
        return idCli;
    }

    public void setIdCli(Cliente idCli) {
        this.idCli = idCli;
    }

    public Pedido getIdPed() {
        return idPed;
    }

    public void setIdPed(Pedido idPed) {
        this.idPed = idPed;
    }

    public Vendedor getIdVen() {
        return idVen;
    }

    public void setIdVen(Vendedor idVen) {
        this.idVen = idVen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfac != null ? idfac.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idfac == null && other.idfac != null) || (this.idfac != null && !this.idfac.equals(other.idfac))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Factura[ idfac=" + idfac + " ]";
    }
    
}
