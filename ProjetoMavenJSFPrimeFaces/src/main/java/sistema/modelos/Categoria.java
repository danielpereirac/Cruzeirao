package sistema.modelos;

public class Categoria {
	
	private int codigoCategoria;
	private String tipoCategoria;
	private int qntMinJogadores;
	private int qntMaxJogadores;
	private String sexoCategoria;
	
	public int getCodigoCategoria() {
		return codigoCategoria;
	}
	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}
	public String getTipoCategoria() {
		return tipoCategoria;
	}
	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}
	public int getQntMinJogadores() {
		return qntMinJogadores;
	}
	public void setQntMinJogadores(int qntMinJogadores) {
		this.qntMinJogadores = qntMinJogadores;
	}
	public int getQntMaxJogadores() {
		return qntMaxJogadores;
	}
	public void setQntMaxJogadores(int qntMaxJogadores) {
		this.qntMaxJogadores = qntMaxJogadores;
	}
	public String getSexoCategoria() {
		return sexoCategoria;
	}
	public void setSexoCategoria(String sexoCategoria) {
		this.sexoCategoria = sexoCategoria;
	}
}
