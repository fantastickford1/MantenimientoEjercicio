<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<div class="mdl-grid">
  <div class="mdl-cell mdl-cell--12-col">
    <h3>Listado  de Sugerencias por integrantes del Equipo</h3>
  </div>
</div>
<div class="mdl-grid">
  <div class="mdl-cell mdl-cell--12-col">
    <table class="mdl-data-table mdl-js-data-table">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Sugerencia</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach var="sugerencia" items="${formaListadoSugerencias.sugerencias}">
          <tr>
            <td class="mdl-data-table__cell--non-numeric">
              <c:out value="${sugerencia.nombre}"/>
            </td>
            <td class="mdl-data-table__cell--non-numeric">
              <c:out value="${sugerencia.sugerencia}"/>
            </td
          </tr>
          </c:forEach>
        </tbody>
      </table>
  </div>
</div>
<div class="mdl-grid">
  <div class="mdl-cell mdl-cell--12-col">
    <a href="solicitarRegistroSugerencia.do" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
      <i class="material-icons">send</i>
      Postear sugerencia
    </a>
  </div>
</div>
