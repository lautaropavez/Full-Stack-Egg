package Ejercicio5_6_7_8;

/**
 *
 * @author Lautaro Pavez
 */
public class Clase1 {

    private static int metodo() {
        int valor = 0;
        try {
            valor = valor + 1;
            valor = valor + Integer.parseInt("42");
            valor = valor + 1;
            System.out.println("Valor final del try :" + valor);
        } catch (NumberFormatException e) {
            valor = valor + Integer.parseInt("42");
            System.out.println("Valor final del catch:" + valor);
        } finally {
            valor = valor + 1;
            System.out.println("Valor final del finally: " + valor);
        }
        valor = valor + 1;
        System.out.println("Valor antes del return:" + valor);
        return valor;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            System.out.println(metodo());
        } catch (Exception e) {
            System.err.println("Excepcion en metodo()");
            e.printStackTrace();
        }
    }
}
//********************************************************
//  Valor final del try: 43
//  Valor final del finally: 44
//  Valor antes del return: 45
//  45

