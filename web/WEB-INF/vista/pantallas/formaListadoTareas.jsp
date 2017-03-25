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
<script language="javascript" type="text/javascript">
<!--
function EliminarPais(strPaisName){
return confirm("¿Desea eliminar el estado '" + strPaisName + "'?")
}
-->
</script>

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
            <td align="left" width="20%"><c:out value="${tarea.nombre}"/></td>
            <td align="left" width="60%"><c:out value="${tarea.descripcion}"/></td>
        </tr>
    </c:forEach>
  </tbody>
</table>
<div>
  <spam>Total:</spam> ${formaListadoTareas.contador}</td>
</div>
</div>
</div>
