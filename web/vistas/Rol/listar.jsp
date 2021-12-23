
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Rol"%>
<%@page import="java.util.List"%>
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
        <%@include file="../../Template/Templete2.jsp" %>
        <div class="container">
            <h1>Roles</h1>
            <a class="btn btn-success" href="ControladorRo?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Nombre Rol</th>                        
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    RolDAO dao=new RolDAO();
                    List<Rol>list=dao.listar();
                    Iterator<Rol>iter=list.iterator();
                    Rol rol=null;
                    while(iter.hasNext()){
                        rol=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= rol.getIdRol()%></td>
                        <td class="text-center"><%= rol.getNombreRol()%></td>
                        
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorRo?accion=editar&id=<%= rol.getIdRol()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorRo?accion=eliminar&id=<%= rol.getIdRol()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
