package introjava;

import java.util.Scanner;

public class EncuestasCondicionalesVideo {

    public static void main(String[] args) {

        int opinion;
        Scanner leer = new Scanner(System.in);
        System.out.println("Clasifique la pelicula de 1 a 5 estrellas:");
        opinion = leer.nextInt();
        if (opinion >= 1 && opinion <= 5) {
            switch (opinion) {
                case 1:
                case 2:
                    System.out.println("Nos sentimos apenadoos de que no hayas disfrutado la peli...");
                    break;
                case 3:
                    System.out.println("Has calificado la peli como buena...");
                    break;
                case 4:
                    System.out.println("Has calificado la peli como muy buena!");
                    break;
                case 5:
                    System.out.println("Fantastico que hayas disfrutado un excelente entretenimiento!!");
                    break;
                //El equivalente al caso "De otro modo" en Java es el "default"
                // default:
                //   <<acciones>>
            }
        } else if (opinion < 0) {
            System.out.println("¿Tan mala fue la pelicula?");
        } else if (opinion == 0) {
            System.out.println("El valor " + opinion + " no es válido. :(");
        } else {
            System.out.println(opinion + "Wow se te fue la mano con la opinión. :D ");
        }
        System.out.println("¡Hasta la próxima!");
    }

}
