package Pareja_Victor_Actividad_1;

public class Constants {

    public static final String FIRST_QUERY = "from Empleado where salario < 1000";
    public static final String SECOND_QUERY = "from Empleado order by salario asc";
    public static final String THIRD_QUERY = "from Empleado e join Departamento d on e.idDepartamento = d.id where d.localizacion <> 'MADRID'";
    public static final String FOURTH_QUERY = "from Empleado where salario > (SELECT MAX(salario) from Empleado where idDepartamento = 30)";
    public static final String FIFTH_QUERY = "from Empleado where salario < (SELECT MIN(salario) from Empleado where idDepartamento = 30)";
    public static final String SIXTH_QUERY = "select d.nombre, COUNT(e.departamento.id) as c FROM Departamento d JOIN Empleado e on e.departamento.id = d.id GROUP BY d.id HAVING c > 1 order by d.id";
}
