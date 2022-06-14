package Ejercicio4;
//    4_ Un cine necesita implementar un sistema en el que se puedan cargar peliculas.
//    Para esto, tendremos una clase Pelicula con el titulo, director y duración de la
//    película (en horas). Implemente las clases y métodos necesarios para esta
//    situación, teniendo en cuenta lo que se pide a continuación:
//
//    En el main deberemos tener un bucle que crea un objeto Pelicula pidiéndole al
//    usuario todos sus datos y guardándolos en el objeto Pelicula.
//    Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario
//    si quiere crear otra Pelicula o no.
//    Después de ese bucle realizaremos las siguientes acciones:
//
//    •Mostrar en pantalla todas las películas.
//    • Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
//    • Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo
//    en pantalla.
//    • Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo
//    en pantalla.
//    • Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.
//    • Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
//    Nota: recordar el uso del Comparator para ordenar colecciones con objetos.
import java.util.ArrayList;
import java.util.Scanner;


public class Cine {
    
    private Scanner leer;
    private String titulo;
    private String director;
    private Integer duracion;
    private ArrayList<String> peliculas;

    public Cine() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.peliculas = new ArrayList();
    }

    public Cine(String titulo, String director, Integer duracion, ArrayList<String> peliculas) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.peliculas = peliculas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public ArrayList<String> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(ArrayList<String> peliculas) {
        this.peliculas = peliculas;
    }

    public Cine Crear(){
        ArrayList<String> peliculas = new ArrayList();
        
        System.out.println("Benvenido...");
        System.out.print("Ingrese el nombre de la pelicula: ");
        titulo = leer.next().toUpperCase();
        
        System.out.println("Ingrese el nombre del director: ");
        director = leer.next().toUpperCase();
       
        System.out.println("Ingrese la duración de la pelicula: ");
        duracion = leer.nextInt();
        
        
       
        return new Cine(titulo, director, duracion, peliculas);
    }

    @Override
    public String toString() {
        return "Cine{" + "titulo=" + titulo + ", director=" + director + ", duracion=" + duracion + '}';
    }



//    public Peliculas(String Titulos, String Director, Integer Duracion) {
//        this.Titulos = Titulos;
//        this.Director = Director;
//        this.Duracion = Duracion;
//    }
 
    
}
