package Mascota;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
public class MascotApp_Conjuntos {

    public static void main(String[] args) {
       // Los conjuntos o sets son partes de las Collections igual que las listas, pero los sets no permiten elemento duplicados a diferencia de las listas
       // Dentro de los sets tenemos:
       // * TreeSet: Tiene la capacidad de ordenarse. Al principio por un criterio implicitamente determinado pero puede ordenarse y seguir sin aceptar elementos duplicados.
       // * LinkedHasSet: Tipo de set enlazado un elemento con el siguiente que tampoco acepta elementos duplicados. No se pueden ordenar de forma natural.
       // *HashSet: No se pueden ordenar de forma natural.
       // Si queremos ordenar un conjunto de datos optamos por el Treeset, si nos queremos asegurar de que no hayan elementos duplicads podemos usar cualquiera de los otros dos.
       
    TreeSet<String> nombres = new TreeSet(); //Usamos este en el caso del video de conjuntos porque vamos a comparar para ordenar y los TreeSet son los que tiene la naturaleza de ordenar cosas
//     HashSet<String> nombres = new HashSet();
       
       //Como no acepta elementos duplicados, solo me sale que tengo uno, el cual es Perro, en vez de tres.
//       nombres.add("Perro");
//       nombres.add("Perro");
//       nombres.add("Perro");
//       
//        for (String nombre : nombres) {
//            System.out.println(nombre);
//        }
//        

        Set<Mascota> mascotas = new HashSet();
        
        mascotas.add(new Mascota("Fer","Chiquito","Perro"));
        mascotas.add(new Mascota("Fer","Chiquito","Perro"));
        mascotas.add(new Mascota("Fer","Chiquito","Perro"));
        mascotas.add(new Mascota("Fer","Chiquito","Perro"));
        mascotas.add(new Mascota("Fer","Chiquito","Perro"));
        mascotas.add(new Mascota("Fer","Chiquito","Perro"));
        mascotas.add(new Mascota("Pepa","Lola","Gato"));    
        mascotas.add(new Mascota("Pepa","Lola","Gato"));    
        mascotas.add(new Mascota("Pepa","Lola","Gato"));
        mascotas.add(new Mascota("Pepa","Lola","Gato"));
        mascotas.add(new Mascota("ZZZ","ZZZ","Gato"));
        
        for (Mascota mascota : mascotas) { // Solo nos muestra 2 porque nosotros ya le enseñamos a la clase mascota como compararse con otra
                                           // mascota cuando entra en un conjunto
            System.out.println(mascota);
        }
        
  }

}
