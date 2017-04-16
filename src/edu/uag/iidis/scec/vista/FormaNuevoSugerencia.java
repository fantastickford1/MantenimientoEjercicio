package edu.uag.iidis.scec.vista;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;
import org.apache.struts.upload.FormFile;

public final class FormaNuevoSugerencia extends ValidatorForm {

  private String nombre;
  private String sugerencia;
  private Collection sugerencias;




	/**
	* Returns value of nombre
	* @return
	*/
	public String getNombre() {
		return nombre;
	}

	/**
	* Sets new value of nombre
	* @param
	*/
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	* Returns value of sugerencia
	* @return
	*/
	public String getSugerencia() {
		return sugerencia;
	}

	/**
	* Sets new value of sugerencia
	* @param
	*/
	public void setSugerencia(String sugerencia) {
		this.sugerencia = sugerencia;
	}

	/**
	* Returns value of sugerencias
	* @return
	*/
	public Collection getSugerencias() {
		return sugerencias;
	}

	/**
	* Sets new value of sugerencias
	* @param
	*/
	public void setSugerencias(Collection sugerencias) {
		this.sugerencias = sugerencias;
	}

  /**
   *vuelve los valores nulos
   *
   *@param mapping acciones
   *@param request informacion
   */
   public void reset(ActionMapping mapping,
                     HttpServletRequest request) {
       nombre=null;
       sugerencia=null;
   }


   /**
   *realiza las validaciones proporcionadas por Struts-Validator
   *
   *@param mapping acciones
   *@param request informacion
   *@return ActionErrors erroresde la acccion
   */

   public ActionErrors validate(ActionMapping mapping,
                                HttpServletRequest request) {

       // Ejecuta las validaciones proporcionadas por Struts-Validator
       ActionErrors errores = super.validate(mapping, request);

       // Validaciones no cubiertas por Struts-Validator

       return errores;

   }
}
