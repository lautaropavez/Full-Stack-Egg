package ejemplo.entidades;

public class Camioneta extends Vehiculo {

    private Boolean dobleCabina;

    public Camioneta() {

    }

    public Camioneta(Boolean dobleCabina, String marca, String modelo, Integer anioFabricacion, String color) {
        super(marca, modelo, anioFabricacion, color);
        this.dobleCabina = dobleCabina;
    }

    public Boolean getDobleCabina() {
        return dobleCabina;
    }

    public void setDobleCabina(Boolean dobleCabina) {
        this.dobleCabina = dobleCabina;
    }

    @Override
    public String toString() {
        return super.toString() + "Camioneta{" + "dobleCabina=" + dobleCabina + '}';
    }

}
