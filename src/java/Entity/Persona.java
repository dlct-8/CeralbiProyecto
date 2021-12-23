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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByCampoIdtabla", query = "SELECT p FROM Persona p WHERE p.campoIdtabla = :campoIdtabla")
    , @NamedQuery(name = "Persona.findByCampoDNItabla", query = "SELECT p FROM Persona p WHERE p.campoDNItabla = :campoDNItabla")
    , @NamedQuery(name = "Persona.findByCampoNombrestabla", query = "SELECT p FROM Persona p WHERE p.campoNombrestabla = :campoNombrestabla")
    , @NamedQuery(name = "Persona.findByCampoFechatabla", query = "SELECT p FROM Persona p WHERE p.campoFechatabla = :campoFechatabla")
    , @NamedQuery(name = "Persona.findByCampoPreciotabla", query = "SELECT p FROM Persona p WHERE p.campoPreciotabla = :campoPreciotabla")
    , @NamedQuery(name = "Persona.findByCampo1Foraneo", query = "SELECT p FROM Persona p WHERE p.campo1Foraneo = :campo1Foraneo")
    , @NamedQuery(name = "Persona.findByCampo2Foraneo", query = "SELECT p FROM Persona p WHERE p.campo2Foraneo = :campo2Foraneo")
    , @NamedQuery(name = "Persona.findByCampo3Foraneo", query = "SELECT p FROM Persona p WHERE p.campo3Foraneo = :campo3Foraneo")
    , @NamedQuery(name = "Persona.findByCampo4Foraneo", query = "SELECT p FROM Persona p WHERE p.campo4Foraneo = :campo4Foraneo")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CampoIdtabla")
    private Integer campoIdtabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CampoDNItabla")
    private String campoDNItabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CampoNombrestabla")
    private String campoNombrestabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CampoFechatabla")
    private String campoFechatabla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CampoPreciotabla")
    private double campoPreciotabla;
    @Column(name = "Campo1Foraneo")
    private Integer campo1Foraneo;
    @Column(name = "Campo2Foraneo")
    private Integer campo2Foraneo;
    @Size(max = 20)
    @Column(name = "Campo3Foraneo")
    private String campo3Foraneo;
    @Size(max = 20)
    @Column(name = "Campo4Foraneo")
    private String campo4Foraneo;

    public Persona() {
    }

    public Persona(Integer campoIdtabla) {
        this.campoIdtabla = campoIdtabla;
    }

    public Persona(Integer campoIdtabla, String campoDNItabla, String campoNombrestabla, String campoFechatabla, double campoPreciotabla) {
        this.campoIdtabla = campoIdtabla;
        this.campoDNItabla = campoDNItabla;
        this.campoNombrestabla = campoNombrestabla;
        this.campoFechatabla = campoFechatabla;
        this.campoPreciotabla = campoPreciotabla;
    }

    public Integer getCampoIdtabla() {
        return campoIdtabla;
    }

    public void setCampoIdtabla(Integer campoIdtabla) {
        this.campoIdtabla = campoIdtabla;
    }

    public String getCampoDNItabla() {
        return campoDNItabla;
    }

    public void setCampoDNItabla(String campoDNItabla) {
        this.campoDNItabla = campoDNItabla;
    }

    public String getCampoNombrestabla() {
        return campoNombrestabla;
    }

    public void setCampoNombrestabla(String campoNombrestabla) {
        this.campoNombrestabla = campoNombrestabla;
    }

    public String getCampoFechatabla() {
        return campoFechatabla;
    }

    public void setCampoFechatabla(String campoFechatabla) {
        this.campoFechatabla = campoFechatabla;
    }

    public double getCampoPreciotabla() {
        return campoPreciotabla;
    }

    public void setCampoPreciotabla(double campoPreciotabla) {
        this.campoPreciotabla = campoPreciotabla;
    }

    public Integer getCampo1Foraneo() {
        return campo1Foraneo;
    }

    public void setCampo1Foraneo(Integer campo1Foraneo) {
        this.campo1Foraneo = campo1Foraneo;
    }

    public Integer getCampo2Foraneo() {
        return campo2Foraneo;
    }

    public void setCampo2Foraneo(Integer campo2Foraneo) {
        this.campo2Foraneo = campo2Foraneo;
    }

    public String getCampo3Foraneo() {
        return campo3Foraneo;
    }

    public void setCampo3Foraneo(String campo3Foraneo) {
        this.campo3Foraneo = campo3Foraneo;
    }

    public String getCampo4Foraneo() {
        return campo4Foraneo;
    }

    public void setCampo4Foraneo(String campo4Foraneo) {
        this.campo4Foraneo = campo4Foraneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campoIdtabla != null ? campoIdtabla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.campoIdtabla == null && other.campoIdtabla != null) || (this.campoIdtabla != null && !this.campoIdtabla.equals(other.campoIdtabla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Persona[ campoIdtabla=" + campoIdtabla + " ]";
    }
    
}
