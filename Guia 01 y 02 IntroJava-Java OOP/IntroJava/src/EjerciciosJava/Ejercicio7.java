package EjerciciosJava;
//7. Implementar un programa que dado dos números enteros determine cuál es el
//mayor y lo muestre por pantalla.

import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {

        int num1, num2;
        Scanner leer = new Scanner(System.in);
        System.out.println("Buenos días, ingrese dos numeros enteros.");
        System.out.println("Ingrese el primer numero:");
        num1 = leer.nextInt();
        System.out.println("Ingrese el segundo numero:");
        num2 = leer.nextInt();
        Math.max(num1, num2);//podria haberlo puesto solo en el sout pero lo dejamos así para acordarnos como hacerlo.
        System.out.println("El mayor de ambos numeros ingresados es: " + Math.max(num1, num2));
    }

}
