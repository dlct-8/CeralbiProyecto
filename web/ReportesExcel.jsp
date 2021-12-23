<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <title>Ceralbi - Administrador</title>
      <meta charset="UTF-8">
      <meta name="description" content="Ceralbi - La tienda en línea">
      <meta name="keywords" content="ceralbi, Encajas, eCommerce, cuadros, html">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Icon -->
      <link href="Imgs/LogoAzul.ico" rel="shortcut icon"/>

      <!-- Google Fonts -->
      <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet">
      <link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet">

      <script src="https://kit.fontawesome.com/cfe8b23fc4.js" crossorigin="anonymous"></script>

      <!-- Stylesheets -->
      <link rel="stylesheet" href="css/bootstrap.min.css"/>
      <link rel="stylesheet" href="css/storeadmin.css"/>
      <link rel="stylesheet" href="css/common.css"/>
      <link rel="stylesheet" href="css/main.css"/>
    </head>
    <body>

      <!-- The sidebar -->
      <div class="sidebar">
       <img src="Imgs/LogoAzulW.png" alt="Logo Ceralbi">
       <div class="adminClose">
        <i class="fas fa-user-cog" style="font-size:35px"></i><br>
     		Administrador
     	 </div>
       <a href="#home"><i class="fas fa-tachometer-alt"></i>Dashboard</a>
       <a href="ControladorCliente?accion=listar"><i class="fas fa-address-book"></i>Clientes</a>
       <a href="ControladorProducto?accion=listar"><i class="fas fa-images"></i>Productos</a>
  		 <a href="ControladorCategoria?accion=listar"><i class="fas fa-filter"></i>Categorías</a>
       <a href="ControladorVenta?accion=listar"><i class="fas fa-chart-line"></i>Ventas</a>
       <a href="ControladorFactura?accion=listar"><i class="fas fa-file-invoice-dollar"></i>Facturas</a>
       <a href="#"><i class="fas fa-boxes"></i>Inventario</a>
       <a class="active" href="ReportesExcel.jsp"><i class="fas fa-file-contract"></i>Reportes</a>
       <a href="ControladorContacto?accion=listar"><i class="fas fa-comment-dots"></i>Contacto</a>
       <div class="exit">
         <a href="Home.jsp"><i class="fas fa-sign-out-alt"></i>Salir</a>
       </div>
      </div>

      <div class="content">
            <h2>Reportes</h2>

            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Reporte</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Descripción</th>

                        <th class="text-center">Acciones</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td class="text-center">1</td>
                        <td class="text-center">Clientes</td>
                        <td>Listado de Clientes</td>

                        <td class="text-center">
                            <a class="edit" href="Exportaciones/Exp_clientes.jsp">
                              <i class="fas fa-file-excel"></i>  Descargar
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">2</td>
                        <td class="text-center">Facturas</td>
                        <td>Listado de Facturas</td>

                        <td class="text-center">
                            <a class="edit" href="Exportaciones/Exp_ConsultasFactura.jsp">
                              <i class="fas fa-file-excel"></i>  Descargar
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">3</td>
                        <td class="text-center">Ventas</td>
                        <td>Listado de Ventas</td>

                        <td class="text-center">
                            <a class="edit" href="Exportaciones/Exp_ConsultasVentas.jsp">
                              <i class="fas fa-file-excel"></i>  Descargar
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">4</td>
                        <td class="text-center">Pedidos</td>
                        <td>Listado de Pedidos</td>

                        <td class="text-center">
                            <a class="edit" href="Exportaciones/Exp_Pedidos.jsp">
                              <i class="fas fa-file-excel"></i>  Descargar
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">5</td>
                        <td class="text-center">Productos</td>
                        <td>Listado de Productos</td>

                        <td class="text-center">
                            <a class="edit" href="Exportaciones/Exp_clientes.jsp">
                              <i class="fas fa-file-excel"></i>  Descargar
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">6</td>
                        <td class="text-center">Ventas</td>
                        <td>Listado de Ventas por medio de pago</td>

                        <td class="text-center">
                            <a class="edit" href="Exportaciones/Exp_ConsultasVentasMed.jsp">
                              <i class="fas fa-file-excel"></i>  Descargar
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">7</td>
                        <td class="text-center">Clientes</td>
                        <td>Listado de Clientes en Bogotá</td>

                        <td class="text-center">
                            <a class="edit" href="Exportaciones/Exp_pa_clientesBogota.jsp">
                              <i class="fas fa-file-excel"></i>  Descargar
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">8</td>
                        <td class="text-center">Reporte</td>
                        <td>Reporte de Clientes</td>

                        <td class="text-center">                            
                            <a class="edit" href="Reportes/Rep Client.pdf">
                              <i class="fas fa-file-pdf"></i>  Descargar
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td class="text-center">9</td>
                        <td class="text-center">Reporte</td>
                        <td>Reporte de Ventas</td>
                
                        <td class="text-center">                            
                            <a class="edit" href="Reportes/Rep Venta.pdf">
                              <i class="fas fa-file-pdf"></i>  Descargar
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>

        </div>


    </body>
