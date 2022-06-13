package introjava;

import java.util.Scanner;

public class IntroJava {

    public static void main(String[] args) {
        // TODO code application logic here
        // Se crea una variable Scanner que se utiliza para leer datos del usuario
        Scanner leer = new Scanner(System.in);
        //Se crea una variable cadena (String) que se utiliza para leer datos del usuario
        String nombre;
        // Muestra un mensaje por pantalla.
        System.out.println("Ingresa tu nombre:");
        //Leemos el nombre de la persona en la variable nombre
        nombre = leer.next();
        // Mostramos por consola un saludo personalizado
        System.out.println("Hola Mundo! Soy " + nombre + " y este es mi primer programa de Java");
    }

}
