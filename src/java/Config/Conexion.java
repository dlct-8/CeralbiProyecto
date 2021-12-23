//13-Creamos el paquete Config
//14-creamos una javaclass Conexion
package Config;
//15-Importamos import java.sql.*;
import java.sql.*;

public class Conexion {
    Connection con;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ceralbi4a","root","ZAYRA2507");   //Nombre de la conexion de BD, usuario root y contraseña         
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
