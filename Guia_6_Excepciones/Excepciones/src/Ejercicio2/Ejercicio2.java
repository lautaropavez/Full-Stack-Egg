package Ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2. Definir una Clase que contenga algún tipo de dato de tipo array y agregue
 * el código para generar y capturar una excepción
 * ArrayIndexOutOfBoundsException (índice de arreglo fuera de rango).
 */
/**
 * @author Lautaro Pavez
 */
public class Ejercicio2 {

    public static void main(String[] args) {

        int[] miVector = new int[10];

        try {
            for (int i = 0; i < 11; i++) {
                miVector[i] = (int) Math.random() * 50 + 1;
                System.out.println("[" + i + "] ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.toString());
        }
        
//
//        int[] Vectormio = new int[10];
//        for (int j = 0; j < 13; j++) {
//            try {
//                miVector[j] = (int) Math.random();
//                System.out.println("[" + j + "]");
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println(e.toString());
//            }
//        }

    }

}
