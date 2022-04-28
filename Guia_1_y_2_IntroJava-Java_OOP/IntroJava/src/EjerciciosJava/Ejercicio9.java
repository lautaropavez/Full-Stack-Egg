package EjerciciosJava;
// 9. Crear un programa que pida una frase y si esa frase es igual a 
// “eureka” el programa pondrá un mensaje de Correcto, sino mostrará 
// un mensaje de Incorrecto. Nota:investigar la función equals() en Java.

import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        System.out.println("Ingrese una frase: ");
        Scanner entrada = new Scanner(System.in);
        String frase2 = entrada.nextLine();

        //boolean equals = frase1.equals(frase2);
        //System.out.println(equals);
        //          
        if (frase2.equals("eureka")) {
            System.out.println("Correcto");
        } else {
            System.out.println("Incorrecto");
        }
    }
}
