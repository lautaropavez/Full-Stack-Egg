package service;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Lautaro Pavez
 *
 */
/*
Realizar un menú en java a través del cual se permita elegir qué consulta se 
desea realizar. Las consultas a realizar sobre la BD son las siguientes:
a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima      ---> Service Familias 
inferior a 10 años.
b) Buscar y listar las casas disponibles para el periodo comprendido entre      ---> Service Casas 
el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.     --->Service Familias?
d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de   ---> Service Casas 
una fecha dada y un número de días específico.
e) Listar los datos de todos los clientes que en algún momento realizaron una   ---> Service Clientes-Estancia-Casa
estancia y la descripción de la casa donde la realizaron.
f) Listar todas las estancias que han sido reservadas por un cliente, mostrar   ---> Service Estancia-Cliente-Casa
el nombre, país y ciudad del cliente y además la información de la casa que 
reservó. La que reemplazaría a la anterior
g) Debido a la devaluación de la libra esterlina con respecto al euro se desea  ---> Service Casas (no usar la de consulta usar la de modificareliminar...)
incrementar el precio por día en un 5% de todas las casas del Reino Unido. 
Mostar los precios actualizados.
h) Obtener el número de casas que existen para cada uno de los países diferentes---> Service Casas
i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas---> Service Casas-Comentarios 
(comentarios) que están ‘limpias’.
j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad de ---> Service Estancias-Casas
las fechas. Para finalizar, pensar junto con un compañero cómo sería posible
optimizar las tablas de la BD para tener un mejor rendimiento
 */
public class Menu {

    private Scanner leer;
    private ServiceFamilia servicefamilia;
    private ServiceCasa servicecasa;
    private ServiceEstancia serviceEstancia;
    //private ServicioProducto servicioproducto;
    private Integer opcion;

    // ISO-8859-1 PERMITE USAR CARACTERES ESPECIALES
    public Menu() {
        this.leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        this.servicefamilia = new ServiceFamilia();
        // this.servicioproducto = new ServicioProducto();
        this.opcion = 0;
    }
    
    
   public void menuPrincipal() {
        
        do {
            try {
                System.out.println("==     MENU PRINCIPAL   ===");
                System.out.println("|| 1.- Mostrar Tablas      ||");
                System.out.println("|| 2.- Editar Registros    ||");
                System.out.println("|| 3.- Borrar Registros    ||");
                System.out.println("|| 4.- Agregar Registros   ||");
                System.out.println("|| 5.- Consultas Ejercicio ||");
                System.out.println("|| 6.- Salir               ||");
                System.out.println("===========================");
        
            opcion = leer.nextInt();
                                
                switch (opcion) {
                    case 1:
                        menuMostrar();
                        break;
                    case 2:
                        MenuEditar();
                        break;
                    case 3:
                        MenuBorrar();
                        break;
                    case 4:
                        MenuAgregar();
                        break;
                    case 5:
                        MenuConsultasEspecíficas();
                        break;
                    case 6:
                        System.out.println("Hasta Luego!!!");
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
           // } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 6);
    }
   
public void menuMostrar(){
            do {
            try {
                System.out.println("==     MENU MOSTRAR   ===");
                System.out.println("|| 1.- Mostrar       ||");
                System.out.println("|| 2.- Editar Registros    ||");
                System.out.println("|| 3.- Borrar Registros    ||");
                System.out.println("|| 4.- Agregar Registros   ||");
                System.out.println("|| 5.- Consultas Ejercicio ||");
                System.out.println("|| 5.- Salir               ||");
                System.out.println("===========================");
        
            opcion = leer.nextInt();
                                
                switch (opcion) {
                    case 1:
                        menuMostrar();
                        break;
                    case 2:
                        MenuEditar();
                        break;
                    case 3:
                        MenuBorrar();
                        break;
                    case 4:
                        MenuAgregar();
                        break;
                    case 5:
                        MenuConsultasEspecíficas();
                        break;
                    case 6:
                        System.out.println("CHAU!!!");
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
           // } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 6);
}
public void MenuEditar(){
    
}
public void MenuBorrar(){
    
}
public void MenuAgregar(){
    
}
public void MenuConsultasEspecíficas(){
    
    System.out.println("                      ==     CONSULTAS ESPECÍFICAS   ===                             ");
    System.out.println("|| 1.- Buscar Familias con cantidad de hijos y edad maxima.                        ||"); // Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima inferior a 10 años.
    System.out.println("|| 2.- Buscar casas disponibles por periodo en Reino Unido.                        ||"); // Buscar y listar las casas disponibles para el periodo comprendido entre el 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
    System.out.println("|| 3.- Buscar familias que usen Hotmail.                                           ||"); // Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
    System.out.println("|| 4.- Buscar Casas disponibles.                                                   ||"); // Consulta la BD para que te devuelva aquellas casas disponibles a partir de  una fecha dada y un número de días específico. 
    System.out.println("|| 5.- Todos los clientes que hicieron estancia y en donde.                        ||"); // Listar los datos de todos los clientes que en algún momento realizaron una estancia y la descripción de la casa donde la realizaron.
    System.out.println("|| 6.- Todas las estancias reservadas por clientes.                                ||"); //  Listar todas las estancias que han sido reservadas por un cliente, mostrar el nombre, país y ciudad del cliente y además la información de la casa que reservó. La que reemplazaría a la anterior
    System.out.println("|| 7.- Modificar precio solo en Reino Unido.                                       ||"); // Debido a la devaluación de la libra esterlina con respecto al euro se desea incrementar el precio por día en un 5% de todas las casas del Reino Unido. Mostar los precios actualizados.
    System.out.println("|| 8.- Numero de casas por pais.                                                   ||"); // Obtener el número de casas que existen para cada uno de los países diferentes 
    System.out.println("|| 9.- Buscar casas con comentarios que son 'limpias' en Reino Unido.              ||"); // Busca y listar aquellas casas del Reino Unido de las que se ha dicho de ellas (comentarios) que están ‘limpias’.
    System.out.println("|| 10.- Insertar nuevos datos en la tabla estancias verificando disponibilidad.    ||"); // Insertar nuevos datos en la tabla estancias verificando la disponibilidad de las fechas. Para finalizar, pensar junto con un compañero cómo sería posible optimizar las tablas de la BD para tener un mejor rendimiento
    System.out.println("|| 11.- Volver al Menú Principal                                                   ||");
    System.out.println("=====================================================================================");

}  

}
