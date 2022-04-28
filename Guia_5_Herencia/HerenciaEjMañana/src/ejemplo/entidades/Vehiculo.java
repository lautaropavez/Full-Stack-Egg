
package ejemplo.entidades;


public class Vehiculo {
    
    //  MODIFICADOR DE ACCESO: PROTECTED (en la clase Padre o Super Clase)
    
    protected String marca;
    protected String modelo;
    protected Integer anioFabricacion;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, Integer anioFabricacion) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
    }
    
    public int capacidadCombustible(int combustible){
        System.out.println("La capacidad del combustible vehicular es : "+ combustible);
        return combustible;
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

    @Override
    public String toString() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", anioFabricacion=" + anioFabricacion + '}';
    }
    
    
}
