package EjerciciosJava;
/** 27_ Un cuadrado mágico 3 x 3 es una matriz 3 x 3 formada por números del 1 al 9
 *  donde la suma de sus filas, sus columnas y sus diagonales son idénticas. Crear un
 *  programa que permita introducir un cuadrado por teclado y determine si este
 *  cuadrado es mágico o no. El programa deberá comprobar que los números
 *  introducidos son correctos, es decir, están entre el 1 y el 9.
*/
import java.util.Scanner;

public class Ejercicio27 {

    public static void main(String[] args) {

        int[][] matrix = new int[3][3];

        // Llamada al metodo para llenar la matriz
        rellenarMatriz(matrix);

        // Mostramos la matriz
        mostrarMatriz(matrix);

        // llamada al metodo para sumar las filas, columnas, diagonales
        sumarValoresMatriz(matrix);
    }

    /**
     * Pedira al usuario que ingrese los valores de la matriz. Validara que los
     * N° ingresados esten entre 1 y 9.
     */
    private static void rellenarMatriz(int[][] matriz) {

        Scanner leer = new Scanner(System.in);
        int num; // Variable que almacenara temporalmente los datos ingresados por usuario

        System.out.println("Ingrese solo valores numericos en el rango de 1 a 9:");

        for (int i = 0; i < 3; i++) {
            System.out.println("-----------------------------------");

            for (int j = 0; j < 3; j++) {
                do {
                    // Entrada de datos
                    System.out.print("--> Posicion: [" + i + "][" + j + "] = ");
                    num = leer.nextInt();

                    // Validamos que el valor ingresado se encuentre en el rango de 1 a 9
                    if (num >= 1 && num <= 9) {
                        matriz[i][j] = num;
                    } else {
                        System.out.println("[ ERROR ] numero ingresado fuera de rango!.");
                    }
                } while (num < 1 || num > 9);
            }

            System.out.println("-----------------------------------");
        }
    }

    /**
     * Recorre las filas y columnas de la matriz y las muestra por pantalla
     */
    private static void mostrarMatriz(int[][] matriz) {
        System.out.println("--------------------------");
        System.out.println("[ CONTENIDO DE LA MATRIZ ]");
        System.out.println("--------------------------");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println("");
        }
    }

    /**
     * Sumara las filas y columnas de la matriz; almacenara el resultado de c/u
     * en un vector La suma de las diagonales se almacenaran en variables.
     * Llamara al metodo esMagica y le pasara los vectores y las variables como
     * parametro.
     */
    private static void sumarValoresMatriz(int[][] matriz) {
        int[] sumaFila = new int[3];
        int[] sumaColumna = new int[3];
        int DiagonalPrincipal = 0;
        int DiagonalSecundaria = 0;
        int sumaF = 0;
        int sumaC = 0;

        // Recorremos la matriz en un for anidado y realizamos las sumas
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                // Sumar filas
                sumaF = sumaF + matriz[i][j]; // Nota += es lo mismo que decir sumaF = sumaF + matriz[i][j]

                // Sumar columnas
                sumaC = sumaC + matriz[j][i];

                // para la diagonal principal se suman los valores que cumplan con la condicion i igual j
                if (i == j) {
                    DiagonalPrincipal = DiagonalPrincipal + matriz[i][j];
                }

                // para la diagonal secundaria la condicion seria i + j = matriz.length
                if (i + j == matriz.length - 1) {
                    DiagonalSecundaria = DiagonalSecundaria + matriz[i][j];
                }
            }
            
            // Almacenamos el resultado de la suma de la fila[i]
            sumaFila[i] = sumaF;
            sumaF = 0; // se "limpia" la variable asignandole cero, para que borre el valor de la suma anterior

            // Almacenamos el resultado de la suma de la columna[i]
            sumaColumna[i] = sumaC;
            sumaC = 0;
        }
        
        // Llamada al metodo esMagica
        esMagica(sumaFila, sumaColumna, DiagonalPrincipal, DiagonalSecundaria);
    }
    
    /**
     * Recibe por parametro los resultados de las sumas. Validara que todos los
     * resultados sean igual a 15 Y mostrara el msj correspondiente
     */
    private static void esMagica(int[] sumaFila, int[] sumaColumnas, int diagonalPrincipal, int diagonalSecundaria) {
        
        boolean auxLogico = false;

        for (int i = 0; i < sumaFila.length; i++) {
            if ((sumaFila[i] == 15) && (sumaColumnas[i] == 15) && (diagonalPrincipal == 15) && (diagonalSecundaria == 15)) {
                auxLogico = true;
            }else{
                break;
            }
        }

        if (auxLogico == true) {
            System.out.println("--------------------------");
            System.out.println("[ LA MATRIZ ES MAGICA !!! ]");
            System.out.println("--------------------------");

            for (int i = 0; i < sumaFila.length; i++) {
                System.out.println("La suma de la fila[" + (i + 1) + "] es = " + sumaFila[i]);
                System.out.println("La suma de la columna[" + (i + 1) + "] es = " + sumaColumnas[i]);
            }

            System.out.println("La suma de la diagonal principal es = " + diagonalPrincipal);
            System.out.println("La suma de la diagonal scundaria es = " + diagonalSecundaria);
            System.out.println("----------------------------------------");
        } else {
            System.out.println("--------------------------");
            System.out.println("[ Es una matriz sin Gracia ni Magia! :c ]");
            System.out.println("--------------------------");
        }
    }
}
