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
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
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
        
            Libro libro = (Libro) em.createQuery("SELECT l "
                    + " FROM Libro l"
                    + " WHERE l.titulo = :titulo"). //Si le ponemos LIKE en vez de = se rompe(por ser String ¿?)
                    setParameter("titulo", titulo).
                    getSingleResult();
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
    
    //De la otra manera que está como comentario me serviria para hacer una lista de libros que tengan X letra.
    public List<Libro> buscarPorAutor(String nombAutor) {
        List<Libro> libros = em.createQuery("SELECT l "
                + " FROM Libro l"
                + " WHERE l.autor.nombre = :nombre").
                //+ " WHERE l.autor.nombre LIKE CONCAT('%', :nombre, '%')", Libro.class). //Si lo hago de esta forma me va a buscar cualquier letra o conjunto de letras que tenga algun autor, por ejemplo si tengo una editorial que se llama joda, y yo busco la letra "j" sola me saldria esta editorial joda
                setParameter("nombre", nombAutor).
                getResultList();
        return libros;
    }
    
    //De la otra manera que está como comentario me serviria para hacer una lista de libros que tengan X letra.
    public List<Libro> buscarPorEditorial(String nombEdit) {
        List<Libro> libros = em.createQuery("SELECT l "
                + " FROM Libro l"
                + " WHERE l.editorial.nombre = :nombre").
                //+ " WHERE l.editorial.nombre LIKE CONCAT('%', :nombre, '%')", Libro.class).  //Si lo hago de esta forma me va a buscar cualquier letra o conjunto de letras que tenga algun autor, por ejemplo si tengo una editorial que se llama joda, y yo busco la letra "j" sola me saldria esta editorial joda
                setParameter("nombre", nombEdit).
                getResultList();
        return libros;
    }

    // Acá hay info si nos aparece un error entity--> https://stackoverflow.com/questions/29775627/entity-must-be-managed-to-call-remove-when-i-try-to-delete-an-entity
    
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
        if (libros == null || libros.size() == 0) { //libros.size() == 0 es lo mismo que libros.isEmpty()
            System.out.println("NO existe un libro con esa Editorial");
        } else {
            for (Libro aux : libros) {
                if (aux.getEditorial().getId().equals(edit.getId())) {
//                    em.isOpen();
                    em.getTransaction().begin();
                    if (!em.contains(aux)) {  //No puede eliminar la entidad si no está adjunta. Si la entidad aún está adjunta, puede eliminarla tal como está. Si ya no está adjunto, puede volver a adjuntarlo usando merge
                        aux = em.merge(aux);
                    }
                    em.remove(aux);
                    em.getTransaction().commit();
//                    em.close();
                }
            }
        }
    }
    
    //NO LO USE :(
    public void eliminaPorAutor(Autor autor) throws Exception {
        List<Libro> libros = buscarPorAutor(autor.getNombre());
        if (libros == null || libros.size() == 0) {
            System.out.println("NO existe un libro con ese Autor");
        } else {
            for (Libro lib : libros) {
                if (lib.getAutor().getId().equals(autor.getId())) {
                    em.getTransaction().begin();
                        if (!em.contains(autor)) {  ////No puede eliminar la entidad si no está adjunta. Si la entidad aún está adjunta, puede eliminarla tal como está. Si ya no está adjunto, puede volver a adjuntarlo usando merge
                            autor = em.merge(autor);
                        }
                    em.remove(lib);
                    em.getTransaction().commit();
                }
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
