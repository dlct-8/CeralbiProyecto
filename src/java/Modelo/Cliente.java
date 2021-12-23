
package Modelo;


public class Cliente {
  private int idCli; 
  private String nombres;
  private String apellidos;
  private int idTipo;
  private String numerodoc;
  private String telefono;
  private String correo;
  private String direccion;

    public Cliente() {
    }

    public Cliente(String nombres, String apellidos, int idTipo, String numerodoc, String telefono, String correo, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.idTipo = idTipo;
        this.numerodoc = numerodoc;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    public int getIdCli() {
        return idCli;
    }

    public void setIdCli(int idCli) {
        this.idCli = idCli;
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

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
  

   
    }

    