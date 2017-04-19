<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<div class="mdl-grid mdl-color--white mdl-shadow--2dp">
<div class="mdl-cell mdl-cell--12-col tarea-main-grid">
<div>
  <span><fmt:message key="formaListadoTareas.titulo" /></span>
</div>
<div>
  <html:errors/>
</div>
<form class="" action="procesarModificarTarea.do" method="post">
  <div class="mdl-textfield mdl-js-textfield">
    <input class="mdl-textfield__input" type="text" required="required" id="usuario" value="${formaModificarTarea.usuario}">
    <label class="mdl-textfield__label" for="usuario"><fmt:message key="formaListadoTareas.etiqueta.usuario" /></label>
  </div>
  <div class="mdl-textfield mdl-js-textfield">
    <input class="mdl-textfield__input" type="text" required="required" id="nombre" value="${formaModificarTarea.nombre}">
    <label class="mdl-textfield__label" for="nombre"><fmt:message key="formaListadoTareas.etiqueta.nombre" /></label>
  </div>
  <div class="mdl-textfield mdl-js-textfield">
    <input class="mdl-textfield__input" type="text" required="required" id="descripcion" value="${formaModificarTarea.descripcion}">
    <label class="mdl-textfield__label" for="descripcion"><fmt:message key="formaListadoTareas.etiqueta.descripcion" /></label>
  </div>
  <div class="mdl-textfield mdl-js-textfield">
    <input class="mdl-textfield__input" type="text" required="required" id="estado" value="${formaModificarTarea.estado}">
    <label class="mdl-textfield__label" for="estado"><fmt:message key="formaListadoTareas.etiqueta.estado" /></label>
  </div>
  <input value="${formaModificarTarea.id}" name="id" style="display: none"/>
  <br>
  <button class="mdl-button mdl-js-button mdl-button--icon" type="submit" name="submit">
    <i class="material-icons">send</i>
    Modificar
  </button>
</form>
</div>
</div>
