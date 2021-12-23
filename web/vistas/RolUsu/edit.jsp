
<%@page import="Modelo.RolUsu"%>
<%@page import="ModeloDAO.RolUsuDAO"%>
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
              RolUsuDAO dao=new RolUsuDAO();
              int id=Integer.parseInt((String)request.getAttribute("idRolUsu"));
              RolUsu r=(RolUsu)dao.list(id);
          %>
            <h1>Modificar Rol Usuario</h1>
            <form action="ControladorRolUsu">
                Id Rol:<br>
                <input class="form-control" type="text" name="txtIdRol" value="<%= r.getIdRol()%>"><br>
                Id Usuario:<br>
                <input class="form-control" type="text" name="txtIdUsu" value="<%= r.getIdRol()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= r.getIdRol()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorRolUsu?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
