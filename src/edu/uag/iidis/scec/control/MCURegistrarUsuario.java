package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


/**
 * Esta clase permite registrar nuevos usuarios usando  el ManejadorUsuarios, FormaNuevaPersona
 * y el modelo usuarios
 * @author alexis
 * @version 1.0
 */

public final class MCURegistrarUsuario
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

    /**
    * registra nuevos usuarios haciendo uso del metodo crearUsuario del manejador
    * @param  ActionMapping       mapping       Informacion del mapeo de accion
    * @param  ActionForm          form          Datos mandados por la vista
    * @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
    * @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
    * @return  ActionForward      exito o fracaso
    * @throws Exception           Error en la transaccion
     */
    public ActionForward solicitarRegistro(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistro");
        }
        return (mapping.findForward("exito"));
    }



    public ActionForward procesarRegistro(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistro");
        }

        // Verifica si la acci�n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acci�n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }


        // Se obtienen los datos para procesar el registro
        FormaNuevaPersona forma = (FormaNuevaPersona)form;

        NombrePersona nombrePersona = new NombrePersona(forma.getPrefijo(),
                                                        forma.getNombre(),
                                                        forma.getApellidoPaterno(),
                                                        forma.getApellidoMaterno(),
                                                        forma.getPosfijo(),
                                                        forma.getIniciales(),
                                                        forma.getlat(),
                                                        forma.getlng());

        Credencial credencial = new Credencial (forma.getNombreUsuario(),
                                                forma.getClaveAcceso());

        Usuario usuario = new Usuario(nombrePersona, credencial);

        ManejadorUsuarios mu = new ManejadorUsuarios();
        int resultado = mu.crearUsuario(usuario);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreUsuarioYaExiste",
                                               forma.getNombreUsuario()));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurri� un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regres� reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}
