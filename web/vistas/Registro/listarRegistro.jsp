
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Registro"%>
<%@page import="java.util.List"%>
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
        
        <%@include file="../../Template/Templete2.jsp" %>
        <div class="container">
            <h1>Registros</h1>
            <a class="btn bg-info" href="ControladorRegistro?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID REGISTRO</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">USUARIO</th>
                        <th class="text-center">CONTRASEÑA</th>
                        
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    RegistroDAO dao=new RegistroDAO();
                    List<Registro>list=dao.listar();
                    Iterator<Registro>iter=list.iterator();
                    Registro reg = null;
                    while(iter.hasNext()){
                        reg = iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= reg.getIdReg()%></td>
                        <td class="text-center"><%= reg.getNombres()%></td>
                        <td><%= reg.getApellidos()%></td>
                        <td><%= reg.getUsuario()%></td>
                        <td><%= reg.getContrasena()%></td>
                      
                        <td class="text-center">
                            <a class="btn btn-primary" href="ControladorRegistro?accion=editar&id=<%= reg.getIdReg()%>">Editar</a>
                            <a class="btn btn-warning" href="ControladorRegistro?accion=eliminar&id=<%= reg.getIdReg()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
