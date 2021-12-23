
package Modelo;


public class Usuario {
     int idUsu;
     String contraseUsu;
     String nombreUsu;

    public Usuario() {
    }

    public Usuario(String contraseUsu) {
        this.contraseUsu = contraseUsu;
    }

    public String getContraseUsu() {
        return contraseUsu;
    }

    public void setContraseUsu(String contraseUsu) {
        this.contraseUsu = contraseUsu;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }
    
    
    
}
