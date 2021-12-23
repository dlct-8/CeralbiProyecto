

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ceralbi - Tienda en línea</title>
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
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/common.css" rel="stylesheet" type="text/css"/>
        <link href="css/main.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
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
			<a href="AboutUs_1.html">Nosotros</a>
			<a href="Contact.html">Contacto</a>
			<a href="Help\CustomerServices.html">Ayuda</a>
			<a href="Home.html" class="active">Inicio</a>
		<!--	<a href="Sales/Cajas/Cajas.html">Cajas</a>
			<a href="Sales/Cuadros/Cuadros.html">Cuadros</a>-->
			<!--<div class="dropdown">
  			<button class="dropbtn">Cuadros <i class="fa fa-caret-down"></i></button>
  			<div class="dropdown-content" id="myDropdown">
    			<a href="Sales\Cuadros\Oficina\Oficina.html">Oficina</a>
  			  <a href="Sales\Cuadros\Hogar\Hogar.html">Hogar</a>
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
				<a href="Sales/Cart.html" class="card-bag"><i class="fa fa-shopping-cart" aria-hidden="true"></i><span>2</span></a>
			</div>

		</div>
	</header>
	<!-- Header section end -->


<body>

	<!-- Hero section -->
	<section class="hero-section set-bg" data-setbg="Imgs/bg.png">
		<div class="hero-slider owl-carousel">
			<div class="hs-item">
				<div class="hs-left">
					<img src="Imgs/Products/Animales.png" alt="Cuadro Animales"></div>
				<div class="hs-right">
					<div class="hs-content">
						<div class="price">desde $20.000</div>
						<h2><span>2021</span> <br>nuevos diseños</h2>
						<a href="Sales/Cuadros/Hogar/Productos/ProductoEjemplo.html" class="site-btn">¡Comprar Ahora!</a>
					</div>
				</div>
			</div>
			<div class="hs-item">
				<div class="hs-left"><img src="Imgs/Products/Bogota.png" alt="" style="padding-right: 30px;"></div>
				<div class="hs-right">
					<div class="hs-content">
						<div class="price">desde $20.000</div>
						<h2><span>2021</span> <br>nueva colección</h2>
						<a href="Sales/Cuadros/Hogar/Productos/ProductoEjemplo.html" class="site-btn">¡Comprar Ahora!</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Hero section end -->

	<!-- Featured section -->
	<div class="featured-section spad">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="featured-item">
						<img src="Imgs/Products/Ciudad.png" alt="">
						<a href="Sales/Cuadros/Hogar/Productos/ProductoEjemplo.html" class="site-btn">Ver más</a>
					</div>
				</div>
				<div class="col-md-6">
					<div class="featured-item mb-0">
						<img src="Imgs/Products/Ciudad2.png" alt="">
						<a href="Sales/Cuadros/Hogar/Productos/ProductoEjemplo.html" class="site-btn">Ver más</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Featured section end -->


	<!-- Product section -->
	<section class="product-section spad">
		<div class="container">
			<ul class="product-filter controls">
				<li class="control" data-filter=".new">Nuevos Productos</li>
				<li class="control" data-filter="all">Recomendados</li>
				<li class="control" data-filter=".best">Más Vendidos</li>
			</ul>
			<div class="row" id="product-filter">
				<div class="mix col-lg-3 col-md-6 best">
					<div class="product-item">
						<figure>
							<img src="Imgs/Products/Animales2.png" alt="">
							<div class="pi-meta">
								<div class="pi-m-left">
									<p class="icon"><i class="fas fa-eye"></i></p>
									<p>Vista Rápida</p>
								</div>
								<div class="pi-m-right">
									<p class="icon"><i class="fas fa-heart"></i></p>
									<p>Guardar</p>
								</div>
							</div>
						</figure>
						<div class="product-info">
							<h6>Cuadro</h6>
							<p>$20.000</p>
							<a href="#" class="site-btn btn-line">AGREGAR AL CARRITO</a>
						</div>
					</div>
				</div>
				<div class="mix col-lg-3 col-md-6 new">
					<div class="product-item">
						<figure>
							<img src="Imgs/Products/Comics2.png" alt="">
							<div class="bache">NUEVO</div>
							<div class="pi-meta">
								<div class="pi-m-left">
									<p class="icon"><i class="fas fa-eye"></i></p>
									<p>Vista Rápida</p>
								</div>
								<div class="pi-m-right">
									<p class="icon"><i class="fas fa-heart"></i></p>
									<p>Guardar</p>
								</div>
							</div>
						</figure>
						<div class="product-info">
							<h6>Cuadro Bote</h6>
							<p>$20.000</p>
							<a href="#" class="site-btn btn-line">AGREGAR AL CARRITO</a>
						</div>
					</div>
				</div>
				<div class="mix col-lg-3 col-md-6 best">
					<div class="product-item">
						<figure>
							<img src="Imgs/Products/Animales.png" alt="">
							<div class="pi-meta">
								<div class="pi-m-left">
									<p class="icon"><i class="fas fa-eye"></i></p>
									<p>Vista Rápida</p>
								</div>
								<div class="pi-m-right">
									<p class="icon"><i class="fas fa-heart"></i></p>
									<p>Guardar</p>
								</div>
							</div>
						</figure>
						<div class="product-info">
							<h6>Cuadro Casa</h6>
							<p>$20.000</p>
							<a href="#" class="site-btn btn-line">AGREGAR AL CARRITO</a>
						</div>
					</div>
				</div>
				<div class="mix col-lg-3 col-md-6 new best">
					<div class="product-item">
						<figure>
							<img src="Imgs/Products/Zorro.png" alt="">
							<div class="bache sale">OFERTA</div>
							<div class="pi-meta">
								<div class="pi-m-left">
									<p class="icon"><i class="fas fa-eye"></i></p>
									<p>Vista Rápida</p>
								</div>
								<div class="pi-m-right">
									<p class="icon"><i class="fas fa-heart"></i></p>
									<p>Guardar</p>
								</div>
							</div>
						</figure>
						<div class="product-info">
							<h6>Cuadro</h6>
							<p>$20.000 <span>Precio 40.000</span></p>
							<a href="#" class="site-btn btn-line">AGREGAR AL CARRITO</a>
						</div>
					</div>
				</div>
				<div class="mix col-lg-3 col-md-6 best">
					<div class="product-item">
						<figure>
							<img src="Imgs/Products/Carro.png" alt="">
							<div class="pi-meta">
								<div class="pi-m-left">
									<p class="icon"><i class="fas fa-eye"></i></p>
									<p>Vista Rápida</p>
								</div>
								<div class="pi-m-right">
									<p class="icon"><i class="fas fa-heart"></i></p>
									<p>Guardar</p>
								</div>
							</div>
						</figure>
						<div class="product-info">
							<h6>Cuadro</h6>
							<p>$20.000</p>
							<a href="#" class="site-btn btn-line">AGREGAR AL CARRITO</a>
						</div>
					</div>
				</div>
				<div class="mix col-lg-3 col-md-6 new">
					<div class="product-item">
						<figure>
							<img src="Imgs/Products/Moto.png" alt="">
							<div class="bache">NUEVO</div>
							<div class="pi-meta">
								<div class="pi-m-left">
									<p class="icon"><i class="fas fa-eye"></i></p>
									<p>Vista Rápida</p>
								</div>
								<div class="pi-m-right">
									<p class="icon"><i class="fas fa-heart"></i></p>
									<p>Guardar</p>
								</div>
							</div>
						</figure>
						<div class="product-info">
							<h6>Cuadro</h6>
							<p>$19.50</p>
							<a href="#" class="site-btn btn-line">AGREGAR AL CARRITO</a>
						</div>
					</div>
				</div>
				<div class="mix col-lg-3 col-md-6 best">
					<div class="product-item">
						<figure>
							<img src="Imgs/Products/Kong.png" alt="">
							<div class="pi-meta">
								<div class="pi-m-left">
									<p class="icon"><i class="fas fa-eye"></i></p>
									<p>Vista Rápida</p>
								</div>
								<div class="pi-m-right">
									<p class="icon"><i class="fas fa-heart"></i></p>
									<p>Guardar</p>
								</div>
							</div>
						</figure>
						<div class="product-info">
							<h6>Cuadro</h6>
							<p>$20.000</p>
							<a href="#" class="site-btn btn-line">AGREGAR AL CARRITO</a>
						</div>
					</div>
				</div>
				<div class="mix col-lg-3 col-md-6 best">
					<div class="product-item">
						<figure>
							<img src="Imgs/Products/PawPatrol.png" alt="">
							<div class="pi-meta">
								<div class="pi-m-left">
									<p class="icon"><i class="fas fa-eye"></i></p>
									<p>Vista Rápida</p>
								</div>
								<div class="pi-m-right">
									<p class="icon"><i class="fas fa-heart"></i></p>
									<p>Guardar</p>
								</div>
							</div>
						</figure>
						<div class="product-info">
							<h6>Cuadro</h6>
							<p>$20.000 <span>Precio 40.000</span></p>
							<a href="#" class="site-btn btn-line">AGREGAR AL CARRITO</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Product section end -->





	<!-- Footer section -->
        <%@include file="Common/Footer.jsp" %>


	<!--====== Javascripts & Jquery ======-->
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
