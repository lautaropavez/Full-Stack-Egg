package principal;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicio.ServiceAutor;
import libreria.servicio.ServiceEditorial;
import libreria.servicio.ServiceLibro;

/**
 *
 * @author Lautaro Pavez
 */
public class Menu {

    private Scanner leer;
    private ServiceAutor servicioAutor;
    private ServiceEditorial servicioEditorial;
    private ServiceLibro servicioLibro;
    private Integer opcion;

    // ISO-8859-1 PERMITE USAR CARACTERES ESPECIALES
    public Menu() {
        this.leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        this.servicioAutor = new ServiceAutor();
        this.servicioEditorial = new ServiceEditorial();
        this.servicioLibro = new ServiceLibro();
        this.opcion = 0;
    }

    //menu general
    public void menuPrincipal() throws Exception {
        do {
            try {
                System.out.println("*****      BIBLIOTECA     ******");
                System.out.println("** 1. ADMINISTRAR LIBROS      **");
                System.out.println("** 2. ADMINISTRAR AUTORES     **");
                System.out.println("** 3. ADMINISTRAR EDITORIALES **");
                System.out.println("** 4. SALIR                   **");
                System.out.println("********************************");
                System.out.println("Ingrese la opcion...\n");
                opcion = leer.nextInt();
                switch (opcion) {
                    case 1:
                        menuLibros();
                        break;
                    case 2:
                        menuAutores();
                        break;
                    case 3:
                        menuEditoriales();
                        break;
                    case 4:
                        System.out.println("Hasta Luego...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("No se admiten caracteres");
                leer.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 4);
    }

    private void menuLibros() throws Exception {
        Integer op = 0;
        do {
            try {
                System.out.println("\n*****     MENU LIBROS     *****");
                System.out.println("* 1.- Mostrar Libros         *");
                System.out.println("* 2.- Nuevo Libro            *");
                System.out.println("* 3.- Modificar Libro        *");
                System.out.println("* 4.- Buscar Libro           *");
                System.out.println("* 5.- Borrar Libro           *");
                System.out.println("* 6.- Prestamo               *");
                System.out.println("* 7.- Devolución             *");
                System.out.println("* 8.- Volver                 *");
                System.out.println("******************************");

                op = leer.nextInt();

                switch (op) {
                    case 1:
                        menuMostrarLibros();
                        break;
                    case 2:
                        crearLibro();
                        break;
                    case 3:
                        menuModificarLibro();
                        break;
                    case 4:
                        menuBuscarLibro();
                        break;
                    case 5:
                        menuEliminarLibro();
                        break;
                    case 6:
                        System.out.println("Opción en desarrollo");
                        break;
                    case 7:
                        System.out.println("Opción en desarrollo");
                        break;
                    case 8:
                        System.out.println("- VOLVER AL MENU PRINCIPAL -");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (op != 8);
    }

    private void menuAutores() throws Exception {
        Integer op = 0;
        do {
            try {
                System.out.println("\n*****   MENU AUTORES   *****");
                System.out.println("* 1.- Mostrar Autores        *");
                System.out.println("* 2.- Nuevo Autor            *");
                System.out.println("* 3.- Modificar Autor        *");
                System.out.println("* 4.- Buscar p/ID            *");
                System.out.println("* 5.- Buscar p/Nombre        *");
                System.out.println("* 6.- Borrar Autor p/ID      *");
                System.out.println("* 7.- Borrar Autor p/Nombre  *");
                System.out.println("* 8.- Volver                 *");
                System.out.println("******************************");

                op = leer.nextInt();

                switch (op) {
                    case 1:
                        mostrarAutores();
                        break;
                    case 2:
                        crearAutor();
                        break;
                    case 3:
                        modificarAutor();
                        break;
                    case 4:
                        buscarAutorPorID();
                        break;
                    case 5:
                        buscarAutorPorNombre();
                        break;
                    case 6:
                        borrarAutorPorID();
                        break;
                    case 7:
                        borrarAutorPorNombre();
                        break;
                    case 8:
                        System.out.println("- VOLVER AL MENU PRINCIPAL -");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (op != 8);
    }

    private void menuEditoriales() throws Exception {
        Integer op = 0;
        do {
            try {
                System.out.println("\n*****    MENU EDITORIALES    *****");
                System.out.println("* 1.- Mostrar Editoriales        *");
                System.out.println("* 2.- Nuevo Editorial            *");
                System.out.println("* 3.- Modificar Editorial        *");
                System.out.println("* 4.- Buscar p/ID                *");
                System.out.println("* 5.- Buscar p/Nombre            *");
                System.out.println("* 6.- Borrar Editorial p/ID      *");
                System.out.println("* 7.- Borrar Editorial p/Nombre  *");
                System.out.println("* 8.- Volver                     *");
                System.out.println("**********************************");

                op = leer.nextInt();

                switch (op) {
                    case 1:
                        mostrarEditoriales();
                        break;
                    case 2:
                        crearEditorial();
                        break;
                    case 3:
                        modificarEditorial();
                        break;
                    case 4:
                        buscarEditorialPorID();
                        break;
                    case 5:
                        buscarEditorialPorNombre();
                        break;
                    case 6:
                        borrarEditorialPorID();
                        break;
                    case 7:
                        borrarEditorialPorNombre();
                        break;
                    case 8:
                        System.out.println("- VOLVER AL MENU PRINCIPAL -");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (op != 8);
    }

    public void limpiarPantalla() throws AWTException {
        //Dejo este metodo para ir borrando la consola.. y que no sea un desorden.
        Robot pressbot = new Robot();
        pressbot.setAutoDelay(30); // Tiempo de espera antes de borrar
        pressbot.keyPress(17); // Orden para apretar CTRL key
        pressbot.keyPress(76);// Orden para apretar L key
        pressbot.keyRelease(17); // Orden para soltar CTRL key
        pressbot.keyRelease(76); // Orden para soltar L key
    }

//============================ MÉTODOS DE LIBROS ===============================
    private void menuMostrarLibros() throws Exception {
        Integer opc = 0;
        do {
            try {

                System.out.println("* 1.- Mostrar todos los libros       *");
                System.out.println("* 2.- Mostrar libros por año         *");
                System.out.println("* 3.- SALIR                          *");

                opc = leer.nextInt();

                switch (opc) {
                    case 1:
                        mostrarTodos();
                        break;
                    case 2:
                        listaPorAnio();
                        break;
                    case 3:
                        System.out.println("Hasta Luego...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            }
        } while (opc != 3);

    }           //OK

    private void menuModificarLibro() {
        Integer opc = 0;
        do {
            try {

                System.out.println("* 1.- Modificar Titulo       *");
                System.out.println("* 1.- Modificar ISBN         *");
                System.out.println("* 3.- Modificar Anio         *");
                System.out.println("* 4.- SALIR                  *");

                opc = leer.nextInt();

                switch (opc) {
                    case 1:
                        modificarTitulo();
                        break;
                    case 2:
                        modificarISBN();
                        break;
                    case 3:
                        modificarAnio();
                        break;
                    case 4:
                        System.out.println("Hasta Luego...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            }
        } while (opc != 4);
    }

    private void menuBuscarLibro() throws Exception {
        Integer opc = 0;
        do {
            try {

                System.out.println("* 1.- Buscar por ID        *");
                System.out.println("* 2.- Buscar por ISBN      *");
                System.out.println("* 3.- Buscar por Titulo    *");
                System.out.println("* 4.- Buscar por Autor     *");
                System.out.println("* 5.- Buscar por Editorial *");
                System.out.println("* 6.- SALIR                *");

                opc = leer.nextInt();

                switch (opc) {
                    case 1:
                        buscarPorID();
                        break;
                    case 2:
                        buscarPorISBN();
                        break;
                    case 3:
                        buscarPorTitulo();
                        break;
                    case 4:
                        buscaPorAutor();
                        break;
                    case 5:
                        buscaPorEditorial();
                        break;
                    case 6:
                        System.out.println("Hasta Luego...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            }
        } while (opc != 6);
    }

    private void menuEliminarLibro() throws Exception {
        Integer opc = 0;
        do {
            try {

                System.out.println("* 1.- Borrar por  ID           *");
                System.out.println("* 2.- Borrar por  ISBN         *");
                System.out.println("* 3.- Borrar por  Titulo       *");
                System.out.println("* 4.- Borrar por Editorial     *");
                System.out.println("* 5.- SALIR                    *");

                opc = leer.nextInt();

                switch (opc) {
                    case 1:
                        borrarPorID();
                        break;
                    case 2:
                        borrarPorISBN();
                        break;
                    case 3:
                        borrarPorTitulo();
                        break;
                    case 4:
                        borrarPorEditorial();
                        break;
                    case 5:
                        System.out.println("Hasta Luego...");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("NO SE ADMITEN CARACTERES");
                leer.next();
            }
        } while (opc != 5);
    }

    private void crearLibro() throws Exception {
        try {
            System.out.println("INGRESE TITULO: ");
            String titulo = leer.next();

            System.out.println("INGRESE EL AÑO: ");
            Integer anio = leer.nextInt();

            System.out.println("INGRESE NOMBRE AUTOR: ");
            String nombreAut = leer.next();

            System.out.println("INGRESE NOMBRE EDITORIAL: ");
            String nombreEdit = leer.next();

            servicioLibro.crearLibro(titulo, anio, nombreAut, nombreEdit);
            //Libro aux = servicioLibro.buscarPorTitulo(titulo);

//        if (aux == null) {
//
//        }else {
//                System.out.println("Ya existe un libro con ese nombre");
//            }
        } catch (Exception e) {
            throw new Exception("ERROR AL CREAR AUTOR " + e.getMessage());
        }
    }

    private void mostrarTodos() throws Exception {
        servicioLibro.listarLibros();
    }

//OTRA MANERA DE LISTAR (EN VEZ DE PONER LOS SOUT PARA MOSTRAR EN EL SERVICE LO HACEMOS ACÁ)
    private void listarPorAnio() throws Exception {
        System.out.println("Ingrese el año del libro: ");
        Integer anioLibro = leer.nextInt();

        List<Libro> libro = servicioLibro.listarPorAnio(anioLibro);

        System.out.println("\n*** LISTA DE LIBROS ***");
        System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR", "AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/

        for (Libro aux : libro) {
            System.out.println(aux);
            //System.out.printf("%-20s%-35s%-25s%-25s\n", aux.getIsbn(), aux.getTitulo(), aux.getAutor().getNombre(), aux.getEditorial().getNombre());
        }
        System.out.println();
    }

    private void listaPorAnio() throws Exception {
        System.out.println("Ingrese el año del libro: ");
        Integer anioLibro = leer.nextInt();
        servicioLibro.listaPorAnio(anioLibro);
    }

    private void modificarTitulo() {
        try {
            System.out.println("INGRESE TITULO ACTUAL DEL LIBRO: ");
            String tituloAct = leer.next();
            System.out.println("INGRESE TITULO A MODIFICAR: ");
            String tituloNuevo = leer.next();

            servicioLibro.modificarTitulo(tituloAct, tituloNuevo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarISBN() {
        try {
            System.out.println("INGRESE ISBN ACTUAL DEL LIBRO: ");
            Long isbnAct = leer.nextLong();
            System.out.println("INGRESE ISBN A MODIFICAR: ");
            Long isbnNuevo = leer.nextLong();

            servicioLibro.modificarISBN(isbnAct, isbnNuevo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void modificarAnio() {
        try {
            System.out.println("INGRESE ID: ");
            String id = leer.next();
            System.out.println("INGRESE AÑO ACTUAL DEL LIBRO: ");
            Integer anioAct = leer.nextInt();
            System.out.println("INGRESE AÑO A MODIFICAR: ");
            Integer anioNuevo = leer.nextInt();

            servicioLibro.modificarAnio(id, anioAct, anioNuevo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarPorID() {
        try {
            System.out.println("INGRESE ID: ");
            Libro lib = servicioLibro.buscarPorId(leer.next());
            System.out.println("\n*** LIBRO ***");
            System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR", "AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/              
            System.out.println(lib);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarPorISBN() {
        try {
            System.out.println("INGRESE ISBN: ");
            Libro lib = servicioLibro.buscarPorISBN(leer.nextLong());;
            System.out.println("\n*** LIBRO ***");
            System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR", "AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/              
            System.out.println(lib);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void buscarPorTitulo() {
        try {
            System.out.println("INGRESE TITULO: ");
            Libro lib = servicioLibro.buscarPorTitulo(leer.next());
            System.out.println("\n*** LIBRO ***");
            System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR", "AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/              
            System.out.println(lib);
            //System.out.printf("%-20s%-35s%-25s%-25s\n", lib.getIsbn(), lib.getTitulo(), lib.getAutor().getNombre(),lib.getAnio(), lib.getEditorial().getNombre()); // ESTA SERIA LA FORMA QUE HARIAMOS SI QUISIERAMOS ELEJIR QUE DATOS MOSTRAR Y OBVIAMENTE CAMBIANDO LOS TITULARES DE ARRIBA TAMBIEN Y SOLO DEJANDO LOS QUE NECESITEMOS, EJ: TITULO Y ID SOLAMENTE.

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //OTRA MANERA DE LISTAR (EN VEZ DE PONER LOS SOUT PARA MOSTRAR EN EL SERVICE LO HACEMOS ACÁ)
    private List<Libro> buscarPorAutor() {
        System.out.println("INGRESE NOMBRE DEL AUTOR: ");
        String nombre = leer.next();

        List<Libro> libro = servicioLibro.buscarPorAutor(nombre);

        System.out.println("\n*** LISTA DE LIBROS ***");
        System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR", "AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/

        for (Libro aux : libro) {
            System.out.println(aux);
            //System.out.printf("%-20s%-35s%-25s%-25s\n", aux.getIsbn(), aux.getTitulo(), aux.getAutor().getNombre(), aux.getAnio(), aux.getEditorial().getNombre());
        }
        return libro;
    }

    private void buscaPorAutor() throws Exception {
        System.out.println("INGRESE NOMBRE DEL AUTOR: ");
        String nombre = leer.next();

        servicioLibro.buscaPorAutor(nombre);
    }

    //OTRA MANERA DE LISTAR (EN VEZ DE PONER LOS SOUT PARA MOSTRAR EN EL SERVICE LO HACEMOS ACÁ)
    private List<Libro> buscarPorEditorial() {
        System.out.println("INGRESE NOMBRE DE LA EDITORIAL: ");
        String nombre = leer.next();

        List<Libro> libro = servicioLibro.buscarPorEditorial(nombre);

        System.out.println("\n*** LISTA DE LIBROS ***");
        System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR", "AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/

        for (Libro aux : libro) {
            System.out.println(aux);
            //System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", aux.getIsbn(), aux.getTitulo(), aux.getAutor().getNombre(),aux.getAnio(), aux.getEditorial().getNombre());
        }
        return libro;
    }

    private void buscaPorEditorial() throws Exception {
        System.out.println("INGRESE NOMBRE DE LA EDITORIAL: ");
        String nombre = leer.next();

        servicioLibro.buscaPorEditorial(nombre);
    }

    //EN REALIDAD CUANDO ELIMINO EL LIBRO SE DEBERIA ELIMINAR EL AUTOR Y LA EDITORIAL SOLOS PERO ACA LO HAGO MANUAL, VER GUIA NUEVAMENTE
    private void borrarPorID() throws Exception {
        System.out.println("INGRESE ID: ");
        String id = leer.next();
        Libro libro = servicioLibro.buscarPorId(id);

        servicioLibro.eliminarPorId(id);
        servicioAutor.eliminarPorNombre(libro.getAutor().getNombre());
        servicioEditorial.eliminarPorNombre(libro.getEditorial().getNombre());
    }

    private void borrarPorISBN() throws Exception {
        System.out.println("INGRESE ISBN: ");
        Long isbn = leer.nextLong();
        Libro libro = servicioLibro.buscarPorISBN(isbn);

        servicioLibro.eliminarPorISBN(isbn);
        servicioAutor.eliminarPorNombre(libro.getAutor().getNombre());
        servicioEditorial.eliminarPorNombre(libro.getEditorial().getNombre());
    }

    private void borrarPorTitulo() throws Exception {
        System.out.println("INGRESE TITULO: ");
        String titulo = leer.next();
        Libro libro = servicioLibro.buscarPorTitulo(titulo);

        servicioLibro.eliminarPorTitulo(titulo);
        servicioAutor.eliminarPorNombre(libro.getAutor().getNombre());
        servicioEditorial.eliminarPorNombre(libro.getEditorial().getNombre());
    }

    private void borrarPorEditorial() throws Exception {
        System.out.println("INGRESE EDITORIAL: ");
        String nombreEdit = leer.next();

        servicioLibro.eliminarPorEditorial(nombreEdit); //Elimino los libros de esa editorial
        servicioEditorial.eliminarPorNombre(nombreEdit); //Elimino esa editorial
    }

//============================ MÉTODOS DE EDITORIAL ============================
    private void mostrarEditoriales() throws Exception {
        servicioEditorial.listarEditoriales();
    }

    private void crearEditorial() throws Exception {
        try {
            System.out.println("INGRESE NOMBRE: ");
            String nombre = leer.next();

            Editorial aux = servicioEditorial.buscarPorNombre(nombre);

            if (aux == null) {
                servicioEditorial.crearEditorial(nombre);
            } else {
                System.out.println("Ya existe una editorial con ese nombre");
            }
        } catch (Exception e) {
            throw new Exception("ERROR AL CREAR EDITORIAL " + e.getMessage());
        }
    }

    private void modificarEditorial() throws Exception {
        try {
            System.out.println("INGRESE NOMBRE ACTUAL: ");
            String nombreAct = leer.next();
            System.out.println("INGRESE NOMBRE A MODIFICAR: ");
            String nombreNuevo = leer.next();
            servicioEditorial.modificarEditorial(nombreAct, nombreNuevo);
        } catch (Exception e) {
            throw new Exception("ERROR AL MODIFICAR EDITORIAL " + e.getMessage());
        }
    }

    private void buscarEditorialPorID() throws Exception {
        try {
            System.out.println("INGRESE ID: ");
            Editorial edit = servicioEditorial.buscarPorId(leer.next());
            if (edit != null) {
                System.out.println("*** EDITORIAL ***");
                System.out.printf("%-20s%-30s\n", "NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
                System.out.println(edit);
                //System.out.printf("%-20s%-30s\n", edit.getNombre(), edit.getId());
            } 
        } catch (Exception e) {
            throw new Exception("ERROR AL BUSCAR EDITORIAL POR ID " + e.getMessage());
        }
    }

    private void buscarEditorialPorNombre() throws Exception {
        try {
            System.out.println("INGRESE NOMBRE: ");
            Editorial edit = servicioEditorial.buscarPorNombre(leer.next());
            if (edit != null) {
                System.out.println("*** EDITORIAL ***");
                System.out.printf("%-20s%-30s\n", "NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
                System.out.println(edit);
                //System.out.printf("%-20s%-30s\n", edit.getNombre(), edit.getId());
            }
        } catch (Exception e) {
            throw new Exception("ERROR AL BUSCAR EDITORIAL POR NOMBRE " + e.getMessage());
        }
    }

    private void borrarEditorialPorID() throws Exception {
        try {
            System.out.println("INGRESE ID: ");
            String id = leer.next();
            servicioEditorial.eliminarPorId(id);
            Editorial editorial = servicioEditorial.buscarPorId(id);
            servicioLibro.buscaPorEditorial(editorial.getNombre());
        } catch (Exception e) {
            throw new Exception("ERROR AL ELIMINAR EDITORIAL POR ID " + e.getMessage());
        }
    }

    private void borrarEditorialPorNombre() throws Exception {
        try {
            System.out.println("INGRESE TITULO: ");
            String nombre = leer.next();
            servicioEditorial.eliminarPorNombre(nombre);
            servicioLibro.eliminarPorEditorial(nombre);
        } catch (Exception e) {
            throw new Exception("ERROR AL ELIMINAR EDITORIAL POR NOMBRE " + e.getMessage());
        }
    }

//============================ MÉTODOS DE AUTOR ================================
    private void mostrarAutores() throws Exception {
        servicioAutor.listarAutores();
    }

    private void crearAutor() throws Exception {
        System.out.println("INGRESE NOMBRE: ");
        String nombre = leer.next();

        Autor aux = servicioAutor.buscarPorNombre(nombre);

        if (aux == null) {
            servicioAutor.crearAutor(nombre);
        } else {
            System.out.println("Ya existe un Autor con ese nombre");
        }
    }

    private void modificarAutor() throws Exception {
        System.out.println("INGRESE NOMBRE ACTUAL: ");
        String nombreAct = leer.next();
        System.out.println("INGRESE NOMBRE A MODIFICAR: ");
        String nombreNuevo = leer.next();
        servicioAutor.modificarAutor(nombreAct, nombreNuevo);
    }

    private void buscarAutorPorID() throws Exception {
        System.out.println("INGRESE ID: ");
        Autor autor = servicioAutor.buscarPorId(leer.next());
        if (autor != null) {
            System.out.println("*** AUTOR ***");
            System.out.printf("%-20s%-30s\n", "NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
            System.out.println(autor);
        }else{
            System.out.println("NO SE ENCONTRO NINGÚN AUTOR.");
        }
    }

    private void buscarAutorPorNombre() throws Exception {
        System.out.println("INGRESE NOMBRE: ");
        Autor autor = servicioAutor.buscarPorNombre(leer.next());
        if (autor != null) {
        System.out.println("*** AUTOR ***");
        System.out.printf("%-20s%-30s\n", "NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
        System.out.println(autor);
        }else{
            System.out.println("NO SE ENCONTRO NINGÚN AUTOR.");
        }
    }

    private void borrarAutorPorID() throws Exception {
        System.out.println("INGRESE ID: ");
        String id = leer.next();
        servicioAutor.eliminarPorId(id);

        Autor autor = servicioAutor.buscarPorId(id);
        servicioLibro.buscaPorAutor(autor.getNombre());
    }

    private void borrarAutorPorNombre() throws Exception {
        System.out.println("INGRESE TITULO: ");
        String nombre = leer.next();
        servicioAutor.eliminarPorNombre(nombre);
        
        Autor autor = servicioAutor.buscarPorNombre(nombre);
        servicioLibro.buscaPorAutor(autor.getNombre());
    }

}
