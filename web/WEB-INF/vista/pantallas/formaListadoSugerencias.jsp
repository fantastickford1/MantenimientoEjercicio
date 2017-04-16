<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<div class="mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid square-login-sugerencia">

                <!-- Floating Multiline Textfield -->
                <div>
                  <html:errors />
                </div>
                <div class="mdl-textfield mdl-js-textfield">
                    <c:forEach var="sugerencia" items="${formaListadoSugerencias.sugerencias}">
                      <span><c:out value="${sugerencia.nombre}"/></span>
                      <textarea class="mdl-textfield__input" type="text" rows= "3" id="txtarea" >
                          <c:out value="${sugerencia.sugerencia}"/>
                      </textarea>
                    </c:forEach>
                </div>
                <a href="solicitarRegistroSugerencia.do" class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
                  <i class="material-icons">send</i>
                  Publicar
                </a>
</div>
