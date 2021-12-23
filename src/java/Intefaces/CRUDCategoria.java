
package Intefaces;


import java.util.List;
import Modelo.Categoria;


public interface CRUDCategoria {
   public List listar();
    public Categoria list(int id);
    public boolean add(Categoria cat);
    public boolean edit(Categoria cat);
    public boolean eliminar(int id);   
}
