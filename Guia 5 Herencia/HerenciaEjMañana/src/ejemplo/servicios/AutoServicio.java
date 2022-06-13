package ejemplo.servicios;

import ejemplo.entidades.Auto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AutoServicio {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    private ArrayList<Auto> autosList = new ArrayList();

    //CREACION, CONSULTA, MODIFICACION, ELIMINACION
    public Auto crearAuto() {
        Auto a = new Auto();
        try {

            System.out.println("Escribe la marca de tu auto");
            String marca = leer.next();

            System.out.println("Escribe el modelo de tu auto");
            String modelo = leer.next();

            System.out.println("Escribe el año de fabricación");
            int fabricacion = leer.nextInt();

            while (fabricacion > 2021 || fabricacion < 1900) {
                System.out.println("El año es incorrecto. Intente nuevamente");
                fabricacion = leer.nextInt();
            }

            a.setMarca(marca);
            a.setModelo(modelo);
            a.setAnioFabricacion(fabricacion);
            try {
                agregarList(a);
            } catch (Exception e) {
                
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return a;
    }

    public void agregarList(Auto a) {

        autosList.add(a);
        
    }

    public void eliminarAuto() {
        System.out.println("Que auto desea eliminar? Ingrese la marca!");
        String marca = leer.next();

        Iterator<Auto> it = autosList.iterator();

        while (it.hasNext()) {
            Auto aux = it.next();

            if (aux.getMarca().equalsIgnoreCase(marca)) {
                System.out.println("Auto a eliminar: " + aux);
                it.remove();

            }

        }

    }

    public void mostrarLista() {
        for (Auto auto : autosList) {
            System.out.println(auto);
        }
    }

    public void mostrarAuto(Auto a) {
        System.out.println("Marca: " + a.getMarca() + "\n"
                + "Modelo: " + a.getModelo() + "\n"
                + "Año Fabricacion: " + a.getAnioFabricacion());
    }
    
    public int calcularGasto(Auto auto,int combustible){
        int nassta = auto.capacidadCombustible(combustible);
        
        int recorrido = 100;
        
        int gasto = nassta * recorrido;
        
        return gasto;
    }

    
}
