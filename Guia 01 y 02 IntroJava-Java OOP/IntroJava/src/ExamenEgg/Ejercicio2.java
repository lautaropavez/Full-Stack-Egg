package ExamenEgg;
//    La función recibirá una palabra y deberá devolverla transformada al geringoso.
//
//    Es decir, si la palabra es:
//
//    "Hola"-> "Hopolapa"
//    "Casa"-> "Capasapa"
//    "Perro"-> "Peperropo"
//    "Carpincho"-> "Caparpipinchopo"
//    En síntesis, debemos añadir después de cada vocal las letras p + {{vocal}}, siendo esa vocal igual a la hallada. Por ejemplo, si encontramos la vocal "o", añadiremos la sílaba "po".
//
//    Resultados esperados:
//
//    Si se ingresa la palabra hola deberá devolver hopolapa.
//    Si se ingresa la palabra qwrty deberá devolver qwrty.
//    Si se ingresa la palabra a deberá devolver apa.
//    Si se ingresa la palabra gato deberá devolver gapatopo.
public class Ejercicio2 {
    public String geringoso(String palabra) {
    String resultado = palabra;
    
    resultado = resultado.replaceAll("a","apa").replaceAll("e","epe").replaceAll("i","ipi").replaceAll("o","opo").replaceAll("u","upu");
    return resultado;
    }
}
