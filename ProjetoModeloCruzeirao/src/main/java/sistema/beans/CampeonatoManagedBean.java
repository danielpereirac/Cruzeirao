package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Campeonato;

import sistema.service.CampeonatoService;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CampeonatoManagedBean implements Serializable {
	private int codigoCampeonato = 1;
	private Campeonato campeonato = new Campeonato(codigoCampeonato);
	private Campeonato campeonatoAtual;
	private CampeonatoService service = new CampeonatoService();

	public int getId() {
		List<Campeonato> lista = service.getCampeonatos();

		Campeonato c = new Campeonato();
		if (!(lista.isEmpty())) {
			c = lista.get(lista.size() - 1);
			return c.getCodigoCampeonato() + 1;
		}

		else
			return 1;
	}

	public void salvar() {
		codigoCampeonato = getId();
		campeonato.setCodigoCampeonato(codigoCampeonato);
		service.salvar(campeonato);
		campeonato = new Campeonato(codigoCampeonato);
	}

	public String inserirCategorias(Campeonato campeonato) {
		this.campeonatoAtual = campeonato;
		return "inserirCategorias";
	}

	public String voltar() {
		return "cadastroCampeonato";
	}

	public String editarCampeonato(Campeonato campeonato) {
		this.campeonatoAtual = campeonato;
		return "editarCampeonato";
	}

	public void removerCampeonato(Campeonato campeonato) {
		service.removerCampeonatos(campeonato);
	}

	public String salvarEditar() {
		service.alterarCampeonato(campeonatoAtual);
		return "cadastroCampeonato";
	}

	public String descricaoCampeonato(Campeonato campeonato) {
		this.campeonatoAtual = campeonato;
		return "descricaoCampeonato";
	}

	public boolean mostrarInscricao(Campeonato campeonato) {
		this.campeonatoAtual = campeonato;
		service.alterarCampeonato(campeonatoAtual);
		return campeonatoAtual.isInscricao();
	}

	public String descricaoCategoria(Campeonato campeonato) {
		this.campeonatoAtual = campeonato;
		return "descricaoCategoria3";
	}

	public String voltarCategoria() {
		return "cadastroCampeonato";
	}

	public void onCellEdit(CellEditEvent event) {
		boolean newValue = ((boolean) event.getNewValue());
		campeonatoAtual.setInscricao(newValue);
		service.alterarCampeonato(campeonatoAtual);
	}

	public void onRowEdit(RowEditEvent event) {
		Campeonato c = ((Campeonato) event.getObject());
		service.alterarCampeonato(c);
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
