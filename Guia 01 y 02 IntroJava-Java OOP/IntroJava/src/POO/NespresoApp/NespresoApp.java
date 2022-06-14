package POO.NespresoApp;
//  6. Programa Nespresso. Desarrolle una clase Cafetera con los atributos
//  capacidadMaxima (la cantidad máxima de café que puede contener la cafetera) y
//  cantidadActual (la cantidad actual de café que hay en la cafetera). Implemente, al
//  menos, los siguientes métodos:
//  • Constructor predeterminado o vacío
//  • Constructor con la capacidad máxima y la cantidad actual
//  • Métodos getters y setters.
//  • Método llenarCafetera(): hace que la cantidad actual sea igual a la capacidad
//  máxima.
//  • Método servirTaza(int): se pide el tamaño de una taza vacía, el método recibe el
//  tamaño de la taza y simula la acción de servir la taza con la capacidad indicada. Si la
//  cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede. El
//  método le informará al usuario si se llenó o no la taza, y de no haberse llenado en
//  cuanto quedó la taza.
//  • Método vaciarCafetera(): pone la cantidad de café actual en cero.
//  • Método agregarCafe(int): se le pide al usuario una cantidad de café, el método lo
//  recibe y se añade a la cafetera la cantidad de café indicada.

public class NespresoApp {

    public static void main(String[] args) {

        //De esta manera ya tenemos acceso a los servicios 
        ServiceCafetera servicio = new ServiceCafetera();

        servicio.ejecutarMenu();
        
//        servicio.llenarCafetera();
//        //Lo que me devuelva la funcion crear Cafetera va a ser guardado en la variable cafetera01
//        Cafetera cafetera01 = servicio.crearCafetera();
//
//        // prueba del funcionamiento de los metodos
//        servicio.llenarCafetera(cafetera01.getCapacidadMaxima(),cafetera01.getCantidadActual());
//
//        servicio.servirTaza(cafetera01.getCantidadActual());
//
//        servicio.agregarCafe(cafetera01.getCantidadActual(),cafetera01.getCapacidadMaxima());
    }
}
