<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<c:forEach var="tarea" items="${formaListadoTareas.tareas}">
    <tr id="${tarea.id}">
        <td id="${tarea.id}-usuario" align="left" width="20%"> <c:out value="${tarea.usuario}"/>     </td>
        <td id="${tarea.id}-nombre" align="left" width="20%"> <c:out value="${tarea.nombre}"/>      </td>
        <td id="${tarea.id}-descripcion" align="left" width="60%"> <c:out value="${tarea.descripcion}"/> </td>
        <td id="${tarea.id}-estado" align="left" width="60$"> <c:out value="${tarea.estado}"/>      </td>
        <td align="left" width="60%">
          <a href='solicitarModificarTarea.do?id=<c:out value="${tarea.id}"/>&usuario=<c:out value="${tarea.usuario}"/>&nombre=<c:out value="${tarea.nombre}"/>&descripcion=<c:out value="${tarea.descripcion}"/>&estado=<c:out value="${tarea.estado}"/>' class="mdl-button mdl-js-button mdl-button--fab mdl-button--mini-fab">
            <i class="material-icons">add</i>
          </a>
        </td>
    </tr>
</c:forEach>
