
import Electrodomesticos.Lavadora;
import Electrodomesticos.Televisor;

public class Electro {
//    Vamos a crear una Lavadora y un Televisor y llamar a los métodos necesarios
//    para mostrar el precio final de los dos electrodomésticos.

    public static void main(String[] args) {

        System.out.println("LAVADORA");
        Lavadora new_lav = new Lavadora();
        new_lav.crearLavadora();
        new_lav.precioFinal();

        System.out.println("TELEVISOR");
        Televisor new_tele = new Televisor();
        new_tele.crearTelevisor();
        new_tele.precioFinal();

        System.out.println("<<<<< PRECIOS >>>>>");
        
        System.out.println("Precio Final de la Lavaropa:$" + new_lav.getPrecio());
        System.out.println("Precio Final de la Television:$" + new_tele.getPrecio());

    }
}
