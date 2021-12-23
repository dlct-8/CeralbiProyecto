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
public class toExcel_productos {
    
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
  File file = new File("C:\\Export_Excel\\producto.xls");
  
    /**
     * Constructor de clase
     */
    public toExcel_productos()
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
            workbook.createSheet( "Productos", 0 );
            excelSheet = workbook.getSheet(0);
            System.out.println(  "creando hoja excel.....Listo"  );            
        } catch (IOException ex) {
            System.err.println( ex.getMessage() );
        }
        
        //Consulta SQL 
        String sql = "SELECT * FROM producto ";
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
              excelSheet.setColumnView (8, 30); // Establecer el ancho de la columna
              
                  Label t1= new Label( 0 , row, "ID Producto" , cf );
                  Label t2= new Label( 1 , row, "Nombre Producto" , cf );                  
                  Label t3= new Label( 2 , row, "Descripción" , cf );                  
                  Label t4= new Label( 3 , row, "Medidas" , cf );
                  Label t5= new Label( 4 , row, "Unidades"  , cf ); 
                  Label t6= new Label( 5 , row, "Precio costo" , cf );                  
                  Label t7= new Label( 6 , row, "Precio venta" , cf );                  
                  Label t8= new Label( 7 , row, "Imagen Producto" , cf );
                  Label t9= new Label( 8 , row, "Categoria"  , cf ); 
                  
                  
                   try {
                     excelSheet.addCell( t1 );
                     excelSheet.addCell( t2 );
                     excelSheet.addCell( t3 );
                     excelSheet.addCell( t4 );
                     excelSheet.addCell( t5 );
                     excelSheet.addCell( t6 );
                     excelSheet.addCell( t7 );
                     excelSheet.addCell( t8 );
                     excelSheet.addCell( t9 );
                   }  catch (WriteException ex) {
                     System.err.println(  ex.getMessage() );
                 } 
                   row ++; 
             
              while(res.next())
              {
                  Label   idPro  = new Label( 0 , row, res.getString( "idPro" ) , cf );
                  Label  nombrePro = new Label( 1 , row, res.getString( "nombrePro" ) , cf );                  
                  Label descripcion= new Label( 2 , row, res.getString( "descripcion" ) , cf );                  
                  Label medidas= new Label( 3 , row, res.getString( "medidas" ) , cf );
                  Label unidades= new Label( 4 , row, res.getString( "unidades" )  , cf ); 
                  Label  precioCosto = new Label( 5 , row, res.getString( "precioCosto" ) , cf );                  
                  Label precioVenta= new Label( 6 , row, res.getString( "precioVenta" ) , cf );                  
                  Label imagenProd= new Label( 7 , row, res.getString( "imagenProd" ) , cf );
                  Label idCat= new Label( 8, row, res.getString( "idCat" )  , cf );
                  
               
                  row ++;                  
                 try {
                     excelSheet.addCell( idPro );
                     excelSheet.addCell( nombrePro );
                     excelSheet.addCell( descripcion );
                     excelSheet.addCell( medidas );
                     excelSheet.addCell( unidades );
                     excelSheet.addCell( precioCosto );
                     excelSheet.addCell( precioVenta );
                     excelSheet.addCell( imagenProd );
                     excelSheet.addCell( idCat );
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
          Logger.getLogger(toExcel_productos.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    
    public static void main(String[] args) {
        new toExcel_productos().WriteExcel();
        /*excel.leerArchivoExcel("c:\\temporal\\output.xls"); */
try{
          /*Runtime.getRuntime().exec("cmd /c start C:\\\"Users\\\\Desktop\"\\File.xls");*/
          Runtime.getRuntime().exec("cmd /c start C:\\Export_Excel\\producto.xls");
          }catch(IOException  e){
              e.printStackTrace();
          }
} 
        
  
}//--> fin clase
