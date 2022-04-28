package Ejemplo2Guia;

import java.util.ArrayList;

public class NewMain {

    public static void main(String[] args) {

        Alumno alumno1 = new Alumno();
        
        alumno1.setNombre("Mariela");
        alumno1.setApellido("Gadea");
        
        ArrayList<Alumno> alumnos = new ArrayList();
        alumnos.add(alumno1);
        
        Curso curso = new Curso();
        curso.setAlumnos(alumnos);

    }
}
