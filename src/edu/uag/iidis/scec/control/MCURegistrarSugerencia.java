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

public final class MCURegistrarSugerencia extends MappingDispatchAction{

   private Log log = LogFactory.getLog(MCURegistrarUsuario.class);

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
