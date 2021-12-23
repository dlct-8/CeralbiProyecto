
package Modelo;

public class Contacto {
    
    private int idCon;    
    private String nombres;
    private String apellidos;
    private String asunto;
    private String mensaje;

    public Contacto() {
    }

    public Contacto(String nombres, String apellidos, String asunto, String mensaje) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    public int getIdCon() {
        return idCon;
    }

    public void setIdCon(int idCon) {
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
 

   
    
    
}
