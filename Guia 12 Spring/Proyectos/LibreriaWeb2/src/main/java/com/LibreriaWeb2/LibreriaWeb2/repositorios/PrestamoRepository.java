
package com.LibreriaWeb2.LibreriaWeb2.repositorios;

import com.LibreriaWeb2.LibreriaWeb2.entidades.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lautaro Pavez
 */
@Repository
public interface PrestamoRepository extends JpaRepository<Prestamo, String>{
    
}
