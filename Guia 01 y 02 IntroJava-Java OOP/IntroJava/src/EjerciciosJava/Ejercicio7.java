package EjerciciosJava;
/** 7. Implementar un programa que dado dos números enteros determine cuál es el
 *  mayor y lo muestre por pantalla.
 */
import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Buenos días, ingrese dos numeros enteros.");
        System.out.println("Ingrese el primer numero: ");
        Integer num1 = leer.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        Integer num2 = leer.nextInt();
        System.out.println("El mayor de ambos numeros ingresados es: " + Math.max(num1, num2));
    }

}
