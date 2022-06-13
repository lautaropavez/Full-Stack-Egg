package POO.Operacion;

/**
 * d) Método para crearOperacion(): que le pide al usuario los dos números y los
 * guarda en los atributos del objeto. X e) Método sumar(): calcular la suma de
 * los números y devolver el resultado al main. - f) Método restar(): calcular
 * la resta de los números y devolver el resultado al main. - g) Método
 * multiplicar(): primero valida que no se haga una multiplicación por cero, si
 * fuera a multiplicar por cero, el método devuelve 0 y se le informa al usuario
 * el error. Si no, se hace la multiplicación y se devuelve el resultado al main
 * h) Método dividir(): primero valida que no se haga una división por cero, si
 * fuera a pasar una división por cero, el método devuelve 0 y se le informa al
 * usuario el error se le informa al usuario. Si no, se hace la división y se
 * devuelve el resultado al main.
 */
import java.util.Scanner;

public class ServiciosOperacion {

    Scanner leer = new Scanner(System.in);

    /**
     * Crea el objeto a partir de los datos ingresados por el usuario
     *
     * @return
     */
    public Operacion crearOperacion() {
        System.out.println("Ingrese el primer número: ");
        int num1 = leer.nextInt();

        System.out.println("Ingrese el segundo número: ");
        int num2 = leer.nextInt();

        return new Operacion(num1, num2);
    }

    public int sumar(int num1, int num2) {

        int suma = num1 + num2;
        return suma;
    }

    public int restar(int num1, int num2) {

        int restar = num1 - num2;
        return restar;
    }

    public int multiplicar(int num1, int num2) {
        int multiplicar = 0;

        if (num1 != 0 && num2 != 0) {
            multiplicar = num1 * num2;
        } else {
            multiplicar = 0;
            System.out.println("No se puede multiplicar por cero (0).");
        }

        return multiplicar;
    }
    
    public double dividir(int num1, int num2) {
        double dividir;

        if (num2 != 0) {
            dividir =(double) num1 /(double) num2;
        } else {
            dividir = 0;
            System.out.println("No se puede dividir por cero (0).");
        }
        return dividir;
    }

}
