package POO.PersonaApp;
//      Crear 4 objetos de tipo Persona con distintos valores, a continuación, llamaremos todos
//      los métodos para cada objeto, deberá comprobar si la persona está en su peso ideal,

import java.util.HashSet;
import java.util.InputMismatchException;

//      tiene sobrepeso o está por debajo de su peso ideal e indicar para cada objeto si la
//      persona es mayor de edad.
//      Por último, guardaremos los resultados de los métodos calcularIMC y esMayorDeEdad
//      en distintas variables, para después en el main, calcular un porcentaje de esas 4
//      personas cuantas están por debajo de su peso, cuantas en su peso ideal y cuantos, por
//      encima, y también calcularemos un porcentaje de cuantos son mayores de edad y
//      cuantos menores.
//      ---EXCEPCIONES---
//      Inicializar un objeto de la clase Persona ejercicio 7 de la guía POO, a null y tratar
//      de invocar el método esMayorDeEdad() a través de ese objeto. Luego, englobe el
//      código con una cláusula try-catch para probar la nueva excepción que debe ser
//      controlada.
public class PersonaApp {

    public static void main(String[] args) {

        ServicePersona servicio = new ServicePersona();
        
        Persona p1 = new Persona();
        p1.setNombre("Lautaro");
        p1.setEdad(24);
        p1.setSexo('H');
        p1.setPeso(80);     
        p1.setAltura(1.75);
//        Persona p1 = servicio.crearPersona();
        
        Persona p2 = new Persona("Mora",12,'M',50, 1.20 );
//      Persona p2 = servicio.crearPersona(); // esta es 1 forma de hacerlo, hay varias, la otra es hacerlos con un bucle for en el main o en el service
           
        Persona p3 = new Persona("Hernan",46,'O',72, 1.80 );
//      Persona p3 = servicio.crearPersona();

//       Persona p4 = servicio.crearPersona();

        System.out.println(p1);
        servicio.calcularIMC(p1);
        servicio.esMayorDeEdad(p1);

        System.out.println(p2);
        servicio.calcularIMC(p2);
        servicio.esMayorDeEdad(p2);
        
        System.out.println(p3);
        servicio.calcularIMC(p3);
        
        servicio.esMayorDeEdad(null);
        
//       Persona[] vectorPersonas = servicio.crearPersonas(4);      //No nos tira error porque esto ya sabe que nos devuelve un arreglo y lo guardo en lista personas
Persona[] vectorPersonas = servicio.crearPersonasTest();  // Lo hacemos para testear la app
         
        servicio.porcentajesPeso(vectorPersonas);
        servicio.porcentajeEdad(vectorPersonas); //Le pasamos el vector que ya tenemos lleno con todos los datos que tenemos en nuestro test
    }

}
