
package Modelo;


public class UsuarioNT { //Aquí definimos tantas variables como atributos en la entidad esto mas adelante lo haremos con el ORM
    private int id;
    private String Usuario;
    private String Clave;
    private String Tipo;
    public UsuarioNT() { // Isertaremos el constructor vacio
    }

    public UsuarioNT(int id, String Usuario, String Clave, String Tipo) { //Agregamos el constructor con su parametros
        this.id = id;
        this.Usuario = Usuario;
        this.Clave = Clave;
        this.Tipo = Tipo;
    }
    
    //Agregamos los metodos get y set con clic derecho insertar codigo getter and setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

   

    
 
    
    
    
    
}
