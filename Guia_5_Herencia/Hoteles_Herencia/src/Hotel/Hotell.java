package Hotel;
import hoteles.Hotel;
import hoteles.Hotel1;
import hoteles.Hotel2;
import hoteles.Hotel3;
import hoteles.Hotel4;
import hoteles.Hotel5;
import java.util.ArrayList;
import java.util.List;

public class Hotell {

    public static void main(String[] args) {
        
       List<Hotel> hoteles = new ArrayList();
       
       Hotel1 h1 = new Hotel1(1500d,9d,10); // Le ponemos la d minuscula porque es el tipo de dato Double, lo mismo si fuera FLOAT le ponemos una f minuscula
       Hotel2 h2 = new Hotel2(2500d,9d,15);
       Hotel3 h3 = new Hotel3(3500d,15d,20);
       Hotel4 h4 = new Hotel4(5000d,20d,30);
       Hotel5 h5 = new Hotel5(10000d,30d,50);
       
       hoteles.add(h1);
       hoteles.add(h2);
       hoteles.add(h3);
       hoteles.add(h4);
       hoteles.add(h5);
       
       // Si yo pongo if + CTRL + Space, voy al 3er if y nos trae este if. Este if nos va a decir en base a que nació en jerarquía. En este caso tenemos que interpretar
       // de la cadena jerarquica del eslabon más chico(nieto,sobrino,etc) para arriba. VIDEO 2  
       for(Hotel aux: hoteles){
           if (aux instanceof Hotel5) { // Si el elemento que recorro fue instanciado al elemento Hotel5, entra al if
               Hotel5 object = (Hotel5) aux; 
               System.out.println("Soy Hotel 5");
               continue;
           }
           
           if (aux instanceof Hotel4) { 
               Hotel4 object = (Hotel4) aux; 
               System.out.println("Soy Hotel 4");
               continue;
           }
           
           if (aux instanceof Hotel3) { 
               Hotel3 object = (Hotel3) aux; 
               System.out.println("Soy Hotel 3");
               continue;
           }
           
           if (aux instanceof Hotel2) { 
               Hotel2 object = (Hotel2) aux; 
               System.out.println("Soy Hotel 2");
               continue;
           }
           
           if (aux instanceof Hotel1) { 
               Hotel1 object = (Hotel1) aux; 
               System.out.println("Soy Hotel 1");
               continue;
           }
           
       }

    }

}
