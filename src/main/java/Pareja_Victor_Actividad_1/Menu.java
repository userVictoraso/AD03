package Pareja_Victor_Actividad_1;

import java.util.Scanner;

public class Menu {
    static Scanner s = new Scanner(System.in);

    public static void Menu() {
        menuOptions();
        int option = s.nextInt();
        switch (option) {
            case 1:
                QuerysA1.activityOne();
                break;
            case 2:
                QuerysA1.activityTwo();
                break;
            case 3:
                QuerysA1.activityThree();
                break;
            case 4:
                QuerysA1.activityFour();
                break;
            case 5:
                QuerysA1.activityFive();
                break;
            case 6:
                QuerysA1.activitySix();
                break;
            case 7:
                System.out.println("Adiós.");
                System.exit(0);
                break;
        }
    }

    private static void menuOptions() {
        System.out.println("***********************************************************************************");
        System.out.println("¿Qué quiere hacer?");
        System.out.println("1.- Apellido, nombre, salario y número de empleado con un salario inferior al mileurista.");
        System.out.println("2.- Número de empleado, departamento y salario de los empleados, ordenados de menor a mayor salario.");
        System.out.println("3.- Datos de empleados cuyo departamento no esté en MADRID.");
        System.out.println("4.- Apellido, salario y número de departamento de los empleados cuyo salario sea  mayor que el máximo salario del departamento 30.");
        System.out.println("5.- Empleados con salario menor que alguno de los empleados  del departamento 30.");
        System.out.println("6.- Mostrar nombre y total de empleados de aquellos departamentos con más de un empleado adscrito. Ordena el resultado por número de empleado.");
        System.out.println("7.- Salir");
        System.out.println("***********************************************************************************");
    }
}
