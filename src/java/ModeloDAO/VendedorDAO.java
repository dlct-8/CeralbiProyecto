
package ModeloDAO;

import Intefaces.CRUDVendedor;
import Modelo.Vendedor;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO implements CRUDVendedor {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Vendedor v=new Vendedor();
   @Override
    public List listar() {
        ArrayList<Vendedor>list=new ArrayList<>();
        String sql="select * from vendedor";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Vendedor ven=new Vendedor();
                ven.setIdVen(rs.getInt("IdVen"));
                ven.setIdUsu(rs.getInt("IdUsu"));
                ven.setNombresVen(rs.getString("NombresVen"));
                ven.setApellidosVen(rs.getString("ApellidosVen"));
                ven.setTipoDoc(rs.getString("TipoDoc"));
                ven.setNumerodoc(rs.getString("Numerodoc"));
                ven.setTelefono(rs.getString("Telefono"));
                ven.setCorreo(rs.getString("Correo"));
               
                list.add(ven);//27- cambiamos el objeto
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Vendedor list(int id) {
        String sql="select * from vendedor where IdVen="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                v.setIdVen(rs.getInt("IdVen"));
                v.setIdUsu(rs.getInt("IdUsu"));
                v.setNombresVen(rs.getString("NombresVen"));
                v.setApellidosVen(rs.getString("ApellidosVen"));
                v.setTipoDoc(rs.getString("TipoDoc"));
                v.setNumerodoc(rs.getString("Numerodoc"));
                v.setTelefono(rs.getString("Telefono"));
                v.setCorreo(rs.getString("Correo"));
            }
        } catch (Exception e) {
        }
        return v;
    }

    @Override
    public boolean add(Vendedor ven) {  
       String sql="insert into vendedor"
               + "(IdUsu,"
               + " NombresVen,"
               + " ApellidosVen,"
               + " TipoDoc,"
               + " Numerodoc,"
               + "Telefono,"
               + "Correo)"
               
               + "values("
               + "'"+ven.getIdUsu()+"',"
               + "'"+ven.getNombresVen()+"',"
               + "'"+ven.getApellidosVen()+"',"
               + "'"+ven.getTipoDoc()+"',"
               + "'"+ven.getNumerodoc()+"',"
               + "'"+ven.getTelefono()+"',"
               + "'"+ven.getCorreo()+"'"
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
    public boolean edit(Vendedor ven) {  
        String sql="update vendedor set "
                + "IdUsu='"+ven.getIdUsu()+"',"
                + "NombresVen='"+ven.getNombresVen()+"',"
                + "ApellidosVen='"+ven.getApellidosVen()+"',"
                + "TipoDoc='"+ven.getTipoDoc()+"',"
                + "Numerodoc='"+ven.getNumerodoc()+"',"
                + "Telefono='"+ven.getTelefono()+"',"
                + "correo='"+ven.getCorreo()+"' "
                + "where IdVen="+ven.getIdVen();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql="delete from vendedor where IdVen="+id;//36- Cambiar nombre tabla
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}


