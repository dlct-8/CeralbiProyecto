
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUDRolUsu;
import Modelo.RolUsu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RolUsuDAO implements CRUDRolUsu {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    RolUsu ros= new RolUsu();
    
    @Override
    public List listar() {
        ArrayList<RolUsu>list=new ArrayList<>();
        String sql="select * from rolUsu";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                RolUsu rols =new RolUsu();
                rols.setIdRolUsu(rs.getInt("IdRolUsu"));
                rols.setIdRol(rs.getInt("IdRol"));
                rols.setIdUsu(rs.getInt("IdUsu"));
                list.add(rols);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public RolUsu list(int id) {
        String sql="select * from rolUsu where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                ros.setIdRolUsu(rs.getInt("IdRolUsu"));
                ros.setIdRol(rs.getInt("IdRol"));
                ros.setIdUsu(rs.getInt("IdUsu"));
            }
        } catch (Exception e) {
        }
        return ros;
    }

    @Override
    public boolean add(RolUsu rols) {
       String sql="insert into rolUsu(IdRol,IdUsu)values('"+rols.getIdRol()+"','"+rols.getIdUsu()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(RolUsu rols) {
        String sql="update RolUsu set IdRol='"+rols.getIdRol()+"',IdUsu='"+rols.getIdUsu()+"'  where Id="+rols.getIdRolUsu();
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
        String sql="delete from rolUsu where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
    
}
