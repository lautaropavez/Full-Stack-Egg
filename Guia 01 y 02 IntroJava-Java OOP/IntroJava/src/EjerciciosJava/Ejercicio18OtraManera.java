package EjerciciosJava;
//18. Necesitamos mostrar un contador con 3 dígitos (X-X-X), que muestre los números
//del 0-0-0 al 9-9-9, con la particularidad que cada vez que aparezca un 3 lo sustituya
//por una E. Ejemplo:
//  0-0-0
//  0-0-1
//  0-0-2
//  0-0-E
//  0-0-4
//  .
//  .
//  0-1-2
//  0-1-E
//Nota: investigar función equals() y como convertir números a String.
public class Ejercicio18OtraManera {

    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int h = 0; h <= 9; h++) {
                    System.out.print(i !=  3 ? i : "E" );
                    System.out.print( " - " );
                    System.out.print(j !=  3  ?j :  "E" );
                    System.out.print( " - " );
                    System.out.println(h !=  3  ?h :  "E" );
                }
            }
        }
    }

}
