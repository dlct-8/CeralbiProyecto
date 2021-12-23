//7-Creamos el paquete interfaces 
//8-Creamos un javainterface 

package Intefaces;
//9-Importamos del paquete modelo.Nombreclase y importamos java.util.List
import Modelo.Persona;
import java.util.List;

public interface CRUDPersona {
    
    public List listar();
    public Persona list(int id);//10-Cambiamos la clase
    public boolean add(Persona per);//11-Cambiamos la clase
    public boolean edit(Persona per);//12-Cambiamos la clase
    public boolean eliminar(int id);
    
}