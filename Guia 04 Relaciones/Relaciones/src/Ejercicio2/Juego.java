package Ejercicio2;

import java.util.ArrayList;
//    Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de
//    Jugadores) y Revolver.
//    Métodos:
//    • llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los
//    jugadores y el revolver para guardarlos en los atributos del juego.
//    • ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
//    aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego,
//    sino se moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se
//    tiene que mojar. Al final del juego, se debe mostrar que jugador se mojó.
//    Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
public class Juego {
    private ArrayList<Jugador> jugadores;
    private Revolver_de_agua revolver;

    public Juego() {
    }

    public Juego(ArrayList<Jugador> jugadores, Revolver_de_agua revolver) {
        this.jugadores = jugadores;
        this.revolver = revolver;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public Revolver_de_agua getRevolver() {
        return revolver;
    }

    public void setRevolver(Revolver_de_agua revolver) {
        this.revolver = revolver;
    }
    
    public void llenarJuego(ArrayList<Jugador>jg, Revolver_de_agua r){
        jugadores = jg;
        revolver= r;
    }
    
    public void ronda(Revolver_de_agua r){
        int cont = 0;
        for (Jugador aux : jugadores) {
            System.out.println("Posicion actual: [" + r.getPosicion_actual() + "]");
            System.out.print("El " + aux.getNombre() + " " + aux.getId() + " se apunta y dispara.");
            if (aux.disparo(r)) {
                System.out.println(" ...Mojado\n");
                break;
            }else{
                System.out.print(" ...se Salvo\n");
                cont++;
            }
        }
        
        if (cont == jugadores.size()) {
            ronda(r);
        }

    }
    
    
    @Override
    public String toString() {
        return "Juego{" + "jugadores=" + jugadores + ", revolver=" + revolver + '}';
    }
    
}
