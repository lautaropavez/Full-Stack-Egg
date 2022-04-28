package colecciones;

import java.util.ArrayList;  //Nos sirve tambien si en vez de List usaramos ArrayList pero con List tenemos acceso a varios metodos más
import java.util.List;
import java.util.Scanner;

public class ServiceColecciones1 {
    
    private Scanner leer;
    private List<String> mascotas;
    
    public ServiceColecciones1(){
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.mascotas = new ArrayList();
    }
    
    public void crearMascota(){
        System.out.println("Introducir nombre: ");
        String nombre = leer.next();
        
        System.out.println("Introducir apodo: ");
        String apodo = leer.next();
        
        System.out.println("Introducir tipo: ");
        String tipo = leer.next();
        
        String mascota = nombre + " " + apodo + " " + tipo ; //Este String que yo creo lo guardo en el Array
        
        mascotas.add(mascota); //Cada vez que yo llame a CrearMascota voy a crear un String Mascota, NO un objeto, y ese String es el que guardo en la lista.
    }
    
    public void MostrarMascotas(){
        
        System.out.println("Las mascotas actuales de la Lista Mascota son: ");
        
        for (String var : mascotas) { // 1° Tipo de dato de la variable auxiliar a mostrar. 2° variable. 3° Sobre que se va a resolver.
            System.out.println(var);
        }
        
        System.out.println("Cantidad = " + mascotas.size());
    }
    
}

