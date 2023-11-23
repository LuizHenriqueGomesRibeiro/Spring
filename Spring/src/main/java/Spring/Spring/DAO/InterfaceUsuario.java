package Spring.Spring.DAO;

import java.util.List;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Spring.Spring.Model.Usuario;

@Repository
public interface InterfaceUsuario extends CrudRepository<Usuario, Long> {

	@Lock(LockModeType.READ)
	@Query(value = "SELECT p FROM Usuario p WHERE p.nome LIKE %?1%")
	public List<Usuario> buscarPorNome(String nome);
	
	@Lock(LockModeType.READ)
	@Query(value = "SELECT p.nome FROM Usuario p WHERE p.nome = :paramnome")
	public String buscarUsuarioPorNome(@Param("paramnome") String nome);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM Usuario p WHERE p.nome = ?1")
	public void deletePorNome(String nome);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE Usuario p SET p.email = ?1 WHERE p.nome LIKE %?2%")
	public void updateEmail(String email, String nome);
}
