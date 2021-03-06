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
public class TareaDAOTest {

  private static TareaDAO dao = null;

    public void testActualizarTareaT() throws Exception {
        TareaDAO dao = new TareaDAO();
        Tarea tarea = new Tarea("Terminar Batman","Terminar Batman Arkham","Terminado","fantastickford1");
        Long num = new Long(1);
        tarea.setId(num);
        HibernateUtil.beginTransaction();
        try {
            dao.modificar(tarea);
            HibernateUtil.commitTransaction();
            assertTrue(dao.existeTareas("Terminar Batman"));
        } catch (Exception e) {
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

    public void testActualizarTareaF() throws Exception {
        //Falla porque la placa no se puede actualizar
        TareaDAO dao = new TareaDAO();
        Tarea tarea = new Tarea("Terminar Batman","Comer","Terminado","fantastickford1");
        Long num = new Long(2);
        tarea.setId(num);
        HibernateUtil.beginTransaction();
        try {
            dao.modificar(tarea);
            Tarea tarea2 = dao.buscarPorId(num,false);
            HibernateUtil.commitTransaction();
            assertTrue(tarea2.getNombre().equals("Terminar Batman"));

        } catch (Exception e) {
            fail("El nombre ya esta registrado");
            HibernateUtil.rollbackTransaction();
            throw e;
        } finally{
            HibernateUtil.closeSession();
        }
    }

public void testBuscarTodosE() throws Exception {

    TareaDAO dao = new TareaDAO();

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

    TareaDAO dao = new TareaDAO();

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

   TestSetup suite = new TestSetup(new TestSuite(TareaDAOTest.class)) {

        protected void setUp(  ) throws Exception {
            // Se ejecuta al inicio de la suite

            SchemaExport ddlExport = new SchemaExport(HibernateUtil.getConfiguration());
            ddlExport.create(false, true);

            dao = new TareaDAO();
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
