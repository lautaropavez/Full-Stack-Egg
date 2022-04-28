
package CodigoEjemploHerencia;

//Final --> Lo agrego si se que nadie va a heredar d esta clase
//Extends --> Palabra reservada para avisar que HEREDA
//nombreClase -->de quien es la SUPERCLASE
public final class Profesor extends Persona {
    //Puedo declarar atributos especificos de esta clase, OJO ESTOS SON PRIVATE
    private Integer remuneracion;

    public Profesor(Integer remuneracion, String nombre, String apellido, byte edad) {
        super(nombre, apellido, edad); // Salta a la clase PErsona 
        this.remuneracion = remuneracion;
    }

    public Profesor() {
        super();
    }

    //CREO GET Y SET DE LOS ATRIBUTOS ESPECIFICOS
    public Integer getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(Integer remuneracion) {
        this.remuneracion = remuneracion;
    }

    @Override // SOBRESCRITURA DE UN METODO
    public void mostrarDatos(){
       super.mostrarDatos();//LLAMO AL METODO EN CLASE PADRE
       System.out.println("La remuneracion es:" + remuneracion); // LE AGREGO ALGO
    }
    
    
    
    
    
    
    
    
    
}
