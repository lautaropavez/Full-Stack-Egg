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
//    • Mostrar en pantalla todas las películas.
//    • Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
//    • Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo
//    en pantalla.
//    • Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo
//    en pantalla.
//    • Ordenar las películas por titulo, alfabéticamente y mostrarlo en pantalla.
//    • Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
//    Nota: recordar el uso del Comparator para ordenar colecciones con objetos.
//    *Cosas que le puedo mejorar, que la hora sea en double.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CineApp {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Cine datos = new Cine();
        ArrayList<Cine> unificar = new ArrayList();
        String verif;

        do {
            Cine Datos_Creados = datos.Crear();
            unificar.add(Datos_Creados);
            System.out.println("¿Desea guardar otra pelicula?(S/N)");
            verif = leer.next().toUpperCase();
        } while (verif.equals("S"));

        System.out.println("");
        System.out.println("\n<<<<< DATOS PELICULAS >>>>>");
        unificar.forEach((aux) -> System.out.println(aux));

        System.out.println("\n<<<<< PELICULAS MAYOR 1 HORAS >>>>>");
        for (Cine aux : unificar) {
            if (aux.getDuracion() > 1) {
                System.out.println("Titulo: " + aux.getTitulo() + " Director: " + aux.getDirector() + " Duración: " + aux.getDuracion() + " horas");
            }
        }

        System.out.println("\n<<<<< DURACION MAYOR A MENOR >>>>>");
        Collections.sort(unificar, ServiceCine.OrdDurDesc);
        unificar.forEach((a)->System.out.println(a));
       
        System.out.println("\n<<<<< DURACION MENOR A MAYOR >>>>>");
        Collections.sort(unificar, ServiceCine.OrdDurAsc);
        unificar.forEach((a)->System.out.println(a));
      
        System.out.println("\n<<<<< ORDEN ALFABETICO TITULOS >>>>>");
        Collections.sort(unificar, ServiceCine.Ord_Tit);
        unificar.forEach((a)->System.out.println(a));
       
       System.out.println("\n<<<<< ORDEN ALFABETICO DIRECTORES >>>>>");
        Collections.sort(unificar, ServiceCine.Ord_Direct);
        unificar.forEach((a)->System.out.println(a));

    }

//        
//        System.out.println("\n<<<<< DURACION MAYOR A MENOR >>>>>");
//        Collections.sort(unificar, Comparadores_Pelis.OrdDurDesc);
//        unificar.forEach((a)->System.out.println(a));
//        
//        System.out.println("\n<<<<< DURACION MENOR A MAYOR >>>>>");
//        Collections.sort(unificar, Comparadores_Pelis.OrdDurAsc);
//        unificar.forEach((a)->System.out.println(a));
//        
//        System.out.println("\n<<<<< ORDEN ALFABETICO TITULOS >>>>>");
//        Collections.sort(unificar, Comparadores_Pelis.Ord_Tit);
//        unificar.forEach((a)->System.out.println(a));
//        
//        System.out.println("\n<<<<< ORDEN ALFABETICO DIRECTORES >>>>>");
//        Collections.sort(unificar, Comparadores_Pelis.Ord_Direct);
//        unificar.forEach((a)->System.out.println(a));
//    }
}
