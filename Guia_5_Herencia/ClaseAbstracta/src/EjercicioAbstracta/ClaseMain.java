package EjercicioAbstracta;

import java.util.ArrayList;

public class ClaseMain {

    public static void main(String[] args) {
        //Recordar, que la clase Animal no puede ser instanciada
        //Creo Perros / Gatos / Caballos
        Animal perroNvo1 = new Perro("Stich", "Carnivoro", 12, "Doberman");
        System.out.println("----Linea de Codigo 15----");
        perroNvo1.alimentarse();// Invoco metodo abstracto desde el perro

        Animal perroNvo2 = new Perro("Teddy", "Croquetas", 10, "Chihuahua");
        System.out.println("----Linea de Codigo 19----");
        perroNvo2.alimentarse();// Invoco metodo abstracto
        System.out.println("----Linea de Codigo 21----");
        perroNvo2.hagoOtraCosas(); // "HOLA CHICOS"

        Animal gatoNvo1 = new Gato("Pelusa", "Galletas", 15, "Siames");
        System.out.println("----Linea de Codigo 22----");
        gatoNvo1.alimentarse();// Invoco metodo abstracto
        System.out.println("----Linea de Codigo 24----");
        gatoNvo1.hagoOtraCosas();// llamo de su padre.

        Animal caballoNvo1 = new Caballo("Spark", "Pasto", 25, "Fino");
        caballoNvo1.alimentarse();// Invoco metodo abstracto
        caballoNvo1.hagoOtraCosas();// Llamamos que era abst, pero lo sobre en MI HIJA

        //Creo un arreglo de Animales, guardo todo lo que cree
        ArrayList<Animal> nuevaLista = new ArrayList();
        //Agrego los objetos....
        nuevaLista.add(perroNvo1);
        nuevaLista.add(perroNvo2);
        nuevaLista.add(gatoNvo1);
        nuevaLista.add(caballoNvo1);
        System.out.println("*****MIS ANIMALES DE TODO TIPO SON*****");
        for (Animal unitario : nuevaLista) {
            System.out.println(unitario.toString());
        }

    }

}
