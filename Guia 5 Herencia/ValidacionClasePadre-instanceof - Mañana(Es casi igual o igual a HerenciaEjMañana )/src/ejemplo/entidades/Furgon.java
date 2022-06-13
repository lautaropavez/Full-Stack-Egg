package ejemplo.entidades;

public class Furgon extends Vehiculo {

    private Boolean ventanillas;

    public Furgon() {
    }

    public Furgon(Boolean ventanillas, String marca, String modelo, Integer anioFabricacion, String color) {
        super(marca, modelo, anioFabricacion, color);
        this.ventanillas = ventanillas;
    }

    public Boolean getVentanillas() {
        return ventanillas;
    }

    public void setVentanillas(Boolean ventanillas) {
        this.ventanillas = ventanillas;
    }

    @Override
    public String toString() {
        return super.marca + " Furgon{" + "ventanillas=" + ventanillas + '}';
    }

}
