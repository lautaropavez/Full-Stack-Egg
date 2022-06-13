package POO.Circunferencia;

public class CircunferenciaApp {

    public static void main(String[] args) {
       ServicioCircunferencia servicio = new ServicioCircunferencia();

       Circunferencia circunferencia01 = servicio.crearCircunferencia();
		
       System.out.println("Area de la Circunferencia:" + servicio.calcularArea(circunferencia01.getRadio()));
	
       System.out.println("Perimetro de la Circunferencia: " + servicio.calcularPerimetro(circunferencia01.getRadio()));
    }

}
