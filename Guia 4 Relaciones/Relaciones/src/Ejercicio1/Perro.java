package Ejercicio1;
//    1_Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de
//    dos clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase
//    Persona con atributos: nombre, apellido, edad, documento y Perro.
//    Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener
//    que pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo,
//    mostrar desde la clase Persona, la información del Perro y de la Persona.
import Enum.SexoAnimal;

public class Perro {
    
    private String nombre;
    private String raza; 
    private Integer edad;
    private double tamano;

    public Perro() {
    }

    public Perro(String nombre, String raza, Integer edad, double tamano) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Perro{" + "nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", tamano=" + tamano + '}';
    }

    
}
