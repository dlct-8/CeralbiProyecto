<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Config.Conexion"%>
<%@page import="Modelo.Vendedor"%>
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
        <div class="container">
            <div class="col-lg-6">
              <%
              VendedorDAO dao=new VendedorDAO();
              int id=Integer.parseInt((String)request.getAttribute("idVen"));
              Vendedor v=(Vendedor)dao.list(id);
          %>
            <h1>Modificar Vendedore</h1>
            <form action="ControladorVendedor">
                Usuario: <br>
                <input class="form-control" type="text" name="txtIdUsu" value="<%=v.getIdUsu()%>"><br>
                Nombres: <br>
                <input class="form-control" type="text" name="txtNombresVen" value="<%=v.getNombresVen()%>"><br>
                 Apellidos: <br>
                <input class="form-control" type="text" name="txtApellidosVen" value="<%=v.getApellidosVen()%>"><br>                
                Tipo Documento: <br>
                <input class="form-control" type="text" name="txtTipoDoc" value="<%=v.getTipoDoc()%>" ><br>
                Numero de documento: <br>
                <input class="form-control" type="text" name="txtNumerodoc" value="<%=v.getNumerodoc()%>"><br>
                Telefono: <br>
                <input class="form-control" type="text" name="txtTelefono" value="<%=v.getTelefono()%>"><br>
                Correo: <br>
                <input class="form-control" type="text" name="txtCorreo" value="<%=v.getCorreo()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= v.getIdVen()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="ControladorVendedor?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
