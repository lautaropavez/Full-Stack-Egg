package Ejemplo1Guia;

public class NewMain {

    public static void main(String[] args) {
        Profesor profesor = new Profesor();
        profesor.setNombre("Agustín");
        profesor.setApellido("Lima");
        Curso curso = new Curso();
        curso.setProfesor(profesor);
    }

}
