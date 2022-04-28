package principal;

;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Principal {

    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAModeloAdriPU");
        EntityManager em = emf.createEntityManager();
        MenuOpciones nuevaEjecucion = new MenuOpciones();
        nuevaEjecucion.menu();

    }
}
