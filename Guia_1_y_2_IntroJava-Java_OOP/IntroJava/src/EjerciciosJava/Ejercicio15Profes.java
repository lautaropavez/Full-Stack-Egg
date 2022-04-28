package EjerciciosJava;

import java.util.Scanner;

/* 15.Realizar un programa que pida dos números enteros positivos por teclado y muestre por pantalla el siguiente menú:
              MENU
              1. Sumar
              2. Restar
              3. Multiplicar
              4. Dividir
              5. Salir
              Elija opción:
   El usuario deberá elegir una opción y el programa deberá mostrar el resultado por
   pantalla y luego volver al menú. El programa deberá ejecutarse hasta que se elija la
   opción 5. Tener en cuenta que, si el usuario selecciona la opción 5, en vez de salir
   del programa directamente, se debe mostrar el siguiente mensaje de confirmación:
   ¿Está seguro que desea salir del programa (S/N)? Si el usuario selecciona el
   carácter ‘S’ se sale del programa, caso contrario se vuelve a mostrar el menú.
 */
public class Ejercicio15Profes {

    public static void main(String[] args) {
        int num1, num2, seleccion;
        char ValSalida;
        System.out.println("Hola, ingrese 2 números y luego seleccione la opción que desee en el menú.");
        System.out.println("Ingrese el primer numero:");
        num1 = pedirEntero();
        System.out.println("Ingrese el segundo numero:");
        num2 = pedirEntero();

        while (num1 <= 0 || num2 <= 0) {
            System.out.println("Ingrese en orden los dos numeros enteros con los que va a operar:");
            num1 = pedirEntero();
            num2 = pedirEntero();
        }

        do {

            MostrarMenu();
            seleccion = validarSeleccion();
            ValSalida = ejecutarSeleccion(seleccion, num1, num2);
        } while (ValSalida != 's');
    }

    public static int pedirEntero() {
        Scanner leer = new Scanner(System.in);
        return leer.nextInt();
    }

    public static char pedirChar() {
        Scanner leer = new Scanner(System.in);
        return leer.next().charAt(0);
    }

    public static void MostrarMenu() {
        System.out.println("------MENU-------\n"
                + "1) Sumar.\n"
                + "2) Restar.\n"
                + "3) Multiplicar.\n"
                + "4) Dividir.\n"
                + "5) Salir.\n"
                + "Elija la opción deseada:.\n");
    }

    public static int validarSeleccion() {
        int seleccion = pedirEntero();
        while (seleccion < 1 || seleccion > 5) {
            System.out.println("OPCIÓN INCORRECTA.\n"
                    + "Elija otra opción: ");
            seleccion = pedirEntero();

        }
        return seleccion;

    }

    public static char ejecutarSeleccion(int seleccion, int a, int b) {
        char ValSalida = '0';
        double division;
        division = division = ((double) a / (double) b);
        switch (seleccion) {
            case 1:
                System.out.println("Usted eligió la opción " + seleccion + ").");
                System.out.println("La suma de " + a + " + " + b + " es = " + (a + b));
                break;
            case 2:
                System.out.println("Usted eligió la opción " + seleccion + ").");
                System.out.println("La resta de " + a + " - " + b + " es = " + (a - b));
                break;
            case 3:
                System.out.println("Usted eligió la opción " + seleccion + ").");
                System.out.println("La multiplicación de " + a + " * " + b + " es = " + (a * b));
                break;
            case 4:
                System.out.println("Usted eligió la opción " + seleccion + ").");
                System.out.println("La division de " + a + "/" + b + " es = " + division);
                break;
            case 5:
                System.out.println("Usted eligió la opción " + seleccion + ").");
                System.out.println("¿Está seguro que desea salir del programa (S/N)?");
                ValSalida = Character.toLowerCase(pedirChar());
                while (ValSalida != 's' && ValSalida != 'n') {
                    System.out.println("Ingrese una opción válida:");
                    ValSalida = Character.toLowerCase(pedirChar());
                }
                break;
        }
        return ValSalida;
    }
}