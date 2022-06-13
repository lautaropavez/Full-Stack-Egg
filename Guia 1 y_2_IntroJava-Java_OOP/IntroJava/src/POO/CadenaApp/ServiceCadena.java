package POO.CadenaApp;

import java.util.Scanner;
//    Deberá además implementar los siguientes métodos:
//    • Método mostrarVocales(), deberá contabilizar la cantidad de vocales que tiene la
//    frase ingresada.
//    • Método invertirFrase(), deberá invertir la frase ingresada y mostrar la frase invertida
//    por pantalla. Por ejemplo: Entrada: "casa blanca", Salida: "acnalb asac".
//    • Método vecesRepetido(String letra), deberá recibir por parámetro un carácter
//    ingresado por el usuario y contabilizar cuántas veces se repite el carácter en la
//    frase, por ejemplo:
//    Entrada: frase = "casa blanca". Salida: El carácter 'a' se repite 4 veces.
//    • Método compararLongitud(String frase), deberá comparar la longitud de la frase
//    que compone la clase con otra nueva frase ingresada por el usuario.
//    • Método unirFrases(String frase), deberá unir la frase contenida en la clase Cadena
//    con una nueva frase ingresada por el usuario y mostrar la frase resultante.
//    • Método reemplazar(String letra), deberá reemplazar todas las letras “a” que se
//    encuentren en la frase, por algún otro carácter seleccionado por el usuario y
//    mostrar la frase resultante.
//    • Método contiene(String letra), deberá comprobar si la frase contiene una letra que
//    ingresa el usuario y devuelve verdadero si la contiene y falso si no.

public class ServiceCadena {
    
    public Scanner leer = new Scanner(System.in);
    
    
    
    Cadena cadena1 = new Cadena();

    public Cadena crearCadena() {

        System.out.println("Ingresa una frase: ");
        String frase = leer.nextLine().toUpperCase();
        int long_frase = frase.length();

        return new Cadena(frase, long_frase);
    }
    
    public int mostrarVocales(Cadena cadena1) {
        int vocales = 0;
        
        String fraseOpalabra = cadena1.getFrase().toUpperCase();

        for (int j = 0; j < cadena1.getLong_frase(); j++) {
            // con charAt obtenemos el caracter actual del recorrido
            // y dentro del switch evualamos coincidencias con las vocales e incrementa el
            // contador correspondiente
            switch (fraseOpalabra.charAt(j)) {  // Otra manera de hacerlo (fraseOpalabra.substring(i,i+1))
                case 'A':
                    vocales++;
                    continue;
                case 'E':
                   vocales++;
                    continue;
                case 'I':
                   vocales++;
                    continue;
                case 'O':
                    vocales++;
                    continue;
                case 'U':
                    vocales++;
            }
        }

        return vocales;
    }

    public void invertirFrase(Cadena cadena1) {

        String invertido = "";
        for (int i = cadena1.getLong_frase(); i > 0; i--) {
            invertido = invertido.concat(cadena1.getFrase().substring(i - 1, i));
        }
        System.out.println("Frase invertida: " + invertido);
    }

    public int vecesRepetido(Cadena cadena1,String Caracter) {
        int repetido = 0;
        String fraseOpalabra = cadena1.getFrase().toUpperCase();
        for (int i = 0; i < cadena1.getLong_frase(); i++) {
            if (fraseOpalabra.substring(i, i + 1).equalsIgnoreCase(Caracter.toUpperCase())) {
                repetido++;
            }

        }
        
        return repetido;
    }

    public void compararLongitud(Cadena cadena1,String newfrase) {

        String frase1 = cadena1.getFrase(); //este no hace falta llamarlo pero para entenderlo mejor
        String frase2 = newfrase;

        int long_frase1 = cadena1.getLong_frase();
        int long_frase2 = newfrase.length();

        if (long_frase1 > long_frase2) {
            System.out.println("La frase: " + frase1 + ", es más larga que la frase: " + frase2 + ".");
        } else if (long_frase1 == long_frase2) {
            System.out.println("La frase: " + frase1 + ", tiene el mismo tamaño que la frase: " + frase2 + ".");
        } else {
            System.out.println("La frase: " + frase2 + ", es más larga que la frase: " + frase2 + ".");
        }

    }
    
    private void mostrarMenu(){
        System.out.println("----------------- MENÚ -----------------\n"
                + "1) - Mostrar vocales \n"
                + "2) - Invertir frase \n"
                + "3) - Cuantas veces se repite X caracter \n"
                + "4) - Comparar Longitud \n"
                + "5) -  Unir Frases \n"
                + "6) -  Reemplazar letra a \n"
                + "7) - Salir \n"
                + "-------- Elija una opción --------");          
    }
    
    private int elegirOpcion(){
        int sel;
        
        do{
           sel = leer.nextInt();
           if(sel<1 || sel>7){
               System.out.println("Selección inválida. Intente nuevamente"); 
           }
        }while(sel<1 || sel>7);
        
        return sel;
    }
    
    public void ejecutarMenu(){
        Cadena cad = crearCadena(); //Como estoy adentro de la clase Servicio no necesito crear instanciar un servicio nuevo
        
        mostrarMenu();
        int sel = 0;
        
        do{
            sel = elegirOpcion();
            
            switch (sel) {
                case 1:
                    mostrarVocales(cad);
                    break;
                case 2:
                    invertirFrase(cad);
                    break;
                case 3:
                    vecesRepetido(cad,String Caracter);
                    break;
                case 4:
                    compararLongitud(cad,String newfrase);
                    break;
                case 5:
                    
                    break;
                case 6:
                    
                    break;
                case 7:
                   System.out.println("Hasta luego. Vuelvas prontos");
                   break; // No necesito un default que es para cuando la seleccion no esta entre 1 y 6 porque directamente lo hice en la linea 115;
            }
            
        }
    }
    
//    public int mostrarcantVocales(Cadena cadena1){
//        int a=0,e=0,i=0,o=0,u=0;
//        
//        String fraseOpalabra = cadena1.getFrase().toUpperCase();
//
//        for (int j = 0; j < cadena1.getLong_frase(); j++) {
//            // con charAt obtenemos el caracter actual del recorrido
//            // y dentro del switch evualamos coincidencias con las vocales e incrementa el
//            // contador correspondiente
//            switch (fraseOpalabra.charAt(j)) {  // Otra manera de hacerlo (fraseOpalabra.substring(i,i+1))
//                case 'A':
//                    a++;
//                    System.out.println("La frase tiene: " + a + " vocales A");
//                    return a;
//                case 'E':
//                    e++;
//                    System.out.println("La frase tiene: " + e + " vocales E");
//                    return e;
//                case 'I':
//                    i++;
//                    System.out.println("La frase tiene: " + i + " vocales I");
//                    return i;
//                case 'O':
//                    o++;
//                    System.out.println("La frase tiene: " + o + " vocales O");
//                    return o;
//                case 'U':
//                    u++;
//                    System.out.println("La frase tiene: " + u + " vocales U");
//                    return u;
//            }
//        }
//
//        System.out.println();   
//    }
}
