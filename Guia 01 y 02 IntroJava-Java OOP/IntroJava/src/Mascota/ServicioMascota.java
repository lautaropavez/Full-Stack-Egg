package Mascota;

import java.util.Scanner;

public class ServicioMascota {

    private Scanner leer = new Scanner(System.in);
    
    public Mascota crearMascota(){
        
        System.out.println("Introducir nombre:");
        String nombre = leer.nextLine();
        
        System.out.println("Introducir apodo:");
        String apodo = leer.nextLine();
        
        System.out.println("Introducir tipo:");
        String tipo = leer.nextLine();
        //Con estos valores alimento el constructor
        
        //Mascota m = new Mascota(nombre, apodo, tipo);// de esta manera hago nacer la mascota y con el return lo devuelvo.
        //return m;
        //Esa seria la forma larga pero nosotros en realidad no necesitamos que exista una variable m (Mascota m) asi que directamente podemos poner:
        
        return new Mascota(nombre, apodo, tipo); //Devolvemos el nacimiento de una mascota que va a tener tales caracteristicas
    }
    
}
