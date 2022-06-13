package Libros;

import java.util.Scanner;

public class ServicioLibro {

    private Scanner leer = new Scanner(System.in);

    /*
      El usuario carga los datos del libro 
      y el metodo retorna los datos
      ingresados para cargar el libro.
      @return
    */
    
    public Libro cargarLibro(){
        
        System.out.println("Ingresar el ISBN del libro:");
        String ISBN = leer.nextLine();
        
        System.out.println("Ingresar TITULO del libro:");
        String titulo = leer.nextLine();
		
	System.out.println("Ingresar AUTOR del libro:");
	String autor = leer.nextLine();
		
	System.out.println("Ingresar Numero de paginas del libro:");
	int numPag = Integer.parseInt(leer.nextLine());
       
        return new Libro(ISBN, titulo,autor, numPag);
    }
}
