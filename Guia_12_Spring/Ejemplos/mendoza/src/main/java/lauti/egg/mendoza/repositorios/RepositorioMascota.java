package lauti.egg.mendoza.repositorios;

import lauti.egg.mendoza.entidades.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lautaro Pavez
 */

@Repository
public interface RepositorioMascota extends JpaRepository<Mascota, Long> {

}
