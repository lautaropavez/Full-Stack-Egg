package POO.CadenaApp;

import java.util.Scanner;

public class CadenaApp {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        // intanciamos las clases Servicio y Cadena
        ServiceCadena servicio = new ServiceCadena();

        Cadena cadena01 = servicio.crearCadena();
        
        
        //servicio.ejecutarMenu();
        
         
       System.out.println("Cantidad de vocales que tiene: " + servicio.mostrarVocales(cadena01));
       
       //System.out.println("Cantidad de vocales que tiene: " + datos.mostrarVocales(cadena01));
        
        //datos.invertirFrase();

        //System.out.println("Ingrese la letra que desea buscar en la cadena: ");
       // datos.vecesRepetido(leer.next().toUpperCase());
       // System.out.println("El caracter se repite " + datos.vecesRepetido(leer.next().toUpperCase())); // me parece que está mal

       // System.out.println("Ingrese una nueva frase: ");
       // datos.compararLongitud(leer.nextLine());

    }

}
