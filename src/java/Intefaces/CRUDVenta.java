
package Intefaces;

import java.util.List;
import Modelo.Venta;

public interface CRUDVenta {
    
    public List listar();
    public Venta list(int id);
    public boolean add(Venta objven);
    public boolean edit(Venta objven);
    public boolean delete(int id);
    
}
