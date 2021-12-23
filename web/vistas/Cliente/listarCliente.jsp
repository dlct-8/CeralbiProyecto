
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Cliente"%>
<%@page import="java.util.List"%>
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
            <h2>Clientes</h2>
            <a class="add" href="ControladorCliente?accion=add">
              <i class="fas fa-user-plus"></i>
            </a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombres</th>
                        <th class="text-center">Apellidos</th>
                        <th class="text-center">Tipo Documento</th>
                        <th class="text-center">Número de Documento</th>
                        <th class="text-center">Teléfono</th>
                        <th class="text-center">E-mail</th>
                        <th class="text-center">Dirección</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ClienteDAO dao=new ClienteDAO();
                    List<Cliente>list=dao.listar();
                    Iterator<Cliente>iter=list.iterator();
                    Cliente cli = null;
                    while(iter.hasNext()){
                        cli=iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= cli.getIdCli()%></td>
                        <td class="text-center"><%= cli.getNombres()%></td>
                        <td><%= cli.getApellidos()%></td>
                        <td><%= cli.getIdTipo()%></td>
                        <td><%= cli.getNumerodoc()%></td>
                        <td><%= cli.getTelefono()%></td>
                        <td><%= cli.getCorreo()%></td>
                        <td><%= cli.getDireccion()%></td>


                        <td class="text-center">
                            <!-- Si quiere puede conservar id como llave para editar y eliminar-->
                            <a class="edit" href="ControladorCliente?accion=editar&id=<%= cli.getIdCli()%>">
                              <i class="fas fa-edit"></i></a>
                            <a class="delete" href="ControladorCliente?accion=eliminar&id=<%= cli.getIdCli()%>">
                              <i class="fas fa-trash-alt"></i></a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
