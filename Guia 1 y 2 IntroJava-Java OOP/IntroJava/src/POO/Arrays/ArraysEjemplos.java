package POO.Arrays;
import java.util.Arrays;
// La clase Arrays es una clase de utilidad que posee una gran cantidad de métodos para manupilar arreglos.
public class ArraysEjemplos {

    public static void main(String[] args) {
       //Creamos un arreglo
       int  arreglo1[] = {4, 2, 8, 6, 10};
       imprimirArreglo(arreglo1);
       
       //Método fill = Método para inicializar arreglos con un valor determinado.
       int arreglo2[] = new int[5];
       Arrays.fill(arreglo2,7);
       imprimirArreglo(arreglo2);
       
       //Método copyOf = Método que permite copiar el contenido de un arreglo en otro arreglo.
       int arreglo3[] = Arrays.copyOf(arreglo1,5); // acá le estamos diciendo que queremos copiar los 5 elementos del arreglo 1
       imprimirArreglo(arreglo3);
       
       //Metodo equals = Determina si dos arreglos son iguales.
       if(Arrays.equals(arreglo1,arreglo2)){
           System.out.println("Los arreglos son iguales.");
       }else{
           System.out.println("Los arreglos son distintos.");
       }
       
       if(Arrays.equals(arreglo1,arreglo3)){
           System.out.println("Los arreglos son iguales.");
       }else{
           System.out.println("Los arreglos son distintos.");
       }
       
       //Método sort = Método para ordenar los arreglos.
       Arrays.sort(arreglo1);
       imprimirArreglo(arreglo1);
       
       //Método binarySearch = Sirve para buscar un elemento determinado en un arreglo. El método devuelve la posición en 
       int posicion = Arrays.binarySearch(arreglo1,8);
        System.out.println("El elemento 8 se encuentra en la posicion: " + posicion);
       
    }
    public static void imprimirArreglo(int arreglo[]){ // Es estático para no tener que crear un objeto de la clase y así poder acceder directamente al método 
        
        System.out.println("***** ARREGLO *****");
        
        for (int i = 0; i < arreglo.length; i++){
            System.out.println(arreglo[i]);
        }   
    }
    
}
