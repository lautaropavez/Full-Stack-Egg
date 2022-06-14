package libreria.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

/**
 *
 * @author Lautaro Pavez
 */
public class EditorialDAO {

    //El parametro de este atributo, es COMO SE NOMBRA MI ARCHIVO PERSISTENCIA (persistence.xml, Persistencia Unit Name)
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Libreria2PU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarEditorial(Editorial editorial) throws Exception {
        em.getTransaction().begin();
        em.persist(editorial);
        em.getTransaction().commit();
    }

    public void modificarEditorial(Editorial editorial) throws Exception {
        em.getTransaction().begin();
        em.merge(editorial);
        em.getTransaction().commit();
    }

    public Editorial buscarEditorialPorId(String id) throws Exception {
        Editorial editorial = em.find(Editorial.class, id); // Esto que envio es la llave primaria
        return editorial;
    }

    //CONSULTA CON PARAMETROS
    public Editorial buscarEditorialPorNombre(String nombre) throws Exception {
        Editorial editorial = (Editorial) em.createQuery("SELECT e "
            + " FROM Editorial e"
//            + " WHERE e.nombre LIKE :nombre"). //
                + " WHERE e.nombre LIKE CONCAT('%', :nombre, '%')", Editorial.class).
//            setParameter("nombre", nombre). //
                    setParameter("nombre", nombre).
            getSingleResult();
        return editorial;
    }

    public void eliminarEditorialPorId(String id) throws Exception {
        Editorial editorial = buscarEditorialPorId(id);
        em.getTransaction().begin();
        em.remove(editorial);
        em.getTransaction().commit();
    }

    public void eliminarEditorialPorNombre(String nombre) throws Exception {
        Editorial editorial = buscarEditorialPorNombre(nombre);
        em.getTransaction().begin();
        em.remove(editorial);
        em.getTransaction().commit();
    }

    //CONSULTA SIN PARAMETROS
    public List<Editorial> listarEditoriales() throws Exception {
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e")
        .getResultList();
        return editoriales;
    }
}
