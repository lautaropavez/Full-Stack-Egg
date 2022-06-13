package POO.Operacion;

public class OperacionApp {

    public static void main(String[] args) {
        
       ServiciosOperacion servicio = new ServiciosOperacion();
       
       //Llamada al método que pedirá los valores al usuario;
       Operacion nuevaOperacion = servicio.crearOperacion();
       
       //Llamada al método sumar
       System.out.println("El resultado de la suma es: " + 
       servicio.sumar(nuevaOperacion.getNumero1(),nuevaOperacion.getNumero2()));
       
       //Llamada al método restar
       System.out.println("El resultado de la resta es: " + 
       servicio.restar(nuevaOperacion.getNumero1(),nuevaOperacion.getNumero2()));
       
       //Llamada al método multiplicar
       System.out.println("El resultado de la multiplicación es: " + 
       servicio.multiplicar(nuevaOperacion.getNumero1(),nuevaOperacion.getNumero2()));
       
       
       //Llamada al método dividir
       System.out.println("El resultado de la división es: " +
       servicio.dividir(nuevaOperacion.getNumero1(),nuevaOperacion.getNumero2())); //Nose como hacer para pasarlo al dividir siendo double.
       
       
    }
}
