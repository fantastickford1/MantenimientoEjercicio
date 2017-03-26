    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="/WEB-INF/vista/etiquetas/struts-html.tld" prefix="html" %>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB_CRCGEtHrjlCvirADKVClFonjDdx2pRM"></script>
    <script>

window.addEventListener('load', iniciar, false);

    function iniciar() {
      var marker;


        var map = new google.maps.Map(document.getElementById('map'), {
          zoom: 13,
          center: {lat: 16.75, lng: -93.1667}
        });

        marker = new google.maps.Marker({
          map: map,
          draggable: true,
          animation: google.maps.Animation.DROP,
          position: {lat: 16.75 , lng: -93.1667}
        });
      //  var markerLatLng = marker.getPosition();

      //  console.long(markerLatLng.lat());
      document.getElementById('test').value = "16.75";
      document.getElementById('test2').value = "-93.1667"

        google.maps.event.addListener(marker, 'mouseup', function(){
           toggleBounce(marker);
       });
      }

    function  toggleBounce(marker) {

      var markerLatLng = marker.getPosition();
    //  console.long(markerLatLng.lat());
    document.getElementById('test').value = markerLatLng.lat();
    document.getElementById('test2').value = markerLatLng.lng();
    }
    </script>

    <br>
    <font size='5'><fmt:message key="formaNuevaPersona.titulo" /></font>
    <div id="map" style="width:500px;height:250px;"></div>
    <form id="forma" action="procesarRegistro.do" method="post">
        <table>
            <tr>
                <td colspan="2">
                   <html:errors />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.prefijo" />
                </td>
                <td align="left">
                    <input type="text"
                           name="prefijo"
                           size="12"
                           maxlength="12"
                           value="${formaNuevaPersona.prefijo}" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.nombre" />
                </td>
                <td align="left">
                    <input type="text"
                           name="nombre"
                           size="50"
                           maxlength="7"
                           value="${formaNuevaPersona.nombre}" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.apellidoPaterno" />
                </td>
                <td align="left">
                    <input type="text"
                           name="apellidoPaterno"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.apellidoPaterno}" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.apellidoMaterno" />
                </td>
                <td align="left">
                    <input type="text"
                           name="apellidoMaterno"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.apellidoMaterno}" />
                </td>
            </tr>
      <!---    /cidades --->

            <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.nombreUsuario" />
                </td>
                <td align="left">
                    <input type="text"
                           name="nombreUsuario"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.nombreUsuario}" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.claveAcceso" />
                </td>
                <td align="left">
                    <input type="text"
                           name="claveAcceso"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.claveAcceso}" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.claveAccesoConfirmacion" />
                </td>
                <td align="left">
                    <input type="text"
                           name="claveAccesoConfirmacion"
                           size="50"
                           maxlength="100"
                           value="${formaNuevaPersona.claveAccesoConfirmacion}" />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.lng" />
                </td>
                <td align="left">
                    <input type="text"
                           name="lat"
                           size="50"
                           maxlength="100"
                           id="test"
                           readonly
                           value="${formaNuevaPersona.lng}"
                          />
                </td>
            </tr>
            <tr>
                <td align="right">
                    <fmt:message key="formaNuevaPersona.etiqueta.lat" />
                </td>
                <td align="left">
                    <input type="text"
                           name="lng"
                           size="50"
                           maxlength="100"
                           id="test2"
                           readonly
                            value="${formaNuevaPersona.lat}"
                          />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                  <input type="button"
                         value="direccion"
                        onclick="iniciar()" />
                    <input type="submit"
                           name="submit"
                           value="Agregar y terminar"/>
                    <input type="submit"
                           name="submit"
                           value="Agregar y volver"
                           onclick="forma.action='procesarRegistro.do?volver=si'"/>
                    <input type="button"
                           value="Reset"
                           onclick="location.href='solicitarRegistro.do'" />
                    <input type="submit"
                           name="org.apache.struts.taglib.html.CANCEL"
                           value="Cancelar"
                           onclick="bCancel=true;">
                </td>
            </tr>
        </table>
    </form>
