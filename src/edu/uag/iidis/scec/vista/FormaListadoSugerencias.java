package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el listado de sugerencias
 * @author Diana
 */
public final class FormaListadoSugerencias
        extends ValidatorForm {

    private Collection sugerencias;
    private int contador;
	private String nombre;

/**
 * Establece las sugerencias en la coleccion
 * @param Collection sugerencias coleccion de sugerencias
 */
    public void setSugerencias(Collection sugerencias) {
        this.sugerencias = sugerencias;
        if (sugerencias != null) {
          this.contador = sugerencias.size();
        } else
          this.contador = -1;
    }
/**
 * Obtiene las sugerencias
 * @return Coleccion de sugerencias
 */
    public Collection getSugerencias() {
        return (this.sugerencias);
    }
/**
 * Obtiene contador de sugerencias
 * @return entero con el numero de sugerencias
 */
    public int getContador(){
        return (this.contador);
    }

    /**
     * Obtiene el nombre de una sugerencia
     * @return String con el numbre de la sugerencia
     */
	public String getNombre(){
		return (this.nombre);
	}
  /**
   * Establece el nombre de la sugerencia
   * @param String nombre nombre de la sugerencia
   */
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
  /**
   * Elimina todos los hoteles
   * @param ActionMapping      mapping acciones
   * @param HttpServletRequest request informacion
   */
    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        sugerencias =null;
    }

/**
 * realiza las validaciones proporcionadas por Struts-Validator
 * @param ActionMapping      mapping acciones
 * @param HttpServletRequest request informacion
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
