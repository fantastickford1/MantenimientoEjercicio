package edu.uag.iidis.scec.control;

import edu.uag.iidis.scec.vista.*;
import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.servicios.*;

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
 * Esta clase permite eliminar uauarios usando  el ManejadorUsuarios, FormaNuevaPersona
 * y el modelo usuarios
 * @author alexis
 * @version 1.0
 */

public final class MCUEliminarUsuario
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

    /**
    * elimina usuarios haciendo uso del metodo eliminarUsuario del manejador
    * @param  ActionMapping       mapping       Informacion del mapeo de accion
    * @param  ActionForm          form          Datos mandados por la vista
    * @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
    * @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
    * @return  ActionForward      exito o fracaso
    * @throws Exception           Error en la transaccion
     */

    public ActionForward procesarEliminarUsuario(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

              if (log.isDebugEnabled()) {
                  log.debug(">procesarEliminarUsuario");
              }

        FormaEliminarUsuario forma = (FormaEliminarUsuario)form;
        ManejadorUsuarios me = new ManejadorUsuarios();

        me.eliminarUsuario(forma.getId());
        return (mapping.findForward("exito"));


    }
}
