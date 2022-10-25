package EjerciciosJava;
/** 23.Realizar un algoritmo que rellene un vector de tamaño N con valores aleatorios y le
 *  pida al usuario un numero a buscar en el vector. El programa mostrará donde se
 *  encuentra el numero y si se encuentra repetido.
*/
import java.util.Scanner;

public class Ejercicio23 {

    public static void main(String[] args) {
        int tam, num;
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el tamaño del vector:");
        tam = leer.nextInt();
        int[] vector = new int[tam];

        // llamada al metodo para llenar el arreglo con valores aleatorios
        rellenarVector(vector);
        
        System.out.println("Ingrese el numero que desea buscar:");
        num = leer.nextInt();
        
        buscarNumero(vector,num);
        // cerramos la entrada de datos
        leer.close();
    }
    //Llena el vector con valores aleatorios. Se hace un casting a int ya que Math.random retorna un double.
    public static void rellenarVector(int[] vector){
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 100) + 1;// este código nos genera numeros entre 1 y 100.
        }
        mostrarVector(vector);  
    }
    
    private static void buscarNumero(int[] vector,int num){
        int numRepetido = 0;
        for(int i=0; i<vector.length; i++){
            // Validamos si el vector[i] es igual al num
            if (vector[i] == num){
                System.out.println("El numero: " + num + " se encuentra en la posicion [" + (i+1) + "] del vector."); // i+1 porque como empieza desde cero siempre tira 1 num menos
                numRepetido ++;
            }
            
            if(numRepetido>1){
                System.out.println("El número "+ num +" se ha repetido: ["+ numRepetido +"] veces.");
            }  
        }
    }
    
    private static void mostrarVector(int[] vector){
      for(int i=0; i<vector.length; i++){
        System.out.print("["+ vector[i] +"]");
      } 
        System.out.println("");
    }
}
