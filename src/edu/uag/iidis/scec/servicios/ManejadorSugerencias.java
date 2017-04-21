package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Sugerencia;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.SugerenciaDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

/**
 * Esta clase facilita las transacciones con la persistencia
 *@author Diana
 *@version 1.0
 */
public class ManejadorSugerencias {
    private Log log = LogFactory.getLog(ManejadorSugerencias.class);
    private SugerenciaDAO dao;
/**
 * Construcctor del manejador
 */
    public ManejadorSugerencias() {
        dao = new SugerenciaDAO();
    }

/**
 * Lista todas las sugerencias usando el metodo buscarTodos de la capa de persistencia
 * @return Collection con todas las sugerencias
 */
    public Collection listarSugerencias() {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscarTodos();
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
/**
 * Lista las sugerencias por un atributo dado usando el metodo
 * buscaSugerencia de la capa de persistencia
 * @param  String nombre        atributo
 * @return        Collection con todas las sugerencias
 */
	public Collection listarSugerenciaPorNombre(String nombre) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarUsuario(usuario)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.buscaSugerencia(nombre);
            log.debug("Consulta "+resultado);
			HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }

/**
 * Elimina una sugerencia usando el metodo hazTransitorio de la capa de persistencia
 * @param Long id ID de la sugerencia a eliminar
 */
    public void eliminarSugerencia(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarSugerencia(sugerencia)");
        }
        try {
            HibernateUtil.beginTransaction();
            Sugerencia sugerencia = dao.buscarPorId(id, true);
            if (sugerencia != null) {
              dao.hazTransitorio(sugerencia);
            }
            HibernateUtil.commitTransaction();
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
        } finally {
            HibernateUtil.closeSession();
        }

    }
/**
 * Inserta una sugerencia en la base de datos usando hazPersistente de la capa de persistencia
 * @param  Sugerencia sugerencia    Sugerencia a agregar
 * @return            1 si ya existe, 0 si se logro exitosamente y 2 si ocurrio una falla
 */
    public int crearSugerencia(Sugerencia sugerencia) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarSugerencia(sugerencia = "+ sugerencia +")");
        }

        try {
            HibernateUtil.beginTransaction();
            System.out.println("Existe la sugerencia????>>>> " + dao.existeSugerencia(sugerencia.getNombre()));
            if (dao.existeSugerencia(sugerencia.getNombre())) {
              System.out.println("!!!!!!!If existe<<<<<<<<>>>>>>>>>");
               resultado = 1; // Excepción. El nombre de ciudad ya existe
            } else {
              System.out.println("Hacer persistente>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
               dao.hazPersistente(sugerencia);
              System.out.println("Se hizo persistente>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
               resultado = 0; // Exito. El ciudad se creo satisfactoriamente.
            }

            HibernateUtil.commitTransaction();

        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();

            if (log.isWarnEnabled()) {
                log.warn("<ExcepcionInfraestructura");
            }
            resultado = 2;    // Excepción. Falla en la infraestructura
        } finally {
            HibernateUtil.closeSession();
        }
        return resultado;
    }
}
