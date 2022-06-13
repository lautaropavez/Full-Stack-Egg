package POO.CuentaApp;

import java.util.Random;
import java.util.Scanner;

public class ServiceCuenta1 {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    /**
     * Metodo para crear un objeto Cuenta, pidiéndole los datos al usuario.
     *
     * @return objeto tipo Cuenta
     */
    private Cuenta1 crearCuenta() {

        Cuenta1 cuenta01 = new Cuenta1();

        System.out.println("Buenos días Cliente, ingrese sus datos para crear una cuenta.");
//      System.out.println("Ingrese su numero de cuenta: "); // para evitar que nos pida nuestro numero de cuenta que no tiene sentido, le damos nosotros
//      int numCuenta = leer.nextInt();                      // una con la clase random que nos tira numeros aleatorios;
        int numCuenta = new Random().nextInt(99999999);

        System.out.println("Ingrese su numero de DNI(sin puntos): ");
        long DNI = leer.nextInt();

        System.out.println("Ingrese el saldo actual de su cuenta: ");
        double saldo = leer.nextDouble();

        cuenta01.setNumeroCuenta(numCuenta);
        cuenta01.setDNI(DNI);
        cuenta01.setSaldo(saldo);

        return cuenta01;
    } //Como esto lo usamos dentro de la clase mas abajo lo ponemos en privado

    /**
     * Método ingresar(double ingreso): el método recibe una cantidad de dinero
     * a ingresar y se la sumara a saldo actual.
     */
    private void ingresarDinero(Cuenta1 c, double ingreso){
        c.setSaldo(c.getSaldo() + ingreso); // con el set establecemos/definimos el valor de una propiedad y dentro le ponemos el get para traer el valor que ya tenia(ingresado anteriormente) y sumarle el ingreso.
        System.out.println("Ingreso exitoso. SALDO ACTUAL: $" + c.getSaldo());
    }

    /**
     * Método retirar(double retiro): el método recibe una cantidad de dinero a
     * retirar y se la restará al saldo actual. Si la cuenta no tiene la
     * cantidad de dinero a retirar,se pondrá el saldo actual en 0.
     */
    private void retirarDinero(Cuenta1 c){
        double retiro;
        System.out.println("Ingrese la cantidad de dinero a retirar: ");
        retiro = leer.nextDouble();
        
        if (c.getSaldo() >= retiro){//Validacion que el retiro no supere el saldo disponible
            c.setSaldo(c.getSaldo() - retiro);
            System.out.println("Usted ha retirado $" + retiro + " pesos de su cuenta, saldo actual: $" + c.getSaldo() + " pesos.");
        } else {
            System.out.println("[ERROR] Fondos insuficientes. Saldo actual: $" + c.getSaldo() + " pesos.");
        }
    }

    /**
     * Permitirá sacar solo un 20% del saldo.
     */
    private void extraccionRapida(Cuenta1 c) {
       double extraccion = c.getSaldo() * 0.2;// calculamos el 20% para la extraccion

        if (extraccion < c.getSaldo()){
           c.setSaldo(c.getSaldo() - extraccion);
            System.out.println("Usted ha retirado el 20% de su cuenta: $" + extraccion + " pesos. Saldo actual: $" + c.getSaldo() + " pesos.");
        } else {
            System.out.println("[ERROR] Fondos insuficientes, no se pudo realizar la extraccion de dinero. Saldo actual: $" + c.getSaldo() + " pesos.");
        }
    }

    /**
     * Método consultarSaldo(): permitirá consultar el saldo disponible en la
     * cuenta.
     */
    private void consultarSaldo(Cuenta1 c) {
        System.out.println(" [ SALDO ACTUAL DE LA CUENTA ] \n"
                + "su saldo es de $" + c.getSaldo() + " pesos.");
    }

    /**
     * Método consultarDatos(): permitirá mostrar todos los datos de la cuenta.
     */
    private void consultarDatos(Cuenta1 c) {
        System.out.println(" [ DATOS DE LA CUENTA ] \n"
                + "DNI: " + c.getDNI() + "\n"
                + "Numero de cuenta: " + c.getNumeroCuenta() + "\n"
                + "El total en el saldo de su cuenta es: $" + c.getSaldo());
    }
    
    private void mostrarMenu(){
        System.out.println("----------------- MENÚ -----------------\n"
                + "1) - Ingreso \n"
                + "2) - Extraccion \n"
                + "3) - Extraccion Rápida \n"
                + "4) - Consulta Saldo Disponible \n"
                + "5) - Consulta datos cuenta \n"
                + "6) - Salir \n"
                + "-------- Elija una opción --------");
                
    }
    
    private int elegirOpcion(){
        int sel;
        
        do{
           sel = leer.nextInt();
           if(sel<1 || sel>6){
               System.out.println("Selección inválida. Intente nuevamente"); 
           }
        }while(sel<1 || sel>6);
        
        return sel;
    }
    
    public void ejecutarMenu(){
        Cuenta1 c1 = crearCuenta(); //Como estoy adentro de la clase Servicio no necesito crear instanciar un servicio nuevo
        mostrarMenu();
        int sel = 0;
        
        do{
            sel = elegirOpcion();
           
            switch(sel){
                case 1:
                    System.out.println("Digite el monto a ingresar: ");
                    double ingreso = leer.nextDouble();
                    ingresarDinero(c1,ingreso); // Llamada a la función ingresar dinero con sus parametros, el ingreso que pedimos en la linea anterior lo sobreescribimos aquí
                    break;                      // Le pude haber pasado en la linea de arriba en los parametros de la llamada al metodo ingresar dinero directamente el valor (ej:1000) en vez de "ingreso". 
                case 2:
                    retirarDinero(c1);
                    break;
                case 3:
                    extraccionRapida(c1);
                    break;
                case 4:
                    consultarSaldo(c1);
                    break;
                case 5:       
                    consultarDatos(c1);
                    break;
                case 6:       
                    System.out.println("Hasta luego. Vuelvas prontos");
                    break; //no necesito un default que es para cuando la seleccion no esta entre 1 y 6 porque directamente lo hice en la linea 115;     
            }
            
            if(sel != 6 ){
                System.out.println("");
                mostrarMenu();
                System.out.println("");
            }
        }while(sel != 6); //distinto de 6 porque en el menu el 6 es "salir"
    }
}

