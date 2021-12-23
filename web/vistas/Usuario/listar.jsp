
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
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
        <%@include file="../../Template/Templete2.jsp" %>
        <div class="container">
            <h1>Usuarios</h1>
            
            <a class="btn btn-success" href="ControladorUsuario?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        
                        <th class="text-center">ID</th>
                        <th class="text-center">CONTRASEÑA</th>
                        <th class="text-center">NOMBRE USUARIO</th>                       
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                
                <%
                    UsuarioDAO dao=new UsuarioDAO();
                    List<Usuario>list=dao.listar();
                    Iterator<Usuario>iter=list.iterator();
                    Usuario usu=null;
                    while(iter.hasNext()){
                        usu=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= usu.getIdUsu()%></td>
                        <td class="text-center"><%= usu.getContraseUsu()%></td>
                        <td><%= usu.getNombreUsu()%></td>
                        
                        <td class="text-center">
                            <!--59-Cambiamos Nombre Controlador y Cambiamos objeto.getId()-->
                            <a class="btn btn-warning" href="ControladorUsuario?accion=editar&id=<%= usu.getIdUsu()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorUsuario?accion=eliminar&id=<%= usu.getIdUsu()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
