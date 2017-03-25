package edu.uag.iidis.scec.servicios;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.uag.iidis.scec.modelo.Sugerencia;
import edu.uag.iidis.scec.excepciones.*;
import edu.uag.iidis.scec.persistencia.SugerenciaDAO;
import edu.uag.iidis.scec.persistencia.hibernate.*;

public class ManejadorSugerencias {
    private Log log = LogFactory.getLog(ManejadorSugerencias.class);
    private SugerenciaDAO dao;

    public ManejadorSugerencias() {
        dao = new SugerenciaDAO();
    }


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

    public int crearSugerencia(Sugerencia sugerencia) {

        int resultado;

        if (log.isDebugEnabled()) {
            log.debug(">guardarSugerencia(sugerencia)");
        }

        try {
            HibernateUtil.beginTransaction();

            if (dao.existeSugerencia(sugerencia.getNombre())) {
               resultado = 1; // Excepción. El nombre de ciudad ya existe
            } else {

               dao.hazPersistente(sugerencia);

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
