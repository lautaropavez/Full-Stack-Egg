package EjerciciosJava;
/* 2. Escribir un programa que pida dos números enteros por teclado 
 y calcule la suma de los dos. El programa deberá después mostrar 
 el resultado de la suma.*/
import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {

        int numero1, numero2, numero3;
        Scanner num1 = new Scanner(System.in);
        Scanner num2 = new Scanner(System.in);
        System.out.println("Ingrese dos numeros enteros:");
        numero1 = num1.nextInt();
        numero2 = num2.nextInt();
        numero3 = numero1 + numero2;
        System.out.println(" La suma de: " + numero1 + " + " + numero2 + " = " + numero3);
        //System.out.println( " La suma de: "  + numero1 +  " + "  + numero2 +  " = "  + (numero1 + numero2));
    }

}
