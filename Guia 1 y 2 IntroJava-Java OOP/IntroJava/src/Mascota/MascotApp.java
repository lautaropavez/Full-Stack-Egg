package Mascota;

import Enum.RazaGato;
import Enum.RazaPerro;
import Enum.SexoHumano;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


//import java.util.Scanner;
public class MascotApp {

    public static void main(String[] args) {
        
 //     video entidad y control Egg
 
//        ServicioMascota sm = new ServicioMascota(); //De esta manera ya tenemos acceso a los servicios
//        Mascota m1 = sm.crearMascota();//Lo que me devuelva la funcion crear mascota va a ser guardado en la variable m1
 // El método crear mascota no seria coherente que estuviera adentro de mascota porque no se puede crear a si misma
 //-----------------------------------------------------------------------------      
 //     Scanner leer = new Scanner(System.in);
 //     Usuario us = new Usuario();// Hecho por mí  
 //     Mascota m1 = new Mascota("Josesito", leer.nextLine(), "Perro");//acá creamos el objeto, a la derecha del igual es cuando hago nacer al objeto, a la izquierda es donde lo asigno;
 //        apretando ctrl+space nos abre el parentesis que esta al lado de mascota, para que nosotros elijamos que constructor queremos usar
 //        La manera que esta debajo es dar los valores uno por uno, pero hay otra forma que es llamando al constructor
 //        m1.apodo = "Chiquito";
 //        m1.nombre = leer.nextLine();
 //        m1.tipo = "Perro";
 //        m1.raza = "Beagle";
 //        m1.edad = 14;
 //        m1.cola = true;
 //        m1.color = "Tricolor";

        //De la misma manera que yo puse "Mascota m1 = new Mascota();" podria haber puesto:"Mascota m2 = new Mascota();" para crear una segunda mascota
        //System.out.println("Apodo: " + m1.apodo + " Nombre: " + m1.nombre + " Tipo: " + m1.tipo); //Si a algún objeto no le pongo un valor nos muestra su valor por defecto.
                                                                                                    //Acá vemos (linea de arriba) que esto lo podemos hacer cuando las variables no están privadas por lo que ahora que si  lo están lo haremos de otra forma
        
//      m1.pasear(100);// al poner 100, puede ser otro nro, este nro pasa a la vaariable energiaRestar y se ejecuta la funcion pasea, pasandonos el resultado de la energia                                                                                       
                                                                                                    
                                                                                                    
//        System.out.println(m1);//Si nosotros ponemos sout(m1) o sout(m1.toString()) no va hacer una función que me devuelve formateado y armado según cada mascota
//      System.out.println(us);// Hecho por mí 

//------------------------------------------------------------------------------
//     video entidad y control Egg
//     Existe el garbage collector que cada vez que en Java no utilizamos un objeto o lo dejamos de utilizar, entiende que no se va a volver a usar entonces no tiene sentido que siga existiendo
//     por lo que lo elimina y no le da el espacio de memoria que tenia antes para optimizar recursos. En otros lenguajes se hace de forma manual.
//
//
//
//
//----------------------------------------VIDEOS RELACIONES---------------------------------------------------
//
//****************************************ENUMERACIONES*******************************************************
//
//
//        Usuario u = new Usuario();
//        
//        u.setSexo(SexoHumano.HOMBRE);
//        
//        System.out.println(u.getSexo());
//        
//        System.out.println(RazaPerro.PITBULL.getValor());
//
//
//
//****************************************GENÉRICOS************************************************************
//
//
//
//        Mascota m1 = new Mascota<RazaPerro>("Fernando","Chiquito","Perro");
//        
//        m1.setRaza(RazaPerro.BORDER_COLLIE);
//        
//        System.out.println(m1.toString());
//        
//        Mascota m2 = new Mascota<RazaGato>("Pepa","Lola","Gato");
//        
//        m2.setRaza(RazaGato.SIAMES);
//        
//        System.out.println(m2.toString());
//
//****************************************UML************************************************************
//
//
//
      Mascota m1 = new Mascota("Fernando","Chiquito","Perro");

      Mascota m2 = new Mascota("Pepa","Lola","Gato");
      
      List<Mascota> mascotas = new ArrayList();
      
      mascotas.add(m1);
      mascotas.add(m2);
        
      Usuario u = new Usuario();
      
      u.setApellido("Fiorde");
      u.setSexo(SexoHumano.HOMBRE);
      u.setNacimiento(new Date("1/01/2022")); // new Date() solo sin el String lo que hace es poner la fecha que es ahora.
      
      u.setMascotaFavorita(m1);
      
      u.setMascota(mascotas);
      
        System.out.println(u.toString());
      
      
      
      
    }

}
