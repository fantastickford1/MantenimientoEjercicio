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
      <th><fmt:message key="formaListadoTareas.etiqueta.usuario" /></th>
      <th class="mdl-data-table__cell--non-numeric"><fmt:message key="formaListadoTareas.etiqueta.nombre" /></th>
      <th><fmt:message key="formaListadoTareas.etiqueta.descripcion" /></th>
      <th><fmt:message key="formaListadoTareas.etiqueta.estado" /></th>
      <th><fmt:message key="formaListadoTareas.etiqueta.actualizar" /></th>
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
              <select>
                <option value="Completado"><fmt:message key="formaListadoTareas.etiqueta.completado" /></option>
                <option value="Terminado"><fmt:message key="formaListadoTareas.etiqueta.terminado" /></option>
                <option value="Incompleto"><fmt:message key="formaListadoTareas.etiqueta.incompleto" /></option>
              </select>
              <button class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab">
                <i class="material-icons">add</i>
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
