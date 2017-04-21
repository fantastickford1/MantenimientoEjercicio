package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el listado de Tareas.
 *
 * @author Karlos
 */
public final class FormaListadoTareas
        extends ValidatorForm {

    private Collection tareas;
    private int contador;

/**
 * establece las tareas en la Collection
 * @param Collection tareas tareas
 */
    public void setTareas(Collection tareas) {
        this.tareas = tareas;
        if (tareas != null) {
          this.contador = tareas.size();
        } else
          this.contador = -1;
    }
/**
 * regresa la coleccion de todos las tareas
 * @return Collection de tareas
 */
    public Collection getTareas() {
        return (this.tareas);
    }

/**
 * regresa el numero de Tareas
 * @return entero con el numero de tareas
 */
    public int getContador() {
        return (this.contador);
    }

/**
 * Elimina todos los hoteles
 * @param ActionMapping      mapping acciones
 * @param HttpServletRequest request informacion
 */
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        tareas =null;
    }

/**
 * realiza las validaciones proporcionadas por Struts-Validator
 * @param  ActionMapping      mapping       Acciones
 * @param  HttpServletRequest request       Informacion
 * @return                    Errores en la transaccion
 */
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
