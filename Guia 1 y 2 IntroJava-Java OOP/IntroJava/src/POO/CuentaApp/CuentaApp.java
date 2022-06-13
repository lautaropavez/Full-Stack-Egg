package POO.CuentaApp;

public class CuentaApp {

    public static void main(String[] args) {

        //Llamada al método que pedirá los valores al usuario;
        ServiceCuenta servicio = new ServiceCuenta();

        // Creamos la cuenta
        Cuenta cuenta_01 = servicio.crearCuenta();

        cuenta_01.consultarDatos();
        cuenta_01.consultarSaldo();

        servicio.ingresarDinero(5000);
        servicio.retirarDinero(3000);
        servicio.extraccionRapida();
        
    }
}
