package sistema.modelos;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Categoria implements Serializable{

	@Id
	private int codigoCategoria;
	private String nome;
	private int nascidosApartirDe;
	private List<Inscricao> inscricoes;
	
	@ManyToOne
	private Campeonato campeonato;
	private List<Fase> fases;
	private int minJogadores;
	private int maxJogadores;
	private String sexo;

	public Categoria() {

	}

	public Categoria(int codigoCategoria) {
		super();
		this.codigoCategoria = codigoCategoria;
	}

	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNascidosApartirDe() {
		return nascidosApartirDe;
	}

	public void setNascidosApartirDe(int nascidosApartirDe) {
		this.nascidosApartirDe = nascidosApartirDe;
	}

	public List<Inscricao> getInscritos() {
		return inscricoes;
	}

	public void setInscritos(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}

	public List<Fase> getFases() {
		return fases;
	}

	public void setFases(List<Fase> fases) {
		this.fases = fases;
	}

	public int getMinJogadores() {
		return minJogadores;
	}

	public void setMinJogadores(int minJogadores) {
		this.minJogadores = minJogadores;
	}

	public int getMaxJogadores() {
		return maxJogadores;
	}

	public void setMaxJogadores(int maxJogadores) {
		this.maxJogadores = maxJogadores;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}
