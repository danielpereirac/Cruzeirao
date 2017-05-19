package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.service.CampeonatoService;
import sistema.service.CategoriaService;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class CategoriaManagedBean implements Serializable {

	private int codigoCategoria = 1;
	private Categoria categoria = new Categoria(codigoCategoria);
	private Categoria categoriaAtual;
	private CategoriaService service = new CategoriaService();
	private Campeonato campeonatoCategoria;
	private Campeonato campeonatoCategoriaAtual;
	private CampeonatoService servCam = new CampeonatoService();

	public int getId() {
		List<Categoria> lista = service.getCategorias();

		Categoria c = new Categoria();
		if (!(lista.isEmpty())) {
			c = lista.get(lista.size() - 1);
			return c.getCodigoCategoria() + 1;
		}

		else
			return 1;
	}

	public void salvar() {

		if (categoria.getMinJogadores() > categoria.getMaxJogadores()) {
			categoria.setMaxJogadores(categoria.getMinJogadores());
		}

		else {

			if (categoria.getMinJogadores() < 5) {
				categoria.setMinJogadores(5);
			}

			if (categoria.getMaxJogadores() < 5) {
				categoria.setMaxJogadores(5);
			}
		}

		campeonatoCategoria.addCategorias(categoria);
		servCam.alterarCampeonato(campeonatoCategoria);

		categoria.setCampeonato(campeonatoCategoria);
		
		codigoCategoria = getId();
		categoria.setCodigoCategoria(codigoCategoria);
		service.salvar(categoria);
		categoria = new Categoria(codigoCategoria);
		campeonatoCategoria = null;

	}
	
	public void salvar2() {

		if (categoria.getMinJogadores() > categoria.getMaxJogadores()) {
			categoria.setMaxJogadores(categoria.getMinJogadores());
		}

		else {

			if (categoria.getMinJogadores() < 5) {
				categoria.setMinJogadores(5);
			}

			if (categoria.getMaxJogadores() < 5) {
				categoria.setMaxJogadores(5);
			}
		}

		campeonatoCategoria.addCategorias(categoria);
		servCam.alterarCampeonato(campeonatoCategoria);

		categoria.setCampeonato(campeonatoCategoria);
		codigoCategoria = getId();
		categoria.setCodigoCategoria(codigoCategoria);

		service.salvar(categoria);
		categoria = new Categoria(codigoCategoria);

	}

	public String salvarEditar() {

		if (categoriaAtual.getMinJogadores() > categoriaAtual.getMaxJogadores()) {
			categoriaAtual.setMaxJogadores(categoriaAtual.getMinJogadores());
		}

		else {

			if (categoriaAtual.getMinJogadores() < 5) {
				categoriaAtual.setMinJogadores(5);
			}

			if (categoriaAtual.getMaxJogadores() < 5) {
				categoriaAtual.setMaxJogadores(5);
			}
		}

		campeonatoCategoriaAtual.addCategorias(categoriaAtual);
		servCam.alterarCampeonato(campeonatoCategoriaAtual);

		categoriaAtual.setCampeonato(campeonatoCategoriaAtual);
		service.alterarCategoria(categoriaAtual);

		campeonatoCategoriaAtual = null;

		return "cadastroCategoria";
	}

	public String editarCategoria(Categoria categoria, Campeonato campeonato) {
		this.categoriaAtual = categoria;
		this.campeonatoCategoriaAtual = campeonato;
		return "editarCategoria";
	}

	public void removerCategoria(Categoria categoria) {
		service.removerCategoria(categoria);
	}

	public void removerCategoria2(Categoria categoria) {
		service.removerCategoria(categoria);
	}
	
	public String inserirCategorias(Campeonato campeonato) {
		this.campeonatoCategoria = campeonato;
		return "inserirCategorias";
	}

	public String descricaoCategoria(Categoria categoria) {
		this.categoriaAtual = categoria;
		return "descricaoCategoria";
	}

	public String descricaoCategoria2(Categoria categoria) {
		this.categoriaAtual = categoria;
		return "descricaoCategoria2";
	}

	public String voltar() {
		return "cadastroCategoria";
	}

	public String voltar2() {
		campeonatoCategoria = null;
		return "cadastroCampeonatoVer";
	}

	public Campeonato getCampeonatoCategoriaAtual() {
		return campeonatoCategoriaAtual;
	}

	public void setCampeonatoCategoriaAtual(Campeonato campeonatoCategoriaAtual) {
		this.campeonatoCategoriaAtual = campeonatoCategoriaAtual;
	}

	public List<Campeonato> getCampeonatos() {
		return servCam.getCampeonatos();
	}

	public Campeonato getCampeonatoCategoria() {
		return campeonatoCategoria;
	}

	public void setCampeonatoCategoria(Campeonato campeonatoCategoria) {
		this.campeonatoCategoria = campeonatoCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return service.getCategorias();
	}

	public Categoria getCategoriaAtual() {
		return categoriaAtual;
	}

	public void setCategoriaAtual(Categoria categoriaAtual) {
		this.categoriaAtual = categoriaAtual;
	}

	public void error() {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",
				"A quantia m�nima de jogadores n�o pode ser maior que a quantia m�xima!."));
	}
}
