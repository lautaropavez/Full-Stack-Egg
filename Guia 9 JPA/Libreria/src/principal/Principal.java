package principal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Lautaro Pavez
 */
public class Principal {

    public static void main(String[] args) throws Exception {
    
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaPU");
    EntityManager em = emf.createEntityManager();
    Menu menu = new Menu(); menu.menuPrincipal();
    
    
    }
}
