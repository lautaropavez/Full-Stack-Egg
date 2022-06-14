package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

/**
 *
 * @author Lautaro Pavez
 */
public class LibroDAO {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Libreria2PU");
    private final EntityManager em = emf.createEntityManager();
    //EntityManager em = Persistence.createEntityManagerFactory("nombreUnidadDePersistencia").createEntityManager(); //Otra manera de ponerlo

    public void guardarLibro(Libro libro) {
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
    }

    public void modificarLibro(Libro libro) {
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
    }

    public Libro buscarPorId(String id) {
        Libro libro = em.find(Libro.class, id);
        return libro;
    }

    public Libro buscarPorTitulo(String titulo) {
//            Libro libro = (Libro) em.createQuery("SELECT l "
//                    + " FROM Libro l"
//                    + " WHERE l.titulo LIKE :titulo").
//                    setParameter("titulo", titulo).
//                    getSingleResult();
//        OTRA FORMA POR SI NO LLEGA A FUNCIONAR LA ANTERIOR   
        Libro libro = (Libro) em.createQuery("SELECT l "
                + " FROM Libro l"
                + " WHERE l.titulo LIKE CONCAT('%', :titulo, '%')", Libro.class)
                .setParameter("titulo", titulo)
                .getSingleResult();
        return libro;

    }

    public Libro buscarPorISBN(Long isbn) {
        Libro libro = (Libro) em.createQuery("SELECT l "
                + " FROM Libro l"
                + " WHERE l.isbn LIKE :isbn").
                setParameter("isbn", isbn).
                getSingleResult();
        return libro;

    }

    public List<Libro> buscarPorAnio(Integer anio) {
        List<Libro> librosXanio = em.createQuery("SELECT l "
                + " FROM Libro l"
                + " WHERE l.anio = :anio").
                setParameter("anio", anio).
                getResultList();
        return librosXanio;
    }

    public List<Libro> buscarPorAutor(String nombAutor) {
        List<Libro> libros = em.createQuery("SELECT l "
                + " FROM Libro l"
                + " WHERE l.autor.nombre LIKE CONCAT('%', :nombre, '%')", Libro.class).
                setParameter("nombre", nombAutor).
                getResultList();
        return libros;
    }

    public List<Libro> buscarPorEditorial(String nombEdit) {
        List<Libro> libros = em.createQuery("SELECT l "
                + " FROM Libro l"
                + " WHERE l.editorial.nombre LIKE CONCAT('%', :nombre, '%')", Libro.class).
                setParameter("nombre", nombEdit).
                getResultList();
        return libros;
    }

    public void eliminarPorId(String id) {
        Libro libro = buscarPorId(id);
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();

    }

    public void eliminarPorTitulo(String titulo) {
        Libro libro = buscarPorTitulo(titulo);
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
    }

    public void eliminarPorISBN(Long isbn) {
        Libro libro = buscarPorISBN(isbn);
        em.getTransaction().begin();
        em.remove(libro);
        em.getTransaction().commit();
    }

    public void eliminaPorEditorial(Editorial edit) {
        List<Libro> libros = buscarPorEditorial(edit.getNombre());
        if (libros == null || libros.size() == 0) {
            System.out.println("NO existe un libro con esa Editorial");
        } else {
            for (Libro aux : libros) {
                if (aux.getEditorial().getId().equals(edit.getId())) {
                    em.getTransaction().begin();
                    em.remove(aux);
                    em.getTransaction().commit();
                }
            }
        }
    }

    public void eliminaPorAutor(Autor autor) throws Exception {
        List<Libro> libros = buscarPorAutor(autor.getNombre());
        if (libros == null || libros.size() == 0) {
            System.out.println("NO existe un libro con ese Autor");
        } else {
            for (Libro lib : libros) {
                em.getTransaction().begin();
                em.remove(lib);
                em.getTransaction().commit();
            }
        }
    }

    public List<Libro> listarTodos() throws Exception {
        List<Libro> libros = em.createQuery("SELECT l FROM Libro l").
                getResultList();
        return libros;
    }
//    public Autor buscarAutorPorNombre(String nombre, Boolean estado) throws MiExcepcion {
//        Autor autor = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre AND a.alta = :estado", Autor.class)
//                .setParameter("nombre", nombre)
//                .setParameter("estado", estado)
//                .getSingleResult();
//        return autor;
//    }
}
