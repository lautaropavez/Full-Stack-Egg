package EjerciciosJava;
//  26_Realice un programa que compruebe si una matriz dada es anti simétrica. Se dice
//  que una matriz A es anti simétrica cuando ésta es igual a su propia traspuesta, pero
//  cambiada de signo. Es decir, A es anti simétrica si A = -AT. La matriz traspuesta de
//  una matriz A se denota por AT y se obtiene cambiando sus filas por columnas (o
//  viceversa).
//  Ejemplo:
//              Matriz                      Matriz Traspuesta
//            |  0 -2  4 |                  |  0  2  4 |
//            |  2  0  2 |                  | -2  0 -2 |
//            | -4 -2  0 |                  |  4  2  0 |
//
//  En este caso la matriz es anti simétrica.
//

import java.util.Scanner;

public class Ejercicio26 {

    public static void main(String[] args) {
        int tam = 0;
        int[][] matriz;
        do {
            Scanner leer = new Scanner(System.in);
            System.out.println("Ingrese el tamaño de la matriz: ");
            tam = leer.nextInt();
            matriz = new int[tam][tam];
            if (tam <= 10) {
                System.out.println("[ TAMAÑO INGRESADO ]");
            } else {
                System.out.println("TAMAÑO INCORRECTO VUELVA A INGRESARLO");
            }
        } while (tam > 10);

        RellenarMatrix(matriz, tam);
        
        System.out.println("[ Matriz Original. ]");
        MostrarMatrix(matriz);

        System.out.println("[ Matriz traspuesta. ]");
        matrizTraspuesta(matriz, tam);
    }

    private static void RellenarMatrix(int[][] matriz, int tam) {

        int num;
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese los valores de la matriz: ");

        for (int i = 0; i < tam; i++) {
            for (int j = 0; j < tam; j++) {
                System.out.println("Ubicación [" + i + "] [" + j + "]");
                num = leer.nextInt();
                matriz[i][j] = num;
            }
        }
        leer.close();
    }

    //Recorre la matriz e imprime sus valores
    private static void MostrarMatrix(int[][] matriz) {
        System.out.println("=====================================");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println(" ");
        }
        System.out.println("=====================================");
    }

    /**
     * Recibe la matriz, la recorre y asigna sus valores a una nueva matriz que
     * obtendra sus valores originales de forma traspuesta, o invertida. Y al
     * final mostrara el resultado.
     */
    private static void matrizTraspuesta(int[][] matriz, int tam) {

        int[][] matriz_Traspuesta = new int[tam][tam];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz_Traspuesta[i][j] = matriz[j][i];
            }
        }
        // mostramos el resultado de la matriz traspuesta
        MostrarMatrix(matriz_Traspuesta);

        //Llamada al método que dirá si es Antisimétrico o no
        esAntisimetrica(matriz, matriz_Traspuesta);
    }

    /**
     * Recibe la matriz original y su traspuesta para validar si es
     * antisimetrica o no. matriz es anti simétrica si matriz == -
     * mattriz_traspuesta
     */
    private static void esAntisimetrica(int[][] matriz, int[][] matriz_Traspuesta) {

        int var_count = 0;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {

                // validamos si es anti simetrica (signos opuestos + / - )
                if (matriz[i][j] == (-matriz_Traspuesta[i][j])) {
                    // de ser verdadero aumentamos el contador
                    var_count++;
                }
            }
        }

        if (var_count > 0) {
            System.out.println("[ Es una matriz anti simetrica ]");
        } else {
            System.out.println("[ No es una matriz anti simetrica ]");
        }
    }
}
