
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Pedido"%>
<%@page import="java.util.List"%>
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
        <%@include file="../../Template/Templete2.jsp" %>
        <div class="container">
            <h1>Pedidos</h1>
            <a class="btn btn-info" href="ControladorPedido?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">SUBTOTAL</th>
                        <th class="text-center">DESCUENTO</th>
                        <th class="text-center">TOTAL</th>                        
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    PedidoDAO dao=new PedidoDAO();
                    List<Pedido>list=dao.listar();
                    Iterator<Pedido>iter=list.iterator();
                    Pedido ped=null;
                    while(iter.hasNext()){
                        ped=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= ped.getIdPed()%></td>
                        <td class="text-center"><%= ped.getSubtotal()%></td>
                        <td><%= ped.getDescuento()%></td>
                        <td><%= ped.getTotal()%></td>                        
                        <td class="text-center">
                            <!-- Si quiere puede conservar id como llave para editar y eliminar-->
                            <a class="btn btn-primary" href="ControladorPedido?accion=editar&id=<%= ped.getIdPed()%>">Editar</a>
                            <a class="btn btn-warning" href="ControladorPedido?accion=eliminar&id=<%= ped.getIdPed()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
