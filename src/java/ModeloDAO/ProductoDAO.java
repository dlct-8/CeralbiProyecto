
package ModeloDAO;

import Intefaces.CRUDProducto;
import Modelo.Producto;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO implements CRUDProducto {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Producto pr = new Producto();
    
    @Override
    public List listar() {
        ArrayList<Producto>list=new ArrayList<>();
        String sql="select * from producto";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Producto pro=new Producto();
                
                pro.setIdPro(rs.getInt("IdPro"));
                pro.setNombrePro(rs.getString("NombrePro"));
                pro.setDescripcion(rs.getString("Descripcion"));
                pro.setMedidas(rs.getString("Medidas"));
                pro.setUnidades(rs.getInt("Unidades"));
                pro.setPrecioCosto(rs.getFloat("PrecioCosto"));
                pro.setPrecioVenta(rs.getFloat("PrecioVenta"));
                pro.setImagenProd(rs.getString("ImagenProd"));
                pro.setIdCat(rs.getInt("IdCat"));
                list.add(pro);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Producto list(int id) { 
        String sql="select * from producto where idPro="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                pr.setIdPro(rs.getInt("IdPro"));
                pr.setNombrePro(rs.getString("NombrePro"));
                pr.setDescripcion(rs.getString("Descripcion"));
                pr.setMedidas(rs.getString("Medidas"));
                pr.setUnidades(rs.getInt("Unidades"));
                pr.setPrecioCosto(rs.getFloat("PrecioCosto"));
                pr.setPrecioVenta(rs.getFloat("PrecioVenta"));
                pr.setImagenProd(rs.getString("ImagenProd"));
                pr.setIdCat(rs.getInt("IdCat"));
            }
        } catch (Exception e) {
        }
        return pr;
    }

    @Override
    public boolean add(Producto pro) {  
       String sql="insert into producto"
               + "(NombrePro,"
               + " Descripcion,"
               + " Medidas,"
               + " Unidades,"
               + " PrecioCosto, "
               + " PrecioVenta,"
               + " ImagenProd,"
               + " IdCat)"
               
               + "values("
               + "'"+pro.getNombrePro()+"',"
               + "'"+pro.getDescripcion()+"',"
               + "'"+pro.getMedidas()+"',"
               + "'"+pro.getUnidades()+"',"
               + "'"+pro.getPrecioCosto()+"',"
               + "'"+pro.getPrecioVenta()+"',"
               + "'"+pro.getImagenProd()+"',"
               + "'"+pro.getIdCat()+"'"
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
    public boolean edit(Producto pro) {  // 34-Cambiamos Clase y objeto
        //35- Cambiamos la sentencia sql, nombre tabla, Atributos y '"+Objeto.getAtributo()"' por cada uno de los campos y el Id
        String sql="update producto set "
                + "NombrePro='"+pro.getNombrePro()+"',"
                + "Descripcion='"+pro.getDescripcion()+"',"
                + "Medidas='"+pro.getMedidas()+"',"
                + "Unidades='"+pro.getUnidades()+"',"
                + "PrecioCosto='"+pro.getPrecioCosto()+"' ,"
                + "PrecioVenta='"+pro.getPrecioVenta()+"' ,"
                + "ImagenProd='"+pro.getImagenProd()+"',"
                + "idCat= '"+pro.getIdCat()+"' "
                + "where idPro="+pro.getIdPro();
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
        String sql="delete from producto where idPro="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
    

