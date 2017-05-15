package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Campeonato;
import sistema.modelos.Categoria;
import sistema.service.CampeonatoService;
import sistema.service.CategoriaService;

@ManagedBean
@SessionScoped
public class CategoriaManagedBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private int codigoCategoria = 1;
	private Categoria categoria = new Categoria(codigoCategoria);
	private Categoria categoriaAtual;
	private CategoriaService service = new CategoriaService();
	private Campeonato campeonatoCategoria;
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
		campeonatoCategoria.addCategorias(categoria);
		servCam.alterarCampeonato(campeonatoCategoria);

		categoria.setCampeonato(campeonatoCategoria);
		codigoCategoria = getId();
		categoria.setCodigoCategoria(codigoCategoria);
		service.salvar(categoria);
		categoria = new Categoria(codigoCategoria);
		campeonatoCategoria = null;
	}

	public String salvarEditar() {
		return "cadastroCategoria";
	}

	public String editarCategoria(Categoria categoria) {
		this.categoriaAtual = categoria;
		return "editarCategoria";
	}

	public void removerCategoria(Categoria categoria) {
		service.removerCategoria(categoria);
	}

	public void removerCategoria2(Categoria categoria) {
		service.removerCategoria(categoria);
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
		return "inserirCategorias";
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
}
