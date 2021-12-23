
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Venta"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.VentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Ventas</title>
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
       <a href="ControladorProducto?accion=listar"><i class="fas fa-images"></i>Productos</a>
       <a href="ControladorCategoria?accion=listar"><i class="fas fa-filter"></i>Categorías</a>
       <a class="active" href="ControladorVenta?accion=listar"><i class="fas fa-chart-line"></i>Ventas</a>
       <a href="ControladorFactura?accion=listar"><i class="fas fa-file-invoice-dollar"></i>Facturas</a>
       <a href="#"><i class="fas fa-boxes"></i>Inventario</a>
       <a href="ReportesExcel.jsp"><i class="fas fa-file-contract"></i>Reportes</a>
       <a href="ControladorContacto?accion=listar"><i class="fas fa-comment-dots"></i>Contacto</a>
       <div class="exit">
         <a href="Home.jsp"><i class="fas fa-sign-out-alt"></i>Salir</a>
       </div>
      </div>

        <div class="content">
            <h2>Ventas</h2>
            <a class="add" href="ControladorVenta?accion=add">
              <i class="fas fa-cart-plus"></i></a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Pedido</th>
                        <th class="text-center">Fecha Realizado</th>
                        <th class="text-center">Fecha de Entrega</th>
                        <th class="text-center">Medio de Pago</th>
                        <th class="text-center">Método de Pago</th>
                        <th class="text-center">Dircción de Envío</th>

                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                    VentaDAO dao=new VentaDAO();
                    List<Venta>list=dao.listar();
                    Iterator<Venta>iter=list.iterator();
                    Venta objven=null;
                    while(iter.hasNext()){
                        objven=iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= objven.getIdVent()%></td>
                        <td class="text-center"><%= objven.getIdPed()%></td>
                        <td><%= objven.getFechaReal()%></td>
                        <td><%= objven.getFechaEntreg()%></td>
                        <td><%= objven.getIdmed()%></td>
                        <td><%= objven.getIdmet()%></td>
                        <td><%= objven.getDirEnvio()%></td>

                        <td class="text-center">
                            <!-- Si quiere puede conservar id como llave para editar y eliminar-->
                            <a class="edit" href="ControladorVenta?accion=editar&id=<%= objven.getIdVent()%>">
                              <i class="fas fa-edit"></i>
                            </a>
                            <a class="delete" href="ControladorVenta?accion=eliminar&id=<%= objven.getIdVent()%>">
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
