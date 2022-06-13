package POO;

public class UsoAuto {

    public static void main(String[] args) {
       //vamos a instanciar una clase
       Auto Renault = new Auto(); //INSTANCIAR UNA CLASE. EJEMPLAR DE LA CLASE 1° nombre de la clase a la que pertenecen. 2° nombre del objeto (Renault) 3°signo igual(=) 4° new 5°Nombre del constructor con parentesis. 
       //Renault.largo= 300; Esto NO está permitido porque esa propiedad está encapsulada con el modificador de accezo private y eso hace que solo se pueda acceder a esta propiedad desde el método correspondiente
       System.out.println(Renault.Dime_Largo()); 
       //System.out.println("Este auto tiene:" + Renault.ruedas + " ruedas."); //Renault es un objeto perteneciente a la clase coche/auto.
    }

}
