package EjerciciosJava;
//19. Dibujar un cuadrado de N elementos por lado utilizando el carácter “*”. Por ejemplo,
//si el cuadrado tiene 4 elementos por lado se deberá dibujar lo siguiente:
//       * * * *
//       *     *
//       *     *
//       * * * *

import java.util.Scanner;

public class Ejercicio19 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        int lado, i, j;
        System.out.println("Ingrese el ancho del cuadrado: ");
        lado = entrada.nextInt();

        for (i = 1; i <= lado; i++) {
            for (j = 1; j <= lado; j++) {
                if ((i > 1) && (i < lado) && (j > 1) && (j < lado)) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println("  ");
        }

//       Para i=1 Hasta lado Con Paso 1 Hacer
//		Para x=1 Hasta lado Con Paso 1 Hacer
//			Si (i>1) y (i<lado) y (x>1) y (x<lado) Entonces
//				Escribir Sin Saltar "  ";
//			SiNo
//				Escribir Sin Saltar "* ";
//			FinSi
//		FinPara
//		
//		Escribir "  "
//	FinPara
    }

}
