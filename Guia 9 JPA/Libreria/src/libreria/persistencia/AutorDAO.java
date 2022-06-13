package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

/**
 *
 * @author Lautaro Pavez
 */
// Anotacion: CRUD(CREATE READ UPDATE DELETE)
public class AutorDAO {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarAutor(Autor autor) throws Exception {
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
    }

    public void modificarAutor(Autor autor) throws Exception {
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
    }

    public Autor buscarAutorPorId(String id) throws Exception {
        Autor autor = em.find(Autor.class, id); // Esto que envio es la llave primaria
//          return em.find(Autor.class, id); Otra manera de ponerlo
        return autor;
    }

    //CONSULTA CON PARAMETROS
    public Autor buscarAutorPorNombre(String nombre) throws Exception {
        try {
            Autor autor = (Autor) em.createQuery("SELECT a "
            + " FROM Autor a"
            + " WHERE a.nombre LIKE :nombre").
            setParameter("nombre", nombre).
            getSingleResult();
            return autor;
        } catch (Exception e) {
            return null;
        }
        
    }

    public void eliminarAutorPorId(String id) throws Exception {
        Autor autor = buscarAutorPorId(id);
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
    }

    public void eliminarAutorPorNombre(String nombre) throws Exception {
        Autor autor = buscarAutorPorNombre(nombre);
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
    }

    //CONSULTA SIN PARAMETROS
    public List<Autor> listarAutores() throws Exception {
        List<Autor> autores = em.createQuery("SELECT a FROM Autor a")
           .getResultList();
        return autores;
    }

//    public void boolean Alta()throws Exception{
//        
//    }
}
