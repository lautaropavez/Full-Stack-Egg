package POO.Ejercicio11;
import java.util.Date;
import java.util.Scanner;
//  11.Pongamos de lado un momento el concepto de POO, ahora vamos a trabajar solo con
//  la clase Date. En este ejercicio deberemos instanciar en el main, una fecha usando la
//  clase Date, para esto vamos a tener que crear 3 variables, dia, mes y anio que se le
//  pedirán al usuario para poner el constructor del objeto Date. Una vez creada la fecha
//  de tipo Date, deberemos mostrarla y mostrar cuantos años hay entre esa fecha y la
//  fecha actual, que se puede conseguir instanciando un objeto Date con constructor
//  vacío.
//  Ejemplo fecha: Date fecha = new Date(anio, mes, dia);
//  Ejemplo fecha actual: Date fechaActual = new Date();
public class EjercicioDate {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        Date fecha_actual = new Date();
        
        System.out.println("Ingrese el año: ");
        int year = leer.nextInt();
        year -= 1900;
        System.out.println("Ingrese el mes: ");
        int mes = leer.nextInt();
        mes -= 1;
        System.out.println("Ingrese el dia: ");
        int dia = leer.nextInt();
        System.out.println("Ingrese la hora: ");
        int hora = leer.nextInt();
        System.out.println("Ingrese los minutos: ");
        int minutos = leer.nextInt();
        System.out.println("Ingrese los segundos: ");
        int segundos = leer.nextInt();
        
        
        Date fecha_usuario = new Date(year,mes,dia,hora,minutos,segundos); 
        System.out.println("<<<<<  FECHA ACTUAL >>>>>" + fecha_actual);
        System.out.println("<<<<<  FECHA INGRESADA >>>>>" + fecha_usuario);
        
        int diferencia_fechas = fecha_actual.getYear() - fecha_usuario.getYear();
        System.out.println("Hay " + diferencia_fechas +" anios de diferencia de la fecha actual. "   );
        
    }

}
