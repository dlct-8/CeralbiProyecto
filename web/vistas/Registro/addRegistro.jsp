<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Config.Conexion"%>
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
                <h1>Agregar Registro</h1>
                <form action="ControladorRegistro">
                    Nombres:<br>
                    <input class="form-control" type="text" name="txtNombres"><br>
                    Apellidos: <br>
                    <input class="form-control" type="text" name="txtApellidos"><br>
                    Usuario: <br>
                    <input class="form-control" type="text" name="txtUsuario"><br>
                    Contraseña: <br>
                    <input class="form-control" type="text" name="txtContrasena"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="ControladorRegistro?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
