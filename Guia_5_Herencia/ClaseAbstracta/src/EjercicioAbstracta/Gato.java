package EjercicioAbstracta;

public class Gato extends Animal {

    public Gato(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }

    public Gato(){
        super();
    }
    
    @Override// Sobreescribo el metodo abstracto / OBLIGADA
    public void alimentarse() {
        System.out.println("El Gato se alimenta de " + this.alimento + " y el gatito hace Miauuu");
    }

    @Override
    public String toString() {// Sobreescribo el metodo para imprimir
        return "Gato{" + super.toString()+'}';
    }

    

}
