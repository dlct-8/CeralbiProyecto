
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Factura"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.FacturaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Facturas</title>
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
       <a href="ControladorVenta?accion=listar"><i class="fas fa-chart-line"></i>Ventas</a>
       <a class="active" href="ControladorFactura?accion=listar"><i class="fas fa-file-invoice-dollar"></i>Facturas</a>
       <a href="#"><i class="fas fa-boxes"></i>Inventario</a>
       <a href="#"><i class="fas fa-file-contract"></i>Reportes</a>
       <a href="ControladorContacto?accion=listar"><i class="fas fa-comment-dots"></i>Contacto</a>
       <div class="exit">
         <a href="Home.jsp"><i class="fas fa-sign-out-alt"></i>Salir</a>
       </div>
      </div>

        <div class="content">
            <h2>Facturas</h2>
            <a class="add" href="ControladorFactura?accion=add">
              <i class="fas fa-folder-plus"></i>
            </a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Emisión</th>
                        <th class="text-center">Vencimiento</th>
                        <th class="text-center">Cliente</th>
                        <th class="text-center">Vendedor</th>
                        <th class="text-center">Pedido</th>
                        <th class="text-center">Impuestos</th>

                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                    FacturaDAO dao=new FacturaDAO();
                    List<Factura>list=dao.listar();
                    Iterator<Factura>iter=list.iterator();
                    Factura fac=null;
                    while(iter.hasNext()){
                        fac=iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= fac.getIdfac()%></td>
                        <td class="text-center"><%= fac.getEmision()%></td>
                        <td><%= fac.getVencimiento()%></td>
                        <td><%= fac.getIdCli()%></td>
                        <td><%= fac.getIdVen()%></td>
                        <td><%= fac.getIdPed()%></td>
                        <td><%= fac.getImpuestos()%></td>

                        <td class="text-center">
                            <!-- Si quiere puede conservar id como llave para editar y eliminar-->
                            <a class="edit" href="ControladorFactura?accion=editar&id=<%= fac.getIdfac()%>">
                              <i class="fas fa-edit"></i>
                            </a>
                            <a class="delete" href="ControladorFactura?accion=eliminar&id=<%= fac.getIdfac()%>">
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
