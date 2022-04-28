package EjerciciosJava;

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
import java.util.Scanner;

public class Ejercicio15 {

    public static void main(String[] args) {

        int num1, num2, opcion;
        double division;
        char salida;
        salida = ' ';

        Scanner entrada = new Scanner(System.in);
        System.out.println("Hola, ingrese 2 números y luego seleccione la opción que desee en el menú.");
        System.out.println("Ingrese el primer numero:");
        num1 = entrada.nextInt();
        System.out.println("Ingrese el segundo numero:");
        num2 = entrada.nextInt();
        division = ((double) num1 / (double) num2);
        do {
            System.out.println("------MENU-------\n"
                    + "1) Sumar."
                    + "2) Restar."
                    + "3) Multiplicar."
                    + "4) Dividir."
                    + "5) Salir"
                    + "Elija la opción deseada:.");
            opcion = entrada.nextInt();
            if (opcion <= 0 || opcion > 5) {
                System.out.println("OPCIÓN INCORRECTA.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Usted eligió la opción " + opcion + ").");
                    System.out.println("La suma de " + num1 + " + " + num2 + " es =" + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Usted eligió la opción " + opcion + ").");
                    System.out.println("La resta de " + num1 + " - " + num2 + " es =" + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Usted eligió la opción " + opcion + ").");
                    System.out.println("La multiplicación de " + num1 + " * " + num2 + " es =" + (num1 * num2));
                    break;
                case 4:
                    System.out.println("Usted eligió la opción " + opcion + ").");
                    System.out.println("La division de " + num1 + "/" + num2 + " es =" + division);
                    break;
                case 5:
                    System.out.println("Usted eligió la opción " + opcion + ").");
                    System.out.println("¿Está seguro que desea salir del programa (S/N)?");
                    salida = entrada.next().charAt(0);
                    salida = Character.toLowerCase(salida);
                    
            }

        } while (salida != 's');
        System.out.println("Gracias por utilizar nuestro sistema, buen viaje!!");
    }

}
