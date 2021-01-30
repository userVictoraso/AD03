package Pareja_Victor_Actividad_2;

import java.util.Scanner;

public class Menu {
    static Scanner s = new Scanner(System.in);

    public static void Menu() {
        menuOptions();
        int option = s.nextInt();
        switch (option) {
            case 1:
                QuerysA2.activityOne();
                break;
            case 2:
                QuerysA2.activityTwo();
                break;
            case 3:
                QuerysA2.activityThree();
                break;
            case 4:
                QuerysA2.activityFour();
                break;
            case 5:
                QuerysA2.activityFive();
                break;
            case 6:
                System.out.println("Adiós.");
                System.exit(0);
                break;
        }
    }

    private static void menuOptions() {
        System.out.println("***********************************************************************************");
        System.out.println("¿Qué quiere hacer?");
        System.out.println("1.- Inserta un nuevo objeto Empleados en la BD");
        System.out.println("2.- Modifica el salario de un objeto Empleados de la BD (empleado A28, con los nuevos valores 2200).");
        System.out.println("3.- Elimina un objeto Empleados de la BD (por ejemplo el empleado A28)");
        System.out.println("4.- Consulta de empleados con salario superior a 1000 € (se muestra su nombre, número de departamento y salario)");
        System.out.println("5.- Listado donde aparezcan los datos de cada departamento y a continuación los datos de los proyectos que controla. En el listado deben aparecer también los departamentos que no controlen proyectos.");
        System.out.println("6.- Salir");
        System.out.println("***********************************************************************************");
    }
}
