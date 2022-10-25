package EjerciciosJava;
/** 11. Escriba un programa que pida una frase o palabra y valide si la primera letra 
 *  de esa frase es una ‘A’. Si la primera letra es una ‘A’, se deberá de imprimir un 
 *  mensaje por pantalla que diga “CORRECTO”, en caso contrario, se deberá imprimir   
 *  “INCORRECTO”. Nota: investigar la función Substring y equals() de Java.
 */
import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese una frase o palabra:");
        String frase = entrada.nextLine();
        
        System.out.println(frase.substring(0, 1));

        if ("A".equals(frase.substring(0, 1))) {
            System.out.println("CORRECTO");
        } else {
            System.out.println("INCORRECTO");
        }

//        //PRÁCTICAS CON SUBSTRING
//        System.out.println(frase.substring(0,1));
//        System.out.println(frase.substring(0,2));
//        System.out.println(frase.substring(0,3));
//        System.out.println(frase.substring(0,4));
//        System.out.println(frase.substring(1,2));
//        System.out.println(frase.substring(2,3));
//        System.out.println(frase.substring(3,3)); //no devuelve nada
//        System.out.println(frase.substring(3,4)); 
    }

}
