package ejemplo.entidades;

public class Furgon extends Vehiculo{
    
    private Boolean ventanillas;

    public Furgon(Boolean ventanillas, String marca, String modelo, Integer anioFabricacion) {
        super(marca, modelo, anioFabricacion);
        this.ventanillas = ventanillas;
    }
    
    @Override
    public int capacidadCombustible(int combustible) {
        System.out.println("La capacidad del combustible del Furgon es : "+ combustible);
        return combustible;
    }

    public Boolean getVentanillas() {
        return ventanillas;
    }

    public void setVentanillas(Boolean ventanillas) {
        this.ventanillas = ventanillas;
    }

    @Override
    public String toString() {
        return super.marca+" Furgon{" + "ventanillas=" + ventanillas + '}';
    }
    
    
    
}
