package EjerciciosJava;
/** 14. Escriba un programa en el cual se ingrese un valor límite positivo, y a continuación
 *  solicite números al usuario hasta que la suma de los números introducidos supere
 *  el límite inicial.
 */
import java.util.Scanner;

public class Ejercicio14 {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un límite positivo: ");
        Integer limite = leer.nextInt();
        Integer suma = 0;
        while(suma<=limite){
            System.out.println("Ingrese un numero: ");
            Integer num = leer.nextInt();
            suma += num;
            System.out.println("La suma de los numeros ingresados es: " + suma);
        }
        System.out.println("Ha superado al límite establecido.");   
    }

}
