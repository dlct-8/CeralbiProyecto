
package Intefaces;

import java.util.List;
import Modelo.Producto;

public interface CRUDProducto {
    public List listar();
    public Producto list(int id);
    public boolean add(Producto pro);
    public boolean edit(Producto pro);
    public boolean eliminar(int id);
    
}
