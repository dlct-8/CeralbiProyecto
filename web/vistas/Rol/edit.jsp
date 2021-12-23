
<%@page import="Modelo.Rol"%>
<%@page import="ModeloDAO.RolDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
              <%
              RolDAO dao=new RolDAO();
              int id=Integer.parseInt((String)request.getAttribute("idRol"));
              Rol r=(Rol)dao.list(id);
          %>
            <h1>Modificar Rol</h1>
            <form action="ControladorRo">
                Nombre rol:<br>
                <input class="form-control" type="text" name="txtNombreRol" value="<%= r.getIdRol()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= r.getIdRol()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorRo?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
