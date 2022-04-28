package colecciones;

import java.util.ArrayList;

public class Colecciones {

    public static void main(String[] args) {
        
       String[] nombresArray = new String[5];
       
        for(int i = 0; i < nombresArray.length; i++) {
            nombresArray[i] = "Pedro " + (i + 1);
        }
        
        for (String var : nombresArray) {
            System.out.println(var);
        }
        
        System.out.println("----------------------------------------------------");
        
        //Collections
        
        System.out.println("COLLECTIONS");
        
        ArrayList<String> nombresArrayList = new ArrayList(); //Si nos olvidamos de poner -> new ArrayList() nos va a tirar error el programa porque no existiria
        
        nombresArrayList.add("Peter"); // .add Agrega un objeto.
        nombresArrayList.add("Peter");
        nombresArrayList.add("Peter");
        
        for (String var : nombresArrayList) {
            System.out.println(var);
        }
        
        System.out.println("La dimension del ArrayList es de " + nombresArrayList.size()); // Ponemos el nombre de las variables(nombresArrayList) + .(punto) y tenemos todos los métodos que tienen los ArrayList
        
        nombresArrayList.add("Jorge");
        
        for (String var : nombresArrayList) {
            System.out.println(var);
        }
        
        System.out.println("La dimension del ArrayList es de " + nombresArrayList.size());
        
        nombresArrayList.remove("Peter"); //remueve un objeto
        
        for (String var : nombresArrayList) {
            System.out.println(var);
        }
        
        System.out.println("La dimension del ArrayList es de " + nombresArrayList.size());
    }
}
