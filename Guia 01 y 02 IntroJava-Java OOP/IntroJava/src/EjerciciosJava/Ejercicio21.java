package EjerciciosJava;
/** 21. Crea una aplicación que a través de una función nos convierta una cantidad de
 *  euros introducida por teclado a otra moneda, estas pueden ser a dólares, yenes o
 *  libras. La función tendrá como parámetros, la cantidad de euros y la moneda a
 *  convertir que será una cadena, este no devolverá ningún valor y mostrará un
 *  mensaje indicando el cambio (void).
 *  El cambio de divisas es:
 *         * 0.86 libras es un 1 €
 *         * 1.28611 $ es un 1 €
 *         * 129.852 yenes es un 1 €
 */
import java.util.Scanner;

public class Ejercicio21 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        String monedaCambio;

        // Pedimos datos al usuario
        System.out.println("[ Convertidor de Moneda ]");
        System.out.println("Ingrese la cantidad de Euros: ");
        double euro = entrada.nextDouble();
        entrada.nextLine(); // Limpiamos el buffer de entrada para poder leer el String

        System.out.println("Ingrese el nombre de la moneda a la que desea convertir: ");
        System.out.println("1- Pesos.");
        System.out.println("2- Libras.");
        System.out.println("3- Yenes.");

        monedaCambio = entrada.nextLine();

        Conversor(euro, monedaCambio);
        entrada.close();

    }

// ==============================================================================
    public static void Conversor(double euro, String monedaCambio) {
        double peso, yen, libra;
        
        // Damos valores a peso, libra, yen.. el equivalente de 1 euro
        
        peso = 1.28611;
        libra = 0.86;
        yen = 129.852;

        switch (monedaCambio.toUpperCase()) {
            case "PESOS":
                System.out.println("El cambio de: €" + euro + " euros a pesos es: $" + (euro * peso));
                break;
            case "YENES":
                System.out.println("El cambio de: €" + euro + " euros a yenes es: £" + (euro * peso));
                break;
            case "LIBRAS":
                System.out.println("El cambio de: €" + euro + " euros a libras es: ¥" + (euro * peso));
                break;
            default:
                System.out.println("[ERROR]");
                System.out.println("El nombre ingresado es incorrecto");
                break;

        }
    }
}
