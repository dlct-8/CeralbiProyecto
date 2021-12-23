<%@page import="java.io.IOException"%>
<%@ page import="exporttoexcel.toExcel_clientes" %>
<%
 new toExcel_clientes().WriteExcel();
 try{
     // cambiar la ruta de almacenamiento y el nombre del archivo
          Runtime.getRuntime().exec("cmd /c start C:\\Export_Excel\\Cliente.xls");
          }catch(IOException  e){
              e.printStackTrace();
          }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Archivo Exportado de forma correcta</h1>
        <!-- redirigir al la pagina que se desee-->
        <% response.sendRedirect("../Home.jsp"); %>
    </body>
</html>
