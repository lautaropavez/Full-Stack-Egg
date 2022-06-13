package introjava;

import java.util.Scanner;

public class UdemyConversiondeTipos {

    public static void main(String[] args) {
//       int edad = Integer.parseInt("20");
//        System.out.println("edad = " + edad);
//       double valorPI = Double.parseDouble("3.1416");
//        System.out.println("valorPI = " + valorPI);
//        
//        //pedir un valor
          Scanner entrada = new Scanner(System.in);
//        System.out.println("Proporciona tu edad: ");
//        edad = Integer.parseInt(entrada.nextLine());
        
//        String edadTexto = String.valueOf(10);
//        System.out.println("edadTexto = " + edadTexto+" 100");
//        
//        Si queremos solicitar solo un caracter y asignarlo a la variable char debemos hacer:
          char caracter = "hola".charAt(0);// esta variable ya nos quedaria de tipo char
          System.out.println("caracter = " + caracter);
          
          System.out.println("Proporciona un caracter: ");
          caracter = entrada.nextLine().charAt(0);
          System.out.println("caracter = " + caracter);
    }

}
