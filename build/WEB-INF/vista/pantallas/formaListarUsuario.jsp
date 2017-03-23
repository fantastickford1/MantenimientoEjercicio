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
function EliminarRol(strRolName){
return confirm("�Desea eliminar el rol '" + strRolName + "'?")
}
-->
</script>
<br>
<font size='5'><fmt:message key="FormaListarUsuario.titulo" /></font>
<table cellpadding="0" cellspacing="0" width="60%" border="0">
    <tr>
        <td colspan="4" style="padding-top:25px; padding-bottom:25px;">
            <a href="solicitarRegistroUsuario.do" class="HipervinculoAdmon">Agregar nuevo rol...</a>
        </td>
    </tr>
    <tr>
        <td colspan="4">
           <html:errors />
        </td>
    </tr>
    <tr bgcolor="#CCCCCC">
     <td><b><fmt:message key="formaListarUsuario.etiqueta.nombre" /></b></td>
     <td style="border-right-style:solid; border-left-style:solid; border-width:1px; border-color:#000000;"><b><fmt:message key="formaListarUsuario.etiqueta.descripcion" /></b></td>
     <td colspan="2"><b><fmt:message key="formaListarUsuario.etiqueta.administracion" /></b></td>
    </tr>
    <c:forEach var="usuario" items="${formaListarUsuario.usuario}">
        <tr>
            <td align="left" width="20%"><c:out value="${usuario.nombre.nombre}"/></td>
            <td align="left" width="60%"><c:out value="${usuario.id}"/></td>
            <td>
                <a href='procesarEliminarUser.do?id=<c:out value="${usuario.id}"/>'
         onClick="javascript: return EliminarRol('<c:out value="${usuario.id}"/>')"
         class="HipervinculoAdmon">
                    <fmt:message key="formaListarUsuario.etiqueta.eliminar" />
                </a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4" align="right" style="padding-top:25px;"><b>Total:</b> ${formaListarUsuario.contador}</td>
    </tr>
</table>
