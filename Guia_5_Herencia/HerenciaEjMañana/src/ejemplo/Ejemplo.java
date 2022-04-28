package ejemplo;

import ejemplo.entidades.Auto;
import ejemplo.entidades.Camioneta;
import ejemplo.entidades.Furgon;
import ejemplo.entidades.Vehiculo;
import ejemplo.servicios.AutoServicio;
import java.util.ArrayList;

public class Ejemplo {
//ATAJO PARA COMENTAR = CTRL + SHIFT + C

    public static void main(String[] args) {

        AutoServicio as = new AutoServicio();

        Auto auto = new Auto(true, "Ford", "Fiesta", 2015);
        Camioneta camioneta = new Camioneta(false, "Jeep", "ndeah", 2000);
        Furgon furgon = new Furgon (true, "VW", "FurGon", 1999);
        
        
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        
        listaVehiculos.add(auto);
        listaVehiculos.add(camioneta);
        listaVehiculos.add(furgon);
        
        System.out.println("Imprimimos todos los datos de la lista");
        for (Vehiculo aux : listaVehiculos) {
            System.out.println("Vehiculo: "+ aux);
        }
        
        System.out.println("Imprimimos los resultados del metodo!");
        
        // RECORRER UNA LISTA DE VEHICULOS, ACCEDIENDO A CADA TIPO DE OBJETO QUE ESTA GUARDADO.
        for (Vehiculo aux : listaVehiculos) {
            aux.capacidadCombustible(50);
        }
        
        //ACCEDEMOS AL METODO HEREDADO, DIRECTAMENTE DESDE UN OBJETO AUTO ESPECIFICO.
        auto.capacidadCombustible(50);
        
        
    }

}
