
package Intefaces;

import java.util.List;
import Modelo.Factura;

public interface CRUDFactura {
    
    public List listar();
    public Factura list(int id);
    public boolean add(Factura fac);
    public boolean edit(Factura fac);
    public boolean eliminar(int id);
    
}
