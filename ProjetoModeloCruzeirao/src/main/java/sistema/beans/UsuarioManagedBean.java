package sistema.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Usuario;
import sistema.service.UsuarioService;

@ManagedBean
@SessionScoped
public class UsuarioManagedBean implements Serializable {
	
	private Usuario usuario = new Usuario();
	private Usuario usuarioRecuperarSenha = new Usuario();
	private Usuario usuarioEntrar = new Usuario();
	private Boolean permissao = false;
	private Usuario usuarioAtual;
	private UsuarioService service = new UsuarioService();
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	
	public String salvar()
	{
		service.salvar(usuario);
		usuario = new Usuario();
		return "login";
	}
	
	public String entrar()
	{
		
		usuarios =service.getUsuarios();
		for(Usuario aux: usuarios)
		{
		
			if((aux.getNome().equals(usuarioEntrar.getNome()))&&(aux.getSenha().equals(usuarioEntrar.getSenha())))
			{
				permissao = true;
			}
			
		}
		if(permissao==true)
		return "paginaInicial";
		else
		return "cadastroCampeonato";
		
	}
	
	public String voltar()
	{
		return "login";
	}
	
	public String recuperarSenha()
	{
		usuarios=service.getUsuarios();
		for(Usuario aux : usuarios)
		{
			if(aux.getEmail().equals(usuarioRecuperarSenha.getEmail())&& (aux.getCpf().equals(usuarioRecuperarSenha.getCpf())))
			{
				permissao = true;
				usuario = aux;
			}
		}
		if(permissao == true)
		{
			return "mostrarSenha";
		}
		else
		{
		permissao = false;
		return "login";
		}
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Usuario> getUsuarios() {
		return service.getUsuarios();
	}
	public Usuario getUsuarioAtual() {
		return usuarioAtual;
	}
	public void setUsuarioAtual(Usuario usuarioAtual) {
		this.usuarioAtual = usuarioAtual;
	}

	public Usuario getUsuarioRecuperarSenha() {
		return usuarioRecuperarSenha;
	}

	public void setUsuarioRecuperarSenha(Usuario usuarioRecuperarSenha) {
		this.usuarioRecuperarSenha = usuarioRecuperarSenha;
	}

	public Usuario getUsuarioEntrar() {
		return usuarioEntrar;
	}

	public void setUsuarioEntrar(Usuario usuarioEntrar) {
		this.usuarioEntrar = usuarioEntrar;
	}
}
