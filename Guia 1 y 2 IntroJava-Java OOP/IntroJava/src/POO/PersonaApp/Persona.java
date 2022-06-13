package POO.PersonaApp;
//    7. Realizar una clase llamada Persona que tenga los siguientes atributos: nombre, edad,
//    sexo ('H' hombre, 'M' mujer, 'O' otro), peso y altura. Si el alumno desea añadir algún
//    otro atributo, puede hacerlo. Los métodos que se implementarán son:
//    • Un constructor por defecto.
//    • Un constructor con todos los atributos como parámetro.
//    • Métodos getters y setters de cada atributo.
public class Persona {
    private String nombre;
    private Integer edad; //Lo definimos como Integer y no int porque podemos sacar provecho de esto ya que podemos acceder a distintos metodos y facilidades que nos otorgan las clases
    private Character sexo; //Lo definimos como Character y no char porque podemos sacar provecho de esto ya que podemos acceder a distintos metodos y facilidades que nos otorgan las clases
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, Integer edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
    }

//------------------------------------------------------------------------------
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
//------------------------------------------------------------------------------

    public String getNombre() {
        return nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "\nPersona{" + 
                "\nNombre: " + nombre +
                "\nEdad: " + edad + 
                "\nSexo: " + sexo + 
                "\nPeso: " + peso + 
                "\nAltura: " + altura + '}';
    }

    
    
    
}
