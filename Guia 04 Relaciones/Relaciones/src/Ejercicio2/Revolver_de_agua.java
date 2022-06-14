package Ejercicio2;
//    2_Realizar el juego de la ruleta rusa de agua en Java. Como muchos saben, el juego se
//    trata de un número de jugadores, que, con un revolver de agua, el cual posee una sola
//    carga de agua, se dispara y se moja. Las clases a hacer del juego son las siguientes:
//    Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual
//    (posición del tambor que se dispara, puede que esté el agua o no) y posición agua (la
//    posición del tambor donde se encuentra el agua). Estas dos posiciones, se generarán
//    aleatoriamente.
//    Métodos:
//    • llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los
//    valores deben ser aleatorios.
//    • mojar(): devuelve true si la posición del agua coincide con la posición actual
//    • siguienteChorro(): cambia a la siguiente posición del tambor
//    • toString(): muestra información del revolver (posición actual y donde está el agua)
public class Revolver_de_agua {
    
    private Integer posicion_actual;
    private Integer posicion_agua;

    public Revolver_de_agua() {
    }

    public Revolver_de_agua(Integer posicion_actual, Integer posicion_agua) {
        this.posicion_actual = posicion_actual;
        this.posicion_agua = posicion_agua;
    }

    public Integer getPosicion_actual() {
        return posicion_actual;
    }

    public void setPosición_actual(Integer posicion_actual) {
        this.posicion_actual = posicion_actual;
    }

    public Integer getPosicion_agua() {
        return posicion_agua;
    }

    public void setPosicion_agua(Integer posicion_agua) {
        this.posicion_agua = posicion_agua;
    }
    
    public Revolver_de_agua llenarRevolver(){
        posicion_actual= (int)(Math.random()*6+1);
        posicion_agua=  (int)(Math.random()*6+1);
        return new Revolver_de_agua(posicion_actual,posicion_agua);
    }
    
    public boolean mojar(){
        return posicion_actual == posicion_agua;
    }
    
    public void siguienteChorro(){
        if (this.posicion_actual == 6){
            this.posicion_actual =1;
        }else{
            this.posicion_actual= posicion_actual+1;
        }
    }

    @Override
    public String toString() {
        return "Revolver_de_agua{" + "posicion_actual=" + posicion_actual + ", posicion_agua=" + posicion_agua + '}';
    }

}
