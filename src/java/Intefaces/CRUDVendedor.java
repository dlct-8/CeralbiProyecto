
package Intefaces;

import java.util.List;
import Modelo.Vendedor;

public interface CRUDVendedor {
    
    public List listar();
    public Vendedor list(int id);//10-Cambiamos la clase
    public boolean add(Vendedor ven);//11-Cambiamos la clase
    public boolean edit(Vendedor ven);//12-Cambiamos la clase
    public boolean eliminar(int id);
}
