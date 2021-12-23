//16-Creamos el paquete ModeloDAO
//17-creamos javaclass claseDAO
package ModeloDAO;
//18- importamos:
import Intefaces.CRUDPersona;//19-Modificamos
import Modelo.Persona;//20- Modificamos
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements CRUDPersona{ //21- Implements CRUDclase
    //Lo dejamos igual linea 15-19
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p=new Persona();//22- Cambiamos la declaración del objeto (la primera letra del nombre de la clase max 2)
    
    @Override
    public List listar() {
        ArrayList<Persona>list=new ArrayList<>();// 23-Cambiamos ArrayList<Clase> por la clase que estemos utilizando
        String sql="select * from persona";// 24- Cambiamos en la sentencencia el nombre de la tabla
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Persona per=new Persona();//25- Cambiamos la declaración del objeto (3primeras letras del nombre de la clase)
                per.setId(rs.getInt("Id"));//26-Objetodeclarado.setatributo y en el parentesis (IdAtributo)
                per.setDni(rs.getString("DNI"));//26-Objetodeclarado.setatributo y en el parentesis (Nombre atributo inicia en mayus)
                per.setNom(rs.getString("Nombres"));//Igual para todos los atributos
                per.setApe(rs.getString("Apellidos"));
                per.setDir(rs.getString("Direccion"));
                per.setTel(rs.getString("Telefono"));
                per.setCor(rs.getString("Correo"));
                list.add(per);//27- cambiamos el objeto
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Persona list(int id) { //28- Cambiamos la clase
        String sql="select * from persona where Id="+id;//29- Cambiamos la tabla
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                p.setId(rs.getInt("Id"));//30- objetodeclarado en la linea 20. set atributo (Cambiamos el atributo)
                p.setDni(rs.getString("DNI"));// Igual para todos los campos
                p.setNom(rs.getString("Nombres"));
                p.setApe(rs.getString("Apellidos"));
                p.setDir(rs.getString("Direccion"));
                p.setTel(rs.getString("Telefono"));
                p.setCor(rs.getString("Correo"));
            }
        } catch (Exception e) {
        }
        return p;
    }

    @Override
    public boolean add(Persona per) {  // 32-Cambiamos Clase y objeto
        //33- Cambiamos la sentencia sql, nomb tabla(Atributos) y '"+Objeto.getAtributo()" por cada uno de los campos'
       String sql="insert into persona(DNI, Nombres, Apellidos, Direccion, Telefono, Correo)values('"+per.getDni()+"','"+per.getNom()+"','"+per.getApe()+"','"+per.getDir()+"','"+per.getTel()+"','"+per.getCor()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Persona per) {  // 34-Cambiamos Clase y objeto
        //35- Cambiamos la sentencia sql, nombre tabla, Atributos y '"+Objeto.getAtributo()"' por cada uno de los campos y el Id
        String sql="update persona set DNI='"+per.getDni()+"',Nombres='"+per.getNom()+"',Apellidos='"+per.getApe()+"',Direccion='"+per.getDir()+"',Telefono='"+per.getTel()+"',Correo='"+per.getCor()+"' where Id="+per.getId();
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
        String sql="delete from persona where Id="+id;//36- Cambiar nombre tabla
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}


