

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <title>Login</title>
	<meta charset="UTF-8">
	<meta name="description" content="Ceralbi - La tienda en línea">
	<meta name="keywords" content="ceralbi, Encajas, eCommerce, cuadros, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Icon -->
	<link href="../Imgs/LogoAzul.ico" rel="shortcut icon"/>

	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,500,500i,600,600i,700,700i"
  rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,600,600i,700,700i"
  rel="stylesheet">
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
	<!-- Stylesheets -->
        <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>	
	<script src="https://kit.fontawesome.com/cfe8b23fc4.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="../css/common.css"/>
	<link rel="stylesheet" href="../css/main.css"/>
	<link rel="stylesheet" href="../css/login.css"/>
	<link rel="stylesheet" href="../css/animate.css"/>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
	<!--JS Alerta-->


    </head>
  <!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
		<!-- Top navigation -->
		<div class="topnav" id="myTopnav">

			<!-- Left-aligned links (default) -->
			<!-- logo -->
			<div class="site-logo">
				<img src="../Imgs/LogoAzulWN.png" alt="Logo Ceralbi">
			</div>
			<a href="javascript:void(0);" class="icon" onclick="hamburgerMenu()">
				<i class="fa fa-bars"></i>
			</a>
			<a href="/../Ceralbi4A/AboutUs.html">Nosotros</a>
			<a href="/../Ceralbi4A/Contact.html">Contacto</a>
			<a href="/../Ceralbi4A/Help/CustomerServices.html">Ayuda</a>
			<a href="/../Ceralbi4A/Home.jsp">Inicio</a>
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
				<a href="Login.html" class="active">Mi Cuenta <i class="fa fa-user-circle-o" aria-hidden="true"></i></a>
				<div class="search-container">
                                   
					<form action="/action_page.php">
						<input type="text" placeholder="Buscar..." name="search">
						<button type="submit"><i class="fa fa-search"></i></button>
					</form>
				</div>
				<a href="/../Ceralbi4A/Sales/Cart.html" class="card-bag"><i class="fa fa-shopping-cart" aria-hidden="true"></i><span>2</span></a>
			</div>

		</div>
</header>
<!-- Header section end -->

<body>
    <br><br>
	<div class="global-container">
            <div class="card login-form">
		<div class="card-body">
                    <h3 class="card-title text-center">Iniciar sesión</h3>
			<div class="logo-is">
                            <img src="../Imgs/LogoBlanco.png" alt="Logo Ceralbi">
			</div>
			<div class="card-text">
 <!--==================================Formulario ======================-->
                            <form action="ControladorUsuarioNT" class="needs-validation" novalidate >
				<!-- to error: add class "has-danger" -->             
				<div class="form-group">
                                    <label for="validationUsername" >Usuario</label><br>
                                         <input type="text" name="txtUsuario" style="background-color: #e0e3e4;" class="form-control"id="validationUsername" placeholder="Mi usuario" required>
                                            <div class="invalid-feedback">
                                                Ingresa un usuario válido.
                                            </div>
				</div>
				<br>
				<div class="form-group">
                                    <label for="validationPassword" >Contraseña</label>
                                        <input type="password" name="txtClave" style="background-color: #e0e3e4;"  class="form-control" id="validationPassword"  required>
                                            <div class="invalid-feedback">
                                                Ingresa una contraseña.
                                            </div>
						<br><a href="Recup.html" style="float:right;font-size:12px;">Recuperar contraseña</a><br>
                                            </div>
                                            <div  id="liveAlertPlaceholder"></div>
                                            <p class="centrado">
						<input type="submit" onclick="Alerta()" class="site-btn btn-full" id="liveAlertBtn" value="Ingresar" >
                                            </p>
					<div class="sign-up">
                                            Aún no tienes una cuenta? <a href="../Customers\Register.html">Regístrate</a>
					</div>
			</form>
                    </div>
		</div>
            </div>
	</div>
<br><br>
<!--Script de alerta-->
					<script>
					var alertPlaceholder = document.getElementById('liveAlertPlaceholder')
					var alertTrigger = document.getElementById('liveAlertBtn')

					function alert(message, type) {
					var wrapper = document.createElement('div')
					wrapper.innerHTML = '<div class="alert alert-' + type + ' alert-dismissible" role="alert">' + message + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>'

					alertPlaceholder.append(wrapper)
					}

					if (alertTrigger) {
					alertTrigger.addEventListener('click', function () {
						alert('Debes ingresar datos válidos', 'danger')
					})
					}
					</script>

<!-- Footer section -->
    <div class="footer-top">
    	<div class="row">
    	<table>
            <tr >
                <td class="col-md-4 pr-md-5">	
           
                    
    			<img src="../Imgs/LogoAzulW.png" class="footer-logo" alt="Logo Ceralbi">
    			<p class="light">Destacados como desarrolladores de software a la medida
    				de aplicaciones web y móviles para todas las industrias.</p>
    		
               </td>
               <td class="col-md-3 ">
    		
    			<ul class="list-unstyled nav-links">
    				<li><a href="/../Ceralbi4A/Home.jsp">Inicio</a></li>
                                
    				<li><a href="/../Ceralbi4A/AboutUs.html">Nosotros</a></li>
    				<li><a href="/../Ceralbi4A/Help/CustomerServices.html">Ayuda</a></li>
    				<li><a href="/../Ceralbi4A/Contact.html">Contacto</a></li>
                               
    			</ul>
    		
                   </td>
                   <td class="col-md-3">
    		
    			<ul class="list-unstyled nav-links">
    				<li><a href="/../Ceralbi4A/Customers/MyAccount.html">Mi Cuenta</a></li>
    				<li><a href="/../Ceralbi4A/index.jsp">Administrador</a></li>                                
    				<li><a href="/../Ceralbi4A/NavMap.html">Mapa de Navegación</a></li>
    				<li><a href="/../Ceralbi4A/ErrorPages/Error404.html">Error 404</a></li>
    				<li><a href="/../Ceralbi4A/ErrorPages/Error500.html">Error 500</a></li>
                             
    			</ul>
    		
                   </td>
    	<!--	<div class="col-md">
    			<ul class="list-unstyled nav-links">
    				<li><a href="#">Política de Privacidad</a></li>
    				<li><a href="#">Términos &amp; Condiciones</a></li>
    				<li><a href="#">Socios</a></li>
    			</ul>
    		</div>-->
        <td  class="col-md-4  text-md-center" >
			
					<ul class="social">
						<li><a href="https://www.instagram.com/encajascl/"><i class="fab fa-instagram-square"></i></a></li>
						<li><a href="#"><i class="fab fa-twitter-square"></i></a></li>
						<li><a href="https://www.facebook.com/publi.print.524"><i class="fab fa-facebook-square"></i></a></li>
						<li><a href="#"><i class="fab fa-pinterest-square"></i></a></li>
					</ul>
					<br><br><p class=""><a href="/../Ceralbi4A/Contact.html" class="btn btn-footer">Contáctanos</a></p>
				
           </td>
    	
        </tr>
                    </table>
            </div>
    </div>
    <!-- Footer section end -->

        <!-- Copyright -->
    <footer class="footer-section">
    	<div class="container">
    		<p class="copyright">
    			Copyright &copy;<script>document.write(new Date().getFullYear());</script> Todos los derechos reservados | Diseñado por
    			<img src="../Imgs/LogoCR.png" alt="Logo Ceralbi" class="copyright">
    		</p>
                
    	</div>
    </footer>
    <!-- End -->


	<!--====== Javascripts & Jquery ======-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	<script src="../js/jquery-3.2.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/mixitup.min.js"></script>
	<script src="../js/sly.min.js"></script>
	<script src="../js/jquery.nicescroll.min.js"></script>
	<script src="../js/main.js"></script>
	<script src="../js/login.js"></script>
	<!--Script de Validaciones tomado de bootstrap-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
	<script type="text/jscript">
	// Example starter JavaScript for disabling form submissions if there are invalid fields
	(function () {
	  'use strict'

	  // Fetch all the forms we want to apply custom Bootstrap validation styles to
	  var forms = document.querySelectorAll('.needs-validation')

	  // Loop over them and prevent submission
	  Array.prototype.slice.call(forms)
	    .forEach(function (form) {
	      form.addEventListener('submit', function (event) {
	        if (!form.checkValidity()) {
	          event.preventDefault()
	          event.stopPropagation()
	        }

	        form.classList.add('was-validated')
	      }, false)
	    })
	})()
	</script>

</body>
</html>
