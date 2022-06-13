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
    //OK
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
    }

    //OK
    private void menuModificarLibro() throws Exception {
        Integer opc = 0;
        do {
            try {

                System.out.println("* 1.- Modificar Titulo       *");
                System.out.println("* 2.- Modificar ISBN         *");
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

    //OK
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

    //OK
    private void menuEliminarLibro() throws Exception {
        Integer opc = 0;
        do {
            try {

                System.out.println("* 1.- Borrar por  ID           *");
                System.out.println("* 2.- Borrar por  ISBN         *");
                System.out.println("* 3.- Borrar por  Titulo       *");
                System.out.println("* 4.- Borrar por Editorial     *");
                System.out.println("* 5.- Borrar por Autor         *");
                System.out.println("* 6.- SALIR                    *");

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
                        borrarPorAutor();
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

    //OK
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
            throw new Exception("ERROR AL CREAR LIBRO " + e.getMessage());
        }
    }

    //OK
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

    //OK
    private void listaPorAnio() throws Exception {
        System.out.println("Ingrese el año del libro: ");
        Integer anioLibro = leer.nextInt();
        servicioLibro.listaPorAnio(anioLibro);
    }

    //OK
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

    //OK
    private void modificarISBN() throws Exception {
        Long isbnAct = (long) 0;
        Long isbnNuevo = (long) 0;
        try {
            System.out.println("INGRESE ISBN ACTUAL DEL LIBRO: ");
            isbnAct = leer.nextLong();
            System.out.println("INGRESE ISBN A MODIFICAR: ");
            isbnNuevo = leer.nextLong();
            servicioLibro.modificarISBN(isbnAct, isbnNuevo);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("DEBE INGRESAR NUMEROS.");
            leer.next();
        } catch (Exception e) {
            throw e;
        }
    }

    //OK
    private void modificarAnio() {
        try {
            System.out.println("INGRESE ID: ");
            String id = leer.next();
            System.out.println("INGRESE AÑO ACTUAL DEL LIBRO: ");
            Integer anioAct = leer.nextInt();
            System.out.println("INGRESE AÑO A MODIFICAR: ");
            Integer anioNuevo = leer.nextInt();

            servicioLibro.modificarAnio(id, anioAct, anioNuevo);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("DEBE INGRESAR NUMEROS.");
            leer.next();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    //OK
    private void buscarPorID() {//Al buscar por id, como lo busca con un metodo especifico si no lo encuentra devuelve un null, en cambio al buscar por nombre u otro atributo (como en los otros metodos)si no lo encuentra viene vacio por eso se rompe y lo agarra el catch del servicio en cuestion.
        try {
            System.out.println("INGRESE ID: ");
            Libro lib = servicioLibro.buscarPorId(leer.next());
            if (lib != null) {
                System.out.println("\n*** LIBRO ***");
                System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR", "AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/              
                System.out.println(lib);
            } else {
                throw new Exception("ERROR AL BUSCAR LIBRO POR ID");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //OK
    private void buscarPorISBN() { //Al buscar por id, como lo busca con un metodo especifico si no lo encuentra devuelve un null, en cambio al buscar por nombre u otro atributo (como en los otros metodos)si no lo encuentra viene vacio por eso se rompe y lo agarra el catch del servicio en cuestion.
        try {
            System.out.println("INGRESE ISBN: ");
            Libro lib = servicioLibro.buscarPorISBN(leer.nextLong());
            //if (lib != null) {  //No hace falta que lo pongamos ya que como dijimos arriba agarra la excepcion en el service, podriamos hacer que retorne un null y ahi si serviria, pero como ya tenemos varios metodos que se llaman entre si tal vez se rompería
            System.out.println("\n*** LIBRO ***");
            System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR", "AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/              
            System.out.println(lib);
            //}  
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("DEBE INGRESAR NUMEROS.");
            leer.next();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //OK
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

    //OK
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

    //OK
    private void buscaPorEditorial() throws Exception {
        System.out.println("INGRESE NOMBRE DE LA EDITORIAL: ");
        String nombre = leer.next();

        servicioLibro.buscaPorEditorial(nombre);
    }

    //OK
    private void borrarPorID() throws Exception {
        System.out.println("INGRESE ID: ");
        String id = leer.next();
//        Libro libro = servicioLibro.buscarPorId(id);

        servicioLibro.eliminarPorId(id); //Autor y libro se eliminan solos por la relacion que pusimos en la entidad libro
//        servicioAutor.eliminarPorNombre(libro.getAutor().getNombre()); //De esta manera seria si no estuvieran relacionados
//        servicioEditorial.eliminarPorNombre(libro.getEditorial().getNombre()); //De esta manera seria si no estuvieran relacionados
    }

    //OK
    private void borrarPorISBN() throws Exception {
        System.out.println("INGRESE ISBN: ");
        Long isbn = leer.nextLong();
        servicioLibro.buscarPorISBN(isbn);

        servicioLibro.eliminarPorISBN(isbn);
    }

    //OK
    private void borrarPorTitulo() throws Exception {
        System.out.println("INGRESE TITULO: ");
        String titulo = leer.next();
        servicioLibro.buscarPorTitulo(titulo);

        servicioLibro.eliminarPorTitulo(titulo);
    }

    //ARREGLAR. NO PUEDO BORRAR MAS DE UNA VEZ, LA SEGUNDA ME SALTA ERROR
    private void borrarPorEditorial() throws Exception {
        System.out.println("INGRESE EDITORIAL: ");
        String nombreEdit = leer.next();
        //Elimino los libros de esa editorial
        servicioLibro.eliminarPorEditorial(nombreEdit);
    }
    //ARREGLAR. NO PUEDO BORRAR MAS DE UNA VEZ, LA SEGUNDA ME SALTA ERROR
    private void borrarPorAutor() throws Exception {
        System.out.println("INGRESE AUTOR: ");
        String nombreAutor = leer.next();
        //Elimino los libros de ese autor
        servicioLibro.eliminarPorAutor(nombreAutor);
    }

//============================ MÉTODOS DE EDITORIAL ============================ (Manera de revisarlas, primero con datos que existan y luego con datos que no para ver tema excepciones)
    //OK
    private void mostrarEditoriales() throws Exception {
        servicioEditorial.listarEditoriales();
    }
    //OK
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
    //OK
    private void modificarEditorial() throws Exception {
        System.out.println("INGRESE NOMBRE ACTUAL: ");
        String nombreAct = leer.next();
        System.out.println("INGRESE NOMBRE A MODIFICAR: ");
        String nombreNuevo = leer.next();

        List<Libro> libros = servicioLibro.buscarPorEditorial(nombreAct);
        if (libros.isEmpty()) { //Si tuviera cascade type en refresh podria actualizarlo solo y cambiarlo directamente desde un metodo en servicelibro
            System.out.println("NO EXISTEN LIBROS PARA ESTA EDITORIAL");
        } else {
            for (Libro aux : libros) {
                aux.getEditorial().setNombre(nombreNuevo);
                System.out.println("LIBRO MODIFICADO\n");
            }
        }

        servicioEditorial.modificarEditorial(nombreAct, nombreNuevo);//Si tuviera cascade type en refresh podria actualizarlo solo y cambiarlo directamente desde un metodo en servicelibro

    }
    //OK
    private void buscarEditorialPorID() throws Exception {
        try {
            System.out.println("INGRESE ID: ");
            Editorial edit = servicioEditorial.buscarPorId(leer.next());
            if (edit != null) {
                System.out.println("*** EDITORIAL ***");
                System.out.printf("%-20s%-30s\n", "NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
                System.out.println(edit);
                //System.out.printf("%-20s%-30s\n", edit.getNombre(), edit.getId());
            } else {
                throw new Exception("ERROR AL BUSCAR EDITORIAL POR ID");
            }
        } catch (Exception e) {
            //throw new Exception("ERROR AL BUSCAR EDITORIAL POR ID " + e.getMessage());
            throw e;
        }
    }
    //OK
    private void buscarEditorialPorNombre() throws Exception {
        try {
            System.out.println("INGRESE NOMBRE: ");
            Editorial edit = servicioEditorial.buscarPorNombre(leer.next());
            if (edit != null) {
                System.out.println("*** EDITORIAL ***");
                System.out.printf("%-20s%-30s\n", "NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
                System.out.println(edit);
                //System.out.printf("%-20s%-30s\n", edit.getNombre(), edit.getId());
            } else {
                throw new Exception("ERROR AL BUSCAR EDITORIAL POR NOMBRE");
            }
        } catch (Exception e) {
//            throw new Exception("ERROR AL BUSCAR EDITORIAL POR NOMBRE " + e.getMessage());
            throw e;
        }
    }
    
    //ARREGLAR
    private void borrarEditorialPorID() throws Exception {
        System.out.println("INGRESE ID: ");
        String id = leer.next();
        Editorial editorial = servicioEditorial.buscarPorId(id); // Al borrar por nombre no le pongo el if porque lo toma en el servicio eliminar por editorial pero como aca lo teniamos que hacer por id si no lo encontraba no llegaba a esa instancia y solo nos tiraba un null.
        if (editorial == null) {
            throw new Exception("La editorial ingresada no existe");
        }
        List <Libro> libros = servicioLibro.buscarPorEditorial(id);
        if (libros == null || libros.isEmpty()) {
            System.out.println("NO EXISTEN LIBROS PARA ESTA EDITORIAL");
        }else{
            servicioLibro.eliminarPorEditorial(editorial.getNombre());
            System.out.println("LIBRO ELIMINADO\n");
        }
    }

    //ARREGLAR. NO PUEDO BORRAR MAS DE UNA VEZ, LA SEGUNDA ME SALTA ERROR
    private void borrarEditorialPorNombre() throws Exception { //No le pongo try and catch porque es lo mismo ya que lo tengo en el servicio de libro y de editorial
//        try {
        System.out.println("INGRESE NOMBRE: ");
        String nombre = leer.next();
        //Elimino todos los libros de la editorial
        servicioLibro.eliminarPorEditorial(nombre);
        //elimino la editorial
        servicioEditorial.eliminarPorNombre(nombre);
//        } catch (Exception e) {
//            throw e; 
//            //throw new Exception("ERROR AL ELIMINAR EDITORIAL POR NOMBRE\n" + e.getMessage()); //Podria ponerlo pero ya le mando el throw de la Excepcion del servicio del metodo que la busca y del que la elimina
//        }
    }

//============================ MÉTODOS DE AUTOR ================================
    //OK
    private void mostrarAutores() throws Exception {
        servicioAutor.listarAutores();
    }
    //OK 
    private void crearAutor() throws Exception {
        System.out.println("INGRESE NOMBRE: ");
        String nombre = leer.next();

        Autor aux = servicioAutor.buscarPorNombre(nombre);

        if (aux == null) {
            servicioAutor.crearAutor(nombre);
            System.out.println("AUTOR CREADO");
        } else {
            System.out.println("Ya existe un Autor con ese nombre");
        }
    }
    //OK
    private void modificarAutor() throws Exception {
        System.out.println("INGRESE NOMBRE ACTUAL: ");
        String nombreAct = leer.next();
        System.out.println("INGRESE NOMBRE A MODIFICAR: ");
        String nombreNuevo = leer.next();

        //Al libro lo puedo modificar antes o despues solo cambiando nombre actual por nombre nuevo.
//        List <Libro> libros = servicioLibro.buscarPorAutor(nombreAct); //Lo tuve que hacer manual porque se actualizaba en libro cuando cerraba el output y lo volvia a abrir, lo busco por el nombre nuevo porque lo buscamos en la linea siguiente de que lo cambiamos en autor, si lo poniamos en la linea anterior de cambiarlo seria con el nombre actual(es lo mismo)
//        if (libros.isEmpty()) { //Si tuviera cascade type en refresh podria actualizarlo solo y cambiarlo directamente desde un metodo en servicelibro
//            System.out.println("NO EXITEN LIBROS PARA ESE AUTOR");
//            //throw new Exception("NO EXISTEN LIBROS PARA ESTE AUTOR");
//        }else{
//            for (Libro aux : libros) {
//            aux.getAutor().setNombre(nombreNuevo);
//            System.out.println("LIBRO MODIFICADO\n");
//            }
//        }   
        servicioAutor.modificarAutor(nombreAct, nombreNuevo);

        List<Libro> libros = servicioLibro.buscarPorAutor(nombreNuevo); //Lo tuve que hacer manual porque se actualizaba en libro cuando cerraba el output y lo volvia a abrir, lo busco por el nombre nuevo porque lo buscamos en la linea siguiente de que lo cambiamos en autor, si lo poniamos en la linea anterior de cambiarlo seria con el nombre actual(es lo mismo)
        if (libros.isEmpty()) { //Si tuviera cascade type en refresh podria actualizarlo solo y cambiarlo directamente desde un metodo en servicelibro
            System.out.println("NO EXISTEN LIBROS PARA ESE AUTOR");
        } else {
            for (Libro aux : libros) {
                aux.getAutor().setNombre(nombreNuevo);
                System.out.println("LIBRO MODIFICADO\n");
            }
        }
    }
    //OK
    private void buscarAutorPorID() throws Exception {
        System.out.println("INGRESE ID: ");
        Autor autor = servicioAutor.buscarPorId(leer.next());
        if (autor != null) {
            System.out.println("*** AUTOR ***");
            System.out.printf("%-20s%-30s\n", "NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
            System.out.println(autor);
        } else {
            System.out.println("NO SE ENCONTRO NINGÚN AUTOR.");
        }
    }
    //OK
    private void buscarAutorPorNombre() throws Exception {
        System.out.println("INGRESE NOMBRE: ");
        Autor autor = servicioAutor.buscarPorNombre(leer.next());
        if (autor != null) {
            System.out.println("*** AUTOR ***");
            System.out.printf("%-20s%-30s\n", "NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
            System.out.println(autor);
        } else {
            System.out.println("NO SE ENCONTRO NINGÚN AUTOR.");
        }
    }

    //ARREGLAR
    private void borrarAutorPorID() throws Exception {
        System.out.println("INGRESE ID: ");
        String id = leer.next();
        Autor autor = servicioAutor.buscarPorId(id);
        if (autor == null) {
            throw new Exception("El autor ingresado no existe");
        }
        List <Libro> libros = servicioLibro.buscarPorAutor(id);
        if (libros == null) {
            System.out.println("NO EXISTEN LIBROS PARA ESTE AUTOR");
        }else{
            servicioLibro.eliminarPorAutor(autor.getNombre());
            System.out.println("LIBRO ELIMINADO\n");
        }
    }

    //ARREGLAR
    private void borrarAutorPorNombre() throws Exception {
        System.out.println("INGRESE AUTOR: ");
        String nombre = leer.next();
        servicioAutor.eliminarPorNombre(nombre);

//        Autor autor = servicioAutor.buscarPorNombre(nombre);
//        servicioLibro.buscaPorAutor(autor.getNombre());
    }
}
