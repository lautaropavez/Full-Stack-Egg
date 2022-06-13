package com.ejemploMendoza.demo.servicios;
import com.ejemploMendoza.demo.entidades.Ciudad;
import com.ejemploMendoza.demo.entidades.Persona;
import com.ejemploMendoza.demo.repositorio.PersonaRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lautaro Pavez
 */

@Service
public class ServicioPersona {
    
    @Autowired
    PersonaRepositorio pr;
    
    @Autowired
    ServicioCiudad cs;
    
    @Transactional
    public Persona crearPersona(Persona persona) throws Exception{
        
        validacion(persona.getDni(), persona.getNombre(), persona.getApellido());
        
        Ciudad c = cs.buscarPorNombre(persona.getCiudad().getNombre());
        if (c == null){
            cs.crear(persona.getCiudad());
        }else{
            persona.setCiudad(c);
        }     
//        if (cs.buscarPorId(persona.getCiudad().getId())== null) {
//            throw new Exception("La ciudad ingresada no existe en la base de datos."); 
//        }      
        return pr.save(persona); //Este método extiende de Jpa repository
    }
    
    @Transactional
    public Persona modificarPersona (Persona persona) throws Exception{
        
        Persona p = pr.buscarPorDNI(persona.getDni());
        if(p != null){
            validacion(persona.getDni(), persona.getNombre(), persona.getApellido());
            p.setNombre(persona.getNombre());
            p.setApellido(persona.getApellido());
            return pr.save(p);
        }else{
           throw new Exception("No se encontró a esta persona en la Base de Datos."); 
        }
    }
    
    //2 Formas de buscar por Id 
    
    public Persona buscarPorId(String id) throws Exception{
        Optional <Persona> p = pr.findById(id);
        if (p.isPresent()) {
            Persona per = p.get();
            return per;
        }else{
           throw new Exception("Esta persona no existe."); 
        }
    }
    
    @Transactional
    public Persona findbyId(String id) throws Exception{
        Persona p = pr.buscarPorId(id);
        if (p != null) {
            return p;
        }else{
           throw new Exception("Esta persona no existe."); 
        }
    } 
    
    public List <Persona> listarTodas(){
        return pr.findAll();
    }
    
    
    @Transactional
    public void eliminarPersona (Persona persona) throws Exception{
        
        Persona p = pr.buscarPorDNI(persona.getDni());
        if(p != null){
            pr.delete(p);
        }else{
           throw new Exception("No se encontró a esta persona en la Base de Datos."); 
        }
    }
        
    
    @Transactional
    public void validacion(Long dni, String nombre, String apellido)throws Exception{
        if(dni == null || dni < 0){
            throw new Exception("El DNI no puede ser nulo o menor que cero"); 
        }
        
        Persona p = pr.buscarPorDNI(dni);
        if(p != null){
            throw new Exception("Ya existe una persona con ese DNI"); 
        }
        
        if(nombre == null || nombre.isEmpty()){
            throw new Exception("El DNI no puede ser nulo o menor que cero"); 
        }
        
        if(apellido == null || apellido.isEmpty()){
            throw new Exception("El DNI no puede ser nulo o menor que cero"); 
        }
    }
    
    
    
    
    
}

