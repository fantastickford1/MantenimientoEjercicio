<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <!--<div>
      <font size='5'><fmt:message key="formaLogin.titulo" /></font>
    </div-->
    <div>
      <div class="mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid square-login">
        <form id="forma" action="procesarLogin.dd" method="post">
          <div>
             <html:errors />
          </div>
          <!--<div align="right">
              <fmt:message key="formaLogin.etiqueta.Usuario" />
          </div>-->
          <div class="mdl-textfield mdl-js-textfield">
            <input class="mdl-textfield__input" type="text" name="user" size="50" maxlength="100"
            value="${formaLogin.user}" id="username"/>
            <label class="mdl-textfield__label" for="username">Usuario</label>
          </div>
          <!--<div align="right">
              <fmt:message key="formaLogin.etiqueta.Contrasena" />
          </div>-->
          <div class="mdl-textfield mdl-js-textfield">
            <input class="mdl-textfield__input" type="password" name="password"
            size="50"
            maxlength="100"
            value="${formaLogin.password}" id="password">
            <label class="mdl-textfield__label" for="password">Contrasena</label>
          </div>
          <input class="mdl-button mdl-js-button" type="submit" name="submit"
          value="Login">
        </form>
      </div>
  </div
