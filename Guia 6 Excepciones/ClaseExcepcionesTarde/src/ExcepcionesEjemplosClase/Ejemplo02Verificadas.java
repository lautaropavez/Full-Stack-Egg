package ExcepcionesEjemplosClase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ejemplo02Verificadas {

    //CUANDO NO QUIERO HACER NADA, SOLO LA DECLARO / PORQUE NO QUIERO TRATARLA ACA (Las verficadas JAVA me obliga a declarar)
//    public static void main(String[] args) throws FileNotFoundException, IOException {
//      //  leerArchivo();
//    }
//
//    public static void leerArchivo() throws FileNotFoundException   { // Java puede leer archivos txt 
//      //  OPCION A PARA LEER UN ARCHIVO TEXTO   - Sin manejar la EXC         
//        File archivo = new File("C:\\Users\\adrib\\Desktop\\PROBANDO55555.txt");  //Hay una clase que se llama file que lo que hace es crear un objeto de tipo archivo y lo que esta entre parentesis es una ruta de ubicacion del archivo
//        Scanner leer = new Scanner(archivo);  // ¿Como funciona? El Scanner tiene la capacidad de agarrar un txt y va agarrando linea por linea
//        leer.useDelimiter("\\Z"); // Z Lee todo el archivo , z lee hasta 1021 caracteres
//        System.out.println(leer.next());
//        System.out.println("FIN PROGRAMA");      
//    }}
//     public static void leerArchivo() throws FileNotFoundException, IOException {
//        OPCION B PARA LEER UN ARCHIVO TEXTO  - Sin manejar la EXC - La dejo para que recuerden en un futuro
//        File archivo = new File("C:\\Users\\adrib\\Desktop\\PROBANDO.txt");
//        Scanner leer = new Scanner(archivo);
//        leer.useDelimiter("\\Z"); // Z Lee todo el archivo , z lee hasta 1021 caracteres
//        System.out.println(leer.next());
//        while (leer.hasNextLine()) { // Uso un ciclo, mientras exista algo para leer en la siguiente linea......(Mientras exista una linea siguiente con contenido segui leyendola)
//            String line = leer.nextLine();  // Este nextline tambien sirve cuando hacemos un lop de un try and catch para que no se rompa, para que no se haga un loop infinito en el Scanner
//        }
//     }}
//    
//    public static void leerArchivo() throws FileNotFoundException, IOException {
//        //OPCION C - Ademas de declararla la trato de forma individual con TRYCATCH
//        try {
//            //TODAS LAS INSTRUCCIONES QUE QUIERO QUE INTENTE REALIZAR
//            File archivo = new File("C:\\Users\\adrib\\Desktop\\PROBANDO.txt");
//            Scanner leer = new Scanner(archivo);
//            leer.useDelimiter("\\Z"); // Z Lee todo el archivo , z lee hasta 1021 caracteres
//            System.out.println(leer.next());
//        } catch (FileNotFoundException y) { // Declaro la Clase a la que podria pertenecer el error
//            System.out.println("OUCH QUE CAGADA");
//        } catch (IOException x) { //Se puede concatenar 2 excepciones en la misma linea
//            System.out.println("ALGUNA EXC QUE NO TRABAJA IO");
//        } finally { // TANTO SI OCURRE O NO, SALE POR ACA
//            System.out.println("TERMINO EL PROGRAMA");
//        }
//    }
}
//  }}

