package introjava;

/**
 * @author Lautaro Pavez
 */
public class Pildoras1Substring2 {

    public static void main(String[] args) {
        
       String frase = "Hoy es un estupendo dia para aprender a progamar en Java.";
       
       String frase_resumen = frase.substring(1, 3); //el 1° num es desde el cuál quiero empezar a extraer (sabiendo que empieza desde el cero), el 2do nro es hasta donde queremos extraer sin contarlo a este mismo(por lo que si pongo 3 tomaria hasta el 2, si pongo 4 hasta el 3 y así.)
       System.out.println("frase_resumen = " + frase_resumen);
       
        String frase_resumen2 = frase.substring(29, 57);
        System.out.println("frase_resumen2 = " + frase_resumen2);
        
        String frase_resumen3 = frase.substring(0, 29) + "irnos a la playa" + " y " + // salto de linea
        frase.substring(29, 57);
        
        System.out.println("frase_resumen3 = " + frase_resumen3);
    }

}
