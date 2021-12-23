
package Modelo;

public class RolUsu {
    private int idRolUsu;
    private int idUsu;
    private int idRol;

    public RolUsu() {
    }

    public RolUsu(int idUsu, int idRol) {
        this.idUsu = idUsu;
        this.idRol = idRol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public int getIdRolUsu() {
        return idRolUsu;
    }

    public void setIdRolUsu(int idRolUsu) {
        this.idRolUsu = idRolUsu;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }
    
    
    
}
