package POOEXTRAS.PuntosApp;
//  2. Definir una clase llamada Puntos que contendrá las coordenadas de dos puntos, sus
//  atributos serán, x1, y1, x2, y2, siendo cada x e y un punto. Generar un objeto puntos
//  usando un método crearPuntos() que le pide al usuario los dos números y los ingresa
//  en los atributos del objeto. Después, a través de otro método calcular y devolver la
//  distancia que existe entre los dos puntos que existen en la clase Puntos.
import java.util.Scanner;

public class ServicePuntos {
    
    Scanner leer = new Scanner(System.in);
    
    public Puntos crearPuntos(){
        
        System.out.println("Buenos días.");
        System.out.println("Ingrese las coordenadas del 1° punto: ");
        System.out.print("x: ");
        int x1 = leer.nextInt();
        System.out.print("y: ");
        int y1 = leer.nextInt();
        
        System.out.println("Ingrese las coordenadas del 2° punto: ");
        System.out.print("x: ");
        int x2 = leer.nextInt();
        System.out.print("y: ");
        int y2 = leer.nextInt();
        
        
        return new Puntos(x1,y1,x2,y2);
    }
    
    public double calcularDistancia(int x1,int y1,int x2,int y2){
        
        double distancia= Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
        
        return distancia;
    }
    
}
