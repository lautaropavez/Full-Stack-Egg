package POO.CuentaApp;

import java.util.Scanner;

public class ServiceCuenta {

    private Scanner leer = new Scanner(System.in);

    Cuenta nuevaCuenta = new Cuenta();


    /**
     * Metodo para crear un objeto Cuenta, pidiéndole los datos al usuario.
     *
     * @return objeto tipo Cuenta
     */
    public Cuenta crearCuenta() {
        System.out.println("Buenos días Cliente.");
        System.out.println("Ingrese su numero de cuenta: ");
        int numCuenta = leer.nextInt();

        System.out.println("Ingrese su numero de DNI(sin puntos): ");
        int DNI = leer.nextInt();

        System.out.println("Ingrese el saldo actual de su cuenta: ");
        double saldo = leer.nextDouble();

        return new Cuenta(numCuenta,DNI,saldo);
    }

    /**
     * Método ingresar(double ingreso): el método recibe una cantidad de dinero
     * a ingresar y se la sumara a saldo actual.
     */
    public void ingresarDinero(double ingreso) {

        double saldo = nuevaCuenta.getSaldo();// obtenemos el saldo de la cuenta
        saldo += ingreso;
        nuevaCuenta.setSaldo(saldo);// asignamos el nuevo saldo
    }

    /**
     * Método retirar(double retiro): el método recibe una cantidad de dinero a
     * retirar y se la restará al saldo actual. Si la cuenta no tiene la
     * cantidad de dinero a retirar,se pondrá el saldo actual en 0.
     */
    public void retirarDinero(double retiro) {

        double saldo = nuevaCuenta.getSaldo();// obtenemos el saldo de la cuenta

        if (saldo >= retiro) {//Validacion que el retiro no supere el saldo disponible
            saldo -= retiro;
            nuevaCuenta.setSaldo(saldo);// asignamos el nuevo saldo
            System.out.println("Usted ha retirado $" + retiro + " pesos de su cuenta, saldo actual: $" + nuevaCuenta.getSaldo() + " pesos.");
        } else {
            System.out.println("[ERROR] Fondos insuficientes. Saldo actual: $" + nuevaCuenta.getSaldo() + " pesos.");
        }
    }

    /**
     * Permitirá sacar solo un 20% del saldo.
     */
    public void extraccionRapida(){
        
        double saldo = nuevaCuenta.getSaldo();// obtenemos el saldo de la cuenta
        double extraccion = saldo * 0.2;// calculamos el 20% para la extraccion
        
        if (extraccion < saldo && saldo > 0){
            saldo -= extraccion;
            System.out.println("Usted ha retirado el 20% de su cuenta: $" + extraccion + " pesos. Saldo actual: $" + nuevaCuenta.getSaldo() + " pesos.");
        }else{
            System.out.println("[ERROR] Fondos insuficientes, no se pudo realizar la extraccion de dinero. Saldo actual: $" + nuevaCuenta.getSaldo() + " pesos.");
        }  
    }
 
}
