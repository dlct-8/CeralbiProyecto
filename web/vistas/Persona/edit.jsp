
<%@page import="Modelo.Persona"%> <!--65-Cambiamos la clase -->
<%@page import="ModeloDAO.PersonaDAO"%><!--66-Cambiamos la claseDAO-->
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
                <!--67-Cambiamos la declaracón del objeto-->
              <%
              PersonaDAO dao = new PersonaDAO();// Modificamos
              int id=Integer.parseInt((String)request.getAttribute("idper"));//Modificamos IdAtr
              Persona p=(Persona)dao.list(id);// Modificamos
          %>
            <h1>Modificar Persona</h1> <!--68-Cambiamos el nombre de la pag-->
            <!--69-Cambiamos nombre del controlador txt-->
            <form action="ControladorPer">
                <!--70-Cambiamos los campos y el objeto.getAtributo()-->
                DNI:<br>
                <input class="form-control" type="text" name="txtDni" value="<%= p.getDni()%>"><br>
                Nombres: <br>
                <input class="form-control" type="text" name="txtNom" value="<%= p.getNom()%>"><br>
                Apellidos: <br>
                <input class="form-control" type="text" name="txtApe" value="<%= p.getApe()%>"><br>
                Dirección: <br>
                <input class="form-control" type="text" name="txtDir" value="<%= p.getDir()%>"><br>
                Teléfono: <br>
                <input class="form-control" type="text" name="txtTel" value="<%= p.getTel()%>"><br>
                Correo: <br>
                <input class="form-control" type="text" name="txtCor" value="<%= p.getCor()%>"><br>
              
                <input type="hidden" name="txtid" value="<%= p.getId()%>"><!--71-Cambiamos el obj.getId()-->
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <!--72-Cambiamos nombre del controlador-->
                <a href="ControladorPer?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
