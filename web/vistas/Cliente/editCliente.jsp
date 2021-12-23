<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Config.Conexion"%>
<%@page import="Modelo.Cliente"%>
<%@page import="ModeloDAO.ClienteDAO"%>
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
              <%
              ClienteDAO dao=new ClienteDAO();
              int id=Integer.parseInt((String)request.getAttribute("llave"));
              Cliente cl=(Cliente)dao.list(id);
          %>
            <h2>Modificar Cliente</h2>
            <form action="ControladorCliente">

                 Nombres: <br>
                <input class="form-control" type="text" name="txtNombres" value="<%= cl.getNombres()%>"><br>
                 Apellidos: <br>
                <input class="form-control" type="text" name="txtApellidos" value="<%= cl.getApellidos()%>"><br>
                 Tipo Documento: <br>
                <input class="form-control" type="text"  name="txtIdTipo" value="<%= cl.getIdTipo()%>"><br>
                 Número de documento: <br>
                <input class="form-control" type="text"  name="txtNumerodoc" value="<%= cl.getNumerodoc()%>"><br>
                Telefono: <br>
                <input class="form-control" type="text"  name="txtTelefono" value="<%= cl.getTelefono()%>"><br>
                Correo: <br>
                <input class="form-control" type="email"  name="txtCorreo" value="<%= cl.getCorreo()%>"><br>
                 Dirección: <br>
                <input class="form-control" type="text"  name="txtDireccion" value="<%= cl.getDireccion()%>"><br>


                <input type="hidden" name="txtid" value="<%= cl.getIdCli()%>">
                <input class="add" type="submit" name="accion" value="Actualizar">
                <a class="add" href="ControladorCliente?accion=listar">Regresar</a>
            </form>
          </div>

        </div>
    </body>
</html>
