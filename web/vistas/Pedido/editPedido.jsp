<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Config.Conexion"%>
<%@page import="Modelo.Pedido"%>
<%@page import="ModeloDAO.PedidoDAO"%>
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
              PedidoDAO dao = new PedidoDAO();
              int id =Integer.parseInt((String)request.getAttribute("idPed"));
              Pedido pe=(Pedido)dao.list(id);
          %>
            <h1>Modificar Pedido</h1>
            <form action="ControladorPedido">
                Subtotal:<br>
                <input class="form-control" type="number" step="0.01" name="txtSubtotal" value="<%=pe.getSubtotal()%>"><br>
                Descuento: <br>
                <input class="form-control" type="number" step="0.01" name="txtDescuento" value="<%=pe.getDescuento()%>"><br>
                 Total: <br>
                <input class="form-control" type="number" step="0.01" name="txtTotal" value="<%=pe.getTotal()%>"><br>
                 
                <input type="hidden" name="txtid" value="<%= pe.getIdPed()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorPedido?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
