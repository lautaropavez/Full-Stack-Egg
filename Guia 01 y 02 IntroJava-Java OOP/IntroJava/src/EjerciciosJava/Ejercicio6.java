package EjerciciosJava;
/** 6. Escribir un programa que lea un número entero por teclado y muestre por pantalla
 *  el doble, el triple y la raíz cuadrada de ese número. Nota: investigar la función
 *  Math.sqrt().
 */
import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Por favor ingrese un número entero:");
        int numero = leer.nextInt();

        System.out.println("El doble de " + numero + " es: " + (numero * 2));
        System.out.println("El triple de " + numero + " es: " + (numero * 3));
        System.out.println("La raíz cuadrada de " + numero + " es: " + Math.sqrt(numero));

    }

}
