package Enum;

public class NewMain {

    public static void main(String[] args) {
        
        String razaImput = "Beagle";
        
        for (Raza aux : Raza.values()) { //.values nos trae todos los valores de la numeración en un Array, valueOf nos dice si existe alguna enumeracion, por ejemplo Beagle en razas
            
            if (aux.toString().equalsIgnoreCase(razaImput)) { //le ponemos .toString porque si trabajamos con enums y lo queremos comparar con algun imput que sea String o numeros tenemos que convertirlo porque no necesariamente es el mismo tipo de dato.
                System.out.println("Raza imput es igual al enum " + aux);
            }
        }
        
        for (Raza aux : Raza.values()) { 
            
            System.out.println(aux.ordinal()); // .ordinal() nos muestra la posicion que ocupa dentro del enum
        }
        
        for (Raza aux : Raza.values()) { 
            
            System.out.println(aux.name()); // .name() nos muestra el nombre
        }
    }

}
