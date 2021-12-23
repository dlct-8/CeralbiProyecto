
<%@page import="Modelo.Usuario"%> 
<%@page import="ModeloDAO.UsuarioDAO"%>
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
              UsuarioDAO dao = new UsuarioDAO();
              int id=Integer.parseInt((String)request.getAttribute("idusu"));
              Usuario u =(Usuario)dao.list(id);
          %>
            <h1>Modificar Usuario</h1> 
            
            <form action="ControladorUsuario">
               
                Contraseña:<br>
                <input class="form-control" type="text" name="txtDni" value="<%= u.getContraseUsu()%>"><br>
                Usuario: <br>
                <input class="form-control" type="text" name="txtNom" value="<%= u.getNombreUsu()%>"><br>
                
              
                <input type="hidden" name="txtid" value="<%= u.getIdUsu()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <!--72-Cambiamos nombre del controlador-->
                <a href="ControladorUsuario?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
