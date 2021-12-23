
package Intefaces;


import java.util.List;
import Modelo.Registro;


public interface CRUDRegistro {
   public List listar();
    public Registro list(int id);
    public boolean add(Registro reg);
    public boolean edit(Registro reg);
    public boolean eliminar(int id);   
}
