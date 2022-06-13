package Ejercicio5_6_7_8;

/**
 * @author Lautaro Pavez
 */
public class Ejercicio5 {

    public static void main(String[] args) {
        
    }
}
//    EJERCICIO 5
//    Dado el método metodoA de la clase A, indique:
//       void metodoA() {
//            sentencia_a1
//            sentencia_a2
//        try {
//            sentencia_a3
//            sentencia_a4
//        } catch (MioException e){
//            sentencia_a6
//        }
//        sentencia_a5
//        }
//    a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción
//        MioException?
//    RTA: 1ro Excepcion1           
//         2do Excepcion2
//         3ro Excepcion6
//
//    b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción
//        MioException?
//     RTA:         1ro sentencia_a1
//                  2do sentencia_a2
//                  3ro sentencia_a3
//                  4do sentencia_a4
//                  5do sentencia_a5
//
//      EJERCICIO 6 
//      Dado el método metodoB de la clase B, indique:
//      a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción 
//          MioException? 
//      RTA:        1ro sentencia_b1
//                  2do sentencia_b3
//                  3ro sentencia_b4
//
//      b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción 
//          MioException? 
//      RTA:        1ro sentencia_b1
//                  2do sentencia_b2
//                  3ro sentencia_b4
//          
//      class B {
//          void metodoB() {
//              sentencia_b1
//                  try {
//                      sentencia_b2
//                  } catch (MioException e){ 
//                      sentencia_b3 
//                  }
//                  finally
//                      sentencia_b4
//                  }
//      }   
//
//EJERCICIO 8
//8. Dado el método metodoC de la clase C, indique:
//a) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción MioException?
//RT:   1ro sentencia_c1
//      2do sentencia_c4
//      3ro sentencia_c6  
//b) ¿Qué sentencias y en qué orden se ejecutan si no se produce la excepción MioException?
//RT:   1ro sentencia_c1
//      2do sentencia_c2
//      3ro sentencia_c3
//      4to sentencia_c6
//c) ¿Qué sentencias y en qué orden se ejecutan si se produce la excepción TuException?
//RT:   1ro sentencia_c1
//      2do sentencia_c5
//      3ro sentencia_c6  

//  class C {
//      void metodoC() throws TuException{
//          sentencia_c1
//              try {
//                  sentencia_c2
//                  sentencia_c3
//              } catch (MioException e){
//                  sentencia_c4
//              } catch (TuException e){
//                  sentencia_c5
//              throw (e)
//              }
//              finally
//                  sentencia_c6
//              }
//      }