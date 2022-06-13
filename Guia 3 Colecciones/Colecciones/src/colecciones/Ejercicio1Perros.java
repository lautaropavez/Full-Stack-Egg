package colecciones;
//  1_Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo
//  String. El programa pedirá una raza de perro en un bucle, el mismo se guardará
//  en la lista y después se le preguntará al usuario si quiere guardar otro perro o si
//  quiere salir. Si decide salir, se mostrará todos los perros guardados en el ArrayList.

public class Ejercicio1Perros {

    public static void main(String[] args) {
       
        
        ServicePerros servPerros = new ServicePerros(); //Aca ya tenemos creado el objeto que corresponde al servicio
       
       //Creo las 2 mascotas y después las muestro
       servPerros.crearMascota();
       //servPerros.crearMascota();
       
       //Las muestro
       servPerros.MostrarPerro();
       
       servPerros.EliminarPerro();
    }
    
    
}
