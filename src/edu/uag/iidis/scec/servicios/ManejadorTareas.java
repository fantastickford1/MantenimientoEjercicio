package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Tarea;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.TareaDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorTareas {
    private Log log = LogFactory.getLog(ManejadorTareas.class);
    private TareaDAO dao;

    public ManejadorTareas() {
        dao = new TareaDAO();
    }


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
}
