<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<div class="mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid square-login-sugerencia">

                <!-- Floating Multiline Textfield -->
                <form action="#">
                  <div class="mdl-textfield mdl-js-textfield">
                    <textarea class="mdl-textfield__input" type="text" rows= "3" id="txtarea" >
                      <c:forEach var="sugerencia" items="${formaListadoSugerencias.sugerencias}">
                          <tr>
                              <td align="left" width="20%"><c:out value="${sugerencia.nombre}"/></td>
                              <td align="left" width="60%"><c:out value="${sugerencia.sugerencia}"/></td>
                          </tr>
                      </c:forEach>
                    </textarea>
                    <label class="mdl-textfield__label" for="txtarea"></label>
                  </div>

                  <!-- Input Name -->
                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" type="text" id="name">
                    <label class="mdl-textfield__label" for="name">Name</label>
                  </div>

                   <!-- Input Sugerencia -->
                  <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                    <input class="mdl-textfield__input" type="text" id="suge">
                    <label class="mdl-textfield__label" for="suge">Sugerencia</label>
                  </div>

                  <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect">
                    Publicar
                  </button>
                </form>
</div>
