
package Intefaces;

import java.util.List;
import Modelo.Pedido;

public interface CRUDPedido {
    
    public List listar();
    public Pedido list(int id);
    public boolean add(Pedido ped);
    public boolean edit(Pedido ped);
    public boolean eliminar(int id);
    
}
