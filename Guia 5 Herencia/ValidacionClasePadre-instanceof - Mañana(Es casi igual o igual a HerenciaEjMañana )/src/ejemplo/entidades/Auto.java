package ejemplo.entidades;

public class Auto extends Vehiculo { //EXTENDS = HEREDA

    private Boolean puertaTrasera;

    public Auto() {
    }

    public Auto(Boolean puertaTrasera, String marca, String modelo, Integer anioFabricacion, String color) {
        //SUPER --> SUPER CLASE O CLASE PADRE
        super(marca, modelo, anioFabricacion, color);
        this.puertaTrasera = puertaTrasera;
    }

    public Boolean getPuertaTrasera() {
        return puertaTrasera;
    }

    public void setPuertaTrasera(Boolean puertaTrasera) {
        this.puertaTrasera = puertaTrasera;
    }

    @Override
    public String toString() {
        return super.toString() + "Auto{" + "puertaTrasera: " + puertaTrasera + '}';
    }

}
