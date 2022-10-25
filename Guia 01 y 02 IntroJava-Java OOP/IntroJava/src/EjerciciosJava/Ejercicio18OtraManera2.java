package EjerciciosJava;
/** 18. Necesitamos mostrar un contador con 3 dígitos (X-X-X), que muestre los números
 *  del 0-0-0 al 9-9-9, con la particularidad que cada vez que aparezca un 3 lo sustituya
 *  por una E. Nota: investigar función equals() y como convertir números a String.
 *  Ejemplo:
 *   0-0-0
 *   0-0-1
 *   0-0-2
 *   0-0-E
 *   0-0-4
 *   .
 *   .
 *   0-1-2
 *   0-1-E
 */
/**
 * @author Lautaro Pavez
 */
public class Ejercicio18OtraManera2 {

    public static void main(String[] args) {
        String conversor;

        for (int i = 0; i < 1000; i++) {
            conversor = String.valueOf(i);//Nos muestra el valor convertido a cadena
            if (i < 10) {
                System.out.println("00" + conversor.replace('3', 'E'));
            } else {
                if (i < 100) {
                    System.out.println("0" + conversor.replace('3', 'E'));
                } else {
                    if (i < 1000) {
                        System.out.println(conversor.replace('3', 'E'));
                    }
                }
            }
        }
    }
}
