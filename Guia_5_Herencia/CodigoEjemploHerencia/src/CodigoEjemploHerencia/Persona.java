
package CodigoEjemploHerencia;

//Mi SUPERCLASE - No neccesito hacer nada raro - DEFINIR ACA TODO LO QUE CREO Q ES "GENERAL"
public class Persona {
    //Declaro los atributos protected, para quienes sean de la familia acceden sin usar GET Y SET
    protected String nombre;
    protected String apellido;
    protected byte edad;
  
 
    public Persona(String nombre, String apellido, byte edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Persona() {
    }
    
    //Para que puedan acceder desde otras clases no hijas
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    //Este metodo lo creo para mostrar DATOS
    public void mostrarDatos(){
        System.out.println("\nNombre Persona:" + nombre
        + "\nApellido Persona: " + apellido
        + "\nEdad Persona: " + edad);
    }
    
    
    
    
    
}
