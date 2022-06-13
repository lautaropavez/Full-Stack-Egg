package POO.RectanguloApp;

import java.util.Scanner;

public class ServiceRectangulo {
    
    private static Scanner leer = new Scanner(System.in);
    
    //Metodo para construir un rectángulo
    public static Rectangulo crearRectangulo(){
        System.out.println("Ingrese la base del rectángulo: ");
        int base = leer.nextInt();
        
        System.out.println("Ingrese la altura del rectángulo: ");
        int altura = leer.nextInt();
        
        return new Rectangulo(base,altura);
    }
    
}
