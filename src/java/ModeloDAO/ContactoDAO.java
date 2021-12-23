
package ModeloDAO;

import Config.Conexion;
import Modelo.Contacto;
import Intefaces.CRUDContacto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO implements CRUDContacto{
     //Lo dejamos igual linea 15-19
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Contacto c=new Contacto();//22- Cambiamos la declaración del objeto (la primera letra del nombre de la clase max 2)
    
    @Override
    public List listar() {
        ArrayList<Contacto>list=new ArrayList<>();// 23-Cambiamos ArrayList<Clase> por la clase que estemos utilizando
        String sql="select * from contacto";// 24- Cambiamos en la sentencencia el nombre de la tabla
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Contacto cont=new Contacto();  
                cont.setIdCon(rs.getInt("IdCon"));                
                cont.setNombres(rs.getString("Nombres"));
                cont.setApellidos(rs.getString("Apellidos"));
                cont.setAsunto(rs.getString("Asunto"));
                cont.setMensaje(rs.getString("Mensaje"));
               
                
                list.add(cont);//27- cambiamos el objeto
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Contacto list(int id) { //28- Cambiamos la clase
        String sql="select * from contacto where IdCon="+id;//29- Cambiamos la tabla
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                c.setIdCon(rs.getInt("IdCon"));                
                c.setNombres(rs.getString("Nombres"));
                c.setApellidos(rs.getString("Apellidos"));
                c.setAsunto(rs.getString("Asunto"));
                c.setMensaje(rs.getString("Mensaje"));
               
            }
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public boolean add(Contacto cont) {  // 32-Cambiamos Clase y objeto
        //33- Cambiamos la sentencia sql, nomb tabla(Atributos) y '"+Objeto.getAtributo()" por cada uno de los campos'
       String sql="insert into contacto( Nombres, Apellidos, Asunto, mensaje)values('"+cont.getNombres()+"','"+cont.getApellidos()+"','"+cont.getAsunto()+"','"+cont.getMensaje()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Contacto cont) {  // 34-Cambiamos Clase y objeto
        //35- Cambiamos la sentencia sql, nombre tabla, Atributos y '"+Objeto.getAtributo()"' por cada uno de los campos y el Id
        String sql="update contacto set Nombres='"+cont.getNombres()+"',Apellidos='"+cont.getApellidos()+"',Asunto='"+cont.getAsunto()+"',mensaje='"+cont.getMensaje()+"' where IdCon="+cont.getIdCon();
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
        String sql="delete from contacto where IdCon="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}

