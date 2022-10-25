package EjerciciosJava;
/** 28_Dadas dos matrices cuadradas de números enteros, la matriz M de 10x10 y la matriz
 *  P de 3x3, se solicita escribir un programa en el cual se compruebe si la matriz P está
 *  contenida dentro de la matriz M. Para ello se debe verificar si entre todas las
 *  submatrices de 3x3 que se pueden formar en la matriz M, desplazándose por filas o
 *  columnas, existe al menos una que coincida con la matriz P. En ese caso, el
 *  programa debe indicar la fila y la columna de la matriz M en la cual empieza el
 *  primer elemento de la submatriz P.
*/
public class Ejercicio28 {

    public static void main(String[] args) {
        
        int [] [] matriz = {
        {1, 26, 36, 47, 5, 6, 72, 81, 95, 10},
        {11, 12, 13, 21, 41, 22, 67, 20, 10, 61},
        {56, 78, 87, 90, 9, 90, 17, 12, 87, 67},
        {41, 87, 24, 56, 97, 74, 87, 42, 64, 35},
        {32, 76, 79, 1, 36, 5, 67, 96, 12, 11},
        {99, 13, 54, 88, 89, 90, 75, 12, 41, 76},
        {67, 78, 87, 45, 14, 22, 26, 42, 56, 78},
        {98, 45, 34, 23, 32, 56, 74, 16, 19, 18},
        {24, 67, 97, 46, 87, 13, 67, 89, 93, 24},
        {21, 68, 78, 98, 90, 67, 12, 41, 65, 12}};
    
        int[][] patron = {
            {36,5,67}, 
            {89,90,75}, 
            {14,22,26}};
        buscarPatron( matriz, patron);
        }
    public static void buscarPatron(int[][] matriz, int[][] patron){
        
        boolean aux;
        
        for (int i = 0; i < matriz.length - 2; i++) {
            for (int j = 0; j < matriz.length - 2; j++) {
                
                aux = true;
                
                for (int k = 0; k < patron.length; k++) {
                    for (int l = 0; l < patron.length; l++) {
//                        System.out.println("i:"+ i +". j:"+ j +". k:"+ k +". l:"+ l); paso realizado para ver el funcionamiento de la función.
//                        System.out.println("matriz ["+ i +"+" + k +"] ["+ j +"+"+ l +"] = patron ["+ k +"]  [" + l +"]");
                        if (matriz[ i + k ][ j + l ] != patron[k][l] ){
                            aux = false;
                            break;
                        }
                    }
                }
                
                if(aux){
                    System.out.println("Se encontró el patrón en la fila "+ i +" y columna "+ j +".");
                    return;//a pesar de ser un método void, en los cuales no se pueden devolver un valor con el return, nos sirve el mismo para que corte el método ahi y no siga.
                }
            }    
        }
        System.out.println("[¡¡ERROR!!] No se encontraron coincidencias");
    }
    }
