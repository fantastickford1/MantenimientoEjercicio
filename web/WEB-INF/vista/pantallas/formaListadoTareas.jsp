<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<div class="mdl-grid mdl-color--white mdl-shadow--2dp">
<div class="mdl-cell mdl-cell--12-col tarea-main-grid">
<div>
  <span><fmt:message key="formaListadoTareas.titulo" /></span>
</div>
<div>
  <html:errors />
</div>
<table class="mdl-data-table mdl-js-data-table">
  <thead>
    <tr>
      <th class="mdl-data-table__cell--non-numeric"><fmt:message key="formaListadoTareas.etiqueta.nombre" /></th>
      <th><fmt:message key="formaListadoTareas.etiqueta.descripcion" /></th>
      <th><fmt:message key="formaListadoTareas.etiqueta.administracion" /></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="tarea" items="${formaListadoTareas.tareas}">
        <tr>
            <td align="left" width="20%"> <c:out value="${tarea.usuario}"/>     </td>
            <td align="left" width="20%"> <c:out value="${tarea.nombre}"/>      </td>
            <td align="left" width="60%"> <c:out value="${tarea.descripcion}"/> </td>
            <td align="left" width="60$"> <c:out value="${tarea.estado}"/>      </td>
            <td align="left" width="60%">
              <button id="demo-menu-lower-right" class="mdl-button mdl-js-button mdl-button--icon">
                <i class="material-icons">assignment</i>
              </button>
            </td>
        </tr>
    </c:forEach>
  </tbody>
</table>
<div>
  <spam>Total:</spam> ${formaListadoTareas.contador}</td>
</div>
</div>
</div>
