<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<div class="mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid square-login-sugerencia">

                <form action="procesarRegistroSugerencia.do" method="post">
                  <div><html:errors /></div>
                  <!-- Input Name -->
                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" type="text" id="name" value="${formaNuevoSugerencia.nombre}">
                    <label class="mdl-textfield__label" for="name">Name</label>
                  </div>

                   <!-- Input Sugerencia -->
                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" type="text" id="suge" value="${formaNuevoSugerencia.sugerencia}">
                    <label class="mdl-textfield__label" for="suge">Sugerencia</label>
                  </div>

                  <button type="submit" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
                    Publicar
                  </button>
                </form>
</div>
