
package Modelo;

public class Auditoria {
 private String usuario;
 private String descripcion;
 private String fecha;

    public Auditoria() {
    }

    public Auditoria(String usuario, String descripcion, String fecha) {
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
 
 
    
}
