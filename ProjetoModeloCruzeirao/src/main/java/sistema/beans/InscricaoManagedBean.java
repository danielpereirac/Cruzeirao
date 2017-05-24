package sistema.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




import sistema.modelos.Categoria;
import sistema.modelos.Equipe;
import sistema.modelos.Inscricao;
import sistema.modelos.Inscrito;
import sistema.modelos.Usuario;
import sistema.beans.InscritoManagedBean;

import sistema.service.CategoriaService;
import sistema.service.InscricaoService;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class InscricaoManagedBean implements Serializable{
	

	private long numero=1;
	private Inscricao inscricao = new Inscricao(numero);
	private InscricaoService service = new InscricaoService();
	private Inscricao inscricaoAtual;
	private Categoria categoriaInscricao;
	private CategoriaService servCat = new CategoriaService();
	private List<Usuario> inscritosSelecionados;
	private InscritoManagedBean inscritoManagedBean;
	private List<Inscrito> inscritos;
	
	
	
	public InscritoManagedBean getInscritoManagedBean() {
		return inscritoManagedBean;
	}

	public void setInscritoManagedBean(InscritoManagedBean inscritoManagedBean) {
		this.inscritoManagedBean = inscritoManagedBean;
	}

	public String finalizarInscricao(Equipe equipe){
		inscricao.setEquipe(equipe);
		return "inscricaoTime";
	}
	
	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Inscricao getInscricao() {
		return inscricao;
	}

	public void setInscricao(Inscricao inscricao) {
		this.inscricao = inscricao;
	}

	public CategoriaService getServCat() {
		return servCat;
	}

	public void setServCat(CategoriaService servCat) {
		this.servCat = servCat;
	}



	public List<Usuario> getInscritosSelecionados() {
		return inscritosSelecionados;
	}

	public void setInscritosSelecionados(List<Usuario> inscritosSelecionados) {
		this.inscritosSelecionados = inscritosSelecionados;
	}
	
	public String salvar(){
		numero = getId();
		inscricao.setNumero(numero);
		inscricao.setCategoria(categoriaInscricao);
		//inscricao.setInscritos(inscritosSelecionados);
	//	inscritos.clear();
	//	inscritos= new ArrayList<Inscrito>();
		
		for(Usuario u: inscritosSelecionados){
			Inscrito i= inscritoManagedBean.salvarInscrito(u, inscricao);
			inscritos.add(i);
			
	}
		inscricao.setInscritos(inscritos);
		service.salvar(inscricao);
		inscricaoAtual=inscricao;
		inscricao = new Inscricao(numero);
		
		return "descricaoInscricao";
	}
	
	public List<Categoria> getCategorias() {
		return servCat.getCategorias();
	}
	public InscricaoService getService() {
		return service;
	}
	public void setService(InscricaoService service) {
		this.service = service;
	}
	public Inscricao getInscricaoAtual() {
		return inscricaoAtual;
	}
	public void setInscricaoAtual(Inscricao inscricaoAtual) {
		this.inscricaoAtual = inscricaoAtual;
	}
	
	public long getId() {
		List<Inscricao> lista = service.getInscricoes();

		Inscricao e = new Inscricao();
		if (!(lista.isEmpty())) {
			e = lista.get(lista.size() - 1);
			return e.getNumero() + 1;
		}

		else
			return 1;
	}

	public Categoria getCategoriaInscricao() {
		return categoriaInscricao;
	}

	public void setCategoriaInscricao(Categoria categoriaInscricao) {
		this.categoriaInscricao = categoriaInscricao;
	}
	
	public String voltar(){
		return "cadastroEquipe";
		
	}
	
	
	
	
	
}
