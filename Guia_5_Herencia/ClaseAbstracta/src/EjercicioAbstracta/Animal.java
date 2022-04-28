package EjercicioAbstracta;
// Esta clase no puede ser instanciada xq es ABSTRACTA.
public abstract class Animal {// ES UNA SUPERCLASE 

    //Declaro mis atributos.
    protected String nombre;
    protected String alimento;
    protected Integer edad;
    protected String raza;

    //Declaro los constructores
    public Animal(String nombre, String alimento, Integer edad, String raza) {
        this.nombre = nombre;
        this.alimento = alimento;
        this.edad = edad;
        this.raza = raza;
    }

    public Animal() {
    }
    /// Declaro metodo abstracto. No puede tener cuerpo, es decir {}
    public abstract void alimentarse();//Puden recibir parametros pero no pueden tener cuerpo

    //Puedo declarar metodos con cuerpo que no son abstractos - No estoy obligada a sobreescribir en mis hijas
    public void hagoOtraCosas() {
        System.out.println("Hola chicos!!!");
    }

    @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", alimento=" + alimento + ", edad=" + edad + ", raza=" + raza + '}';
    }

    
}
