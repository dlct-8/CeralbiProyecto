
package Intefaces;

import Modelo.Contacto;
import java.util.List;

public interface CRUDContacto {
    public List listar();
    public Contacto list(int id);
    public boolean add(Contacto con);
    public boolean edit(Contacto con);
    public boolean eliminar(int id);
}
