package exporttoexcel;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.*; 
import java.io.*; 
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class toExcel_clientes {
    
  /* DATOS PARA LA CONEXION */
  /** nombre de la base de datos*/
  private String db = "ceralbi4a";
  /** usuario */
  private String user = "root";
  /** contraseña de MySql*/
  private String password = "ZAYRA2507";
  /** Cadena de conexion */
  private String url = "jdbc:mysql://localhost:3306/"+db;
  /** variable para trabajar con la conexion a la base de datos */
  private Connection conn = null;  
  /** ruta y archivo de destino */
  File file = new File("C:\\Export_Excel\\Cliente.xls");
  
    /**
     * Constructor de clase
     */
    public toExcel_clientes()
    {
      this.url = "jdbc:mysql://localhost:3306/"+this.db;
       try{
         //obtenemos el driver para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         conn = DriverManager.getConnection( this.url, this.user , this.password );
         if ( conn!=null ){
            System.out.println("Conexión a la base de datos "+this.db+"...... Listo ");
         }
      }catch(SQLException e){
         System.err.println( e.getMessage() );
      }catch(ClassNotFoundException e){
         System.err.println( e.getMessage() );
      }
    }
    
    /**
     * Metodo para obtener los registros de la base de datos y crear el archivo excel
     */
    public void WriteExcel()
    {
        int row=0;
        //formato fuente para el contenido contenido
        WritableFont wf = new WritableFont( WritableFont.ARIAL, 12, WritableFont.NO_BOLD );
        WritableCellFormat cf = new WritableCellFormat(wf);    
       
        //Interfaz para una hoja de cálculo
        WritableSheet excelSheet = null;
        WritableWorkbook workbook = null;
        
        //Establece la configuración regional para generar la hoja de cálculo
        WorkbookSettings wbSettings = new WorkbookSettings();
        wbSettings.setLocale(new Locale("es", "ES"));
        
        try {
            workbook = Workbook.createWorkbook( file, wbSettings );
            //hoja con nombre de la tabla
            workbook.createSheet( "Cliente", 0 );
            excelSheet = workbook.getSheet(0);
            System.out.println(  "creando hoja excel.....Listo"  );            
        } catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }
        
        //Consulta SQL 
        String sql = "SELECT * FROM cliente ";
         try{
             PreparedStatement pstm = conn.prepareStatement( sql );
             ResultSet res = pstm.executeQuery();
             System.out.println(  "obteniendo registros.....Listo"  );
            
               
              excelSheet.setColumnView (0, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (1, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (2, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (3, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (4, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (5, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (6, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (7, 30); // Establecer el ancho de la columna
              
              
                  Label t1= new Label( 0 , row, "ID Cliente" , cf );
                  Label t2= new Label( 1 , row, "Nombres" , cf );                  
                  Label t3= new Label( 2 , row, "Apellidos" , cf );                  
                  Label t4= new Label( 3 , row, "Tipo documento" , cf );
                  Label t5= new Label( 4 , row, "Numero de documento"  , cf ); 
                  Label t6= new Label( 5 , row, "Teléfono" , cf );                  
                  Label t7= new Label( 6 , row, "Correo" , cf );                  
                  Label t8= new Label( 7 , row, "Dirección" , cf );
                  
                  
                  
                   try {
                     excelSheet.addCell( t1 );
                     excelSheet.addCell( t2 );
                     excelSheet.addCell( t3 );
                     excelSheet.addCell( t4 );
                     excelSheet.addCell( t5 );
                     excelSheet.addCell( t6 );
                     excelSheet.addCell( t7 );
                     excelSheet.addCell( t8 );
                   
                   }  catch (WriteException ex) {
                     System.err.println(  ex.getMessage() );
                 } 
                   row ++; 
             
              while(res.next())
              {
                  Label   idCli  = new Label( 0 , row, res.getString( "idCli" ) , cf );
                  Label  nombres = new Label( 1 , row, res.getString( "nombres" ) , cf );                  
                  Label apellidos= new Label( 2 , row, res.getString( "apellidos" ) , cf );                  
                  Label idTipo= new Label( 3 , row, res.getString( "idTipo" ) , cf );
                  Label numerodoc= new Label( 4 , row, res.getString( "numerodoc" )  , cf ); 
                  Label   telefono= new Label( 5 , row, res.getString( "telefono" ) , cf );                  
                  Label correo= new Label( 6 , row, res.getString( "correo" ) , cf );                  
                  Label direccion= new Label( 7 , row, res.getString( "direccion" ) , cf );
                  
                  
               
                  row ++;                  
                 try {
                     excelSheet.addCell( idCli );
                     excelSheet.addCell( nombres );
                     excelSheet.addCell(apellidos  );
                     excelSheet.addCell( idTipo );
                     excelSheet.addCell( numerodoc );
                     excelSheet.addCell( telefono );
                     excelSheet.addCell( correo );
                     excelSheet.addCell( direccion );
                   
                 } catch (WriteException ex) {
                     System.err.println(  ex.getMessage() );
                 } 
              }
             res.close();         
         }catch( SQLException e ){
            System.err.println( e.getMessage() );
        }
         
        //Escribe el archivo excel en disco
        try {
            workbook.write();
            workbook.close();
            System.out.println(  "Escribiendo en disco....Listo"  );         
        } catch (IOException ex) {
            System.err.println(  ex.getMessage() );
        }
        catch (WriteException ex) {
           System.err.println(  ex.getMessage() );
        }
        
        System.out.println(  "Proceso completado...."  );
      try {
          conn.close();
      } catch (SQLException ex) {
          Logger.getLogger(toExcel_clientes.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public static void main(String[] args) {
        new toExcel_clientes().WriteExcel();
        /*excel.leerArchivoExcel("c:\\temporal\\output.xls"); */
try{
          /*Runtime.getRuntime().exec("cmd /c start C:\\\"Users\\\\Desktop\"\\File.xls");*/
          Runtime.getRuntime().exec("cmd /c start C:\\Export_Excel\\Cliente.xls");
          }catch(IOException  e){
              e.printStackTrace();
          }
} 
        
  
}//--> fin clase
