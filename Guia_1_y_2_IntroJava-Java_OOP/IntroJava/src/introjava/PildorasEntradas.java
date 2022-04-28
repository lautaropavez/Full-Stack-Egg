package introjava;

import javax.swing.JOptionPane;

public class PildorasEntradas {

    public static void main(String[] args) {
        
       String Nombre_Usuario = JOptionPane.showInputDialog("Introduce tu nombre por favor");
       
        String edadUsuario = JOptionPane.showInputDialog("Introduce tu edad");
        
        int edad = Integer.parseInt(edadUsuario);
        
        System.out.println("edad = " + (edad+1));
        System.out.println("Nombre_Usuario = " + Nombre_Usuario);
        
        
        double x = 10000.0;
        System.out.printf("%1.2f",x/3);// printF tiene dos parámtros, 1° el formato que le tiene que aplicar al valor numérico y el 2° es el valor numérico. el 2 que esta en 1.2 del primer parametro es porque queremos que salga el numero con dos decimales, si en vez de 2 pongo 4 me devuelve un nro con 4 decimales.
        
        String num_1 = JOptionPane.showInputDialog("Introduce un nro: ");
        Double num_2 = Double.parseDouble(num_1);
        System.out.println("La raiz cuadrada de: "+num_2+" es ");
        System.out.printf("%1.2f",Math.sqrt(num_2));
    }

}
