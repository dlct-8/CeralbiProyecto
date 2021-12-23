
package ModeloDAO;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.UsuarioNT;
import Intefaces.validarUsuarioNT;

public class UsuarioNTDAO implements validarUsuarioNT {  //aqui implementamos todos los metodos abstractos 
Connection con; //decaramomos variable connection
PreparedStatement ps;
ResultSet rs;

Conexion cn = new Conexion(); //Instanciamso la clase conexion 
    @Override
    public int validar(UsuarioNT per) {
        int r=0;
        String sql = "SELECT * FROM usuariont where Usuario=? and Clave=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, per.getUsuario());
            ps.setString(2, per.getClave());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setUsuario(rs.getString("Usuario"));
                per.setClave(rs.getString("Clave"));
            }
            if(r==1){
                return 1;
            } else {
                return 0;
            }
            
        } catch (Exception e) {
            return 0;
        }
        
    }

    
}
