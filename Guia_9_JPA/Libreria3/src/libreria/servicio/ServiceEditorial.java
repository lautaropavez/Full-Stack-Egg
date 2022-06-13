package libreria.servicio;

import java.util.List;
import java.util.UUID;
import libreria.entidades.Editorial;
import libreria.persistencia.EditorialDAO;

/**
 *
 * @author Lautaro Pavez
 */
public class ServiceEditorial {

    private EditorialDAO editorialDAO;
    
    public ServiceEditorial() {
        this.editorialDAO = new EditorialDAO();
    }

    public Editorial crearEditorial(String nombre) {
        Editorial editorial = new Editorial();
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre de la editorial");
            }
            if (buscarPorNombre(nombre) != null ) {
                throw new Exception("Ya existe una editorial con ese nombre");
            }
    
            editorial.setNombre(nombre);
            editorial.setId(UUID.randomUUID().toString().replaceAll("-", "")); // 2° Clase Min 24 Esta es la forma de convertirlo en String porque Eclipse tiene que hacerlo desde el servicio y no puede hacerlo desde la entidad, en Hibernate para las paginas web ya esto lo vamos a hacer directamente con una anotacion en la identidad
            editorial.setAlta(Boolean.TRUE);
            editorialDAO.guardarEditorial(editorial);
            return editorial;
        } catch (Exception e) {
            System.out.println("No se guardo la Editorial de forma correcta " + e.getMessage());
            return null;
        }
    }

    public void modificarEditorial(String nombre, String nuevonombre) throws Exception{
        try {
            //Validamos
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre actual");
            }
            if (nuevonombre == null || nuevonombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nuevo nombre");
            }
            //Buscamos
            Editorial editorial = editorialDAO.buscarEditorialPorNombre(nombre);

            //Validamos
            if (!editorial.getNombre().equalsIgnoreCase(nombre)) {
                throw new Exception("El nombre actual no es el registrado en el sistema para el nombre indicado");
            }
            //Modificamos
            editorial.setNombre(nuevonombre);
            editorialDAO.guardarEditorial(editorial);
            System.out.println("EDITORIAL MODIFICADA CON EXITO\n");
        } catch (Exception e) {
            System.out.println("ERROR AL MODIFICAR EDITORIAL. ");
//            System.out.println(e.getMessage());
            throw e;

        }
    }

    public Editorial buscarPorId(String id) throws Exception {
        try {
            //Validamos
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("Debe indicar el id de la editorial");
            }
            Editorial editorial = editorialDAO.buscarEditorialPorId(id);
            return editorial;
        } catch (Exception e) {
            System.out.println("ERROR AL BUSCAR POR ID.\n ");
            throw e;
        }
    }

    public Editorial buscarPorNombre(String nombre) throws Exception {
        try {
            //Validamos 
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre de la editorial");
            }
            //Buscamos
            try {
                Editorial editorial = editorialDAO.buscarEditorialPorNombre(nombre);
                return editorial;
            } catch (Exception e){
                //System.out.println("NO SE ENCONTRO LA EDITORIAL.");
                return null;
            }   
        } catch (Exception e) {
            throw e;
            
        }
    }
    
//    public Editorial buscarPorNombre(String nombre) throws Exception {
//        try {
//            //Validamos 
//            if (nombre == null || nombre.trim().isEmpty()) {
//                throw new Exception("Debe indicar el nombre de la editorial");
//            }
//            //Buscamos
//            try {
//                Editorial editorial = editorialDAO.buscarEditorialPorNombre(nombre);
//                return editorial;
//            } catch (Exception e){
//                System.out.println("NO SE ENCONTRO LA EDITORIAL.");
//                return null;
//            }   
//        } catch (Exception e) {
//            System.out.println("NO SE ENCONTRO LA EDITORIAL.");
//            return null;
//            throw e;
//        }
//    }

    public void eliminarPorId(String id) throws Exception {
        try {
            // VALIDACIÓN
            if (id == null || id.trim().isEmpty()) {
                throw new Exception("Debe indicar el id de la editorial");
            }
            editorialDAO.eliminarEditorialPorId(id);
            System.out.println("EDITORIAL ELIMINADA CON EXITO");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR AL ELIMINAR. ");
            throw e; 
        }
    }

    public void eliminarPorNombre(String nombre)throws Exception {
        try {
            // VALIDACIÓN
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe indicar el nombre de la editorial");
            }
            
            editorialDAO.eliminarEditorialPorNombre(nombre);
            System.out.println("EDITORIAL ELIMINADA CON EXITO");
        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("ERROR AL ELIMINAR. ");
            throw e;        
        }
    }

    public void listarEditoriales() throws Exception { 
        //List<Editorial> editoriales = null;  //Otra manera y abajo pongo editoriales solo
        try {
            List<Editorial> editoriales = editorialDAO.listarEditoriales();

            if (editoriales.isEmpty()) {
                throw new Exception("NO EXISTEN EDITORIALES");
            } else {
                System.out.println("*** LISTA DE EDITORIALES ***");

                System.out.printf("%-20s%-30s\n","NOMBRE", "ID"); // FORMATO DE IMPRESIÓN
                for (Editorial aux : editoriales) {
                    System.out.println(aux);
                    //System.out.printf("%-20s%-30s\n", aux.getNombre(), aux.getId());
                }
                System.out.println();
            }
        } catch (Exception e) {
            // e.printStackTrace();
            throw e;
            //System.out.println("ERROR DE SISTEMA. ");// Se lo saco porque si esta vacio no es un error, solo esta vacio pero va a mostrar este mensaje y no deberia.
            
        }
    }
}
