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
    Libro buscarPorId(@Param("id")String id);

    // Con esta query se obtiene contenido parecido a algo, LIKE %?1% remplaza a LIKE :variable
    @Query("SELECT lib from Libro lib WHERE "
            + "lib.alta = true AND lib.ejemplaresRestantes > 0 AND "
            + "(lib.titulo LIKE %?1% OR lib.autor.nombre LIKE %?1% OR lib.editorial.nombre LIKE %?1%) "
            + "ORDER BY lib.titulo ASC, lib.autor.nombre ASC")
    List<Libro> buscaTodoActivos(@Param("buscar") String buscar);
    
    @Query("SELECT p from Libro p WHERE"
            + " CONCAT(p.titulo,p.editorial.nombre,p.autor.nombre,p.isbn,p.anio)"
            + " LIKE %?1%")
    List<Libro> buscaTodo(@Param("buscar") String buscar);
    
    @Query("SELECT l from Libro l WHERE l.alta = true AND l.ejemplaresRestantes > 0")
    List<Libro> listaActivos();
    
    //Usado para baja x Autor
    @Query("SELECT l FROM Libro l WHERE l.editorial.nombre = :nombre")
    List<Libro> listarPorEditorial(@Param("nombre")String editorial);
    
    //Usado para baja x Autor
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    List<Libro> listarPorAutor(@Param("nombre")String autor);
    
    //Usado para libro lista
    @Query("SELECT l FROM Libro l ORDER BY l.titulo ASC, l.autor.nombre ASC")
    List<Libro> findAllOrderByTituloAsc();
    
    //Usado para biblioteca
    @Query("SELECT l FROM Libro l WHERE l.alta = true ORDER BY l.titulo ASC, l.autor.nombre ASC")
    List<Libro> findAllActivosOrderByTituloAsc();
      
//-------------------------------NO USADOS--------------------------------------   
    
    //No lo usamos porque usamos el que busca los que esten activos y con ejemplares
//    @Query("SELECT l from Libro l WHERE a.activo = true ")
//    public List<Libro> buscarActivos(@Param("activo")boolean activo); 

    //Porque usamos el metodo buscaTodo y ese nos busca por titulo,editorial y autor a la vez
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    Libro buscarPorTitulo(@Param("titulo")String titulo);
    
    @Query("SELECT l FROM Libro l WHERE l.anio = :anio")
    List<Libro> buscarPorAnio(@Param("anio")Integer anio);
}
