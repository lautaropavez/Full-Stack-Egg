package EjerciciosJava;
/** 20. Realizar un programa que lea 4 números (comprendidos entre 1 y 20) e imprima el
 *  número ingresado seguido de tantos asteriscos como indique su valor. Por ejemplo:
 *  5 *****
 *  3 ***
 *  11 ***********
 *  2 **
 */
import java.util.Scanner;

public class Ejercicio20 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int num;

        // entrada de datos
        for (int i = 1; i <= 4; i++) {
            System.out.println("Ingrese un número del 1 al 20:");
            num = entrada.nextInt();
            // Validamos que el numero ingresado este en el rango de 1 - 20
            if (num >= 1 && num <= 20) {
                // Mostramos el número
                System.out.print(num + " ");
                // el for se itera la cantidad de veces del num ingresado e imprime el *
                for (int j = 0; j < num; j++) {
                    System.out.print(" * ");
                }
            } else {
                System.out.println("Número ingresado fuera de rango. ");
                break;
            }
            System.out.println(" ");
        }
    }
}
