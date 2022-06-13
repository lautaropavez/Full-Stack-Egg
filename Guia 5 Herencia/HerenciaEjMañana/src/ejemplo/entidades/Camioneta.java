package ejemplo.entidades;

public class Camioneta extends Vehiculo {

   
    private Boolean dobleCabina;

    public Camioneta(Boolean dobleCabina, String marca, String modelo, Integer anioFabricacion) {
        super(marca, modelo, anioFabricacion);
        this.dobleCabina = dobleCabina;
    }
    
    @Override
    public int capacidadCombustible(int combustible) {
        System.out.println("La capacidad del combustible de la Camioneta es : "+ combustible);
        return combustible;
    }

    public Boolean getDobleCabina() {
        return dobleCabina;
    }

    public void setDobleCabina(Boolean dobleCabina) {
        this.dobleCabina = dobleCabina;
    }

    @Override
    public String toString() {
        
        return super.toString()+ "Camioneta{" + "dobleCabina=" + dobleCabina + '}';
    }
    
    
}
