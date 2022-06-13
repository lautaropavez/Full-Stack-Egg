package libreria.servicio;

import java.util.List;
import java.util.UUID;
import libreria.entidades.Autor;
import libreria.persistencia.AutorDAO;

/**
 *
 * @author Lautaro Pavez
 */
public class ServiceAutor {

    private AutorDAO autorDAO;
    
    public ServiceAutor() {
        this.autorDAO = new AutorDAO();
    }

    public Autor crearAutor(String nombre) {
        Autor autor = new Autor();
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del autor");
            }
            if (buscarPorNombre(nombre) != null ) {
                throw new Exception("Ya existe una editorial con ese nombre");
            }
            autor.setNombre(nombre);
            autor.setId(UUID.randomUUID().toString().replaceAll("-", "")); // 2° Clase Min 24 Esta es la forma de convertirlo en String porque Eclipse tiene que hacerlo desde el servicio y no puede hacerlo desde la entidad, en Hibernate para las paginas web ya esto lo vamos a hacer directamente con una anotacion en la identidad
            autor.setAlta(Boolean.TRUE);
            autorDAO.guardarAutor(autor);
            return autor;
        } catch (Exception e) {
            System.out.println("No se guardo el Autor de forma correcta" + e.getMessage());
            return null;
        }
    }

    public void modificarAutor(String nombre, String nuevonombre)throws Exception {
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre actual");
            }
            if (nuevonombre == null || nuevonombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nuevo nombre");
            }
            //Buscamos
            Autor autor = autorDAO.buscarAutorPorNombre(nombre);
            Autor autor2 = autorDAO.buscarAutorPorNombre(nuevonombre);
            
            //Validamos
            if (autor == null) {
                throw new Exception("El nombre actual no es el registrado en el sistema para el nombre indicado");
            }
            if (!autor.getNombre().equalsIgnoreCase(nombre)) { 
                throw new Exception("El nombre actual no es el registrado en el sistema para el nombre indicado");
            }
            if (autor2 == null) {
                autor.setNombre(nuevonombre);
                autorDAO.guardarAutor(autor);
                System.out.println("\nAUTOR MODIFICADO CON EXITO\n");
            }else{
                if (autor2.getNombre().equalsIgnoreCase(nuevonombre)) {
                throw new Exception("El nombre indicado para cambiar ya existe");
                }
            }
            
            
            //Modificamos
            
        } catch (Exception e) {
//            System.out.println("El nombre actual no es el registrado en el sistema para el nombre indicado. " + e.getMessage());
            throw e;
        }
    }

    public Autor buscarPorId(String id) throws Exception {
        try {
            //Validamos
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("Debe indicar el id del Autor");
            }
            Autor autor = autorDAO.buscarAutorPorId(id);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            //throw e;
            return null;
        }
    }

    public Autor buscarPorNombre(String nombre)throws Exception {
        try {
            //Validamos 
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del Autor");
            }
        } catch (Exception e) {
            throw e;
        }
        //Buscamos
        Autor autor = autorDAO.buscarAutorPorNombre(nombre);
        return autor;   
    }

    public void eliminarPorId(String id) throws Exception {
        try {
            // VALIDACIÓN
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("Debe indicar el id del Autor");
            }
            //Buscamos
            Autor autor = autorDAO.buscarAutorPorId(id);
            if (autor == null) {
                throw new Exception("El id ingresado no está asociado a ningún Autor");
            }
            autorDAO.eliminarAutorPorId(id);
            System.out.println("AUTOR ELIMINADO CON EXITO");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR AL ELIMINAR. ");
            throw e;
        }
    }

    public void eliminarPorNombre(String nombre)throws Exception {
        Autor autor = null;
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre del autor");
            }
            //Eliminamos
            autorDAO.eliminarAutorPorNombre(nombre);
            System.out.println("AUTOR ELIMINADO CON EXITO");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR AL ELIMINAR. ");
            throw e;
        }
    }
//    public void eliminarPorTitulo(String titulo) throws Exception {
//        Libro libro = null;
//        try {
//            
//            //Buscamos
//            libro = daolibro.buscarPorTitulo(titulo);
//            if (libro == null) {
//                throw new Exception("El titulo ingresado no está asociado a ningún libro");
//            }
//            //Eliminamos
//            daolibro.eliminarPorTitulo(titulo);
//            System.out.println("LIBRO ELIMINADO CON EXITO");
//        } catch (Exception e) {
//            // e.printStackTrace();
//            System.out.println("ERROR AL ELIMINAR. ");
//            throw e;
//        }
//    }
    public void listarAutores() throws Exception { 
        try {
            List<Autor> autores = autorDAO.listarAutores();

            if (autores.isEmpty()) {
                throw new Exception("NO EXISTEN AUTORES");
            } else {
                System.out.println("*** LISTA DE AUTORES ***");

                System.out.printf("%-20s%-30s\n","NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
                for (Autor aux : autores) {
                    System.out.println(aux);
                    //System.out.printf("%-20s%-30s\n", aux.getNombre(), aux.getId());
                }
                System.out.println();
            }
        } catch (Exception e) {
            // e.printStackTrace();
            throw e;
            //System.out.println("ERROR DE SISTEMA. "); // Se lo saco porque si esta vacio no es un error, solo esta vacio pero va a mostrar este mensaje y no deberia.
            
        }
    }

}
