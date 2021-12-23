
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Producto"%>
<%@page import="java.util.List"%>
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
            <h2>Productos</h2>
            <a class="add" href="ControladorProducto?accion=add">
              <i class="fas fa-cart-plus"></i></a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre Producto</th>
                        <th class="text-center">Descripción</th>
                        <th class="text-center">Medidas</th>
                        <th class="text-center">Unidades</th>
                        <th class="text-center">Costo</th>
                         <th class="text-center">Precio</th>
                        <th class="text-center">Imagen</th>
                        <th class="text-center">Categoría</th>

                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                    ProductoDAO dao=new ProductoDAO();
                    List<Producto>list=dao.listar();
                    Iterator<Producto>iter=list.iterator();
                    Producto pro=null;
                    while(iter.hasNext()){
                        pro=iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= pro.getIdPro()%></td>
                        <td class="text-center"><%= pro.getNombrePro()%></td>
                        <td><%= pro.getDescripcion()%></td>
                        <td><%= pro.getMedidas()%></td>
                        <td><%= pro.getUnidades()%></td>
                        <td><%= pro.getPrecioCosto()%></td>
                        <td><%= pro.getPrecioVenta()%></td>
                        <td><%= pro.getImagenProd()%></td>
                        <td><%= pro.getIdCat()%></td>

                        <td class="text-center">
                            <!-- Si quiere puede conservar id como llave para editar y eliminar-->
                            <a class="edit" href="ControladorProducto?accion=editar&id=<%= pro.getIdPro()%>">
                              <i class="fas fa-edit"></i>
                            </a>
                            <a class="delete" href="ControladorProducto?accion=eliminar&id=<%= pro.getIdPro()%>">
                              <i class="fas fa-trash-alt"></i>
                            </a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
