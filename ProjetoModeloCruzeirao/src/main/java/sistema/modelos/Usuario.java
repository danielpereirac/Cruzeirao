package sistema.modelos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Id;
@SuppressWarnings("serial")
@Entity
public class Usuario implements Serializable{
	
	@id
	private String nome;
	private String nomeUsuario;
	private String senha;
	private String email;
	private String rg;
	private String cpf;
	private String dataNascimento;
	private String endereco;
	private String telefoneFixo;
	private String telefoneMovel;
	private List <Campeonato> campeonatos;
	private List <Inscrito> incricoes;
	private List <Equipe> equipes;
	private String foto;
	private Enum sexo ;
	private String cref;
	
	public Usuario()
	{
		
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneMovel() {
		return telefoneMovel;
	}
	public void setTelefoneMovel(String telefoneMovel) {
		this.telefoneMovel = telefoneMovel;
	}
	public List<Campeonato> getCampeonatos() {
		return campeonatos;
	}
	public void setCampeonatos(List<Campeonato> campeonatos) {
		this.campeonatos = campeonatos;
	}
	public List<Inscrito> getIncricoes() {
		return incricoes;
	}
	public void setIncricoes(List<Inscrito> incricoes) {
		this.incricoes = incricoes;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Enum getSexo() {
		return sexo;
	}
	public void setSexo(Enum sexo) {
		this.sexo = sexo;
	}
	public String getCref() {
		return cref;
	}
	public void setCref(String cref) {
		this.cref = cref;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}
