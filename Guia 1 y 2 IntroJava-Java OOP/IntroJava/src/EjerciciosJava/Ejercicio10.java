package EjerciciosJava;
//10. Realizar un programa que solo permita introducir frases o palabras de 8 
//de largo. Si el usuario ingresa una frase o palabra de 8 de largo se deberá de imprimir 
//un mensaje por pantalla que diga “CORRECTO”, en caso contrario, se deberá imprimir 
//“INCORRECTO”. Nota: investigar la función Lenght() en Java.

import java.util.Scanner;

public class Ejercicio10 {

    public static void main(String[] args) {

        int cantidad;
        System.out.println("Ingrese una frase: ");
        Scanner entrada = new Scanner(System.in);
        String frase = entrada.nextLine();
        cantidad = frase.length();
        if (cantidad == 8) {
            System.out.println("CORRECTO");
        } else {
            System.out.println("INCORRECTO");
        }
       
        // if (frase.length()){ // De esta manera no usariamos el "cantidad"
        //     System.out.println("CORRECTO");
        // }else{
        //     System.out.println("INCORRECTO");
        // }

    }

}
