package EjerciciosJava;

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
