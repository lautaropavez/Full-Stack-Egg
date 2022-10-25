package EjerciciosJava;
/** 10. Realizar un programa que solo permita introducir frases o palabras de 8 
 *  de largo. Si el usuario ingresa una frase o palabra de 8 de largo se deberá de imprimir 
 *  un mensaje por pantalla que diga “CORRECTO”, en caso contrario, se deberá imprimir 
 *  “INCORRECTO”. Nota: investigar la función Lenght() en Java.
 */
import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una frase o palabra: ");
        String frase = leer.nextLine();
        
        if(frase.length() == 8){
            System.out.println("CORRECTO");
        }else{
            System.out.println("INCORRECTO");
        }
        
//        //FORMA LARGA
//        int cantidad;
//        System.out.println("Ingrese una frase: ");
//        Scanner entrada = new Scanner(System.in);
//        String frase = entrada.nextLine();
//        cantidad = frase.length();
//        if (cantidad == 8) {
//            System.out.println("CORRECTO");
//        } else {
//            System.out.println("INCORRECTO");
//        }      
    }

}
