
package Intefaces;

import Modelo.RolUsu;
import java.util.List;


public interface CRUDRolUsu {
    public List listar();
    public RolUsu list(int id);
    public boolean add(RolUsu rlU);
    public boolean edit(RolUsu rlU);
    public boolean eliminar(int id);
    
}
