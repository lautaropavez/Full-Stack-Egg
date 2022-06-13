package Ejercicio5;
//import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;
// 5_ Se requiere un programa que lea y guarde países, y para evitar que se ingresen
//    repetidos usaremos un conjunto. El programa pedirá un país en un bucle, se
//    guardará el país en el conjunto y después se le preguntará al usuario si quiere
//    guardar otro país o si quiere salir, si decide salir, se mostrará todos los países
//    guardados en el conjunto.
//    Después deberemos mostrar el conjunto ordenado alfabéticamente para esto
//    recordar como se ordena un conjunto.
//    Y por ultimo, al usuario se le pedirá un país y se recorrerá el conjunto con un
//    Iterator, se buscará el país en el conjunto y si está en el conjunto se eliminará el
//    país que ingresó el usuario y se mostrará el conjunto. Si el país no se encuentra
//    en el conjunto se le informará al usuario.
public class Paises {
    //HashSet<String> nombres = new HashSet();
    private Scanner leer;
    private TreeSet<String> pais;
    
    public Paises() {
        this.pais = new TreeSet();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }

////    public TreeSet<String> getPais() {
////        return pais;
////    }
////
////    public void setPais(TreeSet<String> pais) {
////        this.pais = pais;
////    }

    public void guardarpais() {
        int respuesta;
        do {
            System.out.println("Ingresar pais");
            String aux = leer.next();
            String mostrar = aux;
            pais.add(mostrar);
            System.out.println("Desea ingresar otro pais? 1)SI 2)NO");
            respuesta = leer.nextInt();
        } while (respuesta == 1);
    }

    public void mostrar() {
        System.out.println("--Los paises agregados son--");
        System.out.println(pais);
        System.out.println("\n<<<<< PAISES ORDENADO ALFABETICAMENTE >>>>>");
        ArrayList<String> orden = new ArrayList(pais);
        Collections.sort(orden);
        System.out.println(orden);

    }

    public void borrar() {
        System.out.println("\n<<<<< BORRAR PAISES >>>>>");
        System.out.println("Ingrese el país que desea eliminar: ");
        String borrar = leer.next();

        Iterator<String> it = pais.iterator();
        while (it.hasNext()) { 
            String aux = it.next();
            if (aux.equals(borrar)) {
                it.remove();
            }
        }

        if (pais.contains(borrar)) {
            System.out.println("Pais " + borrar + " borrado.");
        } else {
            System.out.println("El Pais ingresado no se encuentra");
        }
        System.out.println("");
        System.out.println("Los paises que hay son: ");
        System.out.println(pais);
        System.out.println("");

    }
    
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.pais);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Paises other = (Paises) obj;
        if (!Objects.equals(this.pais, other.pais)) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "Paises{" + "pais = " + pais + '}';
    }
    
    
}

