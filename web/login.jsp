
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
        <meta charset="UTF-8">
	<meta name="description" content="Ceralbi - La tienda en línea">
	<meta name="keywords" content="ceralbi, Encajas, eCommerce, cuadros, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Icon -->   
        <link href="Imgs/LogoAzul.ico"rel="shortcut icon"/>
	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">

	<!-- Stylesheets -->
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>        
	<script src="https://kit.fontawesome.com/cfe8b23fc4.js" crossorigin="anonymous"></script>
        <link href="css/owl.carousel.css" rel="stylesheet" type="text/css"/>
        <link href="css/animate.css" rel="stylesheet" type="text/css"/>
	
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

				<img src="Imgs/LogoAzulWN.png" alt="Logo Ceralbi">
			</div>
			<a href="javascript:void(0);" class="icon" onclick="hamburgerMenu()">
				<i class="fa fa-bars"></i>
			</a>
			<a href="AboutUs.html">Nosotros</a>
			<a href="Contact.html">Contacto</a>
                        
			<a href="Help/CustomerServices.html" >Ayuda</a>
			<a href="Home.jsp"class="active">Inicio</a>

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
                            
				<a href="login.jsp">Mi Cuenta <i class="fa fa-user-circle-o" aria-hidden="true"></i></a>
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
	<!-- Header section end -->

        <br>
        <div class="container col-lg-2" style="width: 30%; height: 30%;">
            <form action="ControladorUsuarioNT">
                <div class="form-group" text-center>
                    <center>
                    <img src="Imgs/LogoBlanco.png" height="100" width="100"/>
                    <p><strong>Iniciar sesión</strong></p>
                    </center>
                </div>
                <div class="form-group">
                    <label>Usuario:</label>
                    <input class="form-control" type="text" name="txtUsuario" placeholder="Ingrese Usuario"> 
                </div>
                <div class="form-group">
                    <label>Password:</label>
                    <input class="form-control" type="password" name="txtClave" placeholder="Ingresar Password" class="form-control">  
                </div>
                <br><a href="Recup.html" style="float:right;font-size:12px;">Recuperar contraseña</a><br>
                <input class="btn btn-secondary btn-block" type="submit" name="accion" value="Ingresar"> 
                <br>
                <div class="sign-up">
                   
                Aún no tienes una cuenta? <a  href="ControladorRegistro?accion=add">Registrate</a>
                
                
                </div>
            </form>
        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br><br>
         <br><br><br><br><br><br><br><br><br>
        <%@include file = "Template/Footer.jsp" %>
        
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 <script src="js/actions.js" type="text/javascript"></script>
        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/owl.carousel.min.js" type="text/javascript"></script>
        <script src="js/mixitup.min.js" type="text/javascript"></script>
        <script src="js/sly.min.js" type="text/javascript"></script>
        <script src="js/jquery.nicescroll.min.js" type="text/javascript"></script>
        <script src="js/main.js" type="text/javascript"></script>
    </body>
</html>