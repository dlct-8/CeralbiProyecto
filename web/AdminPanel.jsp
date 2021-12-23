<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
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
     <a class="active" href="#home"><i class="fas fa-tachometer-alt"></i>Dashboard</a>
     <a href="ControladorCliente?accion=listar"><i class="fas fa-address-book"></i>Clientes</a>
     <a href="ControladorProducto?accion=listar"><i class="fas fa-images"></i>Productos</a>
		 <a href="ControladorCategoria?accion=listar"><i class="fas fa-filter"></i>Categorías</a>
     <a href="ControladorVenta?accion=listar"><i class="fas fa-chart-line"></i>Ventas</a>
     <a href="ControladorFactura?accion=listar"><i class="fas fa-file-invoice-dollar"></i>Facturas</a>
     <a href="#"><i class="fas fa-boxes"></i>Inventario</a>
     <a href="ReportesExcel.jsp"><i class="fas fa-file-contract"></i>Reportes</a>
     <a href="ControladorContacto?accion=listar"><i class="fas fa-comment-dots"></i>Contacto</a>
     <div class="exit">
       <a href="Home.jsp"><i class="fas fa-sign-out-alt"></i>Salir</a>
     </div>
    </div>

<!-- Page content -->
<div class="content">
  <h2>Dashboard</h2>
         <div class="container">
             <!-- row -->
             <div class="row tm-content-row">
                 <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                     <div class="tm-bg-primary-dark tm-block"><div style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                         <h2 class="tm-block-title">Latest Hits</h2>
                         <img src="Imgs\Gafica ventas.png" alt="Gráfica ventas">
                         <canvas id="lineChart" style="display: block; width: 465px; height: 232px;" class="chartjs-render-monitor" width="465" height="232"></canvas>
                     </div>
                 </div>
                 <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                     <div class="tm-bg-primary-dark tm-block"><div style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                         <h2 class="tm-block-title">Performance</h2>
                         <img src="Imgs\Porcentaje de ventas.png" alt="Porcentaje ventas">
                         <canvas id="barChart" style="display: block; width: 465px; height: 232px;" class="chartjs-render-monitor" width="465" height="232"></canvas>
                     </div>
                 </div>
                 <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                     <div class="tm-bg-primary-dark tm-block tm-block-taller">
                         <h2 class="tm-block-title">Storage Information</h2>
                         <img src="Imgs\Ganancias.png" alt="Ganancias">
                         <div id="pieChartContainer" style="height: 300px;"><div style="position: absolute; inset: 0px; overflow: hidden; pointer-events: none; visibility: hidden; z-index: -1;" class="chartjs-size-monitor"><div class="chartjs-size-monitor-expand" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:1000000px;height:1000000px;left:0;top:0"></div></div><div class="chartjs-size-monitor-shrink" style="position:absolute;left:0;top:0;right:0;bottom:0;overflow:hidden;pointer-events:none;visibility:hidden;z-index:-1;"><div style="position:absolute;width:200%;height:200%;left:0; top:0"></div></div></div>
                             <canvas id="pieChart" class="chartjs-render-monitor" style="display: block; width: 465px; height: 300px;" width="465" height="300"></canvas>
                         </div>
                     </div>
                 </div>
             </div>
         </div>
     </div>

     <script src="js/jquery-3.3.1.min.js"></script>
     <!-- https://jquery.com/download/ -->
     <script src="js/moment.min.js"></script>
     <!-- https://momentjs.com/ -->
     <script src="js/Chart.min.js"></script>
     <!-- http://www.chartjs.org/docs/latest/ -->
     <script src="js/bootstrap.min.js"></script>
     <!-- https://getbootstrap.com/ -->
     <script src="js/tooplate-scripts.js"></script>
     <script>
         Chart.defaults.global.defaultFontColor = 'white';
         let ctxLine,
             ctxBar,
             ctxPie,
             optionsLine,
             optionsBar,
             optionsPie,
             configLine,
             configBar,
             configPie,
             lineChart;
         barChart, pieChart;
         // DOM is ready
         $(function () {
             drawLineChart(); // Line Chart
             drawBarChart(); // Bar Chart
             drawPieChart(); // Pie Chart

             $(window).resize(function () {
                 updateLineChart();
                 updateBarChart();
             });
         })
     </script>
  </body>
