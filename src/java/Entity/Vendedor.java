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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendedor.findAll", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByIdVen", query = "SELECT v FROM Vendedor v WHERE v.idVen = :idVen")
    , @NamedQuery(name = "Vendedor.findByNombresVen", query = "SELECT v FROM Vendedor v WHERE v.nombresVen = :nombresVen")
    , @NamedQuery(name = "Vendedor.findByApellidosVen", query = "SELECT v FROM Vendedor v WHERE v.apellidosVen = :apellidosVen")
    , @NamedQuery(name = "Vendedor.findByTipoDoc", query = "SELECT v FROM Vendedor v WHERE v.tipoDoc = :tipoDoc")
    , @NamedQuery(name = "Vendedor.findByNumerodoc", query = "SELECT v FROM Vendedor v WHERE v.numerodoc = :numerodoc")
    , @NamedQuery(name = "Vendedor.findByTelefono", query = "SELECT v FROM Vendedor v WHERE v.telefono = :telefono")
    , @NamedQuery(name = "Vendedor.findByCorreo", query = "SELECT v FROM Vendedor v WHERE v.correo = :correo")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idVen")
    private Integer idVen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombresVen")
    private String nombresVen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ApellidosVen")
    private String apellidosVen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "tipoDoc")
    private String tipoDoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "numerodoc")
    private String numerodoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "correo")
    private String correo;
    @JoinColumn(name = "idUsu", referencedColumnName = "idUsu")
    @ManyToOne(optional = false)
    private Usuario idUsu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVen")
    private List<Factura> facturaList;

    public Vendedor() {
    }

    public Vendedor(Integer idVen) {
        this.idVen = idVen;
    }

    public Vendedor(Integer idVen, String nombresVen, String apellidosVen, String tipoDoc, String numerodoc, String telefono, String correo) {
        this.idVen = idVen;
        this.nombresVen = nombresVen;
        this.apellidosVen = apellidosVen;
        this.tipoDoc = tipoDoc;
        this.numerodoc = numerodoc;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Integer getIdVen() {
        return idVen;
    }

    public void setIdVen(Integer idVen) {
        this.idVen = idVen;
    }

    public String getNombresVen() {
        return nombresVen;
    }

    public void setNombresVen(String nombresVen) {
        this.nombresVen = nombresVen;
    }

    public String getApellidosVen() {
        return apellidosVen;
    }

    public void setApellidosVen(String apellidosVen) {
        this.apellidosVen = apellidosVen;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public String getNumerodoc() {
        return numerodoc;
    }

    public void setNumerodoc(String numerodoc) {
        this.numerodoc = numerodoc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Usuario getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(Usuario idUsu) {
        this.idUsu = idUsu;
    }

    @XmlTransient
    public List<Factura> getFacturaList() {
        return facturaList;
    }

    public void setFacturaList(List<Factura> facturaList) {
        this.facturaList = facturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVen != null ? idVen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.idVen == null && other.idVen != null) || (this.idVen != null && !this.idVen.equals(other.idVen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Vendedor[ idVen=" + idVen + " ]";
    }
    
}
