<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Config.Conexion"%>
<%@page import="Modelo.Registro"%>
<%@page import="ModeloDAO.RegistroDAO"%>
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
              RegistroDAO dao=new RegistroDAO();
              int id=Integer.parseInt((String)request.getAttribute("idReg"));
              Registro r =(Registro)dao.list(id);
          %>
            <h1>Modificar Categoria</h1>
            <form action="ControladorRegistro">
                Nombres:<br>
                <input class="form-control" type="text" name="txtNombres" value="<%= r.getNombres()%>"><br>
                Apellidos: <br>
                <input class="form-control" type="text" name="txtApellidos" value="<%= r.getApellidos()%>"><br>
                Usuario <br>
                <input class="form-control" type="text" name="txtUsuario" value="<%= r.getUsuario()%>"><br>
                Contraseña: <br>
                <input class="form-control" type="text" name="txtContrasena" value="<%= r.getContrasena()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= r.getIdReg()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorRegistro?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
