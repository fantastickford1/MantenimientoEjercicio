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

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.extensions.TestSetup;
import junit.textui.TestRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SugerenciaDAOTest {

  private static SugerenciaDAO dao = null;



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

public static Test suite() {

   TestSetup suite = new TestSetup(new TestSuite(SugerenciaDAOTest.class)) {

        protected void setUp(  ) throws Exception {
            // Se ejecuta al inicio de la suite

            SchemaExport ddlExport = new SchemaExport(HibernateUtil.getConfiguration());
            ddlExport.create(false, true);

            dao = new SugerenciaDAO();
        }

        protected void tearDown(  ) throws Exception {
            // se ejecuta al final de la suite
            dao = null;
        }
    };

    return suite;
}

public static void main(String[] args) throws Exception {
    TestRunner.run( suite() );
}



}
