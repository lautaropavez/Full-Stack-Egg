package com.mza.Libreria.repositorios;

import com.mza.Libreria.entidades.Autor;
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
public interface AutorRepository extends JpaRepository<Autor, String>{
 
    @Query("SELECT a FROM Autor a WHERE a.id = :id")
    public Autor buscarPorId(@Param("id")String id);
    
    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre")
    public Autor buscarPorNombre(@Param("nombre")String nombre);

    @Query("SELECT a FROM Autor a WHERE a.alta = true")
    public List<Autor> buscaActivos();
    
    //-------------------------------NO USADOS--------------------------------------   

    //Nose si lo voy a usar
    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre")
    public List<Autor> listarPorNombre(@Param("nombre")String nombre);
    
    /*
        @Query("SELECT p FROM Persona p WHERE p.dni = :dni")
        public Persona buscarPorDNI(@Param("dni")Long dni);

        @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %?1%")
        public List<Autor> buscaPorNombre(@Param("nombre") String nombre);

        @Query ("SELECT a FROM Autor a")
        public List<Autor> buscaAutor();
    */
}