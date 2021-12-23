
package ModeloDAO;

import Intefaces.CRUDPedido;
import Modelo.Pedido;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements CRUDPedido {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Pedido pd=new Pedido();
    
      @Override
    public List listar() {
        ArrayList<Pedido>list=new ArrayList<>();
        String sql="select * from pedido";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Pedido ped=new Pedido();
                ped.setIdPed(rs.getInt("IdPed"));               
                ped.setSubtotal(rs.getFloat("Subtotal"));
                ped.setDescuento(rs.getFloat("Descuento"));
                ped.setTotal(rs.getFloat("Total"));
                
                list.add(ped);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Pedido list(int id) { 
        String sql="select * from pedido where IdPed="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                pd.setIdPed(rs.getInt("IdPed"));
                pd.setSubtotal(rs.getFloat("Subtotal"));
                pd.setDescuento(rs.getFloat("Descuento"));
                pd.setTotal(rs.getFloat("Total"));
                
            }
        } catch (Exception e) {
        }
        return pd;
    }

    @Override
    public boolean add(Pedido ped) {  // 32-Cambiamos Clase y objeto
        //33- Cambiamos la sentencia sql, nomb tabla(Atributos) y '"+Objeto.getAtributo()" por cada uno de los campos'
       String sql="insert into pedido"
               + "(Subtotal,"
               + "Descuento,"
               + "Total)"
               + "values"
               + "('"+ped.getSubtotal()+"',"
               + "'"+ped.getDescuento()+"',"
               + "'"+ped.getTotal()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Pedido ped) {  // 34-Cambiamos Clase y objeto
        //35- Cambiamos la sentencia sql, nombre tabla, Atributos y '"+Objeto.getAtributo()"' por cada uno de los campos y el Id
        String sql="update pedido set "
                + "Subtotal='"+ped.getSubtotal()+"',"
                + "Descuento='"+ped.getDescuento()+"',"
                + "Total='"+ped.getTotal()+"'"
                + " where IdPed="+ped.getIdPed();
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
        String sql="delete from pedido where IdPed="+id;//36- Cambiar nombre tabla
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}