package edu.uag.iidis.scec.vista;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;


/**
 * Form bean para el registro de una nueva persona.
 *
 * @author Victor Ramos
 */
public final class FormaListadoSugerencias
        extends ValidatorForm {

    private Collection sugerencias;
    private int contador;
	private String nombre;

    public void setSugerencias(Collection sugerencias) {
        this.sugerencias = sugerencias;
        if (sugerencias != null) {
          this.contador = sugerencias.size();
        } else
          this.contador = -1;
    }

    public Collection getSugerencias() {
        return (this.sugerencias);
    }

    public int getContador(){
        return (this.contador);
    }
	public String getNombre(){
		return (this.nombre);
	}
	public void setNombre(String nombre){
		this.nombre=nombre;
	}

    public void reset(ActionMapping mapping,
                      HttpServletRequest request) {
        contador=0;
        sugerencias =null;
    }


    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        // Ejecuta las validaciones proporcionadas por Struts-Validator
        ActionErrors errores = super.validate(mapping, request);

        // Validaciones no cubiertas por Struts-Validator

        return errores;

    }

}
