package POOEXTRAS;
//1. Desarrollar una clase Cancion con los siguientes atributos: titulo y autor. Se deberá́
//definir además dos constructores.
public class CancionApp {

    public static void main(String[] args) {
       
        ServiceCancion servicio = new ServiceCancion();
        
        //Llamada al método que pedirá los valores al usuario;
        Cancion cancion1 = servicio.crearCancion();
        
        System.out.println("[ CANCION " + (cancion1.getTitulo().toUpperCase()) + " ]");
        System.out.println("Autor: " + cancion1.getAutor() + ".");
        
//      System.out.println("Area de la Circunferencia:" + servicio.calcularArea(circunferencia01.getRadio())); (AYUDA)
//      System.out.println("Perimetro de la Circunferencia: " + servicio.calcularPerimetro(circunferencia01.getRadio())); (AYUDA)
        
    }

}
