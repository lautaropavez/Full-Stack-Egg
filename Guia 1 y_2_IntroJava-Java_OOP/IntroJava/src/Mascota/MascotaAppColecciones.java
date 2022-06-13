package Mascota;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MascotaAppColecciones {

    public static void main(String[] args) {
       
        ServiceColeccionesMascota servPerros = new ServiceColeccionesMascota(); //Aca ya tenemos creado el objeto que corresponde al servicio
        
        String[] nombres = {"Pepe","Pepa"};//Array de 2 elementos
        
        List <String> nombresList = new ArrayList(Arrays.asList(args)); //Nos posicionamos en el constructor de los arraylist-> new Arraylist(*acá*) y apretamos Ctrl+ space y nos sale todo lo que podemos hacer
                                                     // Podemos pasarle una coleccion haciendo referencia a la clase Arrays que tiene métodos estáticos. Arrays.asList(args) que significa? Esto toma un Array, en este caso el de pepe y pepa, saca los elemntos y lo convierte a un arraylist
        
        List <String> nombresList2 = new ArrayList();   
        
        nombresList2.addAll(0,nombresList2); //Acá estariamos agregandole cosas a nombresList2 de forma masiva, y si le pongo el numero adelante nos sirve de indice para decir ponelo adelante, atras,al medio,etc. 

        nombresList2.isEmpty(); //Nos dice si esta vacio o no, nos devuelve un booleano.
        
//        servPerros.fabricaPerros(20);// De esta manera creo la cantidad de perros que quiera de forma automática, en este caso pusimos 20
         
       servPerros.fabricaMascota(2);
//         
        servPerros.MostrarMascotas();
//         
//        servPerros.actualizarMascota(0);
//        
//        servPerros.MostrarMascotas();
//         
//        servPerros.eliminarMascota(3);
//        
//        servPerros.MostrarMascotas();
//
//        servPerros.eliminarPorNombre("Pepe");

          servPerros.actualizarPorNombre("Pepe","Jorgeciño");// primero nombre viejo, segundo nombre nuevo.

        servPerros.MostrarMascotas();
    }

}
