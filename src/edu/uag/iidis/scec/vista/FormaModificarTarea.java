package edu.uag.iidis.scec.vista;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.ValidatorForm;

/**
 * 
 */
public final class FormaModificarTarea extends ValidatorForm {

  private Long id;
  private String nombre;
  private String descripcion;
  private String estado;
  private String usuario;

	/**
	* Returns value of id
	* @return
	*/
	public Long getId() {
		return id;
	}

	/**
	* Sets new value of id
	* @param
	*/
	public void setId(Long id) {
		this.id = id;
	}

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
	* Returns value of descripcion
	* @return
	*/
	public String getDescripcion() {
		return descripcion;
	}

	/**
	* Sets new value of descripcion
	* @param
	*/
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	* Returns value of estado
	* @return
	*/
	public String getEstado() {
		return estado;
	}

	/**
	* Sets new value of estado
	* @param
	*/
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	* Returns value of usuario
	* @return
	*/
	public String getUsuario() {
		return usuario;
	}

	/**
	* Sets new value of usuario
	* @param
	*/
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

 /**
  * [validate description]
  * @param  ActionMapping      mapping       [description]
  * @param  HttpServletRequest request       [description]
  * @return                    [description]
  */
  @Override
  public ActionErrors validate( ActionMapping mapping, HttpServletRequest request)
  {
    ActionErrors errors = super.validate(mapping, request);
    return errors;
  }

/**
 * [toString description]
 * @return [description]
 */
  @Override
  public String toString(){
    return "FormaModificarTarea{id= " + id + ", nombre= "+ nombre +"}";
  }

}
