package Mascota;

import java.util.Comparator;

public class Comparadores {

    public static Comparator<Mascota> ordenarPorNombreDesc = new Comparator<Mascota>() { //Comparator es una interfaz genérica, al ser genérica significa que el método compare, que recibe T o1, T o2. Yo desde comparadores le digo Comparator tiene que trabajar con Mascota, por eso compare se sobreescribe de esta manera
        @Override
        public int compare(Mascota t1, Mascota t2) { // Lo que hace compare es establecer una comparación entre atributos u objetos y te devuelve un valor.//En este caso como es ordenar por nombre descendente yo quiero agarrar el nombre de la mascota 2 o 1 y compararlo con la mascota 2 o 1
            return (t2.getNombre().compareTo(t1.getNombre())); // En este caso es una comparacion de String porque los nombres son String pero pueden comparar numeros u otros objetos
        }
    };
            
     public static Comparator<Mascota> ordenarPorEdadDesc = new Comparator<Mascota>() { //Comparator es una interfaz genérica, al ser genérica significa que el método 
        @Override
        public int compare(Mascota t1, Mascota t2) {
            return (t1.getEdad().compareTo(t2.getEdad()));
        }
    };     
            
}
