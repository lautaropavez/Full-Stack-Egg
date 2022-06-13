package EjerciciosJava;

import java.util.Random;
import java.util.Scanner;

/**
 * 24. Recorrer un vector de N enteros contabilizando cuántos números son de 1
 * dígito, cuántos de 2 dígitos, etcétera (hasta 5 dígitos).
 */
public class Ejercicio24 {

    public static void main(String[] args) {
        int tam, num = 0;
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del vector:");
        tam = leer.nextInt();
        int[] vector = new int[tam];
        // llamada al metodo para llenar el arreglo con valores aleatorios
        rellenarVector(vector);

        System.out.println("[ VECTOR GENERADO ]");
        // Mostramos los valores del vector
        mostrarVector(vector);

        System.out.println("[ CONTABILIZADOR DE DIGITOS ]");
        // Llamada al metodo para contabilizar los digitos
        contabilizarDigitos(vector);

    }

    private static void contabilizarDigitos(int[] vector){

        String numText;
        int unDigito = 0;
        int dosDigitos = 0;
        int tresDigitos = 0;
        int cuatroDigitos = 0;
        int cincoDigitos = 0;

        for (int i = 0; i < vector.length; i++) {
            // convertimos a String los valores del vector
            numText = Integer.toString(vector[i]);
            // Validamos la longitud de la cadena
            if (numText.length() == 1) {
                unDigito++;
            } else {
                if (numText.length() == 2) {
                    dosDigitos++;
                } else {
                    if (numText.length() == 3) {
                        tresDigitos++;
                    } else {
                        if (numText.length() == 4) {
                            cuatroDigitos++;
                        } else {
                            if (numText.length() == 5) {
                                cincoDigitos++;
                            }
                        }
                    }
                }
            }
        }
            // Mostramos los resultados
            System.out.println("El vector tiene un total de: ");
            System.out.println("[" + unDigito + "] valores de un digito.");
            System.out.println("[" + dosDigitos + "] valores de dos digitos.");
            System.out.println("[" + tresDigitos + "] valores de tres digitos.");
            System.out.println("[" + cuatroDigitos + "] valores de cuatro digitos.");
            System.out.println("[" + cincoDigitos + "] valores de cinco digitos.");
    }
    
  
    /*
     * Llena el vector con valores aleatorios, haciendo uso de la clase Random
     * y su metodo .nextInt() en este caso tendremos un rango de 0 a 300
     */
    private static void rellenarVector(int[] vector){
        
        Random numRandom = new Random(); // Obj de la clase random para usar el metodo nextInt()
        for (int i = 0; i < vector.length; i++) {
            vector[i] = numRandom.nextInt(20000);
        }
    }

    /*
     * Muestra por consola los valores del vector
     */
    private static void mostrarVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println("[" + vector[i] + "]");
        }
        System.out.println("");
    }

}
