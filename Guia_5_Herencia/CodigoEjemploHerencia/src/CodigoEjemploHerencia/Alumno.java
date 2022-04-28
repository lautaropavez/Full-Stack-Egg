package CodigoEjemploHerencia;

public final class Alumno extends Persona {

    private String carrera;

    public Alumno() {
        super(); //SUPER -- palabra para avisar que quiero algo del mas alla, d mi clase PADRE
    }

    public Alumno(String carrera, String nombre, String apellido, byte edad) {
        super(nombre, apellido, edad);// SUPER, hace referencia a las cosas de SUPERCLASE
        this.carrera = carrera;
    }
    //CREO GET Y SET ATRIBUTOS PUNTUALES DE ESTA CLASE

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    @Override // Esta anotacion, me permite "SobreEscribir algo ya existente"
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Carrera Alumno:" + carrera);
    }

}
