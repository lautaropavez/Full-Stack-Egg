package EjerciciosJava;
/*3. Escribir un programa que pida tu nombre, lo guarde en una variable 
 y lo muestre por pantalla. 
 */
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Buenos días, ingrese su nombre:");
        String nombre = leer.nextLine();
        System.out.println("Su nombre es " + nombre);
    }

}
