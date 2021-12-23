
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Persona"%><!--50-Importar Clase-->
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.PersonaDAO"%><!--51-Importar ClaseDAO-->
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
            <h1>Personas</h1><!--52-Cambiamos Nombre Clase-->
            <!--53-Cambiamos Nombre Controlador-->
            <a class="btn btn-success" href="ControladorPer?accion=add">Agregar Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <!--54-Cambiamos Campos-->
                        <th class="text-center">ID</th>
                        <th class="text-center">DNI</th>
                        <th class="text-center">NOMBRES</th>
                        <th class="text-center">APELLIDOS</th>
                        <th class="text-center">DIRECCION</th>
                        <th class="text-center">TELEFONO</th>
                        <th class="text-center">CORREO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <!--55-Cambiamos declaración del objeto-->
                <%
                    PersonaDAO dao=new PersonaDAO();// Modificamos
                    List<Persona>list=dao.listar();// Modificamos
                    Iterator<Persona>iter=list.iterator();// Modificamos
                    Persona per=null;// Modificamos
                    while(iter.hasNext()){
                        per=iter.next();// Modificamos
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= per.getId()%></td><!--56-Cambiamos objeto.getId()-->
                        <td class="text-center"><%= per.getDni()%></td><!--57-Cambiamos objeto.getAtributo()-->
                        <td><%= per.getNom()%></td><!--58-Igual para todos los campos-->
                        <td><%= per.getApe()%></td>
                        <td><%= per.getDir()%></td>
                        <td><%= per.getTel()%></td>
                        <td><%= per.getCor()%></td>
                        <td class="text-center">
                            <!--59-Cambiamos Nombre Controlador y Cambiamos objeto.getId()-->
                            <a class="btn btn-warning" href="ControladorPer?accion=editar&id=<%= per.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorPer?accion=eliminar&id=<%= per.getId()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
