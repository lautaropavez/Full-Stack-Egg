package EjerciciosJava;
// 11. Escriba un programa que pida una frase o palabra y valide si la primera letra 
// de esa frase es una ‘A’. Si la primera letra es una ‘A’, se deberá de imprimir un 
// mensaje por pantalla que diga “CORRECTO”, en caso contrario, se deberá imprimir   
// “INCORRECTO”. Nota: investigar la función Substring y equals() de Java.

import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {

        System.out.println("Ingrese una frase o palabra:");
        Scanner entrada = new Scanner(System.in);
        String frase = entrada.nextLine();

        System.out.println(frase.substring(0, 1));

        if ("A".equals(frase.substring(0, 1))) {
            System.out.println("CORRECTO");
        } else {
            System.out.println("INCORRECTO");
        }
    }

}
