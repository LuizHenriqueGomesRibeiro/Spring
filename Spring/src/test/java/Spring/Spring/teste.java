package Spring.Spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Spring.Spring.DAO.InterfaceUsuario;
import Spring.Spring.Model.Usuario;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class teste {
	
	private InterfaceUsuario interfaceUsuario;
	
	@Test
	public void insert() {
		Usuario usuario = new Usuario();
		usuario.setEmail("Luiz@hotmail.com");
		usuario.setIdade(22);
		usuario.setNome("Luiz");
		usuario.setSenha("senha");
		usuario.setLogin("Luiz");
		interfaceUsuario.save(usuario);
	}
	
	@Test
	public void ask() {
		Usuario usuario = interfaceUsuario.findById(1L).get();
	}
	
	@Test
	public void list() {
		for(Usuario usuario : interfaceUsuario.findAll()) {
			System.out.println(usuario);
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
	
	@Test 
	public void askName() {
		for(Usuario usuario : interfaceUsuario.buscarPorNome("Bruna")) {
			System.out.println(usuario);
		}
	}
}