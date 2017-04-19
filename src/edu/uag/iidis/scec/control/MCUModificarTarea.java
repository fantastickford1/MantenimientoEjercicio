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

/**
 * Esta clase modifica una tarea usando el manejador y la FormaListadoTareas, junto con el
 * modelo de Tarea
 * @author Karlos
 * @version 1.0
 */
public final class MCUModificarTarea extends MappingDispatchAction {

  private final Log log = LogFactory.getLog(MCURegistrarUsuario.class);

/**
 * Este metodo solo sirve como direccionamiento
 * @param  ActionMapping       mapping       Informacion del mapeo de accion
 * @param  ActionForm          form          Datos mandados por la vista
 * @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
 * @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
 * @return  ActionForward      exito o fracaso
 * @throws Exception           Error en la transaccion
 */
  public ActionForward solicitarModificarTarea(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) throws Exception
  {
    if (log.isDebugEnabled()) {
      log.debug(">solicitarModificarTarea");
    }
    return mapping.findForward("exito");
  }

/**
 * Este metodo recibe los datos de la tarea por medio del form y lo actualiza mediante el metodo
 * modificarTarea de manejador
 * @param  ActionMapping       mapping       Informacion del mapeo de accion
 * @param  ActionForm          form          Datos mandados por la vista
 * @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
 * @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
 * @return  ActionForward      exito o fracaso
 * @throws Exception           Error en la transaccion
 */
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
