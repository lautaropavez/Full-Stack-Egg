/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mza.Libreria.repositorios;

import com.mza.Libreria.entidades.Prestamo;
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
public interface PrestamoRepository extends JpaRepository<Prestamo, String>{
    
    @Query("SELECT p FROM Prestamo p WHERE p.usuario.id = :id")
    List<Prestamo> listarPorUsuario(@Param("id")String id);
    
}
