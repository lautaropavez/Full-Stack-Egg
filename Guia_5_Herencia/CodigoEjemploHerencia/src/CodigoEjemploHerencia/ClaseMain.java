package CodigoEjemploHerencia;

import java.util.ArrayList;
import java.util.List;

public class ClaseMain {

    /*Crear una clase "Persona", con los atributos NOMBRE APELLIDO EDAD
  Luego crear clase "alumno" que tendra un atributo carrera 
  Luego crear clase "profesor" que tendra un atributo remuneracion 
  Crear metodos correspondientes para crear objetos
  Mostrar por pantalla*/
    public static void main(String[] args) {
        //Creo una persona  
        Persona nuevaPersona = new Persona("Jorge", "Besti", (byte) 45);
        //Creo Profesores        
        Persona nuevoProfesor = new Profesor(4500, "Adri", "Besti", (byte) 35);
        //Creo Alummnos
        Persona nuevoAlumno = new Alumno("Geografia", "Jojo", "Coco", (byte) 85);
        Alumno nuevoAlumno2 = new Alumno("Geografia", "Jojo", "Fer", (byte) 85);

        //Creo una lista para almacenar los datos - Incorporo los datos -
        //Va a contener OBJETOS DEL TIPO  PERSONA
        List<Persona> listaTodos = new ArrayList();
        //Incorporo ls objetos a mi lista
        listaTodos.add(nuevaPersona);
        listaTodos.add(nuevoProfesor);
        listaTodos.add(nuevoAlumno);
        listaTodos.add(nuevoAlumno2);
        //Recorro la lista para imprimir - IMPRIMO TODOS LOS OBJETOS  -
        System.out.println("******TODAS LAS PERSONAS QUE ESTAN EN MI LISTA******");
        for (Persona unitario : listaTodos) {
            unitario.mostrarDatos();//Uso el mimso metodo.. q segun que tipo de OBJETO
                                    //es, hace lo especifico a la clase
        }

    }

}
