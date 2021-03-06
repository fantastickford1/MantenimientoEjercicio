package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;

/**
 * Representacion de una Tarea
 * @author Karlos
 * @version 1.0
 */
public class Tarea extends ClaseBase implements Serializable {

  private Long id;
  private String nombre;
  private String descripcion;
  private String estado;
  private String usuario;

  public Tarea(){}

/**
 * Constructor que recibe un id
 * @param  Long id            id de la Tarea
 */
  public Tarea(Long id)
  {
    this.id = id;
  }

/**
 * Constructor que recibe 4 parametros
 * @param  String nombre        nombre de la tarea
 * @param  String descripcion   descripcion de la tarea
 * @param  String estado        estado de la tarea
 * @param  String usuario       usuario de la tarea
 */
  public Tarea(String nombre, String descripcion, String estado, String usuario)
  {
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.estado = estado;
    this. usuario = usuario;
  }




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

}
