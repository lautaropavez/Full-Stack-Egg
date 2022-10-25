package EjerciciosJava;
/** 17. Realizar un programa que simule el funcionamiento de un dispositivo RS232, este
 *  tipo de dispositivo lee cadenas enviadas por el usuario. Las cadenas deben llegar
 *  con un formato fijo: tienen que ser de un máximo de 5 caracteres de largo, el primer
 *  carácter tiene que ser X y el último tiene que ser una O.
 *  Las secuencias leídas que respeten el formato se consideran correctas, la
 *  secuencia especial “&&&&&” marca el final de los envíos (llamémosla FDE), y toda
 *  secuencia distinta de FDE, que no respete el formato se considera incorrecta.
 *  Al finalizar el proceso, se imprime un informe indicando la cantidad de lecturas
 *  correctas e incorrectas recibidas. Para resolver el ejercicio deberá investigar cómo
 *  se utilizan las siguientes funciones de Java Substring(), Length(), equals().
 */
import java.util.Scanner;

public class Ejercicio17 {

    public static void main(String[] args) {
        int suma = 0;
        int sumaneg = 0;
        String cadena = null;
        int cantidad;
        System.out.println("Ingrese una palabra o frase de 5 caracteres que empiece con X y termine con O: ");
        do {
            cadena = pedirCadena();
            cadena = cadena.toUpperCase();
            cantidad = cadena.length();
            if ((cantidad == 5) && ("X".equals(cadena.substring(0, 1))) && ("O".equals(cadena.substring(4, 5)))) {
                suma = suma + 1;
                System.out.println("CORRECTO");
            } else {

                sumaneg = sumaneg + 1;
                System.out.println("INCORRECTO");
            }

        } while (!"&&&&&".equals(cadena));
        System.out.println(" Se ingresaron un total de [ " + suma + " ] cadenas correctas. ");
        System.out.println(" Se ingresaron un total de [ " + (sumaneg - 1) + " ] cadenas incorrectas. ");
    }

    public static String pedirCadena() {
        Scanner entrada = new Scanner(System.in).useDelimiter("\n");
        return entrada.nextLine();
    }
}
