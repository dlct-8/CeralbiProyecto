package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUDAuditoria;
import Modelo.Auditoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AuditoriaDAO implements CRUDAuditoria{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Auditoria a =new Auditoria();
    
    @Override
    public List listar() {
        ArrayList<Auditoria>list=new ArrayList<>();
        String sql="select * from auditoria";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Auditoria aud = new Auditoria();
                aud.setUsuario(rs.getString("Usuario"));
                aud.setDescripcion(rs.getString("Descripcion"));
                aud.setFecha(rs.getString("Fecha"));                
                list.add(aud);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Auditoria list(int id) {
        String sql="select * from auditoria where usuario="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                a.setUsuario(rs.getString("Usuario"));
                a.setDescripcion(rs.getString("Descripcion"));
                a.setFecha(rs.getString("Fecha"));
               
            }
        } catch (Exception e) {
        }
        return a;
    }

    @Override
    public boolean add(Auditoria aud) {
       String sql="insert into auditoria"
               + "(Usuario,"
               + " Descripcion,"
               + " fecha)"
               + "values"
               + "('"+aud.getUsuario()+"',"
               + "('"+aud.getDescripcion()+"',"
               + "'"+aud.getFecha()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Auditoria aud) {
        String sql= "update auditoria set"
                + " Usuario='"+aud.getUsuario()+"',"
                + " Descripcion='"+aud.getUsuario()+"',"
                + " fecha='"+aud.getFecha()+"'"
                + " where Usuario="+aud.getUsuario();
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
        String sql="delete from usuario where usuario="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
