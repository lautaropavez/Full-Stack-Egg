package Ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;
//    3_Crear una clase llamada Alumno que mantenga información sobre las notas de
//    distintos alumnos. La clase Alumno tendrá como atributos, su nombre y una lista
//    de tipo Integer con sus 3 notas.
//    En el main deberemos tener un bucle que crea un objeto Alumno. Se pide toda la
//    información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
//    pregunta al usuario si quiere crear otro Alumno o no.
//    Despues de ese bluce tendremos el siguiente método en la clase Alumno:
//    Metodo notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular
//    su nota final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al
//    método. Dentro del método se usará la lista notas para calcular el promedio final
//    de alumno. Siendo este promedio final, devuelto por el método y mostrado en el
//    main.

public class AlumnoApp {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Alumno datos = new Alumno();
        ArrayList<Alumno> lista = new ArrayList();
        
        String verif;
        
        do {
            Alumno Datos_Creados = datos.Crear();
            lista.add(Datos_Creados);
            System.out.println("¿Desea guardar otro alumno?(S/N)");
            verif = leer.next().toUpperCase();
        } while (verif.equals("S"));
        
        lista.forEach((a) -> System.out.println(a));
        
        System.out.println("");
        System.out.println("<<<<< PROMEDIOS >>>>>");
        System.out.println("Ingrese el nombre: ");
        
        String Name = leer.next().toUpperCase();
        double Promedio = 0;
        
        for (Alumno aux : lista) {
            
            if (Name.equals(aux.getNombre())) {
                Promedio = aux.notaFinal(Name);
                System.out.println("Promedio:" + Promedio);
            }
        }
        
    }

    public AlumnoApp() {
    }

}
