package POO.Ejercicio12Persona;

import java.util.Scanner;

public class PersonaDateApp {

    public static void main(String[] args) {
        
       Scanner leer = new Scanner(System.in).useDelimiter("\n");
       ServicePersona service = new ServicePersona();
       
       service.crearPersona();
       service.Calcular_edad();
       System.out.println("<<<<< Usuario 2 >>>>>");
       System.out.println("Ingrese la edad: ");
       service.menorQue(leer.nextInt());
       service.Mostrar_Personal();

    }

}
