package POO.MatemmaticaApp;
//    9. Realizar una clase llamada Matemática que tenga como atributos dos números reales
//    con los cuales se realizarán diferentes operaciones matemáticas. La clase debe tener
//    un constructor vacío, parametrizado y get y set. En el main se creará el objeto y se
//    usará el Math.random para generar los dos números y se guardaran en el objeto con
//    su respectivos set. Deberá además implementar los siguientes métodos:
//    • Método devolverMayor() para retornar cuál de los dos atributos tiene el mayor
//    valor.
//    • Método calcularPotencia() para calcular la potencia del mayor valor de la clase
//    elevado al menor número. Previamente se deben redondear ambos valores.
//    • Método calculaRaiz(), para calcular la raíz cuadrada del menor de los dos valores.
//    Antes de calcular la raíz cuadrada se debe obtener el valor absoluto del número.
import java.util.Scanner;
public class ServiceMatematica1 {
    
    Scanner sc = new Scanner(System.in).useDelimiter("\n");
    
    Matematica mat = new Matematica();
    
    private Matematica crearMat(){
        
        System.out.println("Bienvenido Usuario: \n");
        mat.setNum1((Math.random()*10));
        mat.setNum2((Math.random()*10));
        
        System.out.println("Buenos días sus numeros son: ");
        System.out.println("numero 1: " + mat.getNum1());
        System.out.println("numero 2: " + mat.getNum2());
                
        return mat;
    }
     
    private void devolverMayor(Matematica mat){
       System.out.println("El numero más grande es: " + Math.max(mat.getNum1(),mat.getNum2()));
    }
    
    private void Menor(Matematica mat){
        System.out.println("El numero más chico es: " + Math.min(mat.getNum1(),mat.getNum2()));   
    }
    
    private void calcularPotencia(Matematica mat){ //potencia calculada pasando los dos numeros a enteros
       int mayorr = (int) Math.max(mat.getNum1(),mat.getNum2());
       int minimo = (int) Math.min(mat.getNum1(),mat.getNum2());            
       int potencia = (int)Math.pow(mayorr,minimo);
       System.out.println("La potencia del número " + mayorr +" elevado al " + minimo +" es: " + potencia );
    }
    
    private int ValorAbsoluto(Matematica mat){
        
        int MinAbs = Math.abs((int)Math.min(mat.getNum1(),mat.getNum2()));
        
        return MinAbs;
    }
    
    private void calculaRaiz(Matematica mat){
        double raiz = Math.sqrt((double) ValorAbsoluto(mat));
        System.out.println("La raiz del menor numero (en valor absoluto) es: " + raiz);  
    }
    
    private void mostrarMenu(){
        System.out.println("----------------- MENÚ -----------------\n"
                + "1) - Devolver mayor numero. \n"
                + "2) - Devolver menor numero. \n"
                + "3) - Calcular potencia del mayor numero elevado al menor. \n"
                + "4) - Calcular raíz del menor numero. \n"
                + "5) - Salir \n"
                + "-------- Elija una opción --------");          
    }
    
    private int elegirOpcion(){
        int sel;
        
        do{
           sel = sc.nextInt();
           if(sel<1 || sel>5){
               System.out.println("Selección inválida. Intente nuevamente"); 
           }
        }while(sel<1 || sel>5);
        
        return sel;
    }
    
    public void ejecutarMenu(){
        Matematica matt = crearMat(); //Como estoy adentro de la clase Servicio no necesito crear instanciar un servicio nuevo
        mostrarMenu();
        int sel = 0;
        
        do{
            sel = elegirOpcion();
           
            switch(sel){
                case 1:
                    devolverMayor(matt);        // Si pongo mat o matt es lo mismo porque, en el primero caso estarian sacando la informacion directamente de la clase Matematica, en cambio en el 2do caso iria a la clase crearMat() y esta iría 
                    break;                      // Le pude haber pasado en la linea de arriba en los parametros de la llamada al metodo ingresar dinero directamente el valor (ej:1000) en vez de "ingreso". 
                case 2:
                    Menor(matt);
                    break;
                case 3:
                    calcularPotencia(matt);
                    break;
                case 4:
                    calculaRaiz(matt);
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

