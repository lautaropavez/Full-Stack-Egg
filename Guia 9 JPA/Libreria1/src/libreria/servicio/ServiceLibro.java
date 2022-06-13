package libreria.servicio;

import java.util.List;
import java.util.UUID;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.persistencia.LibroDAO;

/**
 *
 * @author Lautaro Pavez
 */
// Anotación: cuando yo pongo throw new Exception("blablabla") dentro de un if por ej,si ocurre un error por ese if, en el catch cuando yo ponga throw e me va a mandar ese mensaje "blablabla". Porque yo en el catch puse Exception e y despues llamo a esa excepcion
public class ServiceLibro {

    private final LibroDAO daolibro;
    private final ServiceAutor servAut;
    private final ServiceEditorial servEdit;

    public ServiceLibro() {
        this.daolibro = new LibroDAO();
        this.servAut = new ServiceAutor();
        this.servEdit = new ServiceEditorial();
        
    }

    public void crearLibro(String titulo, Integer anio, String nombreAut, String nombreEdit) throws Exception {
        try {
            //Validamos
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave");
            }
            if (anio == null || anio < 0) {
                throw new Exception("Debe indicar el año");
            }
            if (nombreAut == null || nombreAut.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre");
            }
            if (nombreEdit == null || nombreEdit.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave");
            }

            //Creamos el libro
            Libro libronuevo = new Libro();

            libronuevo.setTitulo(titulo);
            libronuevo.setAnio(anio);
            libronuevo.setAlta(Boolean.TRUE);
            libronuevo.setId(UUID.randomUUID().toString());//CADENA DE CARACTERES-->  2° Clase Min 24 Esta es la forma de convertirlo en String porque Eclipse tiene que hacerlo desde el servicio y no puede hacerlo desde la entidad, en Hibernate para las paginas web ya esto lo vamos a hacer directamente con una anotacion en la identidad
          //libronuevo.setId(UUID.randomUUID().toString().replaceAll("-", ""));   //Otra manera de hacerlo
            Autor nuevoAutor = servAut.crearAutor(nombreAut); // Manera en que lo hace la profe, solo habria que cambiar que se piden por String los datos a crearLibro y no el objeto 
            Editorial nuevaEditorial = servEdit.crearEditorial(nombreEdit);
            libronuevo.setAutor(nuevoAutor);
            libronuevo.setEditorial(nuevaEditorial);
            
            //Magia para obtener los ejemplares
            int ejemplares = (int) (Math.random() * 999 + 1);
            int prestados = ejemplares - (int) (Math.random() * 88 + 1);

            libronuevo.setIsbn((long) (int) (Math.random() * 999999 + 1));

            libronuevo.setNroejemplares(ejemplares);;
            libronuevo.setEjemplaresPrestados(prestados);
            libronuevo.setEjemplaresRestantes(ejemplares - prestados);

            daolibro.guardarLibro(libronuevo);
        } catch (Exception e) {
            System.out.println("No se creo el usuario. " + e.getMessage());
        }
    }

    public void modificarTitulo(String tituloActual, String tituloNuevo) throws Exception {
        try {
            //Validamos
            if (tituloActual == null || tituloActual.trim().isEmpty()) {
                throw new Exception("Debe indicar el titulo actual");
            }
            if (tituloNuevo == null || tituloNuevo.trim().isEmpty()) {
                throw new Exception("Debe indicar el titulo nuevo");
            }
            
            //Buscamos
            Libro libro = buscarPorTitulo(tituloActual);
            
            //Validamos
            if (!libro.getTitulo().equalsIgnoreCase(tituloActual)) {
                throw new Exception("El titulo actual no es el registrado en el sistema para el titulo indicado");
            }
            if(libro.getTitulo().equalsIgnoreCase(tituloNuevo)) {
                throw new Exception("El titulo nuevo es igual al actual.");
            } 

            //Modificamos
            libro.setTitulo(tituloNuevo);
            daolibro.modificarLibro(libro);
            System.out.println("TITULO MODIFICADO CON EXITO\n");
        } catch (Exception e) {
            System.out.println("ERROR AL MODIFICAR. " + e.getMessage());
        }
    }

    public void modificarISBN(Long actualisbn, Long nuevoisbn) throws Exception {
        try {
            //Validamos

            if (actualisbn == null || actualisbn < 0) {
                throw new Exception("Debe indicar el ISBN actual");
            }
            if (nuevoisbn == null || nuevoisbn < 0) {
                throw new Exception("Debe indicar el ISBN nuevo");
            }
            //Buscamos
            Libro libro = buscarPorISBN(actualisbn);

            if (!libro.getIsbn().equals(actualisbn)) {
                throw new Exception("El ISBN actual no es el registrado en el sistema para el ISBN indicado");
            }
            if (libro.getIsbn().equals(nuevoisbn)) {
                throw new Exception("El ISBN nuevo es igual al actual.");
            }

            //Modificamos
            libro.setIsbn(nuevoisbn);
            daolibro.modificarLibro(libro);
            System.out.println("ISBN MODIFICADO CON EXITO\n");
        } catch (Exception e) {
            System.out.println("ERROR AL MODIFICAR. " + e.getMessage());
        }
    }

    public void modificarAnio(String id, Integer anioActual, Integer anioNuevo) throws Exception {
        try {
            //Validamos
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("Debe indicar el libro");
            }
            if (anioActual == null || anioActual < 0) {
                throw new Exception("Debe indicar el anio actual");
            }
            if (anioNuevo == null || anioNuevo < 0) {
                throw new Exception("Debe indicar el anio nuevo");
            }
            //Buscamos
            Libro libro = buscarPorId(id);
            
            if (!libro.getAnio().equals(anioActual)) {
                throw new Exception("El anio actual no es el registrado en el sistema para el anio indicado");
            }
            if (libro.getAnio().equals(anioNuevo)) {
                throw new Exception("El anio nuevo es igual al actual.");
            }

            //Modificamos
            libro.setAnio(anioNuevo);
            daolibro.modificarLibro(libro);
            System.out.println("AÑO MODIFICADO CON EXITO\n");
        } catch (Exception e) {
            System.out.println("ERROR AL MODIFICAR. " + e.getMessage());
        }
    }

    public Libro buscarPorId(String id) throws Exception {
        try {
            //Validamos
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("Debe indicar el id del libro");
            }
            Libro libro = daolibro.buscarPorId(id);
            return libro;
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR POR ID. ");
            throw e;
        }
    }

    public Libro buscarPorISBN(Long isbn) throws Exception {
        try {
            //Validamos
            if (isbn == null || isbn < 0) {
                throw new Exception("Debe indicar el ISBN del libro");
            }
            Libro libro = daolibro.buscarPorISBN(isbn);
            return libro;
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR POR ISBN. ");
            throw e;
        }
    }

    public Libro buscarPorTitulo(String titulo) throws Exception {
        try {
            //Validamos
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar el titulo del libro");
            }
            Libro libro = daolibro.buscarPorTitulo(titulo);
            return libro;
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR POR TITULO. ");
            throw e;
        }
    }
    
    public void buscaPorAutor(String nombre) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del Autor");
            }
            
            List<Libro> buscado = daolibro.buscarPorAutor(nombre);
            
            if (buscado.isEmpty()) {
                throw new Exception("NO EXISTEN LIBROS DE ESTE AUTOR");
            } else {
                System.out.println("\n*** LISTA DE LIBROS ***");
               System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR","AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/

                for (Libro aux : buscado) {
                    System.out.println(aux);  
                  //System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", aux.getIsbn(), aux.getTitulo(), aux.getAutor().getNombre(),aux.getAnio(), aux.getEditorial().getNombre());
                }
                System.out.println();
            }
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR AL BUSCAR POR AUTOR. ");
            throw e;
        }
    }

    public void buscaPorEditorial(String nombre) throws Exception {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre de la Editorial");
            }
            List<Libro> buscado = daolibro.buscarPorEditorial(nombre);
            
            if (buscado.isEmpty()) {
                throw new Exception("NO EXISTEN LIBROS DE ESTA EDITORIAL");
            } else {
                System.out.println("\n*** LISTA DE LIBROS ***");
               System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR","AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/

                for (Libro aux : buscado) {
                    System.out.println(aux);
                  //System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", aux.getIsbn(), aux.getTitulo(), aux.getAutor().getNombre(),aux.getAnio(), aux.getEditorial().getNombre());
                }
                System.out.println();
            }
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR AL BUSCAR POR EDITORIAL. ");
            throw e;
        }
    }
    
    public void eliminarPorId(String id) throws Exception {
        try {
            // VALIDACIÓN
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("Debe indicar el id del libro");
            }
            //Buscamos
            Libro libro = daolibro.buscarPorId(id);
            if (libro == null) {
                throw new Exception("El id ingresado no está asociado a ningún libro");
            }
            daolibro.eliminarPorId(id);
            System.out.println("LIBRO ELIMINADO CON EXITO");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR AL ELIMINAR. ");
            throw e;
        }
    }

    public void eliminarPorISBN(Long isbn) throws Exception {
        try {
            // VALIDACIÓN
            if (isbn == null || isbn < 0) {
                throw new Exception("Debe indicar el ISBN del libro");
            }
            //Buscamos
            Libro libro = daolibro.buscarPorISBN(isbn);
            if (libro == null) {
                throw new Exception("El ISBN ingresado no está asociado a ningún libro");
            }
            //Eliminamos
            daolibro.eliminarPorISBN(isbn);
            System.out.println("LIBRO ELIMINADO CON EXITO");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR AL ELIMINAR. ");
            throw e;
        }
    }

    public void eliminarPorTitulo(String titulo) throws Exception {
        try {
            // VALIDACIÓN
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new Exception("Debe indicar el titulo del libro");
            }
            //Buscamos
            Libro libro = daolibro.buscarPorTitulo(titulo);
            if (libro == null) {
                throw new Exception("El titulo ingresado no está asociado a ningún libro");
            }
            //Eliminamos
            daolibro.eliminarPorTitulo(titulo);
            System.out.println("LIBRO ELIMINADO CON EXITO");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR AL ELIMINAR. ");
            throw e;
        }
    }
    
    public void eliminarPorEditorial(String nombEditorial) throws Exception {
        try {
            // VALIDACIÓN
            if (nombEditorial == null || nombEditorial.trim().isEmpty()) {
                throw new Exception("Debe indicar la Editorial");
            }
            //Buscamos
            Editorial editorial = servEdit.buscarPorNombre(nombEditorial);
            List <Libro> libros = daolibro.buscarPorEditorial(nombEditorial);
            if (libros == null) {
                throw new Exception("La editorial ingresada no está asociada a ningún libro");
            }
            //Eliminamos
            
            daolibro.eliminaPorEditorial(editorial);
            System.out.println("LIBROS ELIMINADOS CON EXITO");
        } catch (Exception e) {
            System.out.println("ERROR AL ELIMINAR. ");
            throw e;
        }
    }
    
    public void listaPorAnio(Integer anio) throws Exception {
        try {
            if (anio == null || anio < 0) {
                throw new Exception("Debe indicar el año del libro");
            }
            List<Libro> buscado = daolibro.buscarPorAnio(anio);
            if (buscado.isEmpty()) {
                throw new Exception("NO EXISTEN LIBROS DE ESTA EDITORIAL");
            } else {
                System.out.println("\n*** LISTA DE LIBROS ***");
                                 
               System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR","AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN, + INFO sobre System.out.printf("") https://xperti.io/blogs/formatting-with-printf-in-java/

                for (Libro aux : buscado) {
                    System.out.println(aux);
                    //System.out.printf("%-20s%-35s%-25s%-25s\n", aux.getIsbn(), aux.getTitulo(), aux.getAutor().getNombre(), aux.getEditorial().getNombre());
                }
                System.out.println();
            }
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR DE SISTEMA. ");
            throw e;
        }
    }
    
    public void listarLibros() throws Exception { 
        try {
            List<Libro> libros = daolibro.listarTodos();

            if (libros.isEmpty()) {
                throw new Exception("NO EXISTEN LIBROS");
            } else {
                System.out.println("*** LISTA DE LIBROS ***");

                System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", "ISBN", "TITULO", "AUTOR", "AÑO", "EDITORIAL"); // FORMATO DE IMPRESIÓN
                for (Libro aux : libros) {
                    System.out.printf("%-15s%-30s%-25s%-8s%-25s\n", aux.getIsbn(), aux.getTitulo(), aux.getAutor().getNombre(),aux.getAnio(), aux.getEditorial().getNombre());
                }
                System.out.println();
            }
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR DE SISTEMA. ");
            throw e;
        }
    }
    
    //OTRA MANERA DE LISTAR (EN VEZ DE PONER LOS SOUT PARA MOSTRAR EN EL SERVICE LO HACEMOS EN EL MENÚ)
    public List<Libro> listarPorAnio(Integer anio) throws Exception {
        try {
            if (anio == null || anio < 0) {
                throw new Exception("Debe indicar el año del libro");
            }

            List<Libro> libros = daolibro.buscarPorAnio(anio);
            return libros;
        }catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR DE SISTEMA. ");
            throw e;
        }
    }
    
    //OTRA MANERA DE LISTAR (EN VEZ DE PONER LOS SOUT PARA MOSTRAR EN EL SERVICE LO HACEMOS EN EL MENÚ) ACLARACIÓN: NO ESTÁ HECHO EL METODO CON LOS SOUTS EN EL MENU PARA USAR ESTE METODO    
    public List<Libro> buscarPorAutor(String nombre) {
        // VALIDACIÓN
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del Autor");
            }

            List<Libro> buscado = daolibro.buscarPorAutor(nombre);

            return buscado;

        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR POR AUTOR. " + e.getMessage());
            return null;
        }
    }
    
    //OTRA MANERA DE LISTAR (EN VEZ DE PONER LOS SOUT PARA MOSTRAR EN EL SERVICE LO HACEMOS EN EL MENÚ) ACLARACIÓN: NO ESTÁ HECHO EL METODO CON LOS SOUTS EN EL MENU PARA USAR ESTE METODO    
    public List<Libro> buscarPorEditorial(String nombre) {
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre de la Editorial");
            }

            List<Libro> buscado = daolibro.buscarPorEditorial(nombre);

            return buscado;
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR POR EDITORIAL. " + e.getMessage());
            return null;
        }
    }
    

}
