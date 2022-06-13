package Electrodomesticos;
//    Se debe crear también una subclase llamada Televisor con los siguientes
//    atributos: resolución (en pulgadas) y sintonizador TDT (booleano), además de los

import java.util.Scanner;

//    atributos heredados.
//    Los constructores que se implementarán serán:
//    • Un constructor vacío.
//    • Un constructor con la resolución, sintonizador TDT y el resto de atributos
//    heredados. Recuerda que debes llamar al constructor de la clase padre.
//    Los métodos que se implementara serán:
//    • Método get y set de los atributos resolución y sintonizador TDT.
//    • Método crearTelevisor(): este método llama a crearElectrodomestico() de la
//    clase padre, lo utilizamos para llenar los atributos heredados del padre y
//    después llenamos los atributos del televisor.
//    • Método precioFinal(): este método será heredado y se le sumará la siguiente
//    funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
//    incrementará el precio un 30% y si tiene un sintonizador TDT incorporado,
//    aumentará $500. Recuerda que las condiciones que hemos visto en la clase
//    Electrodomestico también deben afectar al precio.
public final class Televisor extends Electrodomesticos {

    protected int resolucion;
    protected boolean sintonizador_TDT;

    public Televisor() {
    }

    public Televisor(int resolucion, boolean sintonizador_TDT, double precio, double peso, String color, Character consumo_energia) {
        super(precio, peso, color, consumo_energia);
        this.resolucion = resolucion;
        this.sintonizador_TDT = sintonizador_TDT;
    }

    public int getResolucion() {
        return resolucion;
    }

    public void setResolucion(int resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isSintonizador_TDT() {
        return sintonizador_TDT;
    }

    public void setSintonizador_TDT(boolean sintonizador_TDT) {
        this.sintonizador_TDT = sintonizador_TDT;
    }

//    • Método crearTelevisor(): este método llama a crearElectrodomestico() de la
//    clase padre, lo utilizamos para llenar los atributos heredados del padre y
//    después llenamos los atributos del televisor.
    public void crearTelevisor() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        crearElectrodomestico();

        System.out.println("Ingrese la resolucion en pulgadas: ");
        resolucion = leer.nextInt();

        System.out.println("Tiene sintonizador TDT: ");
        String respuesta = leer.next().toUpperCase();

        if (respuesta.equals("SI")) {
            sintonizador_TDT = true;
        }
    }

//    • Método precioFinal(): este método será heredado y se le sumará la siguiente
//    funcionalidad. Si el televisor tiene una resolución mayor de 40 pulgadas, se
//    incrementará el precio un 30% y si tiene un sintonizador TDT incorporado,
//    aumentará $500. Recuerda que las condiciones que hemos visto en la clase
//    Electrodomestico también deben afectar al precio.    
    @Override
    public void precioFinal() {
        super.precioFinal();
        if (resolucion > 40) {
            super.setPrecio(super.getPrecio() * 1.30);
        }
        //        System.out.println("Precio carga= "+super.getPrecio());/*se uso para verificar los calculos*/

        if (sintonizador_TDT == true) {
            super.setPrecio(super.getPrecio() + 500);
        }
        //        System.out.println("Precio carga= "+super.getPrecio());/*se uso para verificar los calculos*/
    }

    @Override
    public String toString() {
        return "Televisor{" + "precio=" + precio + ", color=" + color + ", consumo_energetico=" + consumo_energia + ", peso=" + peso + "resolucion=" + resolucion + ", sintonizador_TDT=" + sintonizador_TDT + '}';
    }

}
