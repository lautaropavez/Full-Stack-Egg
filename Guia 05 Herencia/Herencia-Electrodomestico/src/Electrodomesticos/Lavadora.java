package Electrodomesticos;
import java.util.Scanner;

//    A continuación se debe crear una subclase llamada Lavadora, con el atributo
//    carga, además de los atributos heredados.
//    Los constructores que se implementarán serán:
//    • Un constructor vacío.
//    • Un constructor con la carga y el resto de atributos heredados. Recuerda que
//    debes llamar al constructor de la clase padre.
//    Los métodos que se implementara serán:
//    • Método get y set del atributo carga.
//    • Método crearLavadora (): este método llama a crearElectrodomestico() de la
//    clase padre, lo utilizamos para llenar los atributos heredados del padre y
//    después llenamos el atributo propio de la lavadora.
//    • Método precioFinal(): este método será heredado y se le sumará la siguiente
//    funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500,
//    si la carga es menor o igual, no se incrementará el precio. Este método debe
//    llamar al método padre y añadir el código necesario. Recuerda que las
//    condiciones que hemos visto en la clase Electrodoméstico también deben
//    afectar al precio.

public final class Lavadora extends Electrodomesticos{

    private double carga;

    public Lavadora() {
    }

    public Lavadora(double carga) {
        this.carga = carga;
    }
    
    public Lavadora(double carga, double precio, double peso, String color, Character consumo_energia) {
        super(precio, peso, color, consumo_energia);
        this.carga = carga;
    }

    public double getCarga() {
        return carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }

//    • Método crearLavadora (): este método llama a crearElectrodomestico() de la
//    clase padre, lo utilizamos para llenar los atributos heredados del padre y
//    después llenamos el atributo propio de la lavadora.
    public void crearLavadora(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        crearElectrodomestico();
        
        System.out.println("Ingrese la carga de la lavadora: ");
        carga = leer.nextDouble();
    //  System.out.println("Precio carga= "+super.getPrecio());/*se uso para verificar los calculos*/
    }
   
//    • Método precioFinal(): este método será heredado y se le sumará la siguiente
//    funcionalidad. Si tiene una carga mayor de 30 kg, aumentará el precio en $500,
//    si la carga es menor o igual, no se incrementará el precio. Este método debe
//    llamar al método padre y añadir el código necesario. Recuerda que las
//    condiciones que hemos visto en la clase Electrodoméstico también deben
//    afectar al precio.

    @Override
    public void precioFinal() {
        super.precioFinal(); //To change body of generated methods, choose Tools | Templates.
        
        if (carga > 30) {
            super.setPrecio(super.getPrecio() + 500);
        }
        //System.out.println("Precio final= "+super.getPrecio());/*se uso para verificar los cálculos*/
    }

    @Override
    public String toString() {
        return "Lavadora{" + "precio=" + precio + ", color=" + color + ", consumo_energetico=" + consumo_energia + ", peso=" + peso + ", carga=" + carga + '}';
    }    

}
