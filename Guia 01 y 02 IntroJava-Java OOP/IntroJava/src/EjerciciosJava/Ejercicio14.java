package EjerciciosJava;
//  14. Escriba un programa en el cual se ingrese un valor límite positivo, y a continuación
//  solicite números al usuario hasta que la suma de los números introducidos supere
//  el límite inicial.

import java.util.Scanner;

public class Ejercicio14 {

    public static void main(String[] args) {

        int suma, limite, num;
        System.out.println("Ingrese un límite positivo: ");
        Scanner entrada = new Scanner(System.in);
        limite = entrada.nextInt();
        suma = 0;
        while (suma <= limite) {
            System.out.println("Ingrese un número:");
            num = entrada.nextInt();
            suma = suma + num;
            System.out.println("La suma de los numeros ingresados es: " + suma);
        }
        System.out.println("Ha superado al límite establecido.");
    }

}
