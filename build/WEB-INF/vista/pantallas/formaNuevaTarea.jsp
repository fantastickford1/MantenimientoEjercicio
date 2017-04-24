<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<div id="ima" class="mdl-color--white mdl-shadow--2dp mdl-cell--12--col mdl-grid square-login-sugerencia">
<br>
<div>
	<nav>
		<h1 id="titulo">Bienvenidos al sistema de ingresos de tareas</h1>
		<br>
	</nav>
</div>
<div id="Ingreso">
	<form id="forma" action="procesarRegistroTareas.do" method="post">
		<br>
		<label for="nombre" class="lab">Nombre de tarea</label>
		<br>
		<br>
		<input type="text" name="nombre" value="${FormaNuevaTarea.nombre}" placeholder="Nombre de la tarea" maxlength="60" class="campo">
		<br>
		<br>
		<label for="Estado" class="lab">Estado</label>
		<br>
		<br>
		<input type="text" name="nombre" value="${FormaNuevaTarea.estado}" placeholder="Estado de la tarea" maxlength="60" class="campo">
		<br>
		<br>
		<label for="Alumno_asig" class="lab">Alumno</label>
		<br>
		<br>
		<input type="text" name="Alumno_asig" value="${FormaNuevaTarea.usuario}" placeholder="" maxlength="45" class="campo">
		<br>
		<br>
		<label for="descripcion" class="lab">Descripcion</label>
		<br>
		<br>
		<textarea name="descrip" rows="8" cols="80" readonly value="${FormaNuevaTarea.descripcion}}"></textarea>
		<br>
		<br>
		<input type="submit" name="" value="Aceptar" class="btn">
	</form>
</div>
<footer>
</footer>
</div>
