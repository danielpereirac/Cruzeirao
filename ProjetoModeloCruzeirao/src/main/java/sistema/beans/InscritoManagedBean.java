package sistema.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import sistema.modelos.Inscricao;
import sistema.modelos.Inscrito;
import sistema.modelos.Usuario;
import sistema.service.InscricaoService;
import sistema.service.InscritoService;

@SuppressWarnings("serial")
@ManagedBean
@SessionScoped
public class InscritoManagedBean implements Serializable{
	private Inscrito inscrito;
	private InscritoService service = new InscritoService();
	
	public Inscrito salvarInscrito(Usuario usuario, Inscricao inscricao){
		inscrito=new Inscrito(usuario, inscricao);
		inscrito.setNomeUser(usuario.getNome());
		service.salvar(inscrito);
		return inscrito;//service.getInscritoByNome(usuario.getNome());
				
		
	}
}
