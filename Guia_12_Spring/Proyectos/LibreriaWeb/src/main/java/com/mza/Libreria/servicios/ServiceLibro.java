package com.mza.Libreria.servicios;

import com.mza.Libreria.entidades.Autor;
import com.mza.Libreria.entidades.Editorial;
import com.mza.Libreria.entidades.Libro;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.repositorios.LibroRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lautaro Pavez
 */
// 22 min descanso 
// En clases quede en min 33 y 30
//Nota: Cuando creemos el libro vamos a tener que buscar si existen las editoriales, autores y mostrarlos (si quiere para elegir) sino, si no está que lo ingrese directamente 
//      Dar de baja por autor y editorial
@Service
public class ServiceLibro {

    @Autowired
    private LibroRepository libroRepo;

    @Autowired
    private ServiceAutor sAutor;

    @Autowired
    private ServiceEditorial sEditorial;

    @Transactional
    public void crearLibro(String titulo, Integer anio, String nombreAut, String nombreEdit) throws MiExcepcion {

        validacion(titulo, anio, nombreAut, nombreEdit);
        Libro lib = new Libro();
        //Magia para obtener los ejemplares
        int ejemplares = (int) (Math.random() * 999 + 1);
        int prestados = ejemplares - (int) (Math.random() * 88 + 1);

        lib.setTitulo(titulo.trim());//Remuevo espacios al principio y al final del título
        lib.setAnio(anio);
        lib.setAlta(Boolean.TRUE);
        lib.setNroejemplares(ejemplares);
        lib.setEjemplaresPrestados(prestados);
        lib.setEjemplaresRestantes(ejemplares - prestados);
        lib.setIsbn((long) (int) (Math.random() * 999999 + 1));

        Autor autor = sAutor.buscarporNombre(nombreAut.toUpperCase());
        if (autor == null) {
            sAutor.crearAutor(nombreAut);
            //Autor autornuevo = sAutor.buscarporNombre(nombreAut.toUpperCase());
            //Aib.setAutor(lib.getAutor());
            //Aib.setAutor(sAutor.buscarporId(lib.getAutor().getId()));
        } else {
            lib.setAutor(autor);
        }

        Editorial editorial = sEditorial.buscarporNombre(nombreEdit.toUpperCase());
        if (editorial == null) {
            sEditorial.crearEditorial(nombreEdit);
        } else {
            lib.setEditorial(editorial);
        }

        libroRepo.save(lib);        // Esto es igual al --> daolibro.guardarLibro(lib);
    }

    //2 Formas de buscar por Id 
    public Libro buscarPorId(String id) throws MiExcepcion {
        Optional<Libro> l = libroRepo.findById(id);
        if (l.isPresent()) {
            Libro lib = l.get();
            return lib;
        } else {
            throw new MiExcepcion("Este libro no existe.");
        }
    }

    @Transactional
    public Libro findbyId(String id) throws MiExcepcion {
        Libro l = libroRepo.buscarPorId(id);
        if (l != null) {
            return l;
        } else {
            throw new MiExcepcion("Este libro no existe.");
        }
    }

    @Transactional
    public void modificarLibro(String id, String titulo, Integer anio, String nombreAut, String nombreEdit) throws MiExcepcion {

        validacion(titulo, anio, nombreAut, nombreEdit);

        Libro libro = libroRepo.buscarPorId(id);
        if (libro != null) {

            if (!libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.setTitulo(titulo.toUpperCase());
            }
            if (!libro.getAnio().equals(anio)) {
                libro.setAnio(anio);
            }
            if (!libro.getAutor().getNombre().equalsIgnoreCase(nombreAut)) {
                libro.setAutor(sAutor.modificarAutor(nombreAut));
            }
            if (!libro.getEditorial().getNombre().equalsIgnoreCase(nombreEdit)) {
                libro.setEditorial(sEditorial.modificarEditorial(nombreEdit));
            }
            //Verifico que exista algun cambio entre los dos objetos
            if (libro.getTitulo().equalsIgnoreCase(titulo)
                    && libro.getAnio().equals(anio)
                    && libro.getAutor().getNombre().equalsIgnoreCase(nombreAut)
                    && libro.getEditorial().getNombre().equalsIgnoreCase(nombreEdit)) {
                throw new MiExcepcion("No existen cambios para editar");
            }
            libroRepo.save(libro);
        } else {
            throw new MiExcepcion("No se encontró a este libro en la base de datos");
        }
    }

    @Transactional // Clase servicio tarde min 37
    public void eliminarLibro(String id) throws Exception {
        Libro l = libroRepo.buscarPorId(id);
        if (l != null) {
            throw new Exception("No se encontró a este libro en la base de datos");
        } else {
            libroRepo.deleteById(id);
        }
    }

    @Transactional
    public void eliminarLibro(Libro libro) throws Exception {
        Libro l = libroRepo.buscarPorId(libro.getId());
        if (l != null) {
            throw new Exception("No se encontró a este libro en la base de datos");
        } else {
            libroRepo.deleteById(libro.getId());
        }

    }

    @Transactional(readOnly = true)
    public List<Libro> listarTodos() {
        return libroRepo.findAll();
    }

    //Servicios Spring - Tarde: Min 11:30 muestra método de validación que tiene ella en su clase
    public void validacion(String titulo, Integer anio, String nombreAut, String nombreEdit) throws MiExcepcion {

        if (titulo == null || titulo.isEmpty()) {
            throw new MiExcepcion("Debe indicar el título");
        }
        if (anio == null || anio < 0 || anio > 2100) {
            throw new MiExcepcion("Debe indicar el año");
        }
        if (nombreAut == null || nombreAut.trim().isEmpty()) {
            throw new MiExcepcion("Debe indicar el nombre del Autor");
        }
        if (nombreEdit == null || nombreEdit.trim().isEmpty()) {
            throw new MiExcepcion("Debe indicar el nombre de la Editorial");
        }
    }
    
//    //Otra manera mandando el objeto y retornandolo
//    @Transactional
//    public Libro modificarLibro(Libro editado) throws MiExcepcion{
//
//        validacion(editado.getTitulo(), editado.getAnio(), editado.getAutor().getNombre(), editado.getEditorial().getNombre());
//
//        Libro libro = libroRepo.buscarPorId(editado.getId());
//        if (libro != null) {
//            if (!editado.getTitulo().equalsIgnoreCase(libro.getTitulo())){
//                libro.setTitulo(editado.getTitulo().toUpperCase());
//            }
//            if (!editado.getAnio().equals(libro.getAnio())){
//                libro.setAnio(editado.getAnio());
//            }
//            if (!editado.getAutor().getNombre().equalsIgnoreCase(libro.getAutor().getNombre())){
//                libro.setAutor(sAutor.modificarAutor(editado.getAutor().getNombre()));
//            }
//            if (!editado.getEditorial().getNombre().equalsIgnoreCase(libro.getEditorial().getNombre())){
//                libro.setEditorial(sEditorial.modificarEditorial(editado.getEditorial().getNombre()));
//            }
//            //Verifico que exista algun cambio entre los dos objetos
//            if (editado.getTitulo().equalsIgnoreCase(libro.getTitulo())
//                    && editado.getAnio().equals(libro.getAnio())
//                    && editado.getAutor().getNombre().equalsIgnoreCase(libro.getAutor().getNombre())
//                    && editado.getEditorial().getNombre().equalsIgnoreCase(libro.getEditorial().getNombre())) {
//                throw new MiExcepcion("No existen cambios para editar");
//            }
//            return libroRepo.save(libro);
//        } else {
//            throw new MiExcepcion("No se encontró a este libro en la base de datos");
//        }
//    }

    

      //Así seria si lo hiciera con el String nombre(método no arreglado)
//    public void validacionAutor(String nombre) throws Exception {
//
//        Autor a = sAutor.buscarporNombre(nombre);
//        if (a == null) {
//            sAutor.crearAutor(nombre);
//        } else {
//            libro.setAutor(a);
//        }
//    }
}
