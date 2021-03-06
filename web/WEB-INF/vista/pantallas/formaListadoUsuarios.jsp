<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<style>
.HipervinculoAdmon{
color:#000000;
text-decoration:none;
}

.HipervinculoAdmon:hover{
color:#006666;
text-decoration:underline;
}
</style>

<div class="mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid square-login-sugerencia">
  <h3 >Lista de Informacion de Integrantes</h3>

  <table class="mdl-data-table mdl-js-data-table">

      <thead>
        <tr>
          <th class="mdl-data-table__cell--non-numeric">ID usuario</th>
          <th>Nombre Prefijo</th>
          <th>Nombre</th>
          <th>Apellido Paterno</th>
          <th>Apellido Materno</th>
          <th>Nombre Posfijo</th>
          <th>Iniciales</th>
          <th>Usuario</th>
          <th>Clave</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="usuario" items="${formaListadoUsuarios.usuario}">
        <tr>
          <td class="mdl-data-table__cell--non-numeric">
            <c:out value="${usuario.id}"/>
          </td>
          <td class="mdl-data-table__cell--non-numeric">
            <c:out value="${usuario.nombre.prefijo}"/>
          </td>
          <td class="mdl-data-table__cell--non-numeric">
            <c:out value="${usuario.nombre.nombre}"/>
          </td>
          <td class="mdl-data-table__cell--non-numeric">
            <c:out value="${usuario.nombre.apellidoPaterno}"/>
          </td>
          <td class="mdl-data-table__cell--non-numeric">
            <c:out value="${usuario.nombre.apellidoMaterno}"/>
          </td>
          <td class="mdl-data-table__cell--non-numeric">
            <c:out value="${usuario.nombre.posfijo}"/>
          </td>
          <td class="mdl-data-table__cell--non-numeric">
            <c:out value="${usuario.nombre.iniciales}"/>
          </td>

          <td class="mdl-data-table__cell--non-numeric">
            <c:out value="${usuario.credencial.nombreUsuario}"/>
          </td>
          <td class="mdl-data-table__cell--non-numeric">
            <c:out value="${usuario.credencial.claveAcceso}"/>
          </td>

        </tr>
        </c:forEach>
      </tbody>

    </table>
</div>
