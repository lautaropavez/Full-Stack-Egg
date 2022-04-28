package Figuras;

import java.util.Scanner;

public class Rectangulos implements calculosFormas {

    protected double base;
    protected double altura;

    public Rectangulos() {
    }

    public Rectangulos(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

   public void CrearRectangulo(){
       Scanner leer = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Ingrese la base del rectangulo: ");
        base = leer.nextDouble();
        System.out.println("Ingrese la altura del rectangulo: ");
        altura = leer.nextDouble();
   }
    
    @Override
    public void calcularArea() {
        System.out.println("Area: " + (base * altura));
    }

    @Override
    public void calcularPerimetro() {
        System.out.println("Perimetro: " + 2*(base + altura) );

    }
    
}
