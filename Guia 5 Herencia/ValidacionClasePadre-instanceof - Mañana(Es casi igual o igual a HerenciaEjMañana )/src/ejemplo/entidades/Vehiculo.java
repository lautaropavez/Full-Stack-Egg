package ejemplo.entidades;

public class Vehiculo {

    //  MODIFICADOR DE ACCESO: PROTECTED (en la clase Padre o Super Clase)
    protected String marca;
    protected String modelo;
    protected Integer anioFabricacion;
    protected String color;

    public Vehiculo() {
        this.color = "Negro";
    }

    public Vehiculo(String marca, String modelo, Integer anioFabricacion, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        validarColor(color);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(Integer anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", anioFabricacion=" + anioFabricacion + ", color=" + color + '}';
    }

    private void validarColor(String color) {
        if (!color.equalsIgnoreCase("Blanco") && !color.equalsIgnoreCase("Rojo")) {
            this.color = "Negro";
        } else {
            this.color = color;
        }
    }

}
