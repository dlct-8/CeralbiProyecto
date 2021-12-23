
<%@page import="Modelo.Contacto"%> <!--65-Cambiamos la clase -->
<%@page import="ModeloDAO.ContactoDAO"%><!--66-Cambiamos la claseDAO-->
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
            <div class="col-lg-6">
                <!--67-Cambiamos la declaracón del objeto-->
              <%
              ContactoDAO dao = new ContactoDAO();// Modificamos
              int id=Integer.parseInt((String)request.getAttribute("idCon"));//Modificamos IdAtr
              Contacto c=(Contacto)dao.list(id);// Modificamos
          %>
            <h2>Modificar Contacto</h2> <!--68-Cambiamos el nombre de la pag-->
            <!--69-Cambiamos nombre del controlador txt-->
            <form action="ControladorContacto">
                <!--70-Cambiamos los campos y el objeto.getAtributo()-->

                Nombres: <br>
                <input class="form-control" type="text" name="txtNombres" value="<%= c.getNombres()%>"><br>
                Apellidos: <br>
                <input class="form-control" type="text" name="txtApellidos" value="<%= c.getApellidos()%>"><br>
                Asunto: <br>
                <input class="form-control" type="text" name="txtAsunto" value="<%= c.getAsunto()%>"><br>
                Mensaje: <br>
                <input class="form-control" type="text" name="txtMensaje" value="<%= c.getMensaje()%>"><br>


                <input type="hidden" name="txtid" value="<%= c.getIdCon()%>"><!--71-Cambiamos el obj.getId()-->
                <input class="add" type="submit" name="accion" value="Actualizar">
                <!--72-Cambiamos nombre del controlador-->
                <a class="add" href="ControladorContacto?accion=listar">Regresar</a>
            </form>
          </div>

        </div>
    </body>
</html>
