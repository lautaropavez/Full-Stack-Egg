package Libros;

public class LibreriApp {

    public static void main(String[] args) {
       // Instanciamos obj servicio de libro
       ServicioLibro leer =  new ServicioLibro();
		
       // Instanciamos un obj libro a partir del servicio
       Libro libro_01 = leer.cargarLibro();
		
       // Mostramos los datos del libro
       System.out.println(libro_01.toString());
		
    }

}
