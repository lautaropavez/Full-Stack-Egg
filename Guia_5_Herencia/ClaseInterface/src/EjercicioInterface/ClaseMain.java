
package EjercicioInterface;

 /*Se plantea desarrollar un programa que nos permita calcular el área y el perímetro
de formas geométricas, en este caso un circulo y un rectángulo. Ya que este
calculo se va a repetir en las dos formas geométricas, vamos a crear una Interfaz,
llamada calculosFormas que tendrá, los dos métodos para calcular el área, el
perímetro y el valor de PI como constante. Desarrollar el ejercicio para que las
formas implementen los métodos de la interfaz y se calcule el área y el perímetro
de los dos. En el main se crearán las formas y se mostrará el resultado final.
Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2.*/
public class ClaseMain {

  
    public static void main(String[] args) {

        //CIRCULO CON EL CONSTRUCTOR QUE RECIBE PARAMETROS --> DEL RADIO
        Circulo nuevoCirculo = new Circulo (5);  
       // System.out.println("El area de su circulo es:" + nuevoCirculo.calcularArea());
       //USAMOS PRINTF PARA REGULAR CUANTOS DECIMALES APARECEN
        System.out.printf("El area de su circulo es: " + "%.2f %n", nuevoCirculo.calcularArea()); //System.out.printf: Internamente, printf() usa la clase java.util.Formatter  para analizar la cadena de formato y generar la salida. Se pueden encontrar opciones de cadena de formato adicionales en Formatter Javadoc .
                                                                                                  //En este caso lo usamos para que solo muestre 2 decimales.
        System.out.printf("El perimetro de su circulo es: " + "%.2f %n",nuevoCirculo.calcularPerimetro());
        
        Rectangulo nuevoRectangulo = new Rectangulo(4.6,5);
        System.out.printf("El area de su rectangulo  es: " + "%.2f %n", nuevoRectangulo.calcularArea());
        System.out.printf("El perimetro de su rectangulo es: " + "%.2f %n",nuevoRectangulo.calcularPerimetro());    
    }
//    ------------------------------- System.out.printf --------------------------------------------------
//    El carácter de conversión es obligatorio y determina cómo se formatea el argumento.
//
//    Los caracteres de conversión solo son válidos para ciertos tipos de datos. Aquí hay algunos comunes:
//
//    s da formato a las cadenas.
//    d da formato a enteros decimales.
//    f formatea números de punto flotante.
//    t da formato a los valores de fecha/hora.
//    Mas info en https://www.baeldung.com/java-printstream-printf
}
