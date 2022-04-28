package EjercicioAbstracta;

public class Caballo extends Animal {

    public Caballo(String nombre, String alimento, Integer edad, String raza) {
        super(nombre, alimento, edad, raza);
    }

     public Caballo(){
         super();
     }
     
     
    @Override
    public void alimentarse() {// Sobreescribo el metodo abstracto
        System.out.println("El caballo se alimenta de: " + this.alimento);
    }
        
     @Override
    public void hagoOtraCosas() { // Sobreescribo el metodo que no era abstracto
        super.hagoOtraCosas();
        System.out.println("Chau chicos a cenar!!!");
    }

    @Override
    public String toString() {// Sobreescribo el metodo para imprimir
        return "Caballo{" + super.toString()+ '}';
    }
    
    
    
}
