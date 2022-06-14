package Ejercicio6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
//    6_ Se necesita una aplicación para una tienda en la cual queremos almacenar los
//    distintos productos que venderemos y el precio que tendrán. Además, se necesita
//    que la aplicación cuente con las funciones básicas.
//    Estas las realizaremos en el main. Como, introducir un elemento, modificar su
//    precio, eliminar un producto y mostrar los productos que tenemos con su precio
//    (Utilizar Hashmap). El HashMap tendrá de llave el nombre del producto y de valor
//    el precio. Realizar un menú para lograr todas las acciones previamente
//    mencionadas.

public class TiendaApp {

    public static void main(String[] args) {

        HashMap<String, Double> productos = new HashMap();

        String prod = "", dato = "S";
        Double prec = 0.0;

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        do {
            System.out.println("<<<<<<<<<<<< MENÚ >>>>>>>>>>>>");
            System.out.println("1_Agregar producto.");
            System.out.println("2_Modificar precio del producto.");
            System.out.println("3_Eliminar un producto.");
            System.out.println("4_Mostrar todos los productos");
            System.out.println("5_Eliminar la lista completa de productos.");
            System.out.println("6_Buscar si existe X producto por el nombre: ");
            System.out.println("7_Buscar si existe algun producto a X precio: ");
            System.out.println("8_ ¿La lista(mapa) está vacía? ");
            System.out.println("9_ Cuál es el tamaño de la lista(mapa).");
            System.out.println("10_Salir.");
            switch (leer.nextInt()) {
                case 1:

                    System.out.println("Nombre del producto: ");
                    prod = leer.next();
                    System.out.println("Precio del producto: ");
                    prec = leer.nextDouble();
                    productos.put(prod, prec);
                    break;

                case 2:

                    System.out.println("Nombre del producto que desea modificar: ");
                    prod = leer.next();
                    if (productos.containsKey(prod)) {
                        System.out.println("Nuevo precio: ");
                        prec = leer.nextDouble();

                        productos.put(prod, prec);
                    } else {
                        System.out.println("El producto no se encuentra cargado.");
                    }
                    break;

                case 3:

                    System.out.println("Ingrese el nombre del producto que desea eliminar:");
                    prod = leer.next();
                    if (productos.containsKey(prod)) {
                        productos.remove(prod);
                        System.out.println("El producto ha sido eliminado.");
                    } else {
                        System.out.println("El producto no se encuentra cargado.");
                    }
                    break;

                case 4:

                    for (Map.Entry<String, Double> aux : productos.entrySet()) { //Vamos a tener una variable auxiliar "aux", lo vamos a recorrer sobre nombres.entryset, como que lo procesa para que lo podamos correr con este for
                        String producto = aux.getKey();
                        Double precio = aux.getValue();

                        System.out.println("Producto: " + producto + ", precio: " + precio);
                    }
                    break;

                case 5:
                    
                    productos.clear();
                    System.out.println("La lista ha sido vaciada");                    
                    break;
                    
                case 6:
                    System.out.println("Nombre del producto: ");
                    prod = leer.next();
                    
                    if (productos.containsKey(prod)) {
                        System.out.println("El producto existe.");  
                    } else {
                        System.out.println("El producto no se encuentra cargado.");
                    }
                    break;
                    
                case 7:
                    System.out.println("Ingrese el precio: ");
                    prec = leer.nextDouble();
                    
                    if (productos.containsValue(prec)) {
                        System.out.println("El producto existe."); 
                    } else {
                        System.out.println("Ningún producto tiene ese precio.");
                    }
                    break;
                    
                case 8:
                    if (productos.isEmpty()){
                        System.out.println("Está vacía.");
                    }else{
                        System.out.println("NO está vacía.");
                    }
                    break;
                    
                case 9:
                    System.out.println("El tamaño es de " + productos.size());
                    
                    
                    break;
                    
                case 10:
                    
                    System.out.println("¿Desea realizar otro Operacion?(S/N)");
                    dato = leer.next().toUpperCase();
                    break;

                default:
                    System.out.println("Opción Erronea");
            }
        } while (dato.equals("S"));

    }
}
