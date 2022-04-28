package Ejercicio1;

//    1_Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de
//    dos clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase
//    Persona con atributos: nombre, apellido, edad, documento y Perro.
//    Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener
//    que pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo,
//    mostrar desde la clase Persona, la información del Perro y de la Persona.

public class Persona {
    
    private String nombre;
    private String apellido;
    private Integer edad;
    private Integer documento;
    private Perro Mascota;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Integer edad, Integer documento, Perro Mascota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.Mascota = Mascota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public void setMascota(Perro Mascota) {
        this.Mascota = Mascota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public Integer getDocumento() {
        return documento;
    }

    public Perro getMascota() {
        return Mascota;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", documento=" + documento + ", Mascota=" + Mascota + '}';
    }
    
    
    
}
