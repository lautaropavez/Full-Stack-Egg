package EjerciciosJava;
//13. Escriba un programa que valide si una nota está entre 0 y 10, sino está entre 0 y 10
//la nota se pedirá de nuevo hasta que la nota sea correcta.

import java.util.Scanner;

public class Ejercicio13 {

    public static void main(String[] args) {

        int nota;
        Scanner entrada = new Scanner(System.in);

        do {
            System.out.println("Ingrese una nota (entre 0 y 10): ");
            nota = entrada.nextInt();

        } while (nota < 0 || nota > 10);

        System.out.println("El numero ingresado es válido. Usted ingresó un " + nota + ".");

    }

}
