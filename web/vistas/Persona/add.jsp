
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
                <h1>Agregar Persona</h1> <!--60- Cambiamos la acción-->
                <!--61- Cambiamos el nombre del Controlador-->
                <form action="ControladorPer">
                  <!--62- Cambiamos los atributos-->  
                    DNI:<br>
                    <input class="form-control" type="text" name="txtDni"><br><!--63-Cambiamos en name= el atributo anteponiendo txt-->
                    Nombres: <br>
                    <input class="form-control" type="text" name="txtNom"><br><!--Igual para todos los campos-->
                    Apellidos: <br>
                    <input class="form-control" type="text" name="txtApe"><br>
                    Dirección: <br>
                    <input class="form-control" type="text" name="txtDir"><br>
                    Teléfono: <br>
                    <input class="form-control" type="text" name="txtTel"><br>
                    Correo: <br>
                    <input class="form-control" type="text" name="txtCor"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <!--64-Cambiamos el nombre del controlador-->
                    <a href="ControladorPer?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
