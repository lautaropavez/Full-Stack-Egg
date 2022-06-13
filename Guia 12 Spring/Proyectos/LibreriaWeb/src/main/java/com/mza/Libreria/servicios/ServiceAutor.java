
package com.mza.Libreria.servicios;

import com.mza.Libreria.entidades.Autor;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.repositorios.AutorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lautaro Pavez
 */
@Service
public class ServiceAutor {

    @Autowired
    private AutorRepository autorRepo;
    
    public void crearAutor(String nombre) throws MiExcepcion {
        
        Autor autor = new Autor();
        autor.setNombre(nombre.toUpperCase());
        autor.setAlta(Boolean.TRUE);

        autorRepo.save(autor); // Esto es igual en JPA al --> daolibro.guardarLibro(lib);
    }
    
    public Autor modificarAutor(String nombre) throws MiExcepcion {
        Autor autoreditado = autorRepo.buscarPorNombre(nombre);
        if (autoreditado != null) {      
            autoreditado.setNombre(nombre);
            return autorRepo.save(autoreditado);
        } else {
            throw new MiExcepcion("No se encontró a este Autor en la base de datos.");
        }
    }
    
    public Autor buscarporId(String id){
        return autorRepo.buscarPorId(id);
    }
   
    @Transactional(readOnly = true)
    public List<Autor> buscaAutores() {
        return autorRepo.findAll();
    }
    
    @Transactional(readOnly = true)
    public List<Autor> buscaPorNombre(String nombre) {
        return autorRepo.buscaPorNombre(nombre);
    }


//    Otra manera
//    public void modificarAutorr(String nombre) throws MiExcepcion {
//        Autor autoreditado = autorRepo.buscarPorNombre(nombre);
//        if (autoreditado != null) {      
//            autoreditado.setNombre(nombre);
//            autorRepo.save(autoreditado);
//        } else {
//            throw new MiExcepcion("No se encontró a este Autor en la base de datos.");
//        }
//    }
}
