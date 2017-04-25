package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Tarea;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.TareaDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

/**
 * Esta clase facilita las transacciones con la persistencia
 * @author Karlos
 * @version 1.0
 */
public class ManejadorTareas {
    private Log log = LogFactory.getLog(ManejadorTareas.class);
    private TareaDAO dao;

/**
 * Construcctor del manejador
 */
    public ManejadorTareas() {
        dao = new TareaDAO();
    }

/**
 * Lista todas las tareas mediante el dao
 * @return Collection de todas las tareas
 */
    public Collection listarTareas() {
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
 * Lista las tareas por un atributo
 * @param  String nombre        atributo al ordenar
 * @return        Collection de las tareas ordenadas por el atributo
 */
    public Collection listarTareasPorNombre(String nombre)
    {
      Collection resultado;

      if (log.isDebugEnabled()) {
        log.debug(">guardarUsuario(usuario)");
      }

      try {
        HibernateUtil.beginTransaction();
        resultado = dao.buscarTarea(nombre);
        log.debug("Consulta: " + resultado);
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
 * Modifica la tarea
 * @param  Tarea tarea         Tarea al cual actualizar
 * @return       true or false
 */
    public boolean modificarTarea( Tarea tarea){

      boolean result = false;

      if (log.isDebugEnabled()) {
        log.debug(">guardarTarea(tarea)");
      }

      try {
        HibernateUtil.beginTransaction();
        result = dao.modificar(tarea);
        HibernateUtil.commitTransaction();
      }catch (ExcepcionInfraestructura e) {
        HibernateUtil.rollbackTransaction();
        if (log.isWarnEnabled()) {
          log.warn("< ExcepcionInfraestructura");
        }
      }finally {
        HibernateUtil.closeSession();
      }
      return result;
    }
/**
 * Elimina una tarea
 * @param Long id ID de la tarea a eliminar
 */
    public void eliminarTareas(Long id) {
        if (log.isDebugEnabled()) {
            log.debug(">eliminarTareas(tarea)");
        }
        try {
            HibernateUtil.beginTransaction();
            Tarea tarea = dao.buscarPorId(id, true);
            if (tarea != null) {
              dao.hazTransitorio(tarea);
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
 * Crea una tarea
 * @param  Tarea tarea         Tarea a crear
 * @return       1 si ya existe, 0 si se logro exitosamente y 2 si ocurrio una falla
 */
    public int crearTarea(Tarea tarea) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarTarea(tarea)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (dao.existeTareas(tarea.getNombre())) {
               resultado = 1; // Excepción. El nombre de ciudad ya existe
            } else {

               dao.hazPersistente(tarea);

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

    public Collection ordenarPor(String parametro) {
        Collection resultado;

        if (log.isDebugEnabled()) {
            log.debug(">ordenarPor(nombre)");
        }

        try {
            HibernateUtil.beginTransaction();
            resultado = dao.ordenarPor(parametro);
            HibernateUtil.commitTransaction();
            return resultado;
        } catch (ExcepcionInfraestructura e) {
            HibernateUtil.rollbackTransaction();
            return null;
        } finally {
            HibernateUtil.closeSession();
        }
    }
}
