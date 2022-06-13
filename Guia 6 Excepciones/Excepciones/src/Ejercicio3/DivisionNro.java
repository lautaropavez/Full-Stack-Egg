package Ejercicio3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 3. Defina una clase llamada DivisionNumero. En el método main utilice un
 * Scanner para leer dos números en forma de cadena. A continuación, utilice el
 * método parseInt() de la clase Integer, para convertir las cadenas al tipo int
 * y guardarlas en dos variables de tipo int. Por ultimo realizar una división
 * con los dos numeros y mostrar el resultado. Todas estas operaciones puede
 * tirar excepciones a manejar, el ingreso por teclado puede causar una
 * excepción de tipo InputMismatchException, el método Integer.parseInt() si la
 * cadena no puede convertirse a entero, arroja una NumberFormatException y
 * además, al dividir un número por cero surge una ArithmeticException. Manipule
 * todas las posibles excepciones utilizando bloques try/catch para las
 * distintas excepciones
 */
/**
 * @author Lautaro Pavez
 */
public class DivisionNro {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String valor1;
        String valor2;

        try {
            System.out.println("Ingrese el 1° numero: ");
            valor1 = leer.next();
            System.out.println("Ingrese el 2° numero: ");
            valor2 = leer.next();
            
            int num1 = Integer.parseInt(valor1);
            int num2 = Integer.parseInt(valor2);
            int division = num1/num2;
            System.out.println("Division: " + division);
        } catch (InputMismatchException e) {
            System.out.println("Excepcion de Ingreso");
            System.out.println(e.toString());
        } catch (NumberFormatException e) {
            System.out.println("Excepcion de parseInt");
            System.out.println(e.toString());
        } catch (ArithmeticException e) {
            System.out.println("Excepcion division por CERO");
            System.out.println(e.toString());
        }finally{
            System.out.println("FIN DEL PROGRAMA1");
        }

    }

}
