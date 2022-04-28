package Mascota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MascotApp_Comparator {

    public static void main(String[] args) {
        ArrayList<Mascota> mascotas = new ArrayList();

        mascotas.add(new Mascota("Fer", "Chiquito", "Perro"));
        mascotas.add(new Mascota("Fer", "Chiquito", "Perro"));
        mascotas.add(new Mascota("Fer", "Chiquito", "Perro"));
        mascotas.add(new Mascota("Fer", "Chiquito", "Perro"));
        mascotas.add(new Mascota("Fer", "Chiquito", "Perro"));

        mascotas.add(new Mascota("Fer", "Chiquito", "Perro"));
        mascotas.add(new Mascota("Pepa", "Lola", "Gato"));
        mascotas.add(new Mascota("Pepa", "Lola", "Gato"));
        mascotas.add(new Mascota("Pepa", "Lola", "Gato"));
        mascotas.add(new Mascota("Pepa", "Lola", "Gato"));
        mascotas.add(new Mascota("Pepa", "Lola", "Gato"));
        mascotas.add(new Mascota("Pepa", "Lola", "Gato"));
        mascotas.add(new Mascota("Pepa", "Lola", "Gato"));

        Collections.sort(mascotas, Comparadores.ordenarPorNombreDesc);// Esto escribe la coleccion ordenandolo de otra manera.

        Collections.shuffle(mascotas);// pone los nombres en orden aleatorio.

        for (Mascota mascota : mascotas) {
            System.out.println(mascota);
        }

    }

}
