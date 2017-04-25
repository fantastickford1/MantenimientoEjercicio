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



public final class MCURegistraTarea
        extends MappingDispatchAction {

    private Log log = LogFactory.getLog(MCURegistraTarea.class);


    public ActionForward solicitarRegistroTareas(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroTareas");
        }

        return (mapping.findForward("exito"));
    }


    /**
    * Este metodo se procesar el registro de tareas
    * @param
    */
    public ActionForward procesarRegistroTareas(
                ActionMapping mapping,
                ActionForm form,
                HttpServletRequest request,
                HttpServletResponse response)
            throws Exception {

        if (log.isDebugEnabled()) {
            log.debug(">procesarRegistroTareas");
        }

        /**
        * se verifica si la accion fue cancelada por el usuario
        * @param
        */
        if (isCancelled(request)) {
            if (log.isDebugEnabled()) {
                log.debug("<La acción fue cancelada");
            }
            return (mapping.findForward("cancelar"));
        }


        /**
        * Se obtienen los datos para procesar el registro
        * @param
        */
        FormaNuevaTarea forma = (FormaNuevaTarea)form;

        Tarea tarea = new Tarea(forma.getNombre(),
                          forma.getDescripcion(),
                          forma.getEstado(),
                          forma.getUsuario());

        ManejadorTareas mr = new ManejadorTareas();
        int resultado = mr.crearTarea(tarea);

        ActionMessages errores = new ActionMessages();
        switch (resultado) {
            case 0:
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreTareaYaExiste",
                                               forma.getNombre()));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 3:
                log.error("Ocurrió un error de infraestructura");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            default:
                log.warn("ManejadorUsuario.crearUsuario regresó reultado inesperado");
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.infraestructura"));
                saveErrors(request, errores);
                return (mapping.getInputForward());
        }
    }

}
