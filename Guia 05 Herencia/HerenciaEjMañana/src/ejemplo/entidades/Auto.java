package ejemplo.entidades;

public class Auto extends Vehiculo { //EXTENDS = HEREDA

    private Boolean puertaTrasera; 
    
    public Auto() {
    }

    public Auto(Boolean puertaTrasera, String marca, String modelo, Integer anioFabricacion) {
        //SUPER --> SUPER CLASE O CLASE PADRE
        
        super(marca, modelo, anioFabricacion);
        this.puertaTrasera = puertaTrasera;
    }

    public Boolean getPuertaTrasera() {
        return puertaTrasera;
    }

    public void setPuertaTrasera(Boolean puertaTrasera) {
        this.puertaTrasera = puertaTrasera;
    }

    @Override
    public int capacidadCombustible(int combustible) {
        System.out.println("La capacidad del combustible del Auto es : "+ combustible);
        return combustible;
    }

    @Override
    public String toString() {
        
        return super.toString()+ "Auto{" + "puertaTrasera: " + puertaTrasera + '}';
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
    
    
    
    
    
    
}
