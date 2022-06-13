package colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Colecciones_Iterator {

    public static void main(String[] args) {

        List<String> nombres = new ArrayList();

        nombres.add("Peter");
        nombres.add("Román");
        nombres.add("Estefano");

//        2 maneras de recorrer las listas 
//
//        for (String aux : nombres) {
//            System.out.println(aux);
//        }
//
//        Para mostrar la coleccion de atras para adelante nos conviene con este
//        tipo de for, si es solo para mostrarla nos conviene el otro for.
//        for (int i = 0; i < nombres.size(); i++) {
//            System.out.println(nombres.get(i));
//        }
//
//        nombres.forEach((aux)->System.out.println(aux)); // Manera mas rapida de hacer el forEach
//
//        Si ponemos nombres.stream(). nos salen un monton de metodos que podemos
//        usar para hacer análisis por flujo, es decir podemos con nuestra lista
//        filtrar, buscar o podemos hacer el flat map,etc.
//        Ej: nombres.stream().count();
//
//        En la linea de abajo veremos como NO HAY que hacer para eliminar un objeto
//        Por que no? Porque el forEach sabe que tiene que recorrer todos los nombres,
//        si yo en el medio le elimino un objeto se rompe.
//        for (String aux : nombres) {
//            if (aux.equals("Estefano")) {
//                nombres.remove(aux);
//            }
//        }
//
//        for (int i = 0; i < nombres.size(); i++) { // no se rompe porque en vez de poner que vaya de 0 a algun numero, pongo que vaya de 0 a nombress.size por lo que si elimino algo se modifica solo el tamaño. 
//            
//            String m = nombres.get(i); // yo tomo en la variable m, en base al indice tomo el primer objeto en la posicion 0 y lo pongo en m.
//            if (m.equals("Peter")){
//                nombres.remove(m);
//            }
//        }
//        
//        nombres.forEach((aux)->System.out.println(aux)); // Manera mas rapida de hacer el forEach
//        La otra manera de recorrer es el Iterator, es un patron que se implementó para recorrer distinto tipos de datos,
//        sirve mas que nada cuando hablamos de lista enlazada, por ejemplo una mascota podia tener una mascota consiguiente, eso era cuando 
//        estaba el concepto de las linked list y despues vinieron las colecciones.

        Iterator<String> it = nombres.iterator();
//
//        Usamos este iterator para mostrarlo
//        Iterator lo que hace es tomar la lista, desarma los objetos y me los da en una fila por si los quiero recorrer,
//        entonces si yo quiero usar un iterator los recorro y despues tengo que crear otro iterator si quiero recorrerlo
//        while (it.hasNext()) {      // Cuando yo pongo it.hasnext primero evalua y despues salta al siguiente objeto. Seria algo asi como, empecemos
//                                    // por la posicion 0, existe? sí, entonces entra al while hace lo que tenga que hacer y vuelve a hacer lo mismo, 
//                                    // hay siguiente? si, entonces recorramoslo, asi hasta que no haya siguiente y se corta el bucle.                  
//            String aux = it.next(); // Cuando pongo it.next toma un objeto 
//
//            System.out.println(aux);
//        }
//
//      Usamos este iterator para eliminar
        while (it.hasNext()) {                      
            String aux = it.next(); 

            if (aux.equals("Peter")) {
                it.remove();
            }
        }

        nombres.forEach((aux) -> System.out.println(aux)); // Manera mas rapida de hacer el forEach

    }
}
