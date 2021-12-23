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
        <h1>Agregar Pedido</h1>
        
        <form action="ControladorPedido" method="get">   
        <!-- Campos del Formulario -->
        Subtotal:<br>
        <input class="form-control" type="number" step="0.01" name="txtSubtotal"><br>
        Descuento: <br>
        <input class="form-control" type="number" step="0.01" name="txtDescuento"><br>
        Total: <br>
        <input class="form-control" type="number" step="0.01" name="txtTotal"><br>       
        
        
        <!-- Botón envio de datos -->
        <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
        <!-- Regredar a la vista show -->
        <a href="ControladorPedido?accion=listar">Regresar</a>
        </form>
        
        </div>
        </div>
    </body>
</html>
