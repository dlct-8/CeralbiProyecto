

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ayuda</title>
	<meta charset="UTF-8">
	<meta name="description" content="Ceralbi - La tienda en línea">
	<meta name="keywords" content="ceralbi, Encajas, eCommerce, cuadros, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Icon -->
	<link href="../../Imgs/LogoAzul.ico" rel="shortcut icon"/>
    
	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,500,500i,600,600i,700,700i"
  rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,600,600i,700,700i"
  rel="stylesheet">

	<!-- Stylesheets -->
        <link href="../../css/common.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/main.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>	
	<script src="https://kit.fontawesome.com/cfe8b23fc4.js" crossorigin="anonymous"></script>
        <link href="../../css/owl.carousel.css" rel="stylesheet" type="text/css"/>
        <link href="../../css/animate.css" rel="stylesheet" type="text/css"/>
	

    </head>
    <body>
        <header>

	<!-- Page Preloder-->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
		<!-- Top navigation -->
		<div class="topnav" id="myTopnav">

			<!-- Left-aligned links (default) -->
			<!-- logo -->
			<div class="site-logo">
                          
				<img src="../../Imgs/LogoAzulWN.png" alt="Logo Ceralbi">
			</div>
			<a href="javascript:void(0);" class="icon" onclick="hamburgerMenu()">
				<i class="fa fa-bars"></i>
			</a>
			<a href="../AboutUs.html">Nosotros</a>
			<a href="../Contact.html">Contacto</a>
			<a href="#" class="active">Ayuda</a>
			<a href="../../Home.jsp">Inicio</a>
                        
		<!--	<a href="../Sales/Cajas/Cajas.html">Cajas</a>
			<a href="../Sales/Cuadros/Cuadros.html">Cuadros</a>-->
			<!--<div class="dropdown">
  			<button class="dropbtn" onclick="dropdownMenu()">Cuadros
    			<i class="fa fa-caret-down"></i>
			  </button>
  			<div class="dropdown-content" id="myDropdown">
    			<a href="../Sales/Cuadros/Oficina/Oficina.html">Oficina</a>
  			  <a href="../Sales/Cuadros/Hogar/Hogar.html">Hogar</a>
  			</div>
  		</div>-->

			<!-- Right-aligned links -->
			<div class="topnav-right">
				<a href="../Customers/Login.html">Mi Cuenta <i class="fa fa-user-circle-o" aria-hidden="true"></i></a>
				<div class="search-container">
    			<form action="/action_page.php">
      			<input type="text" placeholder="Buscar..." name="search">
    			  <button type="submit"><i class="fa fa-search"></i></button>
    			</form>
  			</div>
				<a href="../Sales/Cart.html" class="card-bag"><i class="fa fa-shopping-cart" aria-hidden="true"></i><span>2</span></a>
			</div>

		</div>
</header>

<body>
    <div>
      <div class="customer">
      <center>
      <h3>Preguntas Frecuentes</h3><br>
		</div>
		<div class="faq-table">
      <table>
				<tr>
          <td>
            <details>
              <summary><b> ¿Debo registrarme para poder comprar?</b></summary>
              <p>Sí, aunque puedes agregar los productos que quieras al carrito de compras sin estar registrado. Cuando realices el proceso de compra debes ingresar tus datos personales, así como el método de envío y tu medio de pago..</p>
            </details>
          </td>
        </tr>
        <tr>
          <td>
            <details>
              <summary><b> No he recibido mi pedido. ¿Qué puedo hacer?</b></summary>
              <p>Puede rastrear el paquete para conocer el estado del envío y/o ponerse en contacto con el vendedor para obtener más información.</p>
            </details>
          </td>
        </tr>
        <tr>
          <td>
            <details>
              <summary><b> ¿Cómo cancelo un pedido?</b></summary>
              <p>Puedes solicitar la cancelación de un pedido si su estado es "Esperando envío".</p>
            </details>
          </td>
        </tr>
        <tr>
          <td>
            <details>
              <summary><b> ¿Cuándo recibiré mi reembolso?</b></summary>
              <p>Por lo general, los compradores tardan entre 3 y 20 días hábiles, dependiendo del banco, en recibir el reembolso después de que se haya procesado el reembolso con éxito.</p>
            </details>
          </td>
        </tr>
        <tr>
          <td>
            <details>
              <summary><b> ¿Cómo devuelvo productos?</b></summary>
              <p>Empaqueta los productos con el embalaje original para asegurar que no se dañen durante el transporte, luego ponte en contacto con el vendedor.</p>
            </details>
          </td>
        </tr>
        <tr>
          <td>
            <details>
              <summary> <b>He tenido un error de pago. ¿Qué puedo hacer?</b></summary>
              <p>Los errores de pago se deben a fallos de los mismos. Puede volverlo a intentar cuando la entidad financiera le habilite la opción o ponerse en contacto con ellos.</p>
            </details>
          </td>
        </tr>
      </table>
			</div>
    </div>
    <center>
      <div>
        <h5>Si aún sigues con dudas puedes diligenciar el formulario de <a href="../Contact.html">Contacto</a></h5><br>

      </div>


    <!-- Footer section -->
    <div class="footer-top">
    	<div class="row">
    		<div class="col-md-4 pr-md-5">
    			<img src="../../Imgs/LogoAzulW.png" class="footer-logo" alt="Logo Ceralbi">
    			<p class="light">Destacados como desarrolladores de software a la medida
    				de aplicaciones web y móviles para todas las industrias.</p>
    		</div>
    		<div class="col-md">
    			<ul class="list-unstyled nav-links">
    				<li><a href="../Home.html">Inicio</a></li>
    				<li><a href="../AboutUs.html">Nosotros</a></li>
    				<li><a href="../Help/CustomerServices.html">Ayuda</a></li>
    				<li><a href="../Contact.html">Contacto</a></li>
    			</ul>
    		</div>
    		<div class="col-md">
    			<ul class="list-unstyled nav-links">
    				<li><a href="../Customers/MyAccount.html">Mi Cuenta</a></li>
    				<li><a href="../StoreAdmin/Admin.html">Administrador</a></li>
    				<li><a href="../NavMap.html">Mapa de Navegación</a></li>
    				<li><a href="../ErrorPages/Error404.html">Error 404</a></li>
    				<li><a href="../ErrorPages/Error500.html">Error 500</a></li>
    			</ul>
    		</div>
    	<!--	<div class="col-md">
    			<ul class="list-unstyled nav-links">
    				<li><a href="#">Política de Privacidad</a></li>
    				<li><a href="#">Términos &amp; Condiciones</a></li>
    				<li><a href="#">Socios</a></li>
    			</ul>
    		</div>-->
				<div class="col-md text-md-center">
					<ul class="social">
						<li><a href="https://www.instagram.com/encajascl/"><i class="fab fa-instagram-square"></i></a></li>
						<li><a href="#"><i class="fab fa-twitter-square"></i></a></li>
						<li><a href="https://www.facebook.com/publi.print.524"><i class="fab fa-facebook-square"></i></a></li>
						<li><a href="#"><i class="fab fa-pinterest-square"></i></a></li>
					</ul>
					<br><br><p class=""><a href="../Contact.html" class="btn btn-footer">Contáctanos</a></p>
				</div>
    	</div>
    </div>

    <!-- Footer section end -->
</body>
    <!-- Copyright -->
    <footer class="footer-section">
    	<div class="container">
    		<p class="copyright">
    			Copyright &copy;<script>document.write(new Date().getFullYear());</script> Todos los derechos reservados | Diseñado por
    			<img src="../../Imgs/LogoCR.png" alt="Logo Ceralbi" class="copyright">
    		</p>
    	</div>
    </footer>
    <!-- End -->


    	<!--====== Javascripts & Jquery ======-->
        <script src="../../js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="../../js/bootstrap.min.js" type="text/javascript"></script>
        <script src="../../js/mixitup.min.js" type="text/javascript"></script>
        <script src="../../js/sly.min.js" type="text/javascript"></script>
        <script src="../../js/jquery.nicescroll.min.js" type="text/javascript"></script>
        <script src="../../js/main.js" type="text/javascript"></script>
    	
    	
    </body>
</html>
