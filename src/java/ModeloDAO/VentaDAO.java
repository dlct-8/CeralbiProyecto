/* Variables que no se deben modificar
objcla, objba, llave, llaveid, sql, con, cn, ps, rs, accion, listar..
secuencia de trabajo, mapear tabla en modelo, cuadrar interface, cuadrar modeloDAO,
ajustar la carpeta de vistas recordar carpeta por cada tabla,
luego ajustar controlador
nota: No olvidar al generar get and set encapsular y cuando creen el servelet para
el controlador no olvidar marcar la casilla para agregarlo al web.xml si no 
agregarlo de forma manual al web.xml
*/
package ModeloDAO;

import Config.Conexion;
import Modelo.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Intefaces.CRUDVenta;

public class VentaDAO implements CRUDVenta{
     // variables fijas
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    // objeto a instanciar para la entidad
    Venta objve=new Venta();
    
    @Override
    public List listar() {
        ArrayList<Venta>list=new ArrayList<>();
        String sql="select * from venta";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Venta objven=new Venta();
                objven.setIdVent(rs.getInt("idVent"));                
                objven.setIdPed(rs.getInt("idPed"));
                objven.setFechaReal(rs.getString("FechaReal"));
                objven.setFechaEntreg(rs.getString("FechaEntreg"));
                objven.setIdmed(rs.getInt("Idmed"));
                objven.setIdmet(rs.getInt("Idmet"));                
                objven.setDirEnvio(rs.getString("DirEnvio"));
               
                // No olvidar agregar a la lista list.add(objcla)
                list.add(objven);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Venta list(int id) {
        String sql="select * from venta where idVent="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                objve.setIdVent(rs.getInt("IdVent"));
                objve.setIdPed(rs.getInt("IdPed"));
                objve.setFechaReal(rs.getString("FechaReal"));
                objve.setFechaEntreg(rs.getString("FechaEntreg"));                
                objve.setIdmed(rs.getInt("Idmed"));
                objve.setIdmet(rs.getInt("Idmet"));
                objve.setDirEnvio(rs.getString("DirEnvio"));
                              
            }
        } catch (Exception e) {
        }
        return objve;
    }

    @Override
    public boolean add(Venta objvent) {
        /*Ojo en cada fila coloque un componente de la sentencia sql para mayor claridad
        observar bien como van las comillas sencillas dobles, el + 
        */
       String sql="insert into venta "
               + "(IdPed,"
               + " FechaReal,"
               + " FechaEntreg,"
               + " Idmed,"
               + " Idmet,"
               + " DirEnvio)"
               
               + "values("
               + "'"+objvent.getIdPed()+"',"
               + "'"+objvent.getFechaReal()+"',"
               + "'"+objvent.getFechaEntreg()+"',"
               + "'"+objvent.getIdmed()+"',"
               + "'"+objvent.getIdmet()+"',"
               + "'"+objvent.getDirEnvio()+"'"               
               + ")";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Venta objvent) {
        /*Ojo en cada fila coloque un componente de la sentencia sql para mayor claridad
        observar bien como van las comillas sencillas dobles, el + 
        */
        String sql="update venta set "
                + "IdPed='"+objvent.getIdPed()+"',"
                + "fechaReal='"+objvent.getFechaReal()+"' ,"
                + "FechaEntreg='"+objvent.getFechaEntreg()+"',"
                + "Idmed='"+objvent.getIdmed()+"',"
                + "Idmet='"+objvent.getIdmet()+"',"
                + "DirEnvio='"+objvent.getDirEnvio()+"'"                
                + "where idVent="+objvent.getIdVent();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql="delete from venta where idVent="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
