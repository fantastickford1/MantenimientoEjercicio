package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva Tarea.
 *
 * @author Victor Ramos
 */
public final class FormaNuevaTarea
        extends ValidatorForm {

    private String nombre;
    private String descripcion;
    private String estado;
    private String usuario;

    /**
    * Sets new value of nombre
    * @param
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
  	* gets new value of nombre
  	* @param
  	*/
    public String getNombre() {
        return (this.nombre);
    }

    /**
  	* Sets a description
  	* @param
  	*/
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
  	* gets the description
  	* @param
  	*/
    public String getDescripcion() {
        return (this.descripcion);
    }
    /**
  	* Sets the state of the homework
  	* @param
  	*/
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
  	* Gets the state of the homework
  	* @param
  	*/
    public String getEstado() {
        return (this.estado);
    }
    /**
  	* Sets the value of username
  	* @param
  	*/
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
  	* Gets the username
  	* @param
  	*/
    public String getUsuario() {
        return (this.usuario);
    }


    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        nombre=null;
        descripcion=null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
