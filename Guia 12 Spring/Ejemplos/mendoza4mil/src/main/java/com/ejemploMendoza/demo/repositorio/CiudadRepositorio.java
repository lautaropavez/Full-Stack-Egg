/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejemploMendoza.demo.repositorio;

import com.ejemploMendoza.demo.entidades.Ciudad;
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
public interface CiudadRepositorio extends JpaRepository<Ciudad, String>{
    
    @Query("SELECT c FROM Ciudad c WHERE c.nombre = :nombre")
    public List<Ciudad> listarPorCiudad(@Param("nombre")String ciudad);
    
    @Query("SELECT c FROM Ciudad c WHERE c.id = :id")
    public Ciudad buscarPorId(@Param("id")String id);
    
    @Query("SELECT c FROM Ciudad c WHERE c.nombre = :nombre")
    public Ciudad buscarPorNombre(@Param("nombre")String nombre);
}
