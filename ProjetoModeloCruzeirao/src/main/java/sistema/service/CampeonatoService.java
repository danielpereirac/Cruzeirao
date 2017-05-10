package sistema.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import sistema.modelos.Campeonato;

public class CampeonatoService extends Service {

	private ArrayList <Campeonato> campeonatos = new ArrayList<Campeonato>();
	
	public CampeonatoService()
	{
	}
	
	public void salvar(Campeonato campeonato)
	{
	  
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(campeonato);
		em.getTransaction().commit();	
	    em.close();
		
	}
	
	public void removerCampeonatos(Campeonato campeonato)
	{
		campeonatos.remove(campeonato);
	}

	public List <Campeonato> getCampeonatos()
	{
		List <Campeonato >campeonatos;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select c From Campeonato c");
		campeonatos = q.getResultList();
		em.close();
		
		return campeonatos;
	}	
}
