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
public class toExcel_pedido {
    
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
  File file = new File("C:\\Export_Excel\\pedido.xls");
  
    /**
     * Constructor de clase
     */
    public toExcel_pedido()
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
            workbook.createSheet( "Pedidos", 0 );
            excelSheet = workbook.getSheet(0);
            System.out.println(  "creando hoja excel.....Listo"  );            
        } catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }
        
        //Consulta SQL 
        String sql = "SELECT * FROM pedido ";
         try{
             PreparedStatement pstm = conn.prepareStatement( sql );
             ResultSet res = pstm.executeQuery();
             System.out.println(  "obteniendo registros.....Listo"  );
            
               
              excelSheet.setColumnView (0, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (1, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (2, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (3, 30); // Establecer el ancho de la columna
              
              
                  Label t1= new Label( 0 , row, "Número de Pedido" , cf );
                  Label t2= new Label( 1 , row, "Subtotal" , cf );                  
                  Label t3= new Label( 2 , row, "Descuento" , cf );                  
                  Label t4= new Label( 3 , row, "Total" , cf );
                  
                  
                  
                   try {
                     excelSheet.addCell( t1 );
                     excelSheet.addCell( t2 );
                     excelSheet.addCell( t3 );
                     excelSheet.addCell( t4 );
                     
                   }  catch (WriteException ex) {
                     System.err.println(  ex.getMessage() );
                 } 
                   row ++; 
             
              while(res.next())
              {
                  Label  idPed   = new Label( 0 , row, res.getString( "idPed" ) , cf );
                  Label subtotal  = new Label( 1 , row, res.getString( "subtotal" ) , cf );                  
                  Label descuento= new Label( 2 , row, res.getString( "descuento" ) , cf );                  
                  Label total= new Label( 3 , row, res.getString( "total" ) , cf );
                  
                  
               
                  row ++;                  
                 try {
                     excelSheet.addCell( idPed );
                     excelSheet.addCell( subtotal );
                     excelSheet.addCell( descuento );
                     excelSheet.addCell( total );
                     
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
          Logger.getLogger(toExcel_pedido.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public static void main(String[] args) {
        new toExcel_pedido().WriteExcel();
        /*excel.leerArchivoExcel("c:\\temporal\\output.xls"); */
try{
          /*Runtime.getRuntime().exec("cmd /c start C:\\\"Users\\\\Desktop\"\\File.xls");*/
          Runtime.getRuntime().exec("cmd /c start C:\\Export_Excel\\pedido.xls");
          }catch(IOException  e){
              e.printStackTrace();
          }
} 
        
  
}//--> fin clase
