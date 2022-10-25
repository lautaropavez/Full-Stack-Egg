package EjerciciosJava;
/** 8. Crear un programa que dado un numero determine si es par o impar.
 *  (Paso agregado mientras sea distinto de cero.)
 */
import java.util.Scanner;

public class Ejercicio8 {

    public static void main(String[] args) {

        System.out.println("Ingrese un numero:");
        Scanner entrada = new Scanner(System.in);
        Integer numero = entrada.nextInt();

        if (numero % 2 == 0) { // Si el numero es par
            System.out.println("El numero " + numero + " es PAR.");
        } else {
            System.out.println("El numero " + numero + " es IMPAR.");
        }
    }
}
