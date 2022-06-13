package Electrodomesticos;
import java.util.Scanner;
//    Crear una superclase llamada Electrodoméstico con los siguientes atributos:
//    precio, color, consumo energético (letras entre A y F) y peso.
//    Los constructores que se deben implementar son los siguientes:
//    • Un constructor vacío.
//    • Un constructor con todos los atributos pasados por parámetro.
//    Los métodos a implementar son:
//    • Métodos getters y setters de todos los atributos.
//    • Método comprobarConsumoEnergetico(char letra): comprueba que la letra
//    es correcta, sino es correcta usara la letra F por defecto. Este método se debe
//    invocar al crear el objeto y no será visible.
//    • Método comprobarColor(String color): comprueba que el color es correcto, y
//    si no lo es, usa el color blanco por defecto. Los colores disponibles para los
//    electrodomésticos son blanco, negro, rojo, azul y gris. No importa si el nombre
//    está en mayúsculas o en minúsculas. Este método se invocará al crear el
//    objeto y no será visible.
//    • Metodo crearElectrodomestico(): le pide la información al usuario y llena el
//    electrodoméstico, también llama los métodos para comprobar el color y el
//    consumo. Al precio se le da un valor base de $1000.
//    • Método precioFinal(): según el consumo energético y su tamaño, aumentará
//    el valor del precio. Esta es la lista de precios:   
//      LETRA PRECIO               PESO PRECIO
//        A $1000              Entre 1 y 19 kg    $100
//        B $800               Entre 20 y 49 kg   $500
//        C $600               Entre 50 y 79 kg   $800
//        D $500               Mayor que 80 kg    $1000
//        E $300
//        F $100
public class Electrodomesticos {

    protected double precio, peso;
    protected String color;
    protected Character consumo_energia;

    public Electrodomesticos() {
    }

    public Electrodomesticos(double precio, double peso, String color, Character consumo_energia) {
        this.precio = precio;
        this.peso = peso;
        this.color = color;
        this.consumo_energia = consumo_energia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Character getConsumo_energia() {
        return consumo_energia;
    }

    public void setConsumo_energia(Character consumo_energia) {
        this.consumo_energia = consumo_energia;
    }

//------------------------------------------------------------------------------
    public void comprobarConsumoEnergetico(Character letra) {

        letra = Character.toUpperCase(letra);

        switch (letra) {
            case 'A':
                consumo_energia = letra;
                break;
            case 'B':
                consumo_energia = letra;
                break;
            case 'C':
                consumo_energia = letra;
                break;
            case 'D':
                consumo_energia = letra;
                break;
            case 'E':
                consumo_energia = letra;
                break;
            case 'F':
                consumo_energia = letra;
                break;
            default:
                consumo_energia = 'F';
        }
    }

//    • Método comprobarColor(String color): comprueba que el color es correcto, y
//    si no lo es, usa el color blanco por defecto. Los colores disponibles para los
//    electrodomésticos son blanco, negro, rojo, azul y gris. No importa si el nombre
//    está en mayúsculas o en minúsculas. Este método se invocará al crear el
//    objeto y no será visible.
    public void comprobarColor(String color) {

        color = color.toUpperCase();

        switch (color) {
            case "BLANCO":
                this.color = "BLANCO";
                break;
            case "NEGRO":
                this.color = "NEGRO";
                break;
            case "ROJO":
                this.color = "ROJO";
                break;
            case "AZUL":
                this.color = "AZUL";
                break;
            case "GRIS":
                this.color = "GRIS";
                break;
            default:
                this.color = "BLANCO";
        }
    }

//    • Metodo crearElectrodomestico(): le pide la información al usuario y llena el
//    electrodoméstico, también llama los métodos para comprobar el color y el
//    consumo. Al precio se le da un valor base de $1000.
    public void crearElectrodomestico() {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        System.out.println("Ingrese el consumo energético (A-F): ");
        consumo_energia = leer.next().charAt(0);
        comprobarConsumoEnergetico(consumo_energia);

        System.out.println("Ingrese el color de su electrodomestico: ");
        color = leer.next();
        comprobarColor(color);

        System.out.println("Ingrese el peso del electrodomestico: ");
        peso = leer.nextDouble();

        precio = 1000;
    }

//    • Método precioFinal(): según el consumo energético y su tamaño, aumentará
//    el valor del precio. Esta es la lista de precios:  
//      LETRA PRECIO               PESO PRECIO
//        A $1000              Entre 1 y 19 kg    $100
//        B $800               Entre 20 y 49 kg   $500
//        C $600               Entre 50 y 79 kg   $800
//        D $500               Mayor que 80 kg    $1000
//        E $300
//        F $100
    public void precioFinal() {

        if (this.consumo_energia == 'A') {
            this.precio += 1000;
            //this.precio = this.precio + 1000;
        }
        if (this.consumo_energia == 'B') {
            this.precio += 800;
        }
        if (this.consumo_energia == 'C') {
            this.precio += 600;
        }
        if (this.consumo_energia == 'D') {
            this.precio += 500;
        }
        if (this.consumo_energia == 'E') {
            this.precio += 300;
        }
        if (this.consumo_energia == 'F') {
            this.precio += 100;
        }

        //System.out.println("Precio consumo_energetico= "+precio); /*se uso para verificar los calculos*/
        if ((this.peso) >= 1 && (this.peso) <= 19) {
            this.precio += 100;
        }

        if ((this.peso) >= 20 && (this.peso) <= 49) {
            this.precio += 500;
        }

        if ((this.peso) >= 50 && (this.peso) <= 79) {
            this.precio += 800;
        }
        if ((this.peso) >= 80){
            this.precio += 1000;
        }
        
//        System.out.println("Precio peso= "+precio);/*se uso para verificar los calculos*/
    }

    @Override
    public String toString() {
        return "Electrodomesticos{" + "precio=" + precio + ", peso=" + peso + ", color=" + color + ", consumo_energia=" + consumo_energia + '}';
    }

    
}
