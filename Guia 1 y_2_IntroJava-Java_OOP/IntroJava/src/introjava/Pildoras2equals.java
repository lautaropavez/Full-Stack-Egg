package introjava;

/**
 * @author Lautaro Pavez
 */
public class Pildoras2equals {

    public static void main(String[] args) {}{
   
        String alumno1, alumno2;

        alumno1 = "David";
        alumno2 = "David";

        System.out.println(alumno1.equals(alumno2));//equals es para comparar 2 cadenas, teniendo en cuenta las mayusculas y minusculas.

        String alumno3, alumno4;

        alumno3 = "Jorge";
        alumno4 = "jorge";
        
        System.out.println(alumno3.equalsIgnoreCase(alumno4));//equalsIgnoreCase es para comparar sin tener en cuenta mayusculas ni minusculas.
    }

}
