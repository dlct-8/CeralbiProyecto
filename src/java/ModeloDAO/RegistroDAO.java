package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUDRegistro;
import Modelo.Registro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RegistroDAO implements CRUDRegistro{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Registro re =new Registro();
    
    @Override
    public List listar() {
        ArrayList<Registro>list=new ArrayList<>();
        String sql="select * from registro";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Registro reg = new Registro();
                reg.setIdReg(rs.getInt("IdReg"));
                reg.setNombres(rs.getString("Nombres"));
                reg.setApellidos(rs.getString("Apellidos"));  
                reg.setUsuario(rs.getString("Usuario"));
                reg.setContrasena(rs.getString("Contrasena"));
                list.add(reg);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Registro list(int id) {
        String sql="select * from registro where idReg="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                re.setIdReg(rs.getInt("IdReg"));
                re.setNombres(rs.getString("Nombres"));
                re.setApellidos(rs.getString("Apellidos"));
                re.setUsuario(rs.getString("Usuario"));
                re.setContrasena(rs.getString("Contrasena"));
            }
        } catch (Exception e) {
        }
        return re;
    }

    @Override
    public boolean add(Registro reg) {
       String sql="insert into registro"
               + "(Nombres,"
               + " Apellidos,"
               + " Usuario,"
               + " Contrasena)"
               + "values"
               + "('"+reg.getNombres()+"',"
               + "'"+reg.getApellidos()+"',"
               + "'"+reg.getUsuario()+"'," 
               + "'"+reg.getContrasena()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Registro reg) {
        String sql= "update registro set"
                + " Nombres='"+reg.getNombres()+"',"
                + " Apellidos='"+reg.getApellidos()+"',"
                + " Usuario='"+reg.getUsuario()+"',"
                + " Contrasena ='"+reg.getContrasena()+"'"
                + " where idReg="+reg.getIdReg();
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
        String sql="delete from registro where idReg="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
