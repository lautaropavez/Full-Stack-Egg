package lauti.egg.mendoza.repositorios;

import lauti.egg.mendoza.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lautaro Pavez
 */

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

}
