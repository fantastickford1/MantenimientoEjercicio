package edu.uag.iidis.scec.control;

import java.util.Collection;

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
import java.io.*;
import java.util.*;
import org.apache.struts.upload.FormFile;

/**
 * Esta clase registra las sugerencias en la base de datos
 *@author Diana
 *@version 1.0
 */
public final class MCURegistrarSugerencia extends MappingDispatchAction{

   private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

/**
 * Solicita un registro de una sugerencia
 * @param  ActionMapping       mapping       Informacion del mapeo de accion
 * @param  ActionForm          form          Datos mandados por la vista
 * @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
 * @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
 * @return  ActionForward      exito o fracaso
 * @throws Exception           Error en la transaccion
 */
   public ActionForward solicitarRegistroSugerencia(ActionMapping mapping,ActionForm form, HttpServletRequest request,HttpServletResponse response) throws Exception {

     if (log.isDebugEnabled()) {
            log.debug(">solicitarRegistroSugerencia");
      }

      FormaNuevoSugerencia forma = (FormaNuevoSugerencia) form;

      ManejadorSugerencias mr = new ManejadorSugerencias();

      Collection resultado = mr.listarSugerencias();

      ActionMessages errores = new ActionMessages();

      if (resultado != null) {
            if ( resultado.isEmpty() ) {
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.registroVacio"));
                saveErrors(request, errores);
            } else {
                forma.setSugerencias(resultado);
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
 * Registra una sugerencia
 * Recibe el form y mediante el metodo crearSugerencia del manejador se registra en la base de datos
 * @param  ActionMapping       mapping       Informacion del mapeo de accion
 * @param  ActionForm          form          Datos mandados por la vista
 * @param  HttpServletRequest  request       Provee información requerida por HTTP servlets
 * @param  HttpServletResponse response      Servlet que se encarga de enviar una respuesta
 * @return  ActionForward      exito o fracaso
 * @throws Exception           Error en la transaccion
 */
   public ActionForward procesarRegistroSugerencia(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)throws Exception
   {
     if (log.isDebugEnabled()) {
       log.debug(">procesarRegistroSugerencia");
     }
     if (isCancelled(request)) {
       if (log.isDebugEnabled()) {
         log.debug("<La acción fue cancelada");
       }
      return (mapping.findForward("cancelar"));
     }

     FormaNuevoSugerencia forma = (FormaNuevoSugerencia)form;
     Sugerencia sugerencia = new Sugerencia(forma.getNombre(),forma.getSugerencia());
     ManejadorSugerencias mr = new ManejadorSugerencias();
     int resultado = mr.crearSugerencia(sugerencia);
     ActionMessages errores = new ActionMessages();
     switch (resultado) {
            case 0:
                return (mapping.findForward("exito"));

            case 1:
                errores.add(ActionMessages.GLOBAL_MESSAGE,
                            new ActionMessage("errors.nombreRecomendacionYaExiste",
                                               forma.getNombre()));
                saveErrors(request, errores);
                return (mapping.getInputForward());

            case 2:
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
