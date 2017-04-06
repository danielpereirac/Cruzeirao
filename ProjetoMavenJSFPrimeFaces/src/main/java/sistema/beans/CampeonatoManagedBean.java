package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Campeonato;
import sistema.service.CampeonatoService;

@ManagedBean
@SessionScoped
public class CampeonatoManagedBean {
	
	private int codigoCampeonato = 1;
	private Campeonato campeonato = new Campeonato(codigoCampeonato);
	private Campeonato campeonatoAtual;
	private CampeonatoService service = new CampeonatoService();
	
	public void salvar()
	{
		service.salvar(campeonato);
		codigoCampeonato++;
		campeonato = new Campeonato(codigoCampeonato);	
	}
	
	public boolean inscricao(Campeonato campeonato)
	{
		this.campeonatoAtual = campeonato;
		return campeonatoAtual.isInscricao();
	}
	
	public String voltar()
	{
		return "cadastroCampeonato";
	}
	
	public void editarCampeonato(Campeonato campeonato)
	{
		
	}
	
	public void removerCampeonato(Campeonato campeonato)
	{
		
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public List<Campeonato> getCampeonatos() {
		return service.getCampeonatos();
	}

	public Campeonato getCampeonatoAtual() {
		return campeonatoAtual;
	}

	public void setCampeonatoAtual(Campeonato campeonatoAtual) {
		this.campeonatoAtual = campeonatoAtual;
	}
}
