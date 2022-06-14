package ejemplo;

import ejemplo.entidades.Auto;
import ejemplo.entidades.Camioneta;
import ejemplo.entidades.Furgon;
import ejemplo.entidades.Vehiculo;
import ejemplo.servicios.AutoServicio;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo {
//ATAJO PARA COMENTAR = CTRL + SHIFT + C

    public static void main(String[] args) {

        List<Vehiculo> listaVehiculos = new ArrayList<>();

        AutoServicio as = new AutoServicio();

        Auto a = new Auto(Boolean.TRUE, "Ford", "Fiesta", 2018, "Rojo");
        Camioneta c = new Camioneta();
        Furgon f = new Furgon();
        Furgon f2 = new Furgon();

        listaVehiculos.add(a);
        listaVehiculos.add(c);
        listaVehiculos.add(f);
        listaVehiculos.add(f2);

        int contadorCamionetas = 0;
        int contadorAutos = 0;
        int contadorFurgones = 0;

        for (Vehiculo aux : listaVehiculos) {

            if (aux instanceof Auto) {
                Auto x = (Auto) aux;
                if (x.getPuertaTrasera()) {
                    System.out.println("El auto " + x.getMarca() + " " + x.getModelo() + " tiene puertas traseras");
                }

                contadorAutos++;
            }

            if (aux instanceof Camioneta) {
                contadorCamionetas++;
            }

            if (aux instanceof Furgon) {
                contadorFurgones++;
            }
        }

        System.out.println("Hay " + contadorAutos + " autos");
        System.out.println("Hay " + contadorCamionetas + " camionetas");
        System.out.println("Hay " + contadorFurgones + " furgones");

    }

}
