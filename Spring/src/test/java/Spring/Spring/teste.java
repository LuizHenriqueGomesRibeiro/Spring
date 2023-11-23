package Spring.Spring;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import Spring.Spring.DAO.InterfaceTelefone;
import Spring.Spring.DAO.InterfaceUsuario;
import Spring.Spring.Model.Telefone;
import Spring.Spring.Model.Usuario;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class teste {
	
	@Autowired
	private InterfaceUsuario interfaceUsuario;
	
	@Autowired
	private InterfaceTelefone interfaceTelefone;
	
	@Test
	public void insert() {
		Usuario usuario = new Usuario();
		usuario.setEmail("Petrolino@hotmail.com");
		usuario.setIdade(22);
		usuario.setNome("Petrolino");
		usuario.setSenha("senha");
		usuario.setLogin("Petrolino");
		interfaceUsuario.save(usuario);
	}
	
	@Test
	public void ask() {
		Usuario usuario = interfaceUsuario.findById(4L).get();
		System.out.println(usuario);
	}
	
	@Test
	public void list() {
		for(Usuario usuario : interfaceUsuario.findAll()) {
			System.out.println(usuario.getNome());
			for(Telefone telefone : interfaceTelefone.buscarPorId(usuario)) {
				System.out.println(telefone.getNumero());
			}
			System.out.println("--------------------------------------");
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
	public void listLikeName() {
		for(Usuario usuario : interfaceUsuario.buscarPorNome("Bruna")) {
			System.out.println(usuario);
		}
	}
	
	@Test
	public void askByName() {
		String nome = interfaceUsuario.buscarUsuarioPorNome("Luiz");
		System.out.println(nome);
	}
	
	@Test
	public void deleteByName() {
		interfaceUsuario.deletePorNome("Bruna");
	}
	
	@Test
	public void updateEmailByName() {
		interfaceUsuario.updateEmail("LosPolosErmanos@coldmail.com", "Gus");
	}
	
	@Test
	public void insertTelefone() {
		Telefone telefone = new Telefone();
		telefone.setNumero("92489-9238");
		telefone.setTipo("celular");
		Usuario usuario = interfaceUsuario.findById(4L).get();
		telefone.setUsuario(usuario);
		interfaceTelefone.save(telefone);
	}
	
	@Test
	public void listPhones() {
	}
}