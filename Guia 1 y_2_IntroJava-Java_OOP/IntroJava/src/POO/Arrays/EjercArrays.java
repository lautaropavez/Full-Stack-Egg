package POO.Arrays;
import java.util.Arrays;
//  10. Realizar un programa en Java donde se creen dos arreglos: el primero será un arreglo
//  A de 50 números reales, y el segundo B, un arreglo de 20 números, también reales. El
//  programa deberá inicializar el arreglo A con números aleatorios y mostrarlo por
//  pantalla. Luego, el arreglo A se debe ordenar de menor a mayor y copiar los primeros
//  10 números ordenados al arreglo B de 20 elementos, y rellenar los 10 últimos
//  elementos con el valor 0.5. Mostrar los dos arreglos resultantes: el ordenado de 50
//  elementos y el combinado de 20.
public class EjercArrays {
    public static void main(String[] args) {
        System.out.println("<<< Arreglo A >>>");
        double arregloA[]=new double[50];
        crear_Arreglo(arregloA);
        System.out.println(Arrays.toString(arregloA));
        
        System.out.println("\n<<< Arreglo A (menor a mayor)>>>");
        Arrays.sort(arregloA);
        System.out.println(Arrays.toString(arregloA));
        
        System.out.println("\n<<< Arreglo B >>>");
        double arregloB[]=new double[20];
        arregloB=Arrays.copyOf(arregloA, 20);      
        Arrays.fill(arregloB, 10, 20, 0.5);
        System.out.println(Arrays.toString(arregloB));   
    }
    public static void crear_Arreglo(double arregloA[]){
        for (int i = 0; i < arregloA.length; i++) {
            arregloA[i]= (double) Math.random() * (9 - 0 + 1) + 0;
            double truncar = Math.pow(10, 1);
            arregloA[i] = Math.round(arregloA[i]*truncar)/truncar;
        }
    }


}
