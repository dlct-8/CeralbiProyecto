<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Config.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Clientes</title>
      <meta charset="UTF-8">
      <meta name="description" content="Ceralbi - La tienda en línea">
      <meta name="keywords" content="ceralbi, Encajas, eCommerce, cuadros, html">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Icon -->
      <link href="Imgs/LogoAzul.ico" rel="shortcut icon"/>

      <!-- Google Fonts -->
      <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet">
      <link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet">

      <script src="https://kit.fontawesome.com/cfe8b23fc4.js" crossorigin="anonymous"></script>

      <!-- Stylesheets -->
      <link rel="stylesheet" href="css/bootstrap.min.css"/>
      <link rel="stylesheet" href="css/storeadmin.css"/>
      <link rel="stylesheet" href="css/common.css"/>
      <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>
      <!-- The sidebar -->
      <div class="sidebar">
       <img src="Imgs/LogoAzulW.png" alt="Logo Ceralbi">
       <div class="adminClose">
        <i class="fas fa-user-cog" style="font-size:35px"></i><br>
     		Administrador
     	 </div>
       <a href="AdminPanel.jsp"><i class="fas fa-tachometer-alt"></i>Dashboard</a>
       <a class="active" href="ControladorCliente?accion=listar"><i class="fas fa-address-book"></i>Clientes</a>
       <a href="ControladorProducto?accion=listar"><i class="fas fa-images"></i>Productos</a>
  		 <a href="ControladorCategoria?accion=listar"><i class="fas fa-filter"></i>Categorías</a>
       <a href="ControladorVenta?accion=listar"><i class="fas fa-chart-line"></i>Ventas</a>
       <a href="ControladorFactura?accion=listar"><i class="fas fa-file-invoice-dollar"></i>Facturas</a>
       <a href="#"><i class="fas fa-boxes"></i>Inventario</a>
       <a href="ReportesExcel.jsp"><i class="fas fa-file-contract"></i>Reportes</a>
       <a href="ControladorContacto?accion=listar"><i class="fas fa-comment-dots"></i>Contacto</a>
       <div class="exit">
         <a href="Home.jsp"><i class="fas fa-sign-out-alt"></i>Salir</a>
       </div>
      </div>

        <div class="content">
        <div class="col-lg-6">
        <h2>Agregar Cliente</h2>

        <form action="ControladorCliente" method="get">
        <!-- Campos del Formulario -->
        Nombres: <br>
        <input class="form-control" type="text" name="txtNombres"><br>
        Apellidos: <br>
        <input class="form-control" type="text" name="txtApellidos"><br>
        Tipo Documento: <br>
        <select class="form-control" name="txtIdTipo" id="txtIdTipo"> <br>

            <%
            Conexion cn=new Conexion();
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            String sql1="select * from tipodocumento";
                try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql1);
            rs=ps.executeQuery();
            while(rs.next()){
                out.println("<option value='"+rs.getInt("IdTipo")+"'>"+rs.getString("tipodocumento")+ "</option>");
            }
        } catch (Exception e) {
        }
            %>
        </select><br>

        Numero de documento: <br>
        <input class="form-control" type="text" name="txtNumerodoc"><br>
        Telefono: <br>
        <input class="form-control" type="text" name="txtTelefono"><br>
        Correo: <br>
        <input class="form-control" type="email" name="txtCorreo"><br>
        Direccion: <br>
        <input class="form-control" type="text" name="txtDireccion"><br>



        <!-- Botón envio de datos -->
        <input class="add" type="submit" name="accion" value="Agregar">
        <!-- Regredar a la vista show -->
        <a class="add" href="ControladorCliente?accion=listar">Regresar</a>
        </form>

        </div>
        </div>
    </body>
</html>
