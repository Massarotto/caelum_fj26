package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@ManagedBean
@SessionScoped
public class LoginBean {

	private Usuario usuario = new Usuario();
	
	public String efetuaLogin() {
		UsuarioDAO dao = new UsuarioDAO();
		if(dao.existe(usuario)) {
			return "produto?faces-redirect=true";
		}
		return "login?faces-redirect=true";
	}
	
	public String efetuaLogout() {
		this.usuario = new Usuario();
		return "login?faces-redirect=true";
	}
	
	public boolean isLogado() {
		return usuario.getLogin() != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
