package Spring.Spring.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import Spring.Spring.Model.Usuario;

@Repository
public interface InterfaceUsuario extends CrudRepository<Usuario, Long> {
	
	@Transactional(readOnly = true)
	@Query(value = "SELECT p FROM usuarios p WHERE p.nome LIKE %?1%")
	public List<Usuario> buscarPorNome(String nome);
}
