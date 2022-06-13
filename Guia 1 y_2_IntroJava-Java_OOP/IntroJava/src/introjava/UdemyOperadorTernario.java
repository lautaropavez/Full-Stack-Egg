package introjava;

/**
 * @author Lautaro Pavez
 */
public class UdemyOperadorTernario {

    public static void main(String[] args) {
       String resultado = ( 3>2 )? "verdadero": "falso"; //Lo que hace es que si es verdadero se ejecuta la primera sentencia, sino se ejecuta la 2da. No hace falta que diga verdadero o falso pueden ser cualquier oracion.
       
       int numero = 8;
       resultado = ( numero % 2 == 0) ? "El numero es par." : "El numero es impar.";
        System.out.println("resultado = " + resultado);
    }

}
