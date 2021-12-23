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
public class toExcel_consultaFactura {
    
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
  File file = new File("C:\\Export_Excel\\factura.xls");
  
    /**
     * Constructor de clase
     */
    public toExcel_consultaFactura()
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
            workbook.createSheet( "Factura", 0 );
            excelSheet = workbook.getSheet(0);
            System.out.println(  "creando hoja excel.....Listo"  );            
        } catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }
        
        //Consulta SQL 
        String sql = "select factura.idfac, vendedor.nombresVen, vendedor.ApellidosVen, cliente.nombres, cliente. apellidos, pedido.total   \n" +
                        "from pedido \n" +
                        "inner join factura on factura.idPed = pedido.idPed\n" +
                        "inner join cliente on cliente.idCli = factura.idCli\n" +
                        "inner join vendedor on vendedor.idVen = factura.idVen  ";
         try{
             PreparedStatement pstm = conn.prepareStatement( sql );
             ResultSet res = pstm.executeQuery();
             System.out.println(  "obteniendo registros.....Listo"  );
            
               
              excelSheet.setColumnView (0, 15); // Establecer el ancho de la columna
              excelSheet.setColumnView (1, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (2, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (3, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (4, 30); // Establecer el ancho de la columna
              excelSheet.setColumnView (5, 30); // Establecer el ancho de la columna
              
                  Label t1= new Label( 0 , row, "ID factura" , cf );
                  Label t2= new Label( 1 , row, "Nombres Vendedor" , cf );                  
                  Label t3= new Label( 2 , row, "Apellidos Vendedor" , cf );                  
                  Label t4= new Label( 3 , row, "Nombres Cliente" , cf );
                  Label t5= new Label( 4 , row, "Apellidos Cliente" , cf );
                  Label t6= new Label( 5 , row, "Total" , cf );
                  
                   try {
                     excelSheet.addCell( t1 );
                     excelSheet.addCell( t2 );
                     excelSheet.addCell( t3 );
                     excelSheet.addCell( t4 );
                     excelSheet.addCell( t5 );
                     excelSheet.addCell( t6 );
                     
                   }  catch (WriteException ex) {
                     System.err.println(  ex.getMessage() );
                 } 
                   row ++; 
             
              while(res.next())
              {
                  Label  idfac   = new Label( 0 , row, res.getString( "idfac" ) , cf );
                  Label nombresVen  = new Label( 1 , row, res.getString( "nombresVen" ) , cf );                  
                  Label ApellidosVen= new Label( 2 , row, res.getString( "ApellidosVen" ) , cf );                  
                  Label nombres= new Label( 3 , row, res.getString( "nombres" ) , cf );
                  Label apellidos= new Label( 4 , row, res.getString( "apellidos" ) , cf );
                  Label total= new Label( 5 , row, res.getString( "total" ) , cf );
                  
                  
               
                  row ++;                  
                 try {
                     excelSheet.addCell( idfac );
                     excelSheet.addCell( nombresVen );
                     excelSheet.addCell( ApellidosVen );
                     excelSheet.addCell( nombres );
                     excelSheet.addCell( apellidos );
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
          Logger.getLogger(toExcel_consultaFactura.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public static void main(String[] args) {
        new toExcel_consultaFactura().WriteExcel();
        /*excel.leerArchivoExcel("c:\\temporal\\output.xls"); */
try{
          /*Runtime.getRuntime().exec("cmd /c start C:\\\"Users\\\\Desktop\"\\File.xls");*/
          Runtime.getRuntime().exec("cmd /c start C:\\Export_Excel\\factura.xls");
          }catch(IOException  e){
              e.printStackTrace();
          }
} 
        
  
}//--> fin clase
