package POOEXTRAS;
//1. Desarrollar una clase Cancion con los siguientes atributos: titulo y autor. Se deberá́
//definir además dos constructores.
import java.util.Scanner;

public class ServiceCancion {
    
    Scanner leer = new Scanner(System.in);
    /**
     * Crea el objeto a partir de los datos ingresados por el usuario
     *
     * @return
     */
    public Cancion crearCancion(){
        
        System.out.println("Ingrese el titulo de la cancion: ");
        String titulo = leer.nextLine();
        
        System.out.println("Ingrese el nombre del autor: ");
        String autor = leer.nextLine();
        
        return new Cancion(titulo,autor); 
    }
}
