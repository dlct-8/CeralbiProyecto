
package Modelo;


public class Vendedor {
   private int idVen;
   private int idUsu;
   private String nombresVen;
   private String ApellidosVen;
   private String tipoDoc ;
   private String numerodoc;
   private String telefono;
   private String correo;

    public Vendedor() {
    }

    public Vendedor(int idUsu, String nombresVen, String ApellidosVen, String tipoDoc, String numerodoc, String telefono, String correo) {
        this.idUsu = idUsu;
        this.nombresVen = nombresVen;
        this.ApellidosVen = ApellidosVen;
        this.tipoDoc = tipoDoc;
        this.numerodoc = numerodoc;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdVen() {
        return idVen;
    }

    public void setIdVen(int idVen) {
        this.idVen = idVen;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNombresVen() {
        return nombresVen;
    }

    public void setNombresVen(String nombresVen) {
        this.nombresVen = nombresVen;
    }

    public String getApellidosVen() {
        return ApellidosVen;
    }

    public void setApellidosVen(String ApellidosVen) {
        this.ApellidosVen = ApellidosVen;
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

    
   
    
}
