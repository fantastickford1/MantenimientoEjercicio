<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

    <div>
      <font size='5'><fmt:message key="formaLogin.titulo" /></font>
    </div>
    <div>
      <form id="forma" action="procesarLogin.dd" method="post">
          <div>
              <div>
                  <div>
                     <html:errors />
                  </div>
              </div>
              <div>
                  <div align="right">
                      <fmt:message key="formaLogin.etiqueta.Usuario" />
                  </div>
                  <div align="left">
                      <input type="text"
                             name="user"
                             size="50"
                             maxlength="100"
                             value="${formaLogin.user}" />
                  </div>
              </div>
              <div>
                  <div align="right">
                      <fmt:message key="formaLogin.etiqueta.Contrasena" />
                  </div>
                  <div align="left">
                      <input type="password"
                             name="password"
                             size="50"
                             maxlength="100"
                             value="${formaLogin.password}" />
                  </div>
              </div>

              <div>
                  <div align="center">
                      <input type="submit"
                             name="submit"
                             value="Login"/>

                  </div>
              </div>
          </div>
      </form>
  </div
