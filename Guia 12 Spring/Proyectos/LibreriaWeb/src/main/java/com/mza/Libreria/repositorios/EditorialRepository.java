package com.mza.Libreria.repositorios;

import com.mza.Libreria.entidades.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Lautaro Pavez
 */
@Repository
public interface EditorialRepository  extends JpaRepository<Editorial, String>{
    
    @Query("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
    public List<Editorial> listarPorEditorial(@Param("nombre")String ciudad);
    
    @Query("SELECT e FROM Editorial e WHERE e.id = :id")
    public Editorial buscarPorId(@Param("id")String id);
    
    @Query("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
    public Editorial buscarPorNombre(@Param("nombre")String nombre);

    @Query("SELECT e FROM Editorial e WHERE e.alta = true")
    public List<Editorial> buscaActivos();
}
