<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Config.Conexion"%>
<%@page import="Modelo.Producto"%>
<%@page import="ModeloDAO.ProductoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Productos</title>
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
       <a href="ControladorCliente?accion=listar"><i class="fas fa-address-book"></i>Clientes</a>
       <a class="active" href="ControladorProducto?accion=listar"><i class="fas fa-images"></i>Productos</a>
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
              ProductoDAO dao=new ProductoDAO();
              int id=Integer.parseInt((String)request.getAttribute("idPro"));
              Producto pr =(Producto)dao.list(id);
          %>
            <h2>Modificar Producto</h2>
            <form action="ControladorProducto">
                Nombre producto:<br>
                <input class="form-control" type="text" name="txtNombrePro" value="<%=pr.getNombrePro()%>"><br>
                Descripción: <br>
                <input class="form-control" type="text" name="txtDescripcion" value="<%=pr.getDescripcion()%>"><br>
                 Medidas: <br>
                <input class="form-control" type="text" name="txtMedidas" value="<%=pr.getMedidas()%>"><br>
                 Unidades: <br>
                <input class="form-control"  type="number" name="txtUnidades" value="<%=pr.getUnidades()%>"><br>
                 Precio Costo: <br>
                <input class="form-control" type="number" step="0.01" name="txtPrecioCosto" value="<%= pr.getPrecioCosto()%>"><br>
                Precio Venta: <br>
                <input class="form-control" type="number" step="0.01" name="txtPrecioVenta" value="<%=pr.getPrecioVenta()%>" ><br>

                Imagen Producto: <br>
                <input class="form-control" type="text" name="txtImagenProd" value="<%=pr.getImagenProd()%>"><br>
                Categoria: <br>
                <input class="form-control" type="text" name="txtIdCat" value="<%=pr.getIdCat()%>"><br>

                <input type="hidden" name="txtid" value="<%= pr.getIdPro()%>">
                <input class="add" type="submit" name="accion" value="Actualizar">
                <a class="add" href="ControladorProducto?accion=listar">Regresar</a>
            </form>
          </div>

        </div>
    </body>
</html>
