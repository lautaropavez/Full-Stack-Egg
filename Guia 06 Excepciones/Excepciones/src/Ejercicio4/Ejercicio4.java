package Ejercicio4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 4. Escribir un programa en Java que juegue con el usuario a adivinar un
 * número. La computadora debe generar un número aleatorio entre 1 y 500, y el
 * usuario tiene que intentar adivinarlo. Para ello, cada vez que el usuario
 * introduce un valor, la computadora debe decirle al usuario si el número que
 * tiene que adivinar es mayor o menor que el que ha introducido el usuario.
 * Cuando consiga adivinarlo, debe indicárselo e imprimir en pantalla el número
 * de veces que el usuario ha intentado adivinar el número. Si el usuario
 * introduce algo que no es un número, se debe controlar esa excepción e
 * indicarlo por pantalla. En este último caso también se debe contar el
 * carácter fallido como un intento.
 *
 * @author Lautaro Pavez
 */
public class Ejercicio4 {

    public static void main(String[] args) {
        //Acamus lo hizo casi igual
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int num1 = (int) ((Math.random() * 500) + 1);
        int cont = 0;
        int intento = 0;
        System.out.println("");
        System.out.println("numero: " + num1);

        System.out.println("----------------------BIENVENIDO----------------------");
        System.out.println("Vamos a jugar..."
                + "\nLo que debes hacer es adivinar el numero que yo he elegido.");

        do {

            try {
                System.out.println("Adivina el numero ");
                cont++;
                intento = leer.nextInt();
                
            } catch (RuntimeException e) {
                System.out.println("[ERROR]");
                System.out.println(e.toString());
                //cont++; //Si yo lo pongo al contador debajo del leer de intento tengo que ponerlo aca tambine porque salta directamente pero como lo pongo antes no hace falta
                System.out.println("Cantidad de intentos: " + cont);
                break;
            }
            if (intento > (num1+1)) {
                    System.out.println("Te pasaste, un poco menos...");
                    System.out.println("Cantidad de intentos: " + cont);
                } else if (intento < (num1-1)) {
                    System.out.println("Muy bajo, un poco mas..."); 
                    System.out.println("Cantidad de intentos: " + cont);
                } else if (intento == (num1+1) || intento== (num1-1)) {
                    System.out.println("CASI CASI");
                    System.out.println("Cantidad de intentos: " + cont);
                } else if (intento == num1) {
                    System.out.println("CORRECTO");
                    System.out.println("¡GANASTE!");
                    System.out.println("Cantidad de intentos: " + cont);
                }
            
        } while (intento != num1);

    }

}
