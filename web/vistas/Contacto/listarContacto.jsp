
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Contacto"%><!--50-Importar Clase-->
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.ContactoDAO"%><!--51-Importar ClaseDAO-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Mensajes</title>
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
       <a href="ControladorFactura?accion=listar"><i class="fas fa-file-invoice-dollar"></i>Facturas</a>
       <a href="#"><i class="fas fa-boxes"></i>Inventario</a>
       <a href="ReportesExcel.jsp"><i class="fas fa-file-contract"></i>Reportes</a>
       <a class="active" href="ControladorContacto?accion=listar"><i class="fas fa-comment-dots"></i>Contacto</a>
       <div class="exit">
         <a href="Home.jsp"><i class="fas fa-sign-out-alt"></i>Salir</a>
       </div>
      </div>

        <div class="content">
            <h2>Mensajes</h2><!--52-Cambiamos Nombre Clase-->
            <!--53-Cambiamos Nombre Controlador-->
            <a class="add" href="ControladorContacto?accion=add">
              <i class="fas fa-comment-medical"></i>
            </a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <!--54-Cambiamos Campos-->
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombres</th>
                        <th class="text-center">Apellidos</th>
                        <th class="text-center">Asunto</th>
                        <th class="text-center">Mensaje</th>

                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <!--55-Cambiamos declaración del objeto-->
                <%
                    ContactoDAO dao=new ContactoDAO();// Modificamos
                    List<Contacto>list=dao.listar();// Modificamos
                    Iterator<Contacto>iter=list.iterator();// Modificamos
                    Contacto con = null;// Modificamos
                    while(iter.hasNext()){
                        con = iter.next();// Modificamos

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= con.getIdCon()%></td><!--56-Cambiamos objeto.getId()-->
                        <td class="text-center"><%= con.getNombres()%></td><!--57-Cambiamos objeto.getAtributo()-->
                        <td><%= con.getApellidos()%></td>
                        <td><%= con.getAsunto()%></td>
                        <td><%= con.getMensaje()%></td>


                        <td class="text-center">
                            <!--59-Cambiamos Nombre Controlador y Cambiamos objeto.getId()-->
                            <a class="edit" href="ControladorContacto?accion=editar&id=<%= con.getIdCon()%>">
                              <i class="fas fa-edit"></i>
                            </a>
                            <a class="delete" href="ControladorContacto?accion=eliminar&id=<%= con.getIdCon()%>">
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
