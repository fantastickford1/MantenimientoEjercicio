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
 * Esta clase lista los usuarios usando el ManejadorUsuarios, FormaListadoUsuarios
 * y el modelo usuarios
 * @author alexis
 * @version 1.0
 */

public final class MCUListarUsuarios
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

    /**
    * Lista dotas las usuarios haciendo uso del metodo listarUsuarios del manejador
    * @param  ActionMapping       mapping       Informacion del mapeo de accion
    * @param  ActionForm          form          Datos mandados por la vista
    * @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
    * @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
    * @return  ActionForward      exito o fracaso
    * @throws Exception           Error en la transaccion
     */




    public ActionForward solicitarListarUsuarios(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarListarUsuarios");
        }

        // Verifica si la acci�n fue cancelada por el usuario
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acci�n fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }



        FormaListarUsuario forma = (FormaListarUsuario)form;

        ManejadorUsuarios mr = new ManejadorUsuarios();
        Collection resultado = mr.listarUsuarios();

        ActionMessages errores = new ActionMessages();
        if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setUser(resultado);
            }
            return (mapping.findForward("exito"));
        } else {
            log.error("Ocurri� un error de infraestructura");
            errores.add(ActionMessages.GLOBAL_MESSAGE,
                        new ActionMessage("errors.infraestructura"));
            saveErrors(request, errores);
            return ( mapping.findForward("fracaso") );
        }

    }
}
