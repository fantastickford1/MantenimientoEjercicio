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
      <th class="mdl-data-table__cell--non-numeric"><fmt:message key="formaListadoPaises.etiqueta.nombre" /></th>
      <th><fmt:message key="formaListadoPaises.etiqueta.descripcion" /></th>
      <th><fmt:message key="formaListadoPaises.etiqueta.administracion" /></th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="pais" items="${formaListadoPaises.paises}">
        <tr>
            <td align="left" width="20%"><c:out value="${pais.nombre}"/></td>
            <td align="left" width="60%"><c:out value="${pais.descripcion}"/></td>
            <td align="left" width="20%">
                <a href='solicitarModificarPais.do?id=<c:out value="${pais.id}"/>'
         class="HipervinculoAdmon">
                    <fmt:message key="formaListadoEstados.etiqueta.modificar"/>
                </a>
            </td>
            <td>
                <a href='procesarEliminarPais.do?id=<c:out value="${pais.id}"/>'
         onClick="javascript: return EliminarPais('<c:out value="${pais.nombre}"/>')"
         class="HipervinculoAdmon">
                    <fmt:message key="formaListadoPaises.etiqueta.eliminar" />
                </a>
            </td>
        </tr>
    </c:forEach>
  </tbody>
</table>
<div>
  <spam>Total:</spam> ${formaListadoPaises.contador}</td>
</div>
<div>
  <button class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">
    <a href="solicitarRegistroPais.do" class="HipervinculoAdmon">Agregar nuevo pais...</a>
  </button>
</div>
</div>
</div>
