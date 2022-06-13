package com.mza.Libreria.servicios;

import com.mza.Libreria.entidades.Editorial;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.repositorios.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lautaro Pavez
 */
@Service
public class ServiceEditorial {

    @Autowired
    private EditorialRepository editorialRepo;
    
    public void crearEditorial(String nombre) throws MiExcepcion {
        
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre.toUpperCase());
        editorial.setAlta(Boolean.TRUE);

        editorialRepo.save(editorial); // Esto es igual en JPA al --> daolibro.guardarLibro(lib);
    }
    
    public Editorial modificarEditorial(String nombre) throws MiExcepcion {
        Editorial editorialeditado = editorialRepo.buscarPorNombre(nombre);
        if (editorialeditado != null) {      
            editorialeditado.setNombre(nombre);
            return editorialRepo.save(editorialeditado);
        } else {
            throw new MiExcepcion("No se encontró a este Autor en la base de datos.");
        }
    }
    
    public Editorial buscarporId(String id){
        return editorialRepo.buscarPorId(id);
    }
    
    public Editorial buscarporNombre(String nombre){
        return editorialRepo.buscarPorNombre(nombre);
    }
    
}
