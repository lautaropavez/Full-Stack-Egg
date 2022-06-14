package EjerciciosJava;
//4. Escribir un programa que pida una frase y la muestre toda en mayúsculas y
//después toda en minúsculas. Nota: investigar la función toUpperCase() y
//toLowerCase() en Java. 

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una frase");
        String frase = leer.nextLine();

        System.out.println("Su frase en mayúsculas es: " + frase.toUpperCase());
        System.out.println("Su frase en minúsculas es: " + frase.toLowerCase());
    }

}
