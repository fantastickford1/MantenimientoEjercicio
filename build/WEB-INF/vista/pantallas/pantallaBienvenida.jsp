<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
<html>
    <head>
        <title>Titulo del documento</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
					<meta name="viewport" content="width=device-width, initial-scale=1.0">
					<link rel="stylesheet" type="text/css" href="css/material.min.css">
					<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
					<link rel="stylesheet" type="text/css" href="css/style.css">
			    <link rel="stylesheet" type="text/css" href="css/plantilla.css">
					<script src="js/material.min.js"></script>
					<script src="js/jquery-3.2.1.js"></script>
		    </head>
				<body>
					<header class="mdl-layout__header mdl-header-edited" id="banner">
						<c:import url="/WEB-INF/vista/comun/banner.jsp" />
					</header>
					<div class="mdl-layout__drawer show-drawer mdl-color--blue-grey-800" id="nav_bar">
						<c:import url="/WEB-INF/vista/comun/barraMenu01.jsp" />
					</div>
					<main class="mdl-layout__content main_grid">
						<div class="mdl-grid" align="center" valign="center" width="100%">
							<h3>Pantalla de Bienvenida</h3>
							<a href="solicitarListarRoles.do">Administraci�n de roles</a>
						</div>
					</main>
				<footer>
					<c:import url="/WEB-INF/vista/comun/barraPie.jsp" />
				</footer>
    </body>
</html>
