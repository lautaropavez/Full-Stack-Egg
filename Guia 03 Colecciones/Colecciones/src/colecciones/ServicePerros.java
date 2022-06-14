package colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
//  1_Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo
//  String. El programa pedirá una raza de perro en un bucle, el mismo se guardará
//  en la lista y después se le preguntará al usuario si quiere guardar otro perro o si
//  quiere salir. Si decide salir, se mostrará todos los perros guardados en el ArrayList.
//  Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le
//  pedirá un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista.
//  Si el perro está en la lista, se eliminará el perro que ingresó el usuario y se mostrará
//  la lista ordenada. Si el perro no se encuentra en la lista, se le informará al usuario
//  y se mostrará la lista ordenada.
public class ServicePerros {

    private Scanner leer;
    private ArrayList<String> mascotas;
    public Iterator<String> it;  

    public ServicePerros() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.mascotas = new ArrayList();
        this.it = mascotas.iterator();
    }

    public void crearMascota() {
        int opcion = 2;
        //String raza;
        System.out.println("Bienvenido...");

        do {
            System.out.println("Introduzca la raza: ");
            String raza = leer.next().toUpperCase(); //Este String que yo creo lo guardo en el Array

            mascotas.add(raza); //Cada vez que yo llame a CrearMascota voy a crear un String Mascota, NO un objeto, y ese String es el que guardo en la lista. 

            System.out.println("¿Desea introducir otra raza? Marque 1 o 2: ");
            System.out.println("1) Sí.");
            System.out.println("2) No.");
            opcion = leer.nextInt();
        } while (opcion != 2);
    }

    public void MostrarPerro() {

        System.out.println("Las mascotas actuales de la Lista Mascota son: ");
        
          mascotas.forEach((aux) -> System.out.println(aux)); // Manera mas rapida de hacer el forEach,sino lo podemos hacer como esta en la linea de abajo
//        for (String var : mascotas) { // 1° Tipo de dato de la variable auxiliar a mostrar. 2° variable. 3° Sobre que se va a resolver.
//            System.out.println(var);
//        }

        System.out.println("Cantidad = " + mascotas.size());
        
    }
  
    public void EliminarPerro(){
        System.out.println("Ingrese el perro que desea sacar de la lista: ");
        String masc = leer.next().toUpperCase();
        
        it = mascotas.iterator();// Esto lo tuve que agregar porque no me andaba el método.La respuesta esta en esta pagina: https://stackoverflow.com/questions/26955041/concurrentmodificationexception-in-arraylist
                                 // Esto se debe a que cambia la lista mientras el iterador sigue apuntando a la lista anterior. una vez que agregue elementos sin actualizar el iterador, obtendrá la excepción concurrente.                                         
        while (it.hasNext()) {                      
            String aux = it.next();

            if (aux.equals(masc)) {
                it.remove();
                System.out.println("Mascota eliminada.");
                System.out.println(" ");
            }
        }
        MostrarPerro();
        //mascotas.forEach((aux) -> System.out.println(aux)); // Manera mas rapida de hacer el forEach
    }
    
    
    
    
    
//    Manera de hacerlo bonito con métodos de colecciones, sin iterador
//    public void EliminarPerro(){
//        System.out.println("Ingrese la mascota que desea sacar de la lista.");
//        String eliminar=leer.next().toUpperCase();
//        
//        for (int i = 0; i < mascotas.size(); i++) {
//            
//          // mascotas m = mascotas.get(i);
// 
//            if (mascotas.get(i).equals(eliminar)) {
//                mascotas.remove(i);
//                System.out.println("Mascota eliminada.");
//                System.out.println(" ");
//            }else{
//                System.out.println("La mascota que desea eliminar no existe.");  
//            } 
//            
//        MostrarPerro();   
//    }
//    }
    
    
    
    
    
//    Manera rústica de eliminar
//    public void EliminarPerro(){
//        System.out.println("Ingrese la mascota que desea sacar de la lista");
//        String eliminar=leer.next().toUpperCase();
//        mascotas.remove(eliminar); //remueve un objeto
//         
//        MostrarPerro();
//        
//    }
        
    
}
