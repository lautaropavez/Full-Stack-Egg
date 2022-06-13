package EjerciciosJava;
// 5. Dada una cantidad de grados centígrados se debe mostrar su equivalente en
//grados Fahrenheit. La fórmula correspondiente es: F = 32 + (9 * C / 5).

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        System.out.println("Ingrese la cantidad de grados que hacen actualmente: ");
        Scanner leer = new Scanner(System.in);
        int tempC = leer.nextInt();
        int tempF = 32 + (9 * tempC / 5);
        System.out.println(tempC + " grados centigrados son " + tempF + " grados fahrenheit.");
    }

}
