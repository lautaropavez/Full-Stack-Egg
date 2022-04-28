package POO.Circunferencia;

import java.util.Scanner;

public class ServicioCircunferencia {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    /**
     * Usuario ingresa el Radio
     *
     * @return objeto Radio
     */
    public Circunferencia crearCircunferencia() { // METODO GETTER?
        System.out.println(" Ingresa el Radio de la Circunferencia: "); 
        double radio  = Double.parseDouble(leer.next());
        return new Circunferencia(radio);
    }

    /**
     *
     * @param radio
     * @área de retorno
     */
    public double calcularArea(double radio) { // METODO GETTER
        double area = (Math.PI * radio);
        return area;
    }

    /**
     *
     * @param radio
     * @return perimetro
    */
    public double calcularPerimetro(double radio) { // METODO GETTER
        double perimetro = (2 * Math.PI * radio);
        return perimetro;
    }

}
