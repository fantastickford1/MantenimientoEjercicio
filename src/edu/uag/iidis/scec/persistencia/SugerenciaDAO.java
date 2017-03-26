package edu.uag.iidis.scec.persistencia;

import org.hibernate.*;
import org.hibernate.type.*;
import org.hibernate.criterion.Example;
//import org.hibernate.classic.*;


import edu.uag.iidis.scec.excepciones.ExcepcionInfraestructura;
import edu.uag.iidis.scec.modelo.Sugerencia;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Collection;
import java.util.List;


public class SugerenciaDAO {

    private Log log = LogFactory.getLog(SugerenciaDAO.class);

    public SugerenciaDAO() {
    }


    public Sugerencia buscarPorId(Long idSugerencia, boolean bloquear)
            throws ExcepcionInfraestructura {

        Sugerencia sugerencia = null;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorID(" + idSugerencia + ", " + bloquear + ")");
        }

        try {
            if (bloquear) {
                sugerencia = (Sugerencia)HibernateUtil.getSession()
                                                .load(Sugerencia.class,
                                                      idSugerencia,
                                                      LockMode.UPGRADE);
            } else {
                sugerencia = (Sugerencia)HibernateUtil.getSession()
                                                .load(Sugerencia.class,
                                                      idSugerencia);
            }
        } catch (HibernateException ex) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }

            throw new ExcepcionInfraestructura(ex);
        }
        return sugerencia;
    }


    public Collection buscarTodos()
            throws ExcepcionInfraestructura {

        Collection sugerencias;

        if (log.isDebugEnabled()) {
            log.debug(">buscarTodos()");
        }

        try {
            sugerencias = HibernateUtil.getSession()
                                    .createCriteria(Sugerencia.class)
                                    .list();

              log.debug(">buscarTodos() ---- list   " + sugerencias.size());
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return sugerencias;
    }


    public Collection buscarPorEjemplo(Sugerencia sugerencia)
            throws ExcepcionInfraestructura {


        Collection sugerenciass;

        if (log.isDebugEnabled()) {
            log.debug(">buscarPorEjemplo()");
        }

        try {
            Criteria criteria = HibernateUtil.getSession()
                                             .createCriteria(Sugerencia.class);
            sugerenciass = criteria.add(Example.create(sugerencia)).list();
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
        return sugerenciass;
    }


    public void hazPersistente(Sugerencia sugerencia)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazPersistente(sugerencia)");
        }

        try {
            HibernateUtil.getSession().saveOrUpdate(sugerencia);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }


    public void hazTransitorio(Sugerencia sugerencia)
            throws ExcepcionInfraestructura {

        if (log.isDebugEnabled()) {
            log.debug(">hazTransitorio(sugerencia)");
        }

        try {
            HibernateUtil.getSession().delete(sugerencia);
        } catch (HibernateException e) {
            if (log.isWarnEnabled()) {
                log.warn("<HibernateException");
            }
            throw new ExcepcionInfraestructura(e);
        }
    }

    public boolean existeSugerencia(String nombreSugerencia)
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

            String hql = "select nombre from sugerencias where nombre = :nombre";

             if (log.isDebugEnabled()) {
                 log.debug(hql + nombreSugerencia);
            }

            Query query = HibernateUtil.getSession()
                                        .createQuery(hql);
            if (log.isDebugEnabled()) {
                 log.debug("<<<<<<<<< create query ok " );
            }

            query.setParameter("nombre", nombreSugerencia);
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

    public Collection buscaSugerencia(String nombreSugerencia)
              throws ExcepcionInfraestructura {

  		if (log.isDebugEnabled()) {
              log.debug(">existeRol(nombreRol)");
          }

          try {
              String hql = "from sugerencias where nombre like '"+nombreSugerencia+"%'";

               if (log.isDebugEnabled()) {
                   log.debug(hql + nombreSugerencia);
              }

              Query query = HibernateUtil.getSession()
                                          .createQuery(hql);
              if (log.isDebugEnabled()) {
                   log.debug("<<<<<<<<< create query ok " );
              }


              if (log.isDebugEnabled()) {
                   log.debug("<<<<<<<<< set Parameter ok antes del query list >>>>>");
              }
              List results = query.list();
              int resultado = results.size();
              if (log.isDebugEnabled()) {
                   log.debug("<<<<<<<<< Result size " + resultado);
              }
              if (resultado == 0) {
                 return results;
              }

              return results;

          } catch (HibernateException ex) {
              if (log.isWarnEnabled()) {
                  log.warn("<HibernateException *******************");
              }
              throw new ExcepcionInfraestructura(ex);
          }
      }



}
