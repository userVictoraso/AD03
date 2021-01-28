package Pareja_Victor_Actividad_2;

import Entidades.Departamento;
import Entidades.Empleado;
import Entidades.Proyecto;
import HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class QuerysA2 {
    static Session session = null;
    static Transaction transaction = null;

    public static void main(String[] args) {
        activityFour();
    }
    /*Inserta un nuevo objeto Empleados en la BD (identificador:A28, de nombre Pepe Blanco, fecha de ingreso 'la
    fecha actual', salario 2000, jefe 'A11' y en el departamento '01'.*/
    public static void activityOne(){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            //GET FECHA ACTUAL
            SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaActual = new Date();
            //CARGAR TODOS LOS DEPARTAMENTOS
            Query queryAllDepartamento = session.createQuery("from Departamento");
            List<Departamento> listaDepartamentos = queryAllDepartamento.list();
            //ENCONTRAR EL DEPARTAMENTO EN EL QUE QUEREMOS INGRESAR EL EMPLEADO
            for (Departamento departamento : listaDepartamentos) {
                if(departamento.getId() == 1){
                    //UNA VEZ ENCONTRADO EL DPTO, INSTANCIAMOS EL NUEVO EMPLEADO CON EL DEPARTAMENTO ASIGNADO
                    Empleado empleado = new Empleado("PEPE", "BLANCO", "PROGRAMADOR", fechaActual, 2000.0F, 84.0F, departamento);
                    session.save(empleado);
                }
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

    /*Modifica el salario de un objeto Empleados de la BD (empleado A28, con los nuevos valores 2200).*/
    public static void activityTwo(){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            //CARGAR TODOS LOS EMPLEADOS
            Query queryAllEmpleados = session.createQuery("from Empleado ");
            List<Empleado> listaEmpleados = queryAllEmpleados.list();
            //ENCONTRAR EL DEPARTAMENTO EN EL QUE QUEREMOS INGRESAR EL EMPLEADO
            for (Empleado empleado : listaEmpleados) {
                if(empleado.getId() == 30){
                    //UNA VEZ ENCONTRADO EL EMPLEADO
                    empleado.setSalario(2200F);
                    session.save(empleado);
                    System.out.println("Empleado modificado: " + empleado.toString());
                }
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
    /*Elimina un objeto Empleados de la BD (por ejemplo el empleado A28)*/
    public static void activityThree(){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            //CARGAR TODOS LOS EMPLEADOS
            Query queryAllEmpleados = session.createQuery("delete from Empleado e where e.id = 29");
            System.out.println(queryAllEmpleados.executeUpdate() + " modificacione/s en las tablas.");
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

    /*Consulta de empleados con salario superior a 1000 € (se muestra su nombre, número de departamento y salario)*/
    public static void activityFour(){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            //CARGAR TODOS LOS EMPLEADOS
            Query queryAllEmpleados = session.createQuery("from Empleado ");
            List<Empleado> listaEmpleados = queryAllEmpleados.list();
            //ENCONTRAR EL DEPARTAMENTO EN EL QUE QUEREMOS INGRESAR EL EMPLEADO
            for (Empleado empleado : listaEmpleados) {
                if(empleado.getSalario() == null){
                    System.out.println("Empleado [" + empleado.getNombre() + ", " + empleado.getDepartamento().getId() + ", SIN SUELDO]");
                } else if(empleado.getSalario() > 1000){
                    System.out.println("Empleado [" + empleado.getNombre() + ", " + empleado.getDepartamento().getId() + ", " + empleado.getSalario() + "]");
                }
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
    /*Listado donde aparezcan los datos de cada departamento y a continuación los datos de los proyectos que controla.
    En el listado deben aparecer también los departamentos que no controlen proyectos.*/
    public static void activityFive(){
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            //CARGAR TODOS LOS DEPARTAMENTOS
            Query queryallDepartamentos = session.createQuery("from Departamento");
            List<Departamento> listaDepartamentos = queryallDepartamentos.list();
            //CARGAR TODOS LOS PROYECTOS
            Query queryallProyectos = session.createQuery("from Proyecto");
            List<Proyecto> listaProyectos = queryallProyectos.list();
            //IMPRIMIR LA INFO
            for (Departamento departamento : listaDepartamentos) {
                for(Proyecto proyecto : listaProyectos){
                    if (departamento.getId() == proyecto.getDepartamento().getId()){
                        System.out.println("DEPARTAMENTO [" + departamento.toString() + proyecto.toString() + "]");
                    } else {
                        System.out.println("DEPARTAMENTO [" + departamento.toString() + "]");
                    }
                }
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
