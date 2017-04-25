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
 * Esta clase lista las tareas usando el ManejadorTareas, FormaListadoTareas
 * y el modelo Tarea
 * @author Karlos
 * @version 1.0
 */
public final class MCUListarTareas
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

/**
* Lista dotas las Tareas haciendo uso del metodo listarTareas del manejador
* @param  ActionMapping       mapping       Informacion del mapeo de accion
* @param  ActionForm          form          Datos mandados por la vista
* @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
* @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
* @return  ActionForward      exito o fracaso
* @throws Exception           Error en la transaccion
 */
    public ActionForward solicitarListarTareas(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarTareas");
        }

        // Verifica si la acción fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        FormaListadoTareas forma = (FormaListadoTareas)form;

        ManejadorTareas mr = new ManejadorTareas();
        Collection resultado = mr.listarTareas();

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setTareas( resultado );
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

    public ActionForward ordenarPor(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarTareas");
        }

        // Verifica si la acciÃ³n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acciÃ³n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }

        //Obtenemos los datos que fueron enviados por data de AJAX
        FormaListadoTareas forma = (FormaListadoTareas)form;

        ManejadorTareas mr = new ManejadorTareas();
        if (log.isDebugEnabled()) {
                log.debug(forma.getNombre());
            }
        //Buscamos elementos por nombre
        Collection resultado = mr.ordenarPor(forma.getNombre());//Utilizamos
                            //Campo de nombre para evitar más modiicaciones

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                if (log.isDebugEnabled()) {
                    log.debug(resultado.toString());
                }
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setTareas(resultado);
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("OcurriÃ³ un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }


}
