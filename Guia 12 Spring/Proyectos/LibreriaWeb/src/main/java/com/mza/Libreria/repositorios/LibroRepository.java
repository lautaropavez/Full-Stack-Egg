package com.mza.Libreria.repositorios;

import com.mza.Libreria.entidades.Libro;
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
public interface LibroRepository  extends JpaRepository<Libro, String>{

    @Query("SELECT l FROM Libro l WHERE l.id = :id")
    public Libro buscarPorId(@Param("id")String id);
    
    @Query("SELECT l FROM Libro l WHERE l.isbn = :isbn")
    public Libro buscarPorISBN(@Param("isbn")Long isbn);
    
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    public Libro buscarPorTitulo(@Param("titulo")String titulo);
        
//    public void deleteById(Libro id);
//
//    public void delete(Libro t);
    
    @Query("SELECT l from Libro l WHERE a.activo = true ")
    public List<Libro> buscarActivos(@Param("activo")boolean activo);
    
    @Query("SELECT l FROM Libro l WHERE l.anio = :anio")
    public List<Libro> buscarPorAnio(@Param("anio")Integer anio);
    
    @Query("SELECT l from Libro l WHERE l.alta = true AND l.ejemplaresRestantes > 0")
    public List<Libro> listaActivos();
    
    @Query("SELECT l FROM Libro l WHERE l.editorial.nombre = :nombre")
    public List<Libro> listarPorEditorial(@Param("nombre")String editorial);
    
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    public List<Libro> listarPorAutor(@Param("nombre")String autor);
    
    @Query("SELECT l FROM Libro l WHERE l.nombre = :nombre")
    public List<Libro> listarPorNombre(@Param("nombre")String nombre);
 
    // con esta query se obtiene contenido parecido a, LIKE %?1% remplaza a LIKE :variable
//    @Query("SELECT p from Libro p WHERE p.titulo LIKE %?1% or p.autor.nombre LIKE %?1% or p.editorial.nombre LIKE %?1% AND p.alta = true")
//    public List<Libro> buscaActivos(@Param("buscar") String buscar);

//    @Query("SELECT p from Libro p WHERE p.titulo LIKE %?1% or p.autor.nombre LIKE %?1% or p.editorial.nombre LIKE %?1%")
//    List<Libro> buscaTodo(@Param("buscar") String buscar);
    
//    @Query("SELECT i FROM Libro i WHERE i.isbn = :isbn")
//    Optional<Libro> validaISBN(@Param("isbn") String isbn);
}
