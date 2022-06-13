package introjava;
/*  Realizar la multiplicación de un vector por una matriz
 *  Dado un vector 1xN y nuna matriz NxN, el resultado del producto es 1xM
 *  Ej. Vector de 1x2 * Matriz 2x3 = producto 1x
 *  v=|3,5| * m=|4,8,6| = |3*4+5*2,3*8+5*1,3*6+5*7|=|22,29,53|
 *              |2,1,7|
 */
import java.util.Scanner;

public class VectoresyMatricesVideo {

    public static void main(String[] args) {
       //Declaración y creación de un vector
       //tipo[] nombreVector = new tipo [tamaño]
       
       // declarar un arreglo de una dimension
       int[] vector;
       //crear en memoria(construir/dimensionar) con el valor por defecto(CERO para los enteros)
       vector = new int[2]; //2 es el tamaño
       //los dos pasos en una línea
       int[] producto = new int[3];
       
       //Declaración y creación de una matriz
       //tipo [][] nombreMatriz = new tipo[filas][columnas] 
       
       //declaración e inicialización con valores predeterminados
       int[][] matriz = {{4,8,6},{2,1,7}};//{{primer fila}{segunda fila}}={{i1j1, i1j2, i1j3} {i2j1, i2j2, i2j3}}
       
       //Declaración y creación de arreglos genéricos
       //tipo [][]...[] nombreArreglo = new tipo[cardinalidad 1][cardinalidad 2]...[cardinalidad N]
       
        System.out.println("Ingrese los valores del vector de tamaño"+ vector.length+ ":"); // .length nos devuelve el largo  la cardinalidad de cada una de las dimensiones del arreglo
        Scanner leer = new Scanner(System.in);
        //int = 0, porque los subíndices de los arreglos en Java inician en cero.
        for(int i = 0; i < vector.length;i++){ //el valor es menor y NO menor o igual pq si el largo del vector es N, la última posición del vector es N-1
            System.out.println("v["+ i +"]=");
            //acceder al valor i del vector
            vector[i]=leer.nextInt();
        }
        //Multiplica vector por matriz
        int sum;
        //CARDINALIDAD: El cardinal indica el número o cantidad de les elementos de un conjunto.
        //...para cada columna de la matriz...
        for(int j = 0; j < matriz[0].length;j++){ // el largo no es el tamaño del arreglo(2x3), largo es la cardinalidad, en este caso es 2. (matriz[0].length). En este caso queremos decir que la cardinalidad de nuestra matriz es igual a 3 (3 columnas).
            sum=0;
            //...recorro el vector y multiplico
            for(int i = 0; i < vector.length; i++ ){
                sum += vector[i] + matriz[i][j];
            }
            producto[j] = sum;
        }
        String aux = "";
        //Mostrar vector
        System.out.println("* Vector:");
        // bucle for "mejorado" (enhanced)
        // for (tipo elemento: arreglo)
        for(int elemento: vector){ //en vez de elemento le podemos poner cualquier nombre
            aux = aux + " " + elemento;
        }
        System.out.println(aux);
        
        //Mostrar matriz
        System.out.println("\n* Matriz:");
        //para cada fila de la matriz
        for(int[] fila: matriz){
            aux="";
            //para cada elemento de la fila
            for(int elemento: fila){
                aux += " " + elemento; //el operador += nos permite concatenar sumando el valor que estamos concatenando con la expresion que tenemos a la derecha
            }
            System.out.println(aux);    
        }
        //Mostrar resultado
        aux="";
        System.out.println("\n* Vector x Matriz:");
        for(int elemento : producto ){
            aux += " " + elemento;
            
        }
    }
}
