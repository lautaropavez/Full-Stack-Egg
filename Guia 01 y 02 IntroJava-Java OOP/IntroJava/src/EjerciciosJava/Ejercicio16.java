package EjerciciosJava;
/** 16. Escriba un programa que lea 20 números. Si el número leído es igual a cero se debe
 *  salir del bucle y mostrar el mensaje "Se capturó el numero cero". El programa
 *  deberá calcular y mostrar el resultado de la suma de los números leídos, pero si el
 *  número es negativo no debe sumarse. Nota: recordar el uso de la sentencia break.
 */
import java.util.Scanner;

public class Ejercicio16 {

    public static void main(String[] args) {

        Integer suma = 0;
        System.out.println("Ingrese 20 números.");
        
        for (int i = 0; i < 20; i++) {
            System.out.println("Ingrese el " + i + "° numero: ");
            Integer num = pedirEntero();
            if(num > 0){
                suma += num;
                System.out.println("La suma va en " + suma);
            }else if(num == 0){
                System.out.println("Se capturó el numero cero");
                break;
            }
        }
        System.out.println("La suma de todos los número enteros positivos ingresados es: "+ suma);
}

    public static Integer pedirEntero() {
        Scanner entrada = new Scanner(System.in);
        return entrada.nextInt();
    }
}
