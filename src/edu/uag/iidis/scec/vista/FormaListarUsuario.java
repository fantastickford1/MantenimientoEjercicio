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
 * @author alexis
 */
public final class FormaListarUsuario
        extends ValidatorForm {

    private Collection usuario;
    private int contador;

    /**
     * establece los usuarios en la Collection
     * @param Collection usuarios usuarios
     */
    public void setUser(Collection usuario) {
        this.usuario = usuario;
        if (usuario != null) {
          this.contador = usuario.size();
        } else
          this.contador = -1;
    }

    /**
     * regresa la coleccion de todos los usuarios
     * @return Collection de usuarios
     */
    public Collection getUsuario() {
        return (this.usuario);
    }

    /**
     * regresa el numero de usuarios
     * @return entero con el numero de usuarios
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
        usuario=null;
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
