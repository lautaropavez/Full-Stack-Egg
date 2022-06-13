package ExamenEgg;

import java.util.Scanner;
//    La función recibirá tres numéros:
//
//    * numEnt, de tipo int
//    * numReal, de tipo double
//    * numLargo, de tipo long
//      Y deberá devolver true si se cumplen todas las siguientes condiciones:
//
//    numEnt es par
//    numReal está próximo a su valor entero anterior. Por ejemplo, 1.4 SÍ está próximo a 1; 43.9 NO está próximo a 43; 123.5 NO está próximo a 123.
//    numLargo es positivo o es igual a cero
//    Resultados esperados:
//
//    Si se ingresan los números 4, 1.4, 6 deberá devolver true.
//    Si se ingresan los números 2, 1.49999, 77 deberá devolver true.
//    Si se ingresan los números 10000, 1, 123 deberá devolver true.
//    Si se ingresan los números 1, 10, 6 deberá devolver false.
//    Si se ingresa los números 2, 2.9, 6 deberá devolver false.
//    Si se ingresan los números 2, 2, -3 deberá devolver false.
public class Ejercicio1 {
    
    Scanner leer = new Scanner(System.in);
    public int numEnt;
    public double numReal;
    public int numLargo;
    public boolean result;
    
  
    
    public Boolean parCieloPiso(int numEnt, double numReal, long numLargo) {
//        System.out.println("Ingrese un numero entero: ");
//        numEnt = leer.nextInt();
//        System.out.println("Ingrese un numero real: ");
//        numReal = leer.nextDouble();
//        System.out.println("Ingrese un numero largo: ");
//        numLargo = leer.nextLong();
//        int auxEntero = (int) numReal;
        boolean resultado = false;
        
        if((numEnt%2 == 0) && (Math.round(numReal) == Math.floor(numReal)) && (numLargo>=0) ){
          resultado = true;
        }
        return resultado;
  }
    
    
    
    
    
}
