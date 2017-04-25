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

/**
 * Esta clase tiene lo necesario para la persistencia de los datos
 * @author Karlos
 * @version 1.0
 */
public class TareaDAO {

    private Log log = LogFactory.getLog(TareaDAO.class);

    public TareaDAO() {
    }

/**
 * Busca por id las tareas
 * @param  Long                     idTarea       Id de la tarea a buscar
 * @param  boolean                  bloquear      verdadero o falso
 * @return                          Tarea encontrada
 * @throws ExcepcionInfraestructura Error lanzado si ocurre algun problema en la transaccion
 */
    public Tarea buscarPorId(Long idTarea, boolean bloquear) throws ExcepcionInfraestructura
    {

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

/**
 * Busca todas las tareas
 * @return Collection con todas las tareas
 * @throws ExcepcionInfraestructura Error lanzado si ocurre algun problema en la transaccion
 */
    public Collection buscarTodos() throws ExcepcionInfraestructura
    {

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

/**
 * Busca una tarea
 * @param  Tarea                    tarea         Tarea a buscar
 * @return                          Collection con la tarea encontrada
 * @throws ExcepcionInfraestructura Error lanzado si ocurre algun problema en la transaccion
 */
    public Collection buscarPorEjemplo(Tarea tarea) throws ExcepcionInfraestructura
    {

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

/**
 * Busca una tarea
 * @param  String                   tarea         nombre de la tarea a buscar
 * @return                          Collection con la tarea encontrada
 * @throws ExcepcionInfraestructura Error lanzado si ocurre algun problema en la transaccion
 */
    public Collection buscarTarea( String tarea ) throws ExcepcionInfraestructura
    {
        if (log.isDebugEnabled()) {
          log.debug("> existeRol(nombreRol)");
        }

        try {
          String sql = "from Tareas where TareaNombre like '"+ tarea +"'";

          if (log.isDebugEnabled()) {
            log.debug(sql + tarea);
          }

          Query query = HibernateUtil.getSession().createQuery(sql);

          if (log.isDebugEnabled()) {
            log.debug("!!!!!Create query is ok");
          }

          if (log.isDebugEnabled()) {
            log.debug("!!!!set Parameter ok antes del query list!!!!");
          }

          return query.list();
        }catch (HibernateException e) {
          if (log.isDebugEnabled()) {
            log.warn("!! HibernateException !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
          }
          throw new ExcepcionInfraestructura(e);
        }
    }

/**
 * Modifica una tarea
 * @param  Tarea                    tarea         Tarea a modificar
 * @return                          true o false
 * @throws ExcepcionInfraestructura Error lanzado si ocurre algun problema en la transaccion
 */
    public boolean modificar ( Tarea tarea ) throws ExcepcionInfraestructura
    {

      boolean result = false;

      if (log.isDebugEnabled()) {
        log.debug(">modificar(tarea)");
      }

      try {
        System.out.println(tarea.toString());
        log.debug("Tarea a modificar >>>>>>>"+ tarea + "<<<<<<<");
        HibernateUtil.getSession().saveOrUpdate(tarea);
        result = true;
      }catch (HibernateException ex) {
        if (log.isWarnEnabled()) {
          log.warn("<HibernateException");
        }
        throw new ExcepcionInfraestructura(ex);
      }
      return result;
    }

/**
 * Hace persistente una Tarea
 * @param  Tarea                    tarea         Tarea a hacer persistente
 * @throws ExcepcionInfraestructura Error lanzado si ocurre algun problema en la transaccion
 */
    public void hazPersistente(Tarea tarea) throws ExcepcionInfraestructura
    {

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

/**
 * Termina una sesion
 * @param  Tarea                    tarea         Tarea a terminar sesion
 * @throws ExcepcionInfraestructura Error lanzado si ocurre algun problema en la transaccion
 */
    public void hazTransitorio(Tarea tarea) throws ExcepcionInfraestructura
    {

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

/**
 * Comprueva si la tarea existe
 * @param  String                   nombreTareas  Tarea a comprovar
 * @return                          true o false
 * @throws ExcepcionInfraestructura Error lanzado si ocurre algun problema en la transaccion
 */
    public boolean existeTareas(String nombreTareas) throws ExcepcionInfraestructura
    {

        if (log.isDebugEnabled()) {
            log.debug(">existeRol(nombreRol)");
        }

        try {

            String hql = "from Tarea where nombre = :nombre";

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
