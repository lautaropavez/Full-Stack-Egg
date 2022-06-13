package menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import excepcion.MiExcepcion;
import servicio.ServicioFabricante;
import servicio.ServicioProducto;

/**
 *
 * @author Lautaro Pavez
 */
// **- a) Lista el nombre de todos los productos que hay en la tabla producto.
// **- b) Lista los nombres y los precios de todos los productos de la tabla producto.
// ** c) Listar aquellos productos que su precio esté entre 120 y 202.
// ** d) Buscar y listar todos los Portátiles de la tabla producto. (seria buscar pr nombre)
// **- e) Listar el nombre y el precio del producto más barato.
// **- f) Ingresar un producto a la base de datos.
// ** g) Ingresar un fabricante a la base de datos
// ** h) Editar un producto con datos a elección.
public class Menu {

    private Scanner leer;
    private ServicioFabricante serviciofabricante;
    private ServicioProducto servicioproducto;
    private Integer opcion;

    // ISO-8859-1 PERMITE USAR CARACTERES ESPECIALES
    public Menu() {
        this.leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        this.serviciofabricante = new ServicioFabricante();
        this.servicioproducto = new ServicioProducto();
        this.opcion = 0;
    }

    public void menuPrincipal() {


        do {
            try {

                System.out.println("---------------------BIENVENIDO---------------------"
                        + "\nELIJA UNA OPCIÓN:"
                        + "\n 1.- Administracion de Productos "
                        + "\n 2.- Administracion de Fabricantes "
                        + "\n 3.- Salir "
                        + "\n----------------------------------------------------");

                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        menuProductos();
                        break;
                    case 2:
                        menuFabricantes();
                        break;
                    case 3:
                        System.out.println("Hasta Luego...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("No se admiten caracteres");
                leer.next();
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }

        } while (opcion != 3); //CUIDADO EN ESTA LINEA SI LLEGAS A MODIFICAR LOS SOUT
    }

    public void menuProductos() throws MiExcepcion {
        Integer op = 0;

        do {
            try {
                System.out.println("\n***** MENU PRODUCTOS *****");
                System.out.println("* 1.- Mostrar Productos    *");
                System.out.println("* 2.- Nuevo Producto       *");
                System.out.println("* 3.- Modificar Producto   *");
                System.out.println("* 4.- Borrar Producto      *");
                System.out.println("* 5.- Buscar p/Nombre      *");
                System.out.println("* 6.- Mostrar más barato   *");
                System.out.println("* 7.- Listar por nombre/$  *");
                System.out.println("* 8.- entre $ 120/202      *");
                System.out.println("* 9.- Volver               *");
                System.out.println("****************************");

                op = leer.nextInt();

                switch (op) {
                    case 1:
                        servicioproducto.muestraProducto();
                        break;
                    case 2:
                        crearProducto();
                        break;
                    case 3:
                        modificarProducto();
                        break;
                    case 4:
                        menuEliminarProducto();
                        break;
                    case 5:
                        buscarPorNombre();
                        break;
                    case 6:
                        servicioproducto.buscarMasBarato();
                        break;
                    case 7:
                        listarNombrePrecio();
                        break;
                    case 8:
                        servicioproducto.muestraRango(120d, 202d);
                        break;
                    case 9:
                        System.out.println("- VOLVER AL MENU PRINCIPAL -");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("No se admiten caracteres");
                leer.next();
            }
        } while (op != 9);
    }

    public void menuFabricantes() {
        int op = 0;

        do {
            try {
                System.out.println("\n***** MENU FABRICANTES *****");
                System.out.println("* 1.- Mostrar Fabricantes    *");
                System.out.println("* 2.- Nuevo Fabricante       *");
                System.out.println("* 3.- Modificar Fabricante   *");
                System.out.println("* 4.- Borrar Fabricante      *");
                System.out.println("* 5.- Buscar p/Nombre        *");
                System.out.println("* 6.- Volver                 *");
                System.out.println("****************************");

                op = leer.nextInt();

                switch (op) {
                    case 1:
                        serviciofabricante.mostrarFabricantes();
                        break;
                    case 2:
                        crearFabricante();
                        break;
                    case 3:
                        modificarFabricante();
                        break;
                    case 4:
                        menuEliminarFabricante(); //Debemos tratar de no usarlo por el momento hasta solucionar que los productos no queden sin fabricante se deberia eliminar a los productos que sean de ese fabricante también
                        break;
                    case 5:
                        buscarFabPorNombre();
                        break;
                    case 6:
                        System.out.println("- VOLVER AL MENU PRINCIPAL -");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            } catch (MiExcepcion e) {
                System.out.println(e.getMessage());
            }

        } while (op != 6); 

    }

    //======================= MÉTODOS DE PRODUCTOS =============================
    
    public void crearProducto() { //Integer codigo, String nombre, Double precio, Integer cod_fab
        try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();

            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();

            System.out.println("INGRESE PRECIO: ");
            Double precio = leer.nextDouble();

            System.out.println("INGRESE CODIGO DE FABRICANTE: ");
            int cod_fab = leer.nextInt();

            servicioproducto.crearProducto(codigo, nombre, precio, cod_fab);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

    }

    public void modificarProducto() {
        try {
            System.out.println("SOLO SE PODRA MODIFICAR NOMBRE,PRECIO Y FABRICANTE");
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();

            System.out.println("INGRESE NOMBRE A MODIFICAR: ");
            String nombre = leer.next();

            System.out.println("INGRESE PRECIO A MODIFICAR: ");
            Double precio = leer.nextDouble();

            System.out.println("INGRESE CODIGO DE FABRICANTE A MODIFICAR: ");
            int cod_fab = leer.nextInt();

            servicioproducto.modificarProducto(codigo, nombre, precio, cod_fab);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuEliminarProducto() {
        Integer opc = 0;
        do {
            try {

                System.out.println("1- Desea eliminar al producto por NOMBRE");
                System.out.println("2- Desea eliminar al producto por CODIGO");
                System.out.println("3- SALIR ");

                opc = leer.nextInt();

                switch (opc) {
                    case 1:
                        eliminarProductoPorNombre();
                        System.out.println("- PRODUCTO ELIMINADO -");
                        break;
                    case 2:
                        eliminarProductoPorCodigo();
                        System.out.println("- PRODUCTO ELIMINADO -");
                        break;
                    case 3:
                        System.out.println("Hasta Luego");
                        break;
                }
            } catch(InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            }
        } while (opc != 3);

    }

    public void eliminarProductoPorNombre() {
        try {
            System.out.println("¡ ATENCIÓN ! ESTE MÉTODO ELIMINA TODOS LOS PRODUCTOS CON EL NOMBRE QUE USTED INGRESE");
            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();
            servicioproducto.eliminarProductoPorNombre(nombre);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

    }

    public void eliminarProductoPorCodigo() {
        try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();
            servicioproducto.eliminarProductoPorCodigo(codigo);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

    }

    //CONSULTAS ESPECIALES
    public void buscarPorNombre() {
        try {
            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();
            servicioproducto.buscaPorNombre(nombre);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarNombrePrecio() {
        try {
            servicioproducto.listarPorNombre();
        } catch (MiExcepcion ex) {
            System.out.println(ex.getMessage());
        }
    }

    //======================= MÉTODOS DE FABRICANTES ===========================
    
    public void crearFabricante() { 
        try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();

            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();

            System.out.println("INGRESE NACIONALIDAD: ");
            String nac = leer.next();

            serviciofabricante.crearFabricante(codigo, nombre, nac);

        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }

    }

    public void modificarFabricante() {
        try {
            System.out.println("SOLO SE PODRÁ MODIFICAR EL NOMBRE Y/O NACIONALIDAD");
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();

            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();

            System.out.println("INGRESE NACIONALIDAD: ");
            String nac = leer.next();

            serviciofabricante.modificarFabricante(codigo, nombre, nac);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public void menuEliminarFabricante() throws MiExcepcion {
        Integer opc = 0;
        do {
            try {

                System.out.println("1- Desea eliminar al fabricante por NOMBRE");
                System.out.println("2- Desea eliminar al fabricante por CODIGO");
                System.out.println("3- SALIR ");

                opc = leer.nextInt();

                switch (opc) {
                    case 1:
                        eliminarFabricantePorNombre();
                        System.out.println("- FABRICANTE ELIMINADO -");
                        break;
                    case 2:
                        eliminarFabricantePorCodigo();
                        System.out.println("- FABRICANTE ELIMINADO -");
                        break;
                    case 3:
                        System.out.println("Hasta Luego");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            }
        } while (opc != 3);

    }

    public void eliminarFabricantePorNombre() {
        try {
            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();
            serviciofabricante.eliminarFabricantePorNombre(nombre);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarFabricantePorCodigo() {
        try {
            System.out.println("INGRESE CODIGO: ");
            int codigo = leer.nextInt();
            serviciofabricante.eliminarFabricantePorCodigo(codigo);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

    //CONSULTA ESPECIAL
    public void buscarFabPorNombre() {
        try {
            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();
            serviciofabricante.buscaPorNombre(nombre);
        } catch (MiExcepcion e) {
            System.out.println(e.getMessage());
        }
    }

}
