package Spring.Spring.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import Spring.Spring.Model.Usuario;

@Repository
public interface InterfaceUsuario extends CrudRepository<Usuario, Long> {
	
}
