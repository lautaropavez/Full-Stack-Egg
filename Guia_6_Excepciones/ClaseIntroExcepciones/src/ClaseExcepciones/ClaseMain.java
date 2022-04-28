package ClaseExcepciones;

import java.util.Scanner;

public class ClaseMain {

    //El codigo puntual que maneja las excepciones se llama manejador de excepciones
    //Trowable es la superclase de errores, contiene todos los errores que van a ocurrir en mi programa
    //Tenemos 2 grupos el ERROR y EXCEPTION, las del grupo error el programador generalmente no las trabaja porque son eventos que no podemos preveer, que le sucedieron al usuario (por ejemplo problemas en su computadora)
    // Dentro de exception vamos a tener subclases, las del tipo IOException se reconocen tambien como las verificadas(significa que Java sabe que pueden ocurrir), entonces las IOException java te obliga a que las trabajes.
    // Luego tenemos como subclase tambien las del Runtime Exception(se refiere a cuando está corriendo el programa) dentro de esta podemos encontrar la NullPointer Exception(cuando no creamos el epacio de memoria en algun objeto)
    //------------------PABLARAS RESERVADAS----------------------------------
    //TRY(intentar): Todo aquello que considero que puede largar una excepcion va a estar dentro del bloque try. Donde incorporo todas las instrucciones que puedan llegar a largar un error
    //CATCH: Agarro la excepcion y voy a hacer algo con esa excepcion. Donde trata la excepcion. Pueden existir multiples concatenaciones, recordando siempre el nivel de jerarquia de las mismas. 
    //       El catch recibe la excepcion que ocurre como 1° termino y como 2° termino como nos dijeron que es una clase que crea objetos el 2do termino "e" hace referencia a este objeto
    //FINALLY: Se ejecuta suceda o no la excepcion. Actualmente no tiene mucho sentido usar finally per cuando trabajemos con conexion a base de datos, algo que tengo que hacer siempre es desconectarme de la base de datos
    //THROW: Significa que voy a crear un objeto del tipo "Exception" que generalmente esta relacionado a cuando yo creo excepciones que YO las considero excepciones
    //THROWS: Lista las excepciones que un metodo puede lanzar. Puedo concatenar varios de ellos(en el metodo o clase especifica).Siempre va a ser una palabra que va a exigir que incorpore a la definicion de metodo o la clase que esta ocupando este throw. Me dice: che si me dijiste que ibas a largar una excepcion, declara que puede largar una excepcion.
    //        Asi que si uso la primera palabra, la segunda la voy a tener que utilizar como concatenada en el metodo que estoy llamando
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        System.out.println("ACA INICIA TODO");
        //La excepcion InputMacht es cuando ingreso un dato que no era el que yo queria que entre(te mete una letra en vez de un nro)
        try {
            Integer numero1 = leer.nextInt();
            validar(numero1);
            //System.out.println(numero1.compareTo(8));//uso esto cuando es null para ver q se corta...
        } catch (NullPointerException e) { //Lo recomendable y la buena practica es que yo trabaje el error en concreto que puede ocurrir, sea que no llame a toda la clase Exception, sino la especifica que necesite. 
            System.out.println(e.toString() + "Caballero tiene inicilizar el numero");  //Integer numero1 = null;
        } catch (RuntimeException e) {
            System.out.println("Aca ocurrio algo que no trabaje: " + e.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());//Atrapo la excepcion si ocurre de mi metodo "Validar"
        } finally {
            System.out.println("Esto ocurre si o si");
        }

        System.out.println("ACA TERMINA TODO");
    }

    //Este metodo es para validar... recibe un numero por parametro
    public static void validar(Integer numero) throws Exception {
        // Invento mi propia excepcion... por jodida... creo que si el numero es menor a 15 q largue la excp
        if (numero < 15) {
            throw new Exception("El numero no quiero que sea menor a 15, mia la pelota...");
        }
    }
}
