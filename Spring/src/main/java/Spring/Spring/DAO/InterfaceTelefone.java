package Spring.Spring.DAO;

import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Spring.Spring.Model.Telefone;
import Spring.Spring.Model.Usuario;

@Repository
public interface InterfaceTelefone extends CrudRepository<Telefone, Long> {
	
	@Lock(LockModeType.READ)
	@Query(value = "SELECT p FROM Telefone p WHERE p.usuario = ?1")
	public List<Telefone> buscarPorId(Usuario usuario);
}
