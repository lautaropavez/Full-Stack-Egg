package POO.MatemmaticaApp;
//    9. Realizar una clase llamada Matemática que tenga como atributos dos números reales
//    con los cuales se realizarán diferentes operaciones matemáticas. La clase deber tener
//    un constructor vacío, parametrizado y get y set. En el main se creará el objeto y se
//    usará el Math.random para generar los dos números y se guardaran en el objeto con
//    su respectivos set. Deberá además implementar los siguientes métodos:
//    • Método devolverMayor() para retornar cuál de los dos atributos tiene el mayor
//    valor.
//    • Método calcularPotencia() para calcular la potencia del mayor valor de la clase
//    elevado al menor número. Previamente se deben redondear ambos valores.
//    • Método calculaRaiz(), para calcular la raíz cuadrada del menor de los dos valores.
//    Antes de calcular la raíz cuadrada se debe obtener el valor absoluto del número.
import java.util.Scanner;


public class MatematicaApp {

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
        ServiceMatematica servicio = new ServiceMatematica();
        
        Matematica mat1 = new Matematica(); 
        
        mat1.setNum1((Math.random()*10));
        mat1.setNum2((Math.random()*10));
        
        System.out.println("Buenos días sus numeros son: ");
        System.out.println("numero 1: " + mat1.getNum1());
        System.out.println("numero 2: " + mat1.getNum2());

        System.out.println("El número más grande es: " + servicio.devolverMayor(mat1));
        System.out.println("La potencia del número " + servicio.devolverMayor(mat1) +" elevado al " + servicio.Menor(mat1) +" es: " + servicio.calcularPotencia(mat1) ); //redondeando ambos numeros
        System.out.println("La potencia (sin redondearlos) del número " + servicio.devolverMayor(mat1) +" elevado al " + servicio.Menor(mat1) +" es: " + servicio.calcularPotenciaaa(mat1) ); //Sin redondear ambos numeros
        System.out.println("La raiz del menor numero (en valor absoluto) es: " + servicio.calculaRaiz(mat1));
        
    }

}
