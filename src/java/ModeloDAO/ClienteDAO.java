
package ModeloDAO;

import Intefaces.CRUDCliente;
import Modelo.Cliente;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO implements CRUDCliente {
    
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Cliente cl = new Cliente();
    
 @Override
    public List listar() {
        ArrayList<Cliente>list=new ArrayList<>();
        String sql="select * from cliente";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                Cliente cli =new Cliente();                
                cli.setIdCli(rs.getInt("IdCli"));
                cli.setNombres(rs.getString("Nombres"));
                cli.setApellidos(rs.getString("Apellidos"));
                cli.setIdTipo(rs.getInt("IdTipo"));
                cli.setNumerodoc(rs.getString("Numerodoc"));
                cli.setTelefono(rs.getString("Telefono"));
                cli.setCorreo(rs.getString("Correo"));
                cli.setDireccion(rs.getString("Direccion"));             
                
                list.add(cli);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Cliente list(int id) { 
        String sql="select * from cliente where IdCli="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                cl.setIdCli(rs.getInt("IdCli"));
                cl.setNombres(rs.getString("Nombres"));
                cl.setApellidos(rs.getString("Apellidos"));
                cl.setIdTipo(rs.getInt("IdTipo"));
                cl.setNumerodoc(rs.getString("Numerodoc"));
                cl.setTelefono(rs.getString("Telefono"));
                cl.setCorreo(rs.getString("Correo"));
                cl.setDireccion(rs.getString("Direccion"));
                
                
            }
        } catch (Exception e) {
        }
        return cl;
    }

    @Override
    public boolean add(Cliente cli) {  // 32-Cambiamos Clase y objeto
        //33- Cambiamos la sentencia sql, nomb tabla(Atributos) y '"+Objeto.getAtributo()" por cada uno de los campos'
       String sql="insert into cliente"
               + "(Nombres,"
               + " Apellidos, "
               + " IdTipo,"
               + " Numerodoc,"
               + " Telefono,"
               + " Correo,"
               + " Direccion)"
                        
               + "values("
               + "'"+cli.getNombres()+"',"
               + "'"+cli.getApellidos()+"',"
               + "'"+cli.getIdTipo()+"',"
               + "'"+cli.getNumerodoc()+"',"
               + "'"+cli.getTelefono()+"',"
               + "'"+cli.getCorreo()+"',"
               + "'"+cli.getDireccion()+"'"
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
    public boolean edit(Cliente cli) { 
        
        String sql="update cliente set "
                + "Nombres='"+cli.getNombres()+"',"
                + "Apellidos='"+cli.getApellidos()+"',"
                + "IdTipo='"+cli.getIdTipo()+"',"
                + "Numerodoc='"+cli.getNumerodoc()+"',"
                + "Telefono='"+cli.getTelefono()+"',"
                + "Correo='"+cli.getCorreo()+"',"                
                + "Direccion='"+cli.getDireccion()+"' "
                + " where IdCli="+cli.getIdCli();
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
        String sql="delete from cliente where IdCli="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}


