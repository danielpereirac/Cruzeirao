package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Campeonato;
import sistema.modelos.Usuario;

public class UsuarioService extends Service {
	
	private List<Usuario> usuarios;
	
	public UsuarioService()
	{
		
		
		
	}
	
	
	public void salvar(Usuario usuario) 
	{
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	
	public void recuperarSenha(Usuario usuario)
	{
					
	}

	
	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		
		List<Usuario> usuarios;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select u From Usuario u ");
		usuarios = q.getResultList();
		em.close();

		return usuarios;
	}

	public void entrar(Usuario usuarioEntrar) {
		
	}
	
	public void alterarUsuario(Usuario usuario) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(usuario);
		em.getTransaction().commit();
		em.close();
	}
	
	
}
