package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Tarea;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class TareaDAO {

    private Log log = LogFactory.getLog(TareaDAO.class);

    public TareaDAO() {
    }


    public Tarea buscarPorId(Long idTarea, boolean bloquear)
            throws ExcepcionInfraestructura {

        Tarea tarea = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idTarea + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                tarea = (Tarea)HibernateUtil.getSession()
                                                .load(Tarea.class,
                                                      idTarea,
                                                      LockMode.UPGRADE);
            } else {
                tarea = (Tarea)HibernateUtil.getSession()
                                                .load(Tarea.class,
                                                      idTarea);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return tarea;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection tareas;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            tareas = HibernateUtil.getSession()
                                    .createCriteria(Tarea.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + tareas.size());
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return tareas;
    }


    public Collection buscarPorEjemplo(Tarea tarea)
            throws ExcepcionInfraestructura {


        Collection tareaa;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Tarea.class);
            tareaa = criteria.add(Example.create(tarea)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return tareaa;
    }


    public void hazPersistente(Tarea tarea)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(tarea)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(tarea);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Tarea tarea)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(tarea)");
        }

        try {
            HibernateUtil.getSession().delete(tarea);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeTareas(String nombreTareas)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {


//            String consultaCuentaRoles =
//            "select count(*) from Ciudad r where r.nombre=?";
//
 //           int resultado =
 //           ((Integer) HibernateUtil.getSession()
 //                          .find(consultaCuentaRoles,
 //                                nombreRol,
 //                                StringType.INSTANCE)
 //                          .iterator()
 //                          .next()).intValue();
// de acuerdo al nuevo formato

            String hql = "select TareaNombre from Tarea where TareaNombre = :nombreTareas";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreTareas);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreTareas);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
            }
            List results = query.list();
            int resultado = results.size();
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< Result size " + resultado);
            }
            if (resultado == 0) {
               return false;
            }

            return true;

        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException *******************");
            }
            throw new ExcepcionInfraestructura(ex);
        }
    }


}
