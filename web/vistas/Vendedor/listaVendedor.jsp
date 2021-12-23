
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Vendedor"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.VendedorDAO"%>
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
            <h1>Vendedores</h1>
            <a class="btn btn-info" href="ControladorVendedor?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">USUARIO</th>                        
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">TIPO DOCUMENTO</th>
                        <th class="text-center">NUMERO DE DOCUMENTO</th>
                        <th class="text-center">TELEFONO</th>
                        <th class="text-center">CORREO</th>
                       
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    VendedorDAO dao=new VendedorDAO();
                    List<Vendedor>list=dao.listar();
                    Iterator<Vendedor>iter=list.iterator();
                    Vendedor ven=null;
                    while(iter.hasNext()){
                        ven=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= ven.getIdVen()%></td>                        
                        <td class="text-center"><%= ven.getIdUsu()%></td>
                        <td><%= ven.getNombresVen()%></td>
                        <td><%= ven.getApellidosVen()%></td>
                        <td><%= ven.getTipoDoc()%></td>
                        <td><%= ven.getNumerodoc()%></td>
                        <td><%= ven.getTelefono()%></td>
                        <td><%= ven.getCorreo()%></td>
                        <td class="text-center">
                            <!-- Si quiere puede conservar id como llave para editar y eliminar-->
                            <a class="btn btn-primary" href="ControladorVendedor?accion=editar&id=<%= ven.getIdVen()%>">Editar</a>
                            <a class="btn btn-warning" href="ControladorVendedor?accion=eliminar&id=<%= ven.getIdVen()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
