package com.ejemploMendoza.demo.servicios;
import com.ejemploMendoza.demo.entidades.Ciudad;
import com.ejemploMendoza.demo.repositorio.CiudadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lautaro Pavez
 */

@Service
public class ServicioCiudad {

    @Autowired
    CiudadRepositorio cr;
    
    public Ciudad crear(Ciudad c){
        return cr.save(c);
    }
    
    
    public Ciudad buscarPorId(String id){
        return cr.buscarPorId(id);
    }
    
    public Ciudad buscarPorNombre(String nombre){
        return cr.buscarPorNombre(nombre);
    }
}
