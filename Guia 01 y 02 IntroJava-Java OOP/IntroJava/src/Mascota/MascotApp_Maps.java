package Mascota;

import java.util.HashMap;
import java.util.Map;

public class MascotApp_Maps {

    public static void main(String[] args) {
        HashMap<String, Mascota> mascotas = new HashMap();

        //Estamos añadiendo nuestro hash map de mascota a fer y a maria
        mascotas.put("1", new Mascota("Fer","Chiquito","Perro"));
        mascotas.put("2", new Mascota("Maria","santisima","Gato"));
        
        //Para eliminar tenemos varias formas
        //mascotas.remove("1"); //1era manera solo poniendo la key
        mascotas.remove("1", new Mascota("Fer","Chiquito","Perro"));//2da manera que sale cuando ponemos remove
        
        //Si queremos eliminar algo puntual el concepto es similar pero tenemos que usar un bucle acorde a eso, o un iterator.
        //Para recorrer un mapa podemos hacerlo con este tipo de for o con un iterato depende de cual nos convenga
        
        
        //Escribo for + (Ctrl+Space) y nos sale primero este
        for (Map.Entry<String, Mascota> aux : mascotas.entrySet()) { //Vamos a tener una variable auxiliar "aux", lo vamos a recorrer sobre nombres.entryset, como que lo procesa para que lo podamos correr con este for
            String key = aux.getKey();
            Mascota value = aux.getValue();

            System.out.println("key: " + key + ", value: " + value);
        }
        
        
        
        //Debemos ver la naturaleza de cada colection y cada mapa, no solo el hashmap 
    }

}
