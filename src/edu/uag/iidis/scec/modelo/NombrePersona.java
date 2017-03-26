package edu.uag.iidis.scec.modelo;

import java.io.Serializable;

/**
 * @author Victor Ramos
 */
public class NombrePersona
        implements Serializable {

    private String prefijo;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String posfijo;
    private String iniciales;
    private float  lng;
    private float  lat;

    public NombrePersona() {}


    public NombrePersona(String prefijo,
                         String nombre,
                         String apellidoPaterno,
                         String apellidoMaterno,
                         String posfijo,
                         String iniciales,
                         float lng,
                         float lat) {
        this.prefijo = prefijo;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.posfijo = posfijo;
        this.iniciales = iniciales;
        this.lng=lng;
        this.lat=lat;
    }


    public String getPrefijo() {
        return prefijo;
    }


    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellidoPaterno() {
        return apellidoPaterno;
    }


    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }


    public String getApellidoMaterno() {
        return apellidoMaterno;
    }


    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }


    public String getIniciales() {
        return iniciales;
    }


    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }


    public String getPosfijo() {
        return posfijo;
    }


    public void setPosfijo(String posfijo) {
        this.posfijo = posfijo;
    }

    public float getLat() {
        return lat;
    }


    public void setLat(float lat) {
        this.lat=lat;
    }

    public float getLng() {
        return lng;
    }


    public void setLng(float lng) {
        this.lng=lng;
    }

    public String getNombreCompleto() {

        return (nombre + " " +
               apellidoPaterno + " " +
               apellidoMaterno);
    }

}
