package Animal;
//ESTA EL MISMO EJERCICIO HECHO POR LA PROFESORA EN EL PROYECTO CLASE ABSTRACTA.
import Animales.Perro;
import Animales.Gato;
import Animales.Caballo;

public class Animales {

    public static void main(String[] args) {
       
        //Declaración del objeto PERRO
        Perro perro = new Perro("Stich","Carnivoro",15,"Doberman");
        perro.alimentarse();
        //Declaración de otro objeto PERRO
        Perro perro1 = new Perro("Jorgito","Croquetas",5,"Chihuahua");
        perro1.alimentarse();
        //Declaración del objeto GATO      
        Gato gato = new Gato("Pelusa","Galletas",10,"Siames");
        gato.alimentarse();
        //Declaración del objeto CABALLO
        Caballo caballo = new Caballo("Trueno","Pasto",20,"Fino");
        caballo.alimentarse();
        

    }

}
