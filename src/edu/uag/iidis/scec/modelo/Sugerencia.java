package edu.uag.iidis.scec.modelo;

import java.io.Serializable;
import java.util.*;


/**
 * Esta clase es usada para representar un rol de un
 * usuario.
 *
 * <p><a href="Estado.java.html"><i>Ver código fuente</i></a></p>
 *
 * @author <a href="mailto:vramos@uag.mx">Victor Ramos</a>
 * @version 1.0
 */
public class Sugerencia extends ClaseBase
        implements Serializable {

    private Long id;
    private String nombre;
    private String sugerencia;


    public Sugerencia() {
    }

    public Sugerencia(Long id){
        this.id = id;
    }

    public Sugerencia(String nombre, String sugerencia){
        this.nombre=nombre;
        this.sugerencia=sugerencia;
    }

    /**
     * Regresa el id del rol.
     * @return Long
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Establece el id del rol.
     * @return void
     */
    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Regresa el nombre del rol.
     * @return String
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Establece el nombre del rol.
     * @return void
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Regresa la descripción del rol.
     * @return String
     */
    public String getSugerencia() {
        return this.sugerencia;
    }

    /**
     * Establece la descripción de la sugerencia del rol.
     * @return void
     */
    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }


}
