<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>


<div class="mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col mdl-grid square-login-sugerencia">

  <div  style="position: absolute;left: 24%;top: 28%; text-align: center; color: red; background-color: aliceblue;width: 51%;height: auto;">

  <h3 >Lista de Información de Integrantes</h3>

  <div>
     <ul class="demo-list-icon mdl-list">
       <c:forEach var="usuario" items="${formaListarUsuarios.usuario}">
            <li class="mdl-list__item">
              <span class="mdl-list__item-primary-content">
              <i class="material-icons mdl-list__item-icon">person</i>
              <c:out value="${usuario.nombre.nombre}"/>
          </span>
            </li>

          </c:forEach>
    </ul>


   </div>
 </div>



</div>
