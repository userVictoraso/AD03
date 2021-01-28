package Pareja_Victor_Actividad_2;

import Entidades.Departamento;
import Entidades.Empleado;
import HibernateUtil.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;

public class TestMain {
    @SuppressWarnings("checked")
    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Departamento departamento = new Departamento("AUTOMOCIÓN", "MÁLAGA");
            session.save(departamento);

            Empleado empleado1 = new Empleado();
            empleado1.setNombre("ANGEL'S");
            empleado1.setApellidos("GÓMEZ DE LA TORRE");
            empleado1.setDepartamento(departamento);
            session.save(empleado1);

            SimpleDateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");

            Empleado empleado2 = new Empleado("担架桌", "MÁRQUEZ NÚÑEZ", "OPERARIO", fecha.parse("2015-05-15"), 154788.8F, 84.0F, departamento);
            empleado2.setDepartamento(departamento);
            empleado2.setNombre("担架桌");
            session.save(empleado2);

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
