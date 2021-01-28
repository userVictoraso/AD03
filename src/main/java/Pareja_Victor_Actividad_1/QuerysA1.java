package Pareja_Victor_Actividad_1;

import Entidades.Departamento;
import Entidades.Empleado;
import HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QuerysA1 {
    static Session session;
    static Transaction transaction;

    public static void main(String[] args) { activitySix();
    }
    //Apellido, nombre, salario y número de empleado con un salario inferior al mileurista.
    public static void activityOne() {
        session = null;
        transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query queryAll = session.createQuery("from Empleado where salario < 1000");
            List<Empleado> everyEmployeer = queryAll.list();
            for (Empleado employeer : everyEmployeer) {
                System.out.println("EMPLOYEER [" + employeer.getApellidos() + "," + employeer.getNombre() + ", " +
                        employeer.getSalario() + ", " + employeer.getId() + "]");
            }

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtil.shutdown();
    }

    //Número de empleado, departamento y salario de los empleados, ordenados de menor a mayor salario.
    public static void activityTwo() {
        session = null;
        transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query queryAll = session.createQuery("from Empleado order by salario asc");
            List<Empleado> everyEmployeer = queryAll.list();
            for (Empleado employeer : everyEmployeer) {
                System.out.println("EMPLOYEER [" + employeer.getId() + "," + employeer.getDepartamento().getId() + ", " +
                        employeer.getSalario() + "]");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtil.shutdown();
    }
    //Datos de empleados cuyo departamento no esté en MADRID.
    public static void activityThree() {
        session = null;
        transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query queryAll = session.createQuery("from Empleado e where e.departamento.localizacion <> 'MADRID'");
            List<Empleado> everyEmployeer = queryAll.list();
            for (Empleado employeer : everyEmployeer) {
                System.out.println("EMPLOYEER [" + employeer.toString() + "]");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtil.shutdown();
    }
    //Apellido, salario y número de departamento de los empleados cuyo salario sea  mayor que el máximo salario del departamento 30.
    public static void activityFour() {
        session = null;
        transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query queryAll = session.createQuery("from Empleado where salario > (SELECT MAX(salario) from Empleado e where e.departamento.id = 30)");
            List<Empleado> everyEmployeer = queryAll.list();
            for (Empleado employeer : everyEmployeer) {
                System.out.println("EMPLOYEER [" + employeer.getApellidos() + ", " + employeer.getSalario() + ", " + employeer.getDepartamento() + "]");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtil.shutdown();
    }
    //Empleados con salario menor que alguno de los empleados  del departamento 30.
    public static void activityFive() {
        session = null;
        transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query queryAll = session.createQuery("from Empleado where salario < (SELECT MIN(salario) from Empleado e where e.departamento.id = 30)");
            List<Empleado> everyEmployeer = queryAll.list();
            for (Empleado employeer : everyEmployeer) {
                System.out.println("EMPLOYEER [" + employeer.toString() + "]");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtil.shutdown();
    }
    //Mostrar nombre y total de empleados de aquellos departamentos con más de un empleado adscrito. Ordena el resultado por número de empleado.
    public static void activitySix() {
        session = null;
        transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Query queryAllDepartamento = session.createQuery("from Departamento");
            List<Departamento> listaDepartamentos = queryAllDepartamento.list();

            for (Departamento departamento : listaDepartamentos) {
                System.out.println("DEPARTMENT [" + departamento.getNombre() + "]");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        HibernateUtil.shutdown();
    }
}



