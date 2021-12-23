
package Intefaces;

import java.util.List;
import Modelo.Cliente;

public interface CRUDCliente {
    
    public List listar();
    public Cliente list(int id);//10-Cambiamos la clase
    public boolean add(Cliente cli);//11-Cambiamos la clase
    public boolean edit(Cliente cli);//12-Cambiamos la clase
    public boolean eliminar(int id);
    
}
