package EjerciciosJava;

/**
 *
 * @author lautaropavez
 */
public class Métodos {
/**
    Método                           Usado      Descripción                                                   
charAt(int index)                               Retorna el carácter especificado en la posición index
equals(String str)                         X    Sirve para comparar si dos cadenas son iguales.
                                                Devuelve true si son iguales y false si no.
equalsIgnoreCase(String str)               X    Sirve para comparar si dos cadenas son iguales,
                                                ignorando la grafía de la palabra. Devuelve true si son iguales y false si no.
compareTo(String otraCadena)                    Compara dos cadenas de caracteres alfabéticamente.
                                                Retorna 0 si son iguales, entero negativo si la primera es
                                                menor o entero positivo si la primera es mayor.
concat(String str)                              Concatena la cadena del parámetro al final de la primera cadena.
contains(CharSequence s)                        Retorna true si la cadena contiene la secuencia tipo char del parámetro.
endsWith(String suffix)                         Retorna verdadero si la cadena es igual al objeto del parámetro
indexOf(String str)                             Retorna el índice de la primera ocurrencia de la cadena del parámetro
isEmpty()                                       Retorna verdadero si la longitud de la cadena es 0
length()                                   X    Retorna la longitud de la cadena
replace(char oldChar, char newChar)             Retorna una nueva cadena reemplazando los
                                                caracteres del primer parámetro con el carácter del
                                                segundo parámetro
split(String regex)                             Retorna un arreglo de cadenas separadas por la cadena
                                                del parámetro
startsWith(String prefix)                       Retorna verdadero si el comienzo de la cadena es igual
                                                al prefijo del parámetro
substring(int beginIndex)                  X    Retorna la sub cadena desde el carácter del parámetro
substring(int beginIndex, int endIndex)    X    Retorna la sub cadena desde el carácter del primer parámetro hasta el carácter del segundo parámetro
toCharArray()                                   Retorna el conjunto de caracteres de la cadena
toLowerCase()                              X    Retorna la cadena en minúsculas
toUpperCase()                              X    Retorna la cadena en mayúsculas

 
METODOS DE CLASE MATH 
abs(double a)                                   Devuelve el valor absoluto de un valor double introducido como parámetro.
abs(int a)                                      Devuelve el valor absoluto de un valor Entero introducido como parámetro.
abs(long a)                                     Devuelve el valor absoluto de un valor long introducido como parámetro.
max(double a, double b)                    X    Devuelve el mayor de dos valores double
max(int a, int b)                          X    Devuelve el mayor de dos valores Enteros.
max(long a, long b)                        X    Devuelve el mayor de dos valores long.
min(double a, double b)                         Devuelve el menor de dos valores double.
min(int a, int b)                               Devuelve el menor de dos valores enteros.
min(long a, long b)                             Devuelve el menor de dos valores long.
pow(double a, double b)                         Devuelve el valor del primer argumento elevado a la potencia del segundo argumento.
random()                                        Devuelve un double con un signo positivo, mayor o igual que 0.0 y menor que 1.0. 
                                                Para generar un número entero entre 0 y 9, hay que escribir la siguiente sentencia:
                                                int numero = (int) (Math.random() * 10);
round(double a)                                 Devuelve el long redondeado más cercano al double introducido.
sqrt(double a)                             X    Devuelve la raíz cuadrada positiva correctamente redondeada de un double.
floor(double a)                                 Devuelve el entero más cercano por debajo.

*/
}
