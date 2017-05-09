package sistema.service;

import java.util.ArrayList;
import java.util.List;

import sistema.modelos.Usuario;

public class UsuarioService {
	
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	
	public UsuarioService()
	{
		
	}
	
	public void salvar(Usuario usuario) 
	{
		usuarios.add(usuario);
	}
	
	public boolean entrar(Usuario usuario)
	{
		
		for(Usuario aux: usuarios){
		if(aux.getNomeUsuario()==usuario.getNomeUsuario()&& aux.getSenha()==usuario.getSenha())
			
			return true;
		}
			return false;
	}
	
	public void recuperarSenha(Usuario usuario)
	{
					
	}

	public ArrayList <Usuario> getUsuarios()
	{
		return usuarios;
	}
}
