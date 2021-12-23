package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUDCategoria;
import Modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements CRUDCategoria{
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Categoria c =new Categoria();
    
    @Override
    public List listar() {
        ArrayList<Categoria>list=new ArrayList<>();
        String sql="select * from categoria";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Categoria cat = new Categoria();
                cat.setIdCat(rs.getInt("IdCat"));
                cat.setNombreCat(rs.getString("NombreCat"));
                cat.setDescripcion(rs.getString("Descripcion"));                
                list.add(cat);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Categoria list(int id) {
        String sql="select * from categoria where IdCat="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                c.setIdCat(rs.getInt("IdCat"));
                c.setNombreCat(rs.getString("NombreCat"));
                c.setDescripcion(rs.getString("Descripcion"));
               
            }
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public boolean add(Categoria cat) {
       String sql="insert into categoria"
               + "(NombreCat,"
               + " Descripcion)"
               + "values"
               + "('"+cat.getNombreCat()+"',"
               + "'"+cat.getDescripcion()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Categoria cat) {
        String sql= "update categoria set"
                + " NombreCat='"+cat.getNombreCat()+"',"
                + "Descripcion='"+cat.getDescripcion()+"'"
                + " where IdCat="+cat.getIdCat();
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
        String sql="delete from categoria where IdCat="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
