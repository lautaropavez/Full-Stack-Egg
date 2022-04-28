package ExcepcionesEjemplosClase;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Ejemplo01NoVerificadas {

   // CASO A - No hago nada... veo que pasa.
//    public static void main(String[] args) {
//        int numero1 = 10, numero2 =0; //Modificar numero2 a cero y ver lo que pasa
//         int resultado = numero1/numero2;       
//         System.out.println("La division es: "+ resultado);//
//      
//    }
    
    
//    CASO B - Preveo lo que puede pasar
//    public static void main(String[] args) {
//        int numero1 = 10, numero2 = 0; //Modificar numero2 a cero y ver lo que pasa
//        try {
//            int resultado = numero1 / numero2;
//            System.out.println("La division es: " + resultado);
//        } catch (ArithmeticException e) {   //ArithmeticException hace referencia a que NO se puede dividir por cero
//            System.out.println("NO SE PUEDE DIVIDIR POR CERO");
//            System.out.println(e.getMessage());  //Acá el e.getMessage te trae el mensaje de Arithmetic, es como utilizar el toString.
//        } catch (Exception e) { 
//            System.out.println("Aca ocurrio algo que no tuve en cuenta");           
//        } finally {            
//            System.out.println("FIN PROGRAMA");
//        }
//    }
    
    
    //CASO C - Ver manejo de que entra un dato Cadena cuando esperaba numero(cuando te pone un String cuando tiene que meter un numero)
//    public static void main(String[] args) {
//        Scanner leer = new Scanner(System.in);
//        System.out.println("Ingrese un numero entero");
//        
//        try {
//            int numeroI = leer.nextInt();
//            System.out.println("El numero ingresado es:" + numeroI);
//        } catch (InputMismatchException e) {
//            System.out.println(e.toString() + e.getMessage()+   " UPS....OCURRIO ALGO INESPERADO");
//        } finally {
//            System.out.println("FIN");
//        }
//    }

}
