package com.mza.Libreria.servicios;

import com.mza.Libreria.entidades.Editorial;
import com.mza.Libreria.excepciones.MiExcepcion;
import com.mza.Libreria.repositorios.EditorialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Lautaro Pavez
 */
//Todo ok, falta ver tema de baja y alta
//No tengo metodo modificar porque se modifica solo en el libro

@Service
public class ServiceEditorial {

    @Autowired
    private EditorialRepository editorialRepo;
    
    @Transactional
    public void crearEditorial(String nombre) throws MiExcepcion {
        
        Editorial editorial = new Editorial();
        editorial.setNombre(nombre.toUpperCase());
        editorial.setAlta(Boolean.TRUE);

        editorialRepo.save(editorial); // Esto es igual en JPA al --> daolibro.guardarLibro(lib);
    }
    
    @Transactional(readOnly = true)
    public Editorial buscarporId(String id){
        return editorialRepo.buscarPorId(id);
    }
    
    @Transactional(readOnly = true)
    public Editorial buscarporNombre(String nombre){
        return editorialRepo.buscarPorNombre(nombre);
    }
    
    //Busca todas las editoriales(activas e inactivas)
    @Transactional(readOnly = true)
    public List<Editorial> buscaTodas() {
        return editorialRepo.findAll(); 
    }
    
    //Busca todas las editoriales activas
    @Transactional(readOnly = true)
    public List<Editorial> buscaActivas() {
        return editorialRepo.buscaActivas(); 
    }
    
    @Transactional 
    public void eliminarEditorial(String id) throws Exception {
        Editorial e = editorialRepo.buscarPorId(id);
        if (e != null) {
            throw new Exception("No se encontró a esta Editorial en la base de datos");
        } else {
            editorialRepo.deleteById(id);
        }
    }
    
//    ---------------------------------- NO USADOS --------------------------------
    
//    @Transactional
//    public Editorial modificarEditorial(String nombre) throws MiExcepcion {
//        Editorial editorialeditado = editorialRepo.buscarPorNombre(nombre);
//        if (editorialeditado != null) {      
//            editorialeditado.setNombre(nombre);
//            return editorialRepo.save(editorialeditado);
//        } else {
//            throw new MiExcepcion("No se encontró a este Autor en la base de datos.");
//        }
//    }
    
}
