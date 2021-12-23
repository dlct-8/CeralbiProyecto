
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.RolUsu"%>
<%@page import="java.util.List"%>
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
        <%@include file="../../Template/Templete2.jsp" %>
        <div class="container">
            <h1>Roles</h1>
            <a class="btn btn-success" href="ControladorRolUsu?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id Rol</th> 
                        <th class="text-center">Id Usuario</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    RolUsuDAO dao=new RolUsuDAO();
                    List<RolUsu>list=dao.listar();
                    Iterator<RolUsu>iter=list.iterator();
                    RolUsu rls=null;
                    while(iter.hasNext()){
                        rls=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= rls.getIdRolUsu()%></td>
                        <td class="text-center"><%= rls.getIdRol()%></td>
                        <td class="text-center"><%= rls.getIdUsu()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorRolUsu?accion=editar&id=<%= rls.getIdRolUsu()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorRolUsu?accion=eliminar&id=<%= rls.getIdRolUsu()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
