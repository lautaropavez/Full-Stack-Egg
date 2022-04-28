package Ejercicio4;

import java.util.Comparator;

public class ServiceCine {
   public static Comparator<Cine>OrdDurAsc= new Comparator<Cine>() {
       @Override
       public int compare(Cine t1, Cine t2) {
            return t1.getDuracion().compareTo(t2.getDuracion());   // me anduvo porque en la clase cine tengo que poner Integer en vez de int y en el get tambien.     
       }
   };
 
    public static Comparator<Cine>OrdDurDesc= new Comparator<Cine>() {
        @Override
        public int compare(Cine t, Cine t1) {
            return t1.getDuracion().compareTo(t.getDuracion());
        }
    };
    
    public static Comparator<Cine>Ord_Tit= new Comparator<Cine>() {
        @Override
        public int compare(Cine t, Cine t1) {
            return t.getTitulo().compareTo(t1.getTitulo());
        }
    };
    
    public static Comparator<Cine>Ord_Direct= new Comparator<Cine>() {
        @Override
        public int compare(Cine t, Cine t1) {
            return t.getDirector().compareTo(t1.getDirector());
        }
    };
 
    
    
    
    
    
//--------------------------------------------------------------------------------------------------------------------------------------------
//    public static Comparator<Cine> OrdenarPorDuracionMayor = new Comparator<Cine>() { //Ctrl + space y se autocompleta esto desde los ().
//        @Override
//        public int compare(Cine t1, Cine t2) {
//            return t2.getDuracion().compareTo(t1.getDuracion());
//        }
//    };
    
//    public static Comparator<Perro> compararEdad = new Comparator<Perro>() {
//        @Override
//        public int compare(Perro p1, Perro p2) {
//            return p2.getEdad().compareTo(p1.getEdad());
//        }
//    };
//_-----------------------------------------------------------------------------
    
            
}
