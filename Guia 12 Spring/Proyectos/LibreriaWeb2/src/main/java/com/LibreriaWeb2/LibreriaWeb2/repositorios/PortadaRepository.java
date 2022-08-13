package com.LibreriaWeb2.LibreriaWeb2.repositorios;

import com.LibreriaWeb2.LibreriaWeb2.entidades.Portada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lautaro Pavez
 */
@Repository
public interface PortadaRepository extends JpaRepository<Portada, String> {
    
}
