package introjava;

/**
 * @author Lautaro Pavez
 */
public class EjemploMathRandom {

    public static void main(String[] args) {
       //100 numeros reales entre 1 y 11 sin contar el 11
       for(int i=1; i<=100; i++){
          double aleatoria = (Math.random()*10)+1;
           System.out.println(aleatoria);
       }
       //100 numeros entre 1 y 20 enteros 
       for(int i=1; i<=100; i++){
          int aleatoria = (int)(Math.random()*20)+1;
           System.out.println(aleatoria);
       }
    }
    

}
