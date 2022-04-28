package ExcepcionesEjemplosClase;

import java.util.InputMismatchException;
import java.util.Scanner;
//Verificadas o Marcadas se dice
public class Ejemplo03NoVerificadas {

    public static void main(String[] args) throws ExcepcionPropia {
     crearPersona();
    }
    
    public static void crearPersona() {
        try {
            //ingresarDatos();
            ingresarDatoss();
        } catch (ExcepcionPropia | InputMismatchException ex) { // Recordar que en el mismo bloque puedo concatenar cosas...
            System.out.println(ex.getMessage());
            crearPersona();
        }
    }

//    public static void ingresarDatos() throws ExcepcionPropia, InputMismatchException {
//        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//        
//        System.out.println("ingrese su nombre");
//        String nombreI = leer.next();
//        if (nombreI.length() < 2) {//Inventando que si ingresa menos 2 es un 
//            throw new ExcepcionPropia(" No ingreso un nombre valido - Vas a tener q reingresar el dato");
//        }
//        
//        System.out.println("Ingrese su edad");
//        byte edadI = leer.nextByte();
//        if (edadI < 0) {
//            throw new ExcepcionPropia(" Como vas a tener menos que 0 años.....");
//        }
//
//        System.out.println("LOS DATOS INGRESADOS  SON: "
//                + "\n Nombre: " + nombreI.toUpperCase()
//                + "\n Edad: " + edadI);
//    }
//    
    public static void ingresarDatoss() throws ExcepcionPropia, InputMismatchException{
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Ingrese su nombre: ");
        String nombre = leer.next();
        if (nombre.length()<2 || nombre.equalsIgnoreCase("Martin")){
            throw new ExcepcionPropia("No ingreso un nombre valido, vuelva a ingresar datos");
        }
        
        System.out.println("Ingrese su edad: ");
        byte edadI = leer.nextByte();
        if (edadI < 0) {
            throw new ExcepcionPropia("Como vas a tener menos de 2 años");
        }
        
        System.out.println("LOS DATOS INGRESADOS SON: "
                        + "\nNombre: " + nombre.toUpperCase()
                        +  "\nEdad: "+ edadI);
    }
}
