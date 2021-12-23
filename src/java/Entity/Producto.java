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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ZAYRA
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdPro", query = "SELECT p FROM Producto p WHERE p.idPro = :idPro")
    , @NamedQuery(name = "Producto.findByNombrePro", query = "SELECT p FROM Producto p WHERE p.nombrePro = :nombrePro")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByMedidas", query = "SELECT p FROM Producto p WHERE p.medidas = :medidas")
    , @NamedQuery(name = "Producto.findByUnidades", query = "SELECT p FROM Producto p WHERE p.unidades = :unidades")
    , @NamedQuery(name = "Producto.findByPrecioCosto", query = "SELECT p FROM Producto p WHERE p.precioCosto = :precioCosto")
    , @NamedQuery(name = "Producto.findByPrecioVenta", query = "SELECT p FROM Producto p WHERE p.precioVenta = :precioVenta")
    , @NamedQuery(name = "Producto.findByImagenProd", query = "SELECT p FROM Producto p WHERE p.imagenProd = :imagenProd")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPro")
    private Integer idPro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombrePro")
    private String nombrePro;
    @Size(max = 40)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 40)
    @Column(name = "medidas")
    private String medidas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades")
    private int unidades;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioCosto")
    private Float precioCosto;
    @Column(name = "precioVenta")
    private Float precioVenta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "imagenProd")
    private String imagenProd;
    @JoinColumn(name = "idCat", referencedColumnName = "idCat")
    @ManyToOne(optional = false)
    private Categoria idCat;

    public Producto() {
    }

    public Producto(Integer idPro) {
        this.idPro = idPro;
    }

    public Producto(Integer idPro, String nombrePro, int unidades, String imagenProd) {
        this.idPro = idPro;
        this.nombrePro = nombrePro;
        this.unidades = unidades;
        this.imagenProd = imagenProd;
    }

    public Integer getIdPro() {
        return idPro;
    }

    public void setIdPro(Integer idPro) {
        this.idPro = idPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMedidas() {
        return medidas;
    }

    public void setMedidas(String medidas) {
        this.medidas = medidas;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public Float getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Float precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getImagenProd() {
        return imagenProd;
    }

    public void setImagenProd(String imagenProd) {
        this.imagenProd = imagenProd;
    }

    public Categoria getIdCat() {
        return idCat;
    }

    public void setIdCat(Categoria idCat) {
        this.idCat = idCat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPro != null ? idPro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idPro == null && other.idPro != null) || (this.idPro != null && !this.idPro.equals(other.idPro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Producto[ idPro=" + idPro + " ]";
    }
    
}
