package edu.uag.iidis.scec.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import edu.uag.iidis.scec.servicios.*;
import edu.uag.iidis.scec.modelo.Tarea;
import edu.uag.iidis.scec.vista.FormaModificarTarea;

public final class MCUModificarTarea extends MappingDispatchAction {

  private final Log log = LogFactory.getLog(MCURegistrarUsuario.class);

  public ActionForward solicitarModificarTarea(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) throws Exception
  {
    if (log.isDebugEnabled()) {
      log.debug(">solicitarModificarTarea");
    }
    return mapping.findForward("exito");
  }

  public ActionForward procesarModificarTarea(ActionMapping mapping, ActionForm form,
                        HttpServletRequest request, HttpServletResponse response) throws Exception
  {

    if (log.isDebugEnabled()) {
      log.debug("> procesarModificarEstado");
    }

    if (isCancelled(request)) {

      if (log.isDebugEnabled()) {
        log.debug("<< La accion fue cancelada");
      }

      return mapping.findForward("cancelar");
    }

    FormaModificarTarea formaModificarTarea  = (FormaModificarTarea) form;
    System.out.println(formaModificarTarea);
    Tarea tarea =  new Tarea(
      formaModificarTarea.getNombre(), formaModificarTarea.getDescripcion(),
      formaModificarTarea.getEstado(), formaModificarTarea.getUsuario()
    );
    tarea.setId(formaModificarTarea.getId());
    ManejadorTareas manejadorTareas = new ManejadorTareas();
    manejadorTareas.modificarTarea(tarea);
    ActionMessages errores = new ActionMessages();
    return mapping.findForward("exito");
  }


}
