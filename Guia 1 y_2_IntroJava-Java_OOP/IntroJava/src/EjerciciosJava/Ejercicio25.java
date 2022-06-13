package EjerciciosJava;
//  25_Realizar un programa que rellene un matriz de 4 x 4 de valores aleatorios y
//  muestre traspuesta.

import java.util.Random;
import java.util.Scanner;

public class Ejercicio25 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        int[][] Matriz = new int[4][4];

        // Llamada al metodo para rellenar la matriz
        rellenarMatriz(Matriz);

        System.out.println("[ Matriz aleatoria creada. ]");

        // Mostramos la matriz generada
        System.out.println("---------------------------------------");
        mostrarMatriz(Matriz);
        System.out.println("---------------------------------------");

        // Mostramos la matriz traspuesta
        System.out.println("[ Matriz traspuesta. ]");
        System.out.println("---------------------------------------");
        matrizTraspuesta(Matriz);
        System.out.println("---------------------------------------");

    }

    private static void rellenarMatriz(int[][] matriz) {
        Random numRandom = new Random(); // Obj de la clase random para usar el metodo nextInt()
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = numRandom.nextInt(100);
            }
        }
    }

    //Recorre la matriz e imprime sus valores
    private static void mostrarMatriz(int[][] matriz) {
        String aux = "";

        System.out.println("\n* Matriz:");

        //para cada fila de la matriz
        for (int[] fila : matriz) {
            aux = "";
            //para cada elemento de la fila
            for (int elemento : fila) {
                aux += " " + elemento; //el operador += nos permite concatenar sumando el valor que estamos concatenando con la expresion que tenemos a la derecha
            }
            System.out.println(aux);
        }

    }
    
    /**
    * Recibe la matriz, la recorre y asigna sus valores a una nueva matriz que
     * obtendra sus valores originales de forma traspuesta, o invertida. Y al final
     * mostrara el resultado.
     */
    private static void matrizTraspuesta(int[][] matriz) {
        
        int[][] matriz_traspuesta = new int[4][4];

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz.length; j++){
                matriz_traspuesta[i][j] = matriz[j][i]; // invertimos las filas y columnas
            }
        }
        // mostramos el resultado de la matriz traspuesta
	mostrarMatriz(matriz_traspuesta);
 
}       
}
