package EjerciciosJava;
// 4. Escribir un programa que pida una frase y la muestre toda en mayúsculas y
// después toda en minúsculas. Nota: investigar la función toUpperCase () y
// toLowerCase () es Java.

import java.util.Scanner;

public class Ejercicio4_OtraManera {

    public static void main(String[] args) {

        String frase;

        Scanner entrada = new Scanner(System.in);

        System.out.println(" Ingrese una frase: ");
        frase = entrada.nextLine();

        // Pasamos a Mayusclas
        frase = frase.toUpperCase();

        System.out.println(" La frase en mayúsculas: " + frase);

        // Pasamos a Minusculas
        frase = frase.toLowerCase();

        System.out.println(" La frase en minúsculas: " + frase);

    }

}
