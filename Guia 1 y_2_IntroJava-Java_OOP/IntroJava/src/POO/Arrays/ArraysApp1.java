package POO.Arrays;

public class ArraysApp1 {

    public static void main(String[] args) {
        
        ServiceArrays servicio = new ServiceArrays();
        
        double ArregloA[]= new double[50];
        servicio.crearArreglo(ArregloA);
        servicio.OrdenarArreglo(ArregloA);
        
        
        double ArregloB[]= new double[20];
        servicio.copiarArreglo(ArregloB, ArregloA);
    }
        

}
