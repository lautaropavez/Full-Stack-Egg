package POO;

import java.util.*;
/**
 * @author Lautaro Pavez
 */
public class UsoEmpleado {

    public static void main(String[] args) {
       
       /*
       Empleado empleado1 = new Empleado("Esteban Quito",15000,1990,12,17);
       Empleado empleado2 = new Empleado("Roberto Marolio",86000,1964,2,7);
       Empleado empleado3 = new Empleado("Eltu Maa",150000,1998,1,30);
       
       empleado1.subeSueldo(5); // Le subimos un 5% de sueldo al empleado
       empleado1.subeSueldo(10); // Le subimos un 10% de sueldo al empleado
       empleado1.subeSueldo(7); // Le subimos un 7% de sueldo al empleado
       
       System.out.println("Nombre: " + empleado1.getNombre() + ". Sueldo: " + empleado1.getSueldo() +
               ". Fecha de alta: " + empleado1.getAltaContrato());
        
       System.out.println("Nombre: " + empleado2.getNombre() + ". Sueldo: " + empleado2.getSueldo() +
               ". Fecha de alta: " + empleado2.getAltaContrato());
        
       System.out.println("Nombre: " + empleado3.getNombre() + ". Sueldo: " + empleado3.getSueldo() +
               ". Fecha de alta: " + empleado3.getAltaContrato());
       */
       
       Empleado[] misEmpleados = new Empleado[3];
       
       misEmpleados[0] = new Empleado("Paco Gomez",85000,1990,12,7);
       misEmpleados[1] = new Empleado("Estela Miro",67000,1973,2,23);
       misEmpleados[2] = new Empleado("Javier Gutierrez",105000,1998,1,2);
       
       /* for (int i = 0; i < 3; i++) {
            misEmpleados[i].subeSueldo(5); //for para subir el sueldo 5%
        }
       */
       
        for (Empleado e : misEmpleados) { //for each sube sueldo
             e.subeSueldo(5);
        }
        
        for (Empleado e : misEmpleados) {
            System.out.println("Nombre: " + e.getNombre() + ". Sueldo: " 
            + e.getSueldo() + ". Fecha de Alta: " + e.getAltaContrato());
        }
       
       
        /*for (int i = 0; i < 3; i++) {
            System.out.println("Nombre: " + misEmpleados[i].getNombre() + ". Sueldo: " 
            + misEmpleados[i].getSueldo() + ". Fecha de Alta: " + misEmpleados[i].getAltaContrato());
        }
        */
       
    }
}

class Empleado{ // solo una de las clases puede ser publica
    
     public Empleado(){
         
     }
    
    public Empleado(String nom,double sue, int annio, int mes, int dia){
        nombre = nom;
        sueldo = sue;
        GregorianCalendar calendula = new GregorianCalendar(annio, mes-1, dia);
        altaContrato = calendula.getTime(); //Este es un MÉTODO preestablecido por la API de Java perteneciente a la clase Gregoriancalendar heredado de la clase calendario que me devuelve la fecha en tipo Date
    }

    public String getNombre() {
        return nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public Date getAltaContrato() {
        return altaContrato;
    }


 public void subeSueldo(double porcentaje){
     double aumento = sueldo * (porcentaje/100);
     sueldo += aumento;
 } 
    
    private String nombre;
    private double sueldo;
    private Date altaContrato;
    
}