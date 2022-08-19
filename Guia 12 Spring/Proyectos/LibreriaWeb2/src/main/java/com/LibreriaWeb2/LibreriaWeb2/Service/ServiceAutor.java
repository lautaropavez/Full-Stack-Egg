
package com.LibreriaWeb2.LibreriaWeb2.service;

import com.LibreriaWeb2.LibreriaWeb2.entidades.Autor;
import com.LibreriaWeb2.LibreriaWeb2.excepciones.MiExcepcion;
import com.LibreriaWeb2.LibreriaWeb2.repositorios.AutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lautaro Pavez
 */
//Todo ok, falta ver tema de baja y alta, chequeado tambien con clase de acamus.
//No tengo metodo modificar porque se modifica solo en el libro

@Service
public class ServiceAutor {

    @Autowired
    private AutorRepository autorRepo;
    
    @Transactional
    public void crearAutor(String nombre) throws MiExcepcion {
        
        Autor autor = new Autor();
        autor.setNombre(nombre.toUpperCase());
        autor.setAlta(Boolean.TRUE);

        autorRepo.save(autor); // Esto es igual en JPA al --> daolibro.guardarLibro(lib);
    }
       
    @Transactional(readOnly = true)
    public Autor buscarporId(String id){
        return autorRepo.buscarPorId(id); 
    }
   
    @Transactional(readOnly = true)
    public Autor buscarPorNombre(String nombre) {
        return autorRepo.buscarPorNombre(nombre); 
    }
    
    //Busca todos los autores(activos e inactivos)
    @Transactional(readOnly = true)
    public List<Autor> buscaTodos() {
        return autorRepo.findAll(); 
    }
    
    //Busca todos los autores activos
    @Transactional(readOnly = true)
    public List<Autor> buscaActivos() {
        return autorRepo.buscaActivos(); 
    }
    
    @Transactional // Clase servicio tarde min 37
    public void eliminarAutor(String id) throws Exception {
        Autor a = autorRepo.buscarPorId(id);
        if (a != null) {
            throw new Exception("No se encontró a este Autor en la base de datos");
        } else {
            autorRepo.deleteById(id);
        }
    }

    //------------------------------- NO USADOS --------------------------------
    
//    @Transactional
//    public Autor modificarAutor(String nombre) throws MiExcepcion { 
//        Autor autoreditado = autorRepo.buscarPorNombre(nombre);
//        if (autoreditado != null) {                                //Explicación lógica del método: Si autoredit es distinto a null, existe por lo tanto existe algún libro con ese autor
//            autoreditado.setNombre(nombre);                        //Posible linea innecesaria
//            return autorRepo.save(autoreditado);
//        } else {                                                   //Si no lo encuentra quiere decir que no existe ningún libro con ese autor por lo tanto sería un error
//            throw new MiExcepcion("No se encontró a este Autor en la base de datos.");
//        }
//    }
    
    //Nose si lo usaré, en buscar por nombre busco solo un objeto pq lo necesito asi para las validaciones si existe un autor o no
    @Transactional(readOnly = true)
    public List<Autor> listarPorAutor(String nombre) {
        return autorRepo.listarPorNombre(nombre);
    }

    //Nose si lo usaré
    @Transactional
    public void eliminarAutor(Autor libro) throws Exception {
        Autor a = autorRepo.buscarPorId(libro.getId());
        if (a != null) {
            throw new Exception("No se encontró a este libro en la base de datos");
        } else {
            autorRepo.deleteById(libro.getId());
        }
    }
}