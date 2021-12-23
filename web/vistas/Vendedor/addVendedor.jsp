<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Config.Conexion"%>
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
        <h1>Agregar Vendedor</h1>
        
        <form action="ControladorVendedor" method="get">   
        <!-- Campos del Formulario -->
        Usuario: <br>
        <select class="form-control" name="txtIdUsu" id="txtIdUsu"> <br>
            <option>Opciones</option>
            <%   
            Conexion cn=new Conexion();
            Connection con;
            PreparedStatement ps;
            ResultSet rs;
            String sql1="select * from usuario";
                try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql1);
            rs=ps.executeQuery();
            while(rs.next()){
                out.println("<option value='"+rs.getInt("idUsu")+"'>"+rs.getString("nombreUsu")+ "</option>");
            }
        } catch (Exception e) {
        }
            %>
        </select><br>     
        
        Nombres: <br>
        <input class="form-control" type="text" name="txtNombresVen"><br>
        Apellidos: <br>
        <input class="form-control" type="text" name="txtApellidosVen"><br>
        Tipo Documento: <br>
        <input class="form-control" type="text" name="txtTipoDoc"><br>       
        Numero de documento: <br>
        <input class="form-control" type="text"  name="txtNumerodoc"><br>
        Teléfono: <br>
        <input class="form-control" type="text"  name="txtTelefono"><br>
        Correo: <br>
        <input class="form-control" type="text"  name="txtCorreo"><br>
                 
        <!-- Botón envio de datos -->
        <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
        <!-- Regredar a la vista show -->
        <a href="ControladorVendedor?accion=listar">Regresar</a>
        </form>
        
        </div>
        </div>
    </body>
</html>
