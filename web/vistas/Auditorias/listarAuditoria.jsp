
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Auditoria"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.AuditoriaDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Ceralbi - Administrador</title>
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
       <a href="#home"><i class="fas fa-tachometer-alt"></i>Dashboard</a>
       <a href="ControladorCliente?accion=listar"><i class="fas fa-address-book"></i>Clientes</a>
       <a href="ControladorProducto?accion=listar"><i class="fas fa-images"></i>Productos</a>
       <a class="active" href="ControladorCategoria?accion=listar"><i class="fas fa-filter"></i>Categorías</a>
       <a href="ControladorVenta?accion=listar"><i class="fas fa-chart-line"></i>Ventas</a>
       <a href="ControladorFactura?accion=listar"><i class="fas fa-file-invoice-dollar"></i>Facturas</a>
       <a href="#"><i class="fas fa-boxes"></i>Inventario</a>
       <a href="#"><i class="fas fa-file-contract"></i>Reportes</a>
       <a href="ControladorContacto?accion=listar"><i class="fas fa-comment-dots"></i>Contacto</a>
       <div class="exit">
         <a href="Home.jsp"><i class="fas fa-sign-out-alt"></i>Salir</a>
       </div>
      </div>

      <div class="content">
            <h2>Auditorias</h2>
              <a class="add" href="ControladorAuditoria?accion=add"><i class="fas fa-plus-square"></i>
                Agregar
              </a>

            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">USUARIO</th>
                        <th class="text-center">DESCRIPCION</th>
                        <th class="text-center">FECHA</th>

                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>
                <%
                    AuditoriaDAO dao=new AuditoriaDAO();
                    List<Auditoria>list=dao.listar();
                    Iterator<Auditoria>iter=list.iterator();
                    Auditoria aud = null;
                    while(iter.hasNext()){
                        aud = iter.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= aud.getUsuario()%></td>
                        <td class="text-center"><%= aud.getDescripcion()%></td>
                        <td><%= aud.getFecha()%></td>

                        <td class="text-center">
                            <a class="edit" href="ControladorAuditoria?accion=editar&usuario=<%= aud.getUsuario()%>">
                              <i class="fas fa-edit"></i>
                            </a>
                            <a class="delete" href="ControladorAuditoria?accion=eliminar&usuario=<%= aud.getUsuario()%>">
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
