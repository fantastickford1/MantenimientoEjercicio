package edu.uag.iidis.scec.pruebas;


import org.junit.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.hibernate.cfg.Environment;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import edu.uag.iidis.scec.modelo.*;
import edu.uag.iidis.scec.persistencia.*;
import edu.uag.iidis.scec.persistencia.hibernate.HibernateUtil;

import java.util.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SugerenciaDAOTest {

  @Test
    public void testCrearSugerenciaT() throws Exception {
      SugerenciaDAO dao = new SugerenciaDAO();
         Sugerencia sugerencia = new Sugerencia("Diana","Hola");

         HibernateUtil.beginTransaction();
         try {
             dao.hazPersistente(sugerencia);
             HibernateUtil.commitTransaction();
             assertTrue(dao.existeSugerencia("Diana"));
         } catch (Exception e) {
             HibernateUtil.rollbackTransaction();
             throw e;
         } finally{
             HibernateUtil.closeSession();
         }
    }

    @Test
    public void testCrearSugerenciaF() throws Exception {
      SugerenciaDAO dao = new SugerenciaDAO();
         Sugerencia sugerencia = new Sugerencia("Carlos","Hola");
         Long num = new Long(1);
         sugerencia.setId(num);
         HibernateUtil.beginTransaction();
         try {
             dao.hazPersistente(sugerencia);
             HibernateUtil.commitTransaction();
             assertTrue(dao.existeSugerencia("Carlos"));
         } catch (Exception e) {
             HibernateUtil.rollbackTransaction();
             throw e;
         } finally{
             HibernateUtil.closeSession();
         }
    }

    @Test
public void testBuscarTodosE() throws Exception {

    SugerenciaDAO dao = new SugerenciaDAO();

    HibernateUtil.beginTransaction();
    try {
        Collection resultado = dao.buscarTodos();
        HibernateUtil.commitTransaction();

        assertTrue(resultado != null);
        assertTrue(!resultado.isEmpty());
    } catch (Exception e) {
        HibernateUtil.rollbackTransaction();
        throw e;
    } finally{
        HibernateUtil.closeSession();
    }
}
@Test
public void testBuscarTodosF() throws Exception {

    SugerenciaDAO dao = new SugerenciaDAO();

    HibernateUtil.beginTransaction();
    try {
        Collection resultado = dao.buscarTodos();
        HibernateUtil.commitTransaction();

        assertTrue(resultado != null);
        assertTrue("La busqueda fallo",resultado.isEmpty());
    } catch (Exception e) {
        HibernateUtil.rollbackTransaction();
        throw e;
    } finally{
        HibernateUtil.closeSession();
    }
}



}
