package POO.Arrays;

import java.util.Arrays;
//  10. Realizar un programa en Java donde se creen dos arreglos: el primero será un arreglo
//  A de 50 números reales, y el segundo B, un arreglo de 20 números, también reales. El
//  programa deberá inicializar el arreglo A con números aleatorios y mostrarlo por
//  pantalla. Luego, el arreglo A se debe ordenar de menor a mayor y copiar los primeros
//  10 números ordenados al arreglo B de 20 elementos, y rellenar los 10 últimos
//  elementos con el valor 0.5. Mostrar los dos arreglos resultantes: el ordenado de 50
//  elementos y el combinado de 20.

//ESTE SERVICE ES PARA LA CLASE **ARRAYSAPP1**
public class ServiceArrays {

    public void crearArreglo(double ArregloA[]) {

        System.out.println("<<<<< Arreglo A >>>>>");

        for (int i = 0; i < ArregloA.length; i++) {
            ArregloA[i] = (Math.random() * 10) + 1; // este código nos genera numeros entre 1 y 100.
            double truncar = Math.pow(10, 1);
            ArregloA[i] = Math.round(ArregloA[i] * truncar) / truncar;
        }

        System.out.println(Arrays.toString(ArregloA));
    }

    public void OrdenarArreglo(double ArregloA[]) {

        System.out.println("\n<<< Arreglo A (menor a mayor)>>>");
        Arrays.sort(ArregloA);
        System.out.println(Arrays.toString(ArregloA));

    }
    
    public void copiarArreglo(double ArregloB[],double ArregloA[]) {
        System.out.println("\n<<<<< Arreglo B >>>>>");
        ArregloB = Arrays.copyOf(ArregloA,20);
        Arrays.fill(ArregloB,10,20,0.5); //1° Ponemenos el array que vamos a inicializar 2° Desde donde 3° Hasta donde 4° Con que numero lo queremos llenar
        System.out.println(Arrays.toString(ArregloB));

    }
    
    //Otra manera(dicho por profe Mari):Para que no quede el Array2 con 10 elementos, te recomiendo hacer el copyOfRange(array1 ,0 ,20), es decir, copiar los 20 primeros elementos. Y luego, rellenar con Array.fill desde el 10 en adelante!
}
