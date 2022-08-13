package com.LibreriaWeb2.LibreriaWeb2.repositorios;

import com.LibreriaWeb2.LibreriaWeb2.entidades.Editorial;
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
    
    @Query("SELECT e FROM Editorial e WHERE e.id = :id")
    public Editorial buscarPorId(@Param("id")String id);
    
    @Query("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
    public Editorial buscarPorNombre(@Param("nombre")String nombre);

    @Query("SELECT e FROM Editorial e WHERE e.alta = true")
    public List<Editorial> buscaActivas();
    
    //------------------------------- NO USADOS --------------------------------
    
    //Nose si lo voy a usar
    @Query("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
    public List<Editorial> listarPorEditorial(@Param("nombre")String ciudad);
    
}
