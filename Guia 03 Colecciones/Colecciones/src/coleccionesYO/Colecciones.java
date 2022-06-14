package coleccionesYO;

import java.util.ArrayList;

public class Colecciones {

    public static void main(String[] args) {

        String[] nombresArray = new String[5];

        for (int i = 0; i < nombresArray.length; i++) {
            nombresArray[i] = "Suertudo " + (i + 1);
        }

        for (String var : nombresArray) {
            System.out.println(var);
        }
        
        System.out.println("---------------------COLLECTIONS-------------------------------");//Collections
        
        ArrayList<String> nombresArrayList = new ArrayList();
        
        nombresArrayList.add("Jorge");
        nombresArrayList.add("Pedro");
        nombresArrayList.add("Maria");
        
        for (String var : nombresArrayList) {
            System.out.println(var);
        }
        
        nombresArrayList.remove("Pedro");
        
        System.out.println("------------------");
        
        for (String var : nombresArrayList) {
            System.out.println(var);
        }
        
    }

}
