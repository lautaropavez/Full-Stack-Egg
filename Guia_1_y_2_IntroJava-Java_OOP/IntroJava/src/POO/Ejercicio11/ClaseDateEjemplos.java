package POO.Ejercicio11;

import java.util.Date;

public class ClaseDateEjemplos {

    public static void main(String[] args) {
       ///////////////////////////////////////
       //////////////CLASE DATE///////////////
       ///////////////////////////////////////
       
       // La clase Date tiene 2 constructores:
       Date fecha1 = new Date();   // * 1 por defecto --> Representa el momento en el que se está ejecutando el programa
       Date fecha2 = new Date(9999900055555L);   // * 2 Manual --> Indicamos la fecha con un valor long en milisegundos que fecha quiero representar
       // Si tocamos Ctrl en la clase Date nos lleva al constructor y dice que comienza a contar los milisegundos a partir del 1 de enero de 1970,
       // Por lo que para representar la fecha 8 de sept a las 20:00 hs le paso ese valor long que metí 
       
       // Método toString = Retorna la fecha en una cadena de caracteres./Returns the date in a character string.
       String descripcionFecha1 = fecha1.toString();
       System.out.println(descripcionFecha1);
       
       String descripcionFecha2 = fecha2.toString();
       System.out.println(descripcionFecha2);
       
       // Método after = Retorna verdadero si la fecha está después de la fecha del parámetro/Returns true if the date is after the parameter date
       
       if(fecha1.after(fecha2)){
           System.out.println("La fecha 1 es posterior a la fecha 2.");
       }else{
           System.out.println("La fecha 1 es anterior a la fecha 2.");
       }
       
       // Método before = Retorna verdadero si la fecha está antes de la fecha del parámetro/Returns true if the date is before the parameter date
       if(fecha2.before(fecha1)){
           System.out.println("La fecha 2 es anterior a la fecha 1.");
       }else{
           System.out.println("La fecha 2 es posterior a la fecha 1.");
       }
       
       // Método getTime = Retorna la fecha en milisegundos/Returns the date in milliseconds
       long milisegundoFecha1 = fecha1.getTime();
       System.out.println("La cantidad de milisegundos de la fecha 1 es: " + milisegundoFecha1);
       long milisegundoFecha2 = fecha2.getTime();
       System.out.println("La cantidad de milisegundos de la fecha 2 es: " + milisegundoFecha2);
       
       // Método equals = Retorna verdadero si la fecha es igual a la del objeto del parámetro/Returns true if the date is equal to that of the parameter object.
        if (fecha1.equals(fecha2)){
            System.out.println("Las fechas son iguales.");
        }else{
            System.out.println("Las fechas son diferentes.");
        }
        
        //Método setTime = Asigna la fecha en milisegundos, permite setear milisegundos a un atributo de tipo fecha posterior a haber sido creado
        fecha2.setTime(milisegundoFecha1);
        if (fecha1.equals(fecha2)){
            System.out.println("Las fechas son iguales");
        }else{
            System.out.println("Las fechas son diferentes.");    
        }
        
    }

}
