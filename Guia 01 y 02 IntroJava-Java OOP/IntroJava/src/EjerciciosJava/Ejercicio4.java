package EjerciciosJava;
/** 4. Escribir un programa que pida una frase y la muestre toda en mayúsculas y
 *  después toda en minúsculas. Nota: investigar la función toUpperCase() y
 *  toLowerCase() en Java. 
 */
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una frase: ");
        String frase = leer.nextLine();
        System.out.println("FRASE EN MAYÚSCULAS:" + frase.toUpperCase());
        System.out.println("FRASE EN MINÚSCULAS:" + frase.toLowerCase());
        
//        //Versión Larga
//        Scanner leer = new Scanner(System.in);
//        String frase;
//        System.out.println(" Ingrese una frase: ");
//        frase = leer.nextLine();
//
//        // Pasamos a Mayusclas
//        frase = frase.toUpperCase();
//
//        System.out.println(" La frase en mayúsculas: " + frase);
//
//        // Pasamos a Minusculas
//        frase = frase.toLowerCase();
//
//        System.out.println(" La frase en minúsculas: " + frase);
    }

}
