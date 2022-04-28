package Figuras;

import java.util.Scanner;

public class Circulos implements calculosFormas{

    protected double radio;

    public Circulos() {
    }

    public Circulos(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void CrearCirculo(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese el radio del circulo: ");
        radio = leer.nextDouble();
    }
            
    @Override
    public void calcularArea() {
        System.out.println("Area: " + (PI * radio *  2));
//      System.out.println("Area Circulo= "+(PI*Radio*Radio));

    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perimetro: " + ( PI * Math.pow(radio, 2)));
//      System.out.println("Perimetro Circulo= "+(PI*(Radio+Radio)));
    }

}
