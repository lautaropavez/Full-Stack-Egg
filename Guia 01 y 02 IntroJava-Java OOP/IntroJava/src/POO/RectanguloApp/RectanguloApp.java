package POO.RectanguloApp;

public class RectanguloApp {

    public static void main(String[] args) {
        
        // Creamos el rectangulo a partir del metodo
        Rectangulo r1 = new Rectangulo();
        
        Rectangulo crear = ServiceRectangulo.crearRectangulo();
        
        System.out.println("Superficie del rectángulo: " + r1.Calcularsuperficie(crear.getBase(),crear.getAltura()));
        System.out.println("Perímetro del rectángulo: " + r1.Calcularperimetro(crear.getBase(),crear.getAltura()));
        
        System.out.println("");
        // llamada al metodo que dibujara el rectangulo
        r1.dibujarRectangulo(crear.getBase(),crear.getAltura());
    }

}
