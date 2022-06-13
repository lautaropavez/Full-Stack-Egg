package herencia.ejemplo;

import java.util.*;

public class HerenciaEjemplo {

    public static void main(String[] args) {
        
        //Creo una persona
        Persona nuevaPersona = new Persona("Jorge", "Bestie",(byte) 0); // Le ponemos el byte entre parentesis porque sino Java por defecto considera que los numeros son Integer
        //Creo un Profesor
        Persona nuevoProfesor = new Profesor(4500, "Adri","Bestie",(byte) 35);
        //Creo Alumnos
        Persona nuevoAlumno = new Alumno("Geografia", "Pepa", "Lola",(byte) 85 );
        Alumno nuevoAlumno2 = new Alumno("Matematica", "Fer", "Chiquito",(byte) 85);
        
        //Creo una lista para almacenar los datos - Incorporo los datos - 
        //Va a contener objetos del tipo PERSONA
        List<Persona> listaTodos = new ArrayList();
        //Incorporo los objetos a mi lista
        listaTodos.add(nuevaPersona);
        listaTodos.add(nuevoProfesor);
        listaTodos.add(nuevoAlumno);
        listaTodos.add(nuevoAlumno2);
        
        //Recorro la lista para imprimir - IMPRIMO TODOS LOS OBJETOS -
        System.out.println("***** TODAS LAS PERSONAS QUE ESTAN EN MI LISTA *****");
        
        for (Persona unitario : listaTodos) {
            unitario.mostrarDatos();
        }
        
        Integer contadorAlumno = 0;
        Integer contadorProfesor = 0;
        Integer contadorPersona = 0;
        //Separo segun la condicion de la clase
        for (Persona unitario : listaTodos) {
            if (unitario instanceof Alumno ) {
                contadorAlumno++;
            }
            if(unitario instanceof Profesor){
                contadorProfesor++;
            }
            if(unitario instanceof Persona){
                contadorPersona++;
            }
            
        }
        System.out.println("");
        System.out.println("La cantidad de alumnos es: " + contadorAlumno);
        System.out.println("La cantidad de profesores es: " + contadorProfesor);
        System.out.println("La cantidad de Personas es: " + contadorPersona);
}
    

}
