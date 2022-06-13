package com.ejemploMendoza.demo.repositorio;


import com.ejemploMendoza.demo.entidades.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lautaro Pavez
 */
@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, String>{
    
    @Query("SELECT p FROM Persona p WHERE p.ciudad.nombre = :nombre")
    public List<Persona> listarPorCiudad(@Param("nombre")String ciudad);
    
    @Query("SELECT p FROM Persona p WHERE p.id = :id")
    public Persona buscarPorId(@Param("id")String id);
    
    @Query("SELECT p FROM Persona p WHERE p.dni = :dni")
    public Persona buscarPorDNI(@Param("dni")Long dni);
    
    
    
    
}

