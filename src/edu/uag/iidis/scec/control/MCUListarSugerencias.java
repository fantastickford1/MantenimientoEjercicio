package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;


/**
 * Esta clase lista las sugerencias usando el ManejadorSugerencias, FormaListadoSugerencias
 * y el modelo Sugerencia
 *@author Diana
 *@version 1.0
 */
public final class MCUListarSugerencias
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

/**
 * Lista las sugerencias haciendo uso del metodo listarSugerencias del
 * ManejadorSugerencias para setearlo al FormaListadoSugerencias
 * @param  ActionMapping       mapping       Informacion del mapeo de accion
 * @param  ActionForm          form          Datos mandados por la vista
 * @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
 * @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
 * @return  ActionForward      exito o fracaso
 * @throws Exception           Error en la transaccion
 */
    public ActionForward solicitarListarSugerencias(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarSugerencias");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoSugerencias forma = (FormaListadoSugerencias)form;

        ManejadorSugerencias mr = new ManejadorSugerencias();
        Collection resultado = mr.listarSugerencias();

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setSugerencias( resultado );
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }

/**
 * Busca una sugerencia
 * Castea el form recibido para mandar al manejador a realizar el metodo de listarSugerenciaPorNombre
 * @param  ActionMapping       mapping       Informacion del mapeo de accion
 * @param  ActionForm          form          Datos mandados por la vista
 * @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
 * @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
 * @return  ActionForward      exito o fracaso
 * @throws Exception           Error en la transaccion
 */
	public ActionForward buscarSugerencia(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarSugerencias");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoSugerencias forma = (FormaListadoSugerencias)form;

        ManejadorSugerencias mr = new ManejadorSugerencias();
        Collection resultado = mr.listarSugerenciaPorNombre(forma.getNombre());
		log.debug("Resultado "+resultado);
        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setSugerencias( resultado );
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurrió un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }
}
