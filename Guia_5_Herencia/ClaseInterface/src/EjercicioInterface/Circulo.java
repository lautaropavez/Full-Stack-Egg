package EjercicioInterface;

public class Circulo implements calcularFormas {

    //ATRIBUTOS DE MI CLASE
    private double radio;
    private double diametro;

    public Circulo() {
    }

    public Circulo(double radio) {
        this.radio = radio;
        this.diametro = radio * 2; // Este atributo, lo seteo cuando tengo el diametro
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = this.radio * 2;
    }

    //SOBREESCRIBO LOS METODOS
    @Override
    public double calcularArea() {
        double aux = (constantePi * (Math.pow(this.radio, 2)));
        return aux;
    }

    @Override
    public double calcularPerimetro() {
        double aux = constantePi * this.diametro;
        return aux;
    }

}
