
package ModeloDAO;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Modelo.Usuario;
import Intefaces.CRUDUsuario;

public class UsuarioDAO implements CRUDUsuario {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario u = new Usuario();
    
    @Override
    public List listar() {
        ArrayList<Usuario>list=new ArrayList<>();
        String sql="select * from usuario";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario usu = new Usuario();
                usu.setIdUsu(rs.getInt("IdUsu"));               
                usu.setContraseUsu(rs.getString("ContraseUsu"));
                usu.setNombreUsu(rs.getString("NombreUsu"));
                
                list.add(usu);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Usuario list(int id) {
        String sql="select * from usuario where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                u.setIdUsu(rs.getInt("Id"));//
                u.setContraseUsu(rs.getString("ContraseUsu"));
                u.setNombreUsu(rs.getString("NombreUsu"));
                
                
            }
        } catch (Exception e) {
        }
        return u;
    }

    @Override
    public boolean add(Usuario usu) {
       String sql="insert into usuario(ContraseUsu, NombreUsu)values('"+usu.getContraseUsu()+"','"+usu.getNombreUsu()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Usuario usu) {
        String sql="update usuario set ContraseUsu='"+usu.getContraseUsu()+"' NombreUsu='"+usu.getNombreUsu()+"' where Id="+usu.getIdUsu();
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
        String sql="delete from usuario where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
    


