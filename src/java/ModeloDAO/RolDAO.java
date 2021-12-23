
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUDRol;
import Modelo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolDAO implements CRUDRol {
     Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Rol r= new Rol();
    
    @Override
    public List listar() {
        ArrayList<Rol>list=new ArrayList<>();
        String sql="select * from rol";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Rol rol =new Rol();
                rol.setIdRol(rs.getInt("IdRol"));
                rol.setNombreRol(rs.getString("NombreRol"));                
                list.add(rol);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Rol list(int id) {
        String sql="select * from rol where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                r.setIdRol(rs.getInt("IdRol"));
                r.setNombreRol(rs.getString("NombreRol"));
                
            }
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public boolean add(Rol rol) {
       String sql="insert into rol(NombreRol)values('"+rol.getNombreRol()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Rol rol) {
        String sql="update Rol set NombreRol='"+rol.getNombreRol()+"' where Id="+rol.getIdRol();
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
        String sql="delete from rol where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
