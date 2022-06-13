package herencia.ejemplo;

public final class Profesor extends Persona {
    
    private Integer remuneracion;

    public Profesor(Integer remuneracion, String nombre, String apellido, byte edad) {
        super(nombre, apellido, edad);
        this.remuneracion = remuneracion;
    }

    public Profesor() {
        super();
    }

    public Integer getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(Integer remuneracion) {
        this.remuneracion = remuneracion;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("La remuneracion es de: " + remuneracion);
    }

    
    
    
    
}
