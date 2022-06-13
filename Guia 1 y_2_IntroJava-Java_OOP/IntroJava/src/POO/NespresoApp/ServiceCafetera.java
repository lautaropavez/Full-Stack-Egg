package POO.NespresoApp;

import java.util.Scanner;
//  6. Programa Nespresso. Desarrolle una clase Cafetera con los atributos
//  capacidadMaxima (la cantidad máxima de café que puede contener la cafetera) y
//  cantidadActual (la cantidad actual de café que hay en la cafetera). Implemente, al
//  menos, los siguientes métodos:
//  • Constructor predeterminado o vacío
//  • Constructor con la capacidad máxima y la cantidad actual
//  • Métodos getters y setters.
//  • Método llenarCafetera(): hace que la cantidad actual sea igual a la capacidad
//  máxima.
//  • Método servirTaza(int): se pide el tamaño de una taza vacía, el método recibe el
//  tamaño de la taza y simula la acción de servir la taza con la capacidad indicada. Si la
//  cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede. El
//  método le informará al usuario si se llenó o no la taza, y de no haberse llenado en
//  cuanto quedó la taza.
//  • Método vaciarCafetera(): pone la cantidad de café actual en cero.
//  • Método agregarCafe(int): se le pide al usuario una cantidad de café, el método lo
//  recibe y se añade a la cafetera la cantidad de café indicada.
public class ServiceCafetera {
    
    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    Cafetera cf = new Cafetera();
    
    private Cafetera crearCafetera(){
        
        System.out.println("Buenos días.");
        int capacidadMaxima = 0;
        int cantidadActual = 0;
        
        do{
            
            System.out.println("Ingrese la capacidad máxima de café de la cafetera: ");
            capacidadMaxima = leer.nextInt();
        }while(capacidadMaxima <= 0);
        
        do{
            
            System.out.println("Ingrese la cantidad actual de café que hay en la cafetera: ");
            cantidadActual = leer.nextInt();
        
            if(cantidadActual > capacidadMaxima){
                System.out.println("Capacidad máxima superada, la cafetera se rebalsará.");
                System.out.println("Ingrese nuevamente su cantidad actual.");
            }  
        }while((cantidadActual > capacidadMaxima) || (cantidadActual < 0));
        
        if((cantidadActual>0) && (cantidadActual == capacidadMaxima)){
            System.out.println("Su cafetera se encuentra llena de café. :) ");
        }
        
        cf.setCapacidadMaxima(capacidadMaxima);
        cf.setCantidadActual(cantidadActual);
        
        return cf;
    }
    
    // Método llenarCafetera(): hace que la cantidad actual sea igual a la capacidad máxima.
    private void llenarCafetera(Cafetera cf) {
        
        if( cf.getCantidadActual() == cf.getCapacidadMaxima()){
            System.out.println("Su cafetera ya está llena de café.");
        }else{
           cf.setCantidadActual(cf.getCapacidadMaxima());   
           System.out.println("Se lleno por completo la cafetera.");
        } 
    }
    
    /** Simula la acción de servir la taza con la capacidad indicada. Si la cantidad actual 
     *  de café “no alcanza” para llenar la taza, se sirve lo que quede. El método le 
     *  informará al usuario si se llenó o no la taza, y de no haberse llenado en cuanto quedó la taza.
     * @param cf
     */
    private void servirTaza(Cafetera cf){
        
        System.out.println("Ingrese el tamaño de la taza: ");
        int tam_taza = leer.nextInt();
        
        System.out.println("Sirviendo...");
        int calculo = (tam_taza - cf.getCantidadActual());
        
        if (tam_taza>cf.getCantidadActual()){
            System.out.println("No se pudo llenar la taza de cafe, ya que la cantidad de cafe que quedaba era: " + cf.getCantidadActual());
            System.out.println("Faltaron " + calculo + " ml. para llenarla.");
            cf.setCantidadActual(0);
            
        }else if(cf.getCantidadActual() == tam_taza ){
            System.out.println("Se lleno su taza.");
            cf.setCantidadActual(cf.getCantidadActual() - tam_taza );
            System.out.println("La cafetera quedo con una cantidad actual de " + cf.getCantidadActual() + " ml. de café");
        }else{
            System.out.println("La taza se lleno completamente");
            cf.setCantidadActual(cf.getCantidadActual() - tam_taza );
            System.out.println("La cafetera quedo con una cantidad actual de " + cf.getCantidadActual() + " ml. de café");    
        }
    }  
    
    /** pone la cantidad de café actual en cero.
     * @param cf
     */
    private void vaciarCafetera(Cafetera cf ){
        cf.setCantidadActual(0);
        System.out.println("Su cafetera ahora tiene " + cf.getCantidadActual() + " ml. de cafe");
        System.out.println("Se encuentra completamente vacía.");  
    }
    
    /** Método agregarCafe(int): se le pide al usuario una cantidad de café, el 
     * método lo recibe y se añade a la cafetera la cantidad de café indicada.
     * @param cf
     */  
    private void agregarCafe(Cafetera cf ){
        int cantidad = 0; 
        int Carga = 0;
        int cantAntesCarga = 0;
        do{
           System.out.println("Ingrese la cantidad de café que desea agregar: ");
           cantidad = leer.nextInt();
           cantAntesCarga =cf.getCantidadActual() ;
           Carga = cf.getCantidadActual() + cantidad;
           if(Carga > cf.getCapacidadMaxima()){
              System.out.println(" [ ERROR ]");
              System.out.println("La cantidad ingresada supera a la capacidad máxima de la cafetera.");
              System.out.println("La cantidad actual es: " + cf.getCantidadActual());
	      System.out.println("La cantidad maxima es: " + cf.getCapacidadMaxima());
            }  
        }while(Carga > cf.getCapacidadMaxima());
        
        if(Carga < cf.getCapacidadMaxima()){
            System.out.println("Se han cargado " + cantidad + " ml. de café.");
            cf.setCantidadActual(cf.getCantidadActual() + cantidad);
            System.out.println("La cantidad actual de su cafetera es de " + cf.getCantidadActual() + " ml. de café.");
        } else{ // (Carga == capacidadMaxima)
            cf.setCantidadActual(cf.getCantidadActual() + cantidad);
            System.out.println("Su cafetera se ha llenado.");
            System.out.println("Usted tenia "+ cantAntesCarga + " ml. y se le ha cargado " + cantidad + " ml. de café.");
            System.out.println("La cantidad actual de su cafetera es de " + cf.getCantidadActual() + " ml. de café.");
        }
        
        
     }
    
    private void mostrarMenu(){
        System.out.println("----------------- MENÚ -----------------\n"
                + "1) - Llenar cafetera \n"
                + "2) - Servir taza \n"
                + "3) - Vaciar cafetera \n"
                + "4) - Agregar café \n"
                + "5) - Salir \n"
                + "-------- Elija una opción --------");          
    }
    
    private int elegirOpcion(){
        int sel;
        
        do{
           sel = leer.nextInt();
           if(sel<1 || sel>5){
               System.out.println("Selección inválida. Intente nuevamente"); 
           }
        }while(sel<1 || sel>5);
        
        return sel;
    }
    
    public void ejecutarMenu(){
        Cafetera cff = crearCafetera(); //Como estoy adentro de la clase Servicio no necesito crear instanciar un servicio nuevo
        mostrarMenu();
        int sel = 0;
        
        do{
            sel = elegirOpcion();
           
            switch(sel){
                case 1:
                    llenarCafetera(cff);
                    break;                      // Le pude haber pasado en la linea de arriba en los parametros de la llamada al metodo ingresar dinero directamente el valor (ej:1000) en vez de "ingreso". 
                case 2:
                    servirTaza(cff);
                    break;
                case 3:
                    vaciarCafetera(cff);
                    break;
                case 4:
                    agregarCafe(cff);
                    break;
                case 5:       
                   System.out.println("Hasta luego. Vuelvas prontos");
                   break; //no necesito un default que es para cuando la seleccion no esta entre 1 y 6 porque directamente lo hice en la linea 115;      
                         
            }
            
            if(sel != 5 ){
                System.out.println("");
                mostrarMenu();
                System.out.println("");
            }
        }while(sel != 5); //distinto de 6 porque en el menu el 6 es "salir"
    }
}
