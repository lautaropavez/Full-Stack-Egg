package POO.Ejercicio12Persona;
import java.util.Date;
//  12_ Implemente la clase Persona. Una persona tiene un nombre y una fecha de
//  nacimiento (Tipo Date), constructor vacío, constructor parametrizado, get y set. Y los
//  siguientes métodos:
//  • Agregar un método de creación del objeto que respete la siguiente firma:
//  crearPersona(). Este método rellena el objeto mediante un Scanner y le pregunta
//  al usuario el nombre y la fecha de nacimiento de la persona a crear, recordemos
//  que la fecha de nacimiento debe guardarse en un Date y los guarda en el objeto.
//  • Escribir un método calcularEdad() a partir de la fecha de nacimiento ingresada.
//  Tener en cuenta que para conocer la edad de la persona también se debe
//  conocer la fecha actual.
//  • Agregar a la clase el método menorQue(int edad) que recibe como parámetro
//  otra edad y retorna true en caso de que el receptor tenga menor edad que la
//  persona que se recibe como parámetro, o false en caso contrario.
//  • Metodo mostrarPersona(): este método muestra la persona creada en el método
//  anterior.
 public class PersonaDate {
    private String nombre;
    private int edad;
    private Date fecha_nac;
    private Date fecha_actual;
    private Character sexo; //Lo definimos como Character y no char porque podemos sacar provecho de esto ya que podemos acceder a distintos metodos y facilidades que nos otorgan las clases
    private double altura;
    
    public PersonaDate() {
    }

    public PersonaDate(String nombre, int edad, Date fecha_nac, Date fecha_actual, Character sexo, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.fecha_nac = fecha_nac;
        this.fecha_actual = fecha_actual;
        this.sexo = sexo;
        this.altura = altura;
    }

    
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public Date getFecha_actual() {
        return fecha_actual;
    }

    public Character getSexo() {
        return sexo;
    }

    public double getAltura() {
        return altura;
    }
    
//------------------------------------------------------------------------------
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setFecha_actual(Date fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
}

