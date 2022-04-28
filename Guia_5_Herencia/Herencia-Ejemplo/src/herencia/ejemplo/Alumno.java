package herencia.ejemplo;

public final class Alumno extends Persona {
    //Al no tener geteers ni setters propios de edad entra a la validacion igual.
    private String carrera;

    public Alumno(String nombre, String apellido, byte edad) {
        super(nombre, apellido, edad);
    }

    public Alumno(String carrera, String nombre, String apellido, byte edad) {
        super(nombre, apellido, edad);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos(); 
        System.out.println("Carrera alumno: " + carrera);
    }

    
}
