package POO;

import java.util.Scanner;

public class UsoAuto2 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
       //VOLVEMOS A HACER UNA CLASE CON MAIN, PARA VER QUE OTRAS COSAS PODEMOS PEDIR Y PRACTICARLAS DESDE CERO.
       Auto miAuto = new Auto();
       
       //miAuto.establece_color();   //nombre de objeto o nombre de instancia + .(punto) + método
       
       //System.out.println(miAuto.Dime_Color()); //Porque pone en el sout dime color en vez de establece color? Porque primero llama al método setter para saber cual es el color y en el sout al getter que es el que nos devuelve el valor de esa proopiedad
       
       System.out.println(miAuto.dime_datos_generales());
       
       System.out.println("Diga el color del coche: ");
       miAuto.establece_color(leer.nextLine());  //Llamada al método establece_color y le pasamos el valor "amarillo" al parámetro color de coche;
       System.out.println(miAuto.Dime_Color() );
       
       //miAuto.color="rosa";               //Si no tuvieramos la variable color en la clase Auto encapsulada, está sería la manera de cambiarle los datos, en vez de llamarla como está arriba pero ESTO NUNCA DEBE PASAR.
       
       System.out.println("¿Tiene asientos de cuero? ");
       miAuto.configura_asientos(leer.nextLine());
       
       System.out.println(miAuto.dime_asientos());
       
       System.out.println("¿Tiene climatizador? ");
       miAuto.configura_climatizador(leer.nextLine());
       
       System.out.println(miAuto.dime_climatizador());
       
       System.out.println(miAuto.dime_pesocoche()); //no hace falta establecerlo porque este método hace las dos cosas a la vez
        
       System.out.println("El precio final del auto es: "+ miAuto.precio_coche());
    }   
}
