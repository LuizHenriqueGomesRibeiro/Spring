package Spring.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Spring.Spring.DAO.InterfaceUsuario;
import Spring.Spring.Model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class teste {
	
	@Autowired
	private InterfaceUsuario interfaceUsuario;
	
	@Test
	public void insert() {
		Usuario usuario = new Usuario();
		usuario.setEmail("Bruna@hotmail.com");
		usuario.setIdade(29);
		usuario.setNome("Bruna");
		usuario.setSenha("senha");
		usuario.setLogin("Bruna");
		interfaceUsuario.save(usuario);
	}
	
	@Test
	public void ask() {
		Usuario usuario = interfaceUsuario.findById(1L).get();
	}
	
	@Test
	public void list() {
		for(Usuario usuario : interfaceUsuario.findAll()) {
		}
	}
	
	@Test
	public void update() {
		Usuario usuario = interfaceUsuario.findById(1L).get();
		usuario.setNome("Luiz updated");
		interfaceUsuario.save(usuario);
	}
	
	@Test
	public void delete() {
		interfaceUsuario.deleteById(1L);
	}
}