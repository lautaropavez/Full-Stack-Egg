package Ejercicio1;

/**
 * @author Lautaro Pavez
 */
public class Main {

    public static void main(String[] args) {
        
         ServicePersona sp = new ServicePersona();
        //String nombre, int edad, String sexo, float peso, float altura
        Persona p1 = new Persona();
        p1.setNombre("Adrian");
        p1.setEdad(42);
        p1.setSexo("H");
        p1.setPeso(98);
        p1.setAltura((1.80));
        //Persona p1 = sp.crearPersona();

        Persona p2 = new Persona("William", 33, "H", 78, (1.86));
        //Persona p2 = sp.crearPersona();

        Persona p3 = new Persona("Alina", 9, "M", 37, (1.52));
        //Persona p3 = sp.crearPersona();

        //Persona p4 = sp.crearPersona();
        
        System.out.println(p1);
        sp.calcularIMC(p1);
        sp.esMayorDeEdad(p1);
        
        System.out.println(p2);
        sp.calcularIMC(p2);
        sp.esMayorDeEdad(p2);
        
        System.out.println(p3);
        sp.calcularIMC(p3);
        
        sp.esMayorDeEdad(null);
        
        //System.out.println(p4);
        //sp.calcularIMC(p4);
        //sp.esMayorDeEdad(null);
        //sp.estadistica(3);
        
        
        
        
    }

}
