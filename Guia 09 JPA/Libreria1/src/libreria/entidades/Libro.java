package libreria.entidades;

import com.sun.istack.internal.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author Lautaro Pavez
 */
/*  
    La entidad libro modela los libros que están disponibles en la biblioteca para ser
    prestados. En esta entidad, el atributo “ejemplares” contiene la cantidad total de
    ejemplares de ese libro, mientras que el atributo “ejemplaresPrestados” contiene
    cuántos de esos ejemplares se encuentran prestados en este momento y el atributo
    “ejemplaresRestantes” contiene cuántos de esos ejemplares quedan para prestar.
 */
@Entity // Esta anotacion, avisa que esta clase se convertira en TABLA
public class Libro {
    
    @Id
    @GeneratedValue
    private String id;

    @Column(nullable = false)
    private Long isbn;
    
    @NotNull
    private String titulo;
    
    private Integer anio;
    private Integer nroejemplares;
    private Integer ejemplaresPrestados;
    private Integer ejemplaresRestantes;
    private Boolean alta;
    
//    @ManyToOne
    @OneToOne
    private Autor autor; //2° Clase min 5
    
    @OneToOne
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String id, Long isbn, String titulo, Integer anio, Integer nroejemplares, Integer ejemplaresPrestados, Integer ejemplaresRestantes, Boolean alta, Autor autor, Editorial editorial) {
        this.id = id;
        this.isbn = isbn;
        this.titulo = titulo;
        this.anio = anio;
        this.nroejemplares = nroejemplares;
        this.ejemplaresPrestados = ejemplaresPrestados;
        this.ejemplaresRestantes = ejemplaresRestantes;
        this.alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getNroejemplares() {
        return nroejemplares;
    }

    public void setNroejemplares(Integer nroejemplares) {
        this.nroejemplares = nroejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-30s%-25s%-8s%-25s", isbn, titulo,autor.getNombre(),anio,editorial.getNombre());
        //return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + '}';
    }
    
    
    
}
