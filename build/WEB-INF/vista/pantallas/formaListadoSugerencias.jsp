<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<div class="mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid square-login-sugerencia">

                <!-- Floating Multiline Textfield -->
<<<<<<< HEAD
                <form action="#">
                  <div class="mdl-textfield mdl-js-textfield">
                    <div style="text-align: left;">
                      <c:forEach var="sugerencia" items="${formaListadoSugerencias.sugerencias}">
                          <tr>
                              <td class="negritas" align="left" width="20%"><c:out value="${sugerencia.nombre}"/>:</td>
                              <td align="left" width="60%"><c:out value="${sugerencia.sugerencia}"/></td>
                          </tr><br>
                      </c:forEach>
                    </div><br>
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
=======
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
>>>>>>> 3ebff8cf6576e97ce24cb722a7dc9509e5708e48
</div>
