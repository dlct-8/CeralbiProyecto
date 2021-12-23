
package Intefaces;
import java.util.List;
import Modelo.Auditoria;

public interface CRUDAuditoria {
    public List listar();
    public Auditoria list(int id);
    public boolean add(Auditoria aud);
    public boolean edit(Auditoria aud);
    public boolean eliminar(int id); 
}
