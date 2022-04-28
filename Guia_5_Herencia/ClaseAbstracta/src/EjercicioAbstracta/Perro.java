
package EjercicioAbstracta;

public class Perro extends Animal{

    //Llamo los constructores de mi padre
    public Perro(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }

    public Perro() {
        super();
    }

    
  @Override // Sobreescribo el metodo abstracto
    public void alimentarse() {
        System.out.println("El Perro se alimenta de " + this.alimento + " y el perrito hace guauuu");
    }

    @Override// Sobreescribo el metodo para imprimir
    public String toString() {
        return "Perro{" + super.toString()+ '}';
    }

   
   
    
}
