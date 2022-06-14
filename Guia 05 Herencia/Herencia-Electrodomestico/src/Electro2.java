
import Electrodomesticos.*;
import java.util.ArrayList;

public class Electro2 {
//    En el main vamos a crear un ArrayList de Electrodomésticos para guardar 4 
//    electrodomésticos, ya sean lavadoras o televisores, con valores ya asignados.
//    Luego, recorrer este array y ejecutar el método precioFinal() en cada
//    electrodoméstico. Se deberá también mostrar el precio de cada tipo de objeto,
//    es decir, el precio de todos los televisores y el de las lavadoras. Una vez hecho
//    eso, también deberemos mostrar, la suma del precio de todos los
//    Electrodomésticos. Por ejemplo, si tenemos una lavadora con un precio de 2000
//    y un televisor de 5000, el resultado final será de 7000 (2000+5000) para
//    electrodomésticos, 2000 para lavadora y 5000 para televisor.

    public static void main(String[] args) {

        System.out.println("LAVADORA 1");
        Lavadora new_lav1 = new Lavadora();
        new_lav1.crearLavadora();
        new_lav1.precioFinal();

        System.out.println("LAVADORA 2");
        Lavadora new_lav2 = new Lavadora();
        new_lav2.crearLavadora();
        new_lav2.precioFinal();

        System.out.println("TELEVISOR 1");
        Televisor new_tele1 = new Televisor();
        new_tele1.crearTelevisor();
        new_tele1.precioFinal();

        System.out.println("TELEVISOR 2");
        Televisor new_tele2 = new Televisor();
        new_tele2.crearTelevisor();
        new_tele2.precioFinal();
        
        System.out.println("------------------------------------------------------------");
        System.out.println("<<<<< PRECIOS >>>>>");
        ArrayList<Electrodomesticos> E_D = new ArrayList();
        
        E_D.add(new_lav1);
        E_D.add(new_lav2);
        E_D.add(new_tele1);
        E_D.add(new_tele2);
        
        double Total_Television=0;
        double Total_Lavadora=0;
        
        //E_D.forEach((aux) -> System.out.println("Electrodomestico: " + aux ));
        
        for (Electrodomesticos aux : E_D) {
            if (aux instanceof Televisor) {
                System.out.println("Precio Television: $" + aux.getPrecio());
                Total_Television += aux.getPrecio();
            }
            
            if (aux instanceof Lavadora) {
                System.out.println("Precio Lavadora: $" + aux.getPrecio());
                Total_Lavadora += aux.getPrecio();
            }
        }
        
        System.out.println("\nLa suma de todos los televisores es: $" + Total_Television);
        System.out.println("La suma de todas las lavadoras es: $" + Total_Lavadora);
        System.out.println("La suma total es: $"+(Total_Television + Total_Lavadora));
      
    }


}
