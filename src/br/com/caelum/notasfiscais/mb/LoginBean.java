package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.notasfiscais.dao.UsuarioDAO;
import br.com.caelum.notasfiscais.modelo.Usuario;

@Named
@RequestScoped
public class LoginBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioLogado usuarioLogado;
	
	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioDAO dao;
	
	public String efetuaLogin() {
		boolean loginValido = dao.existe(usuario);
		if(loginValido) {
			usuarioLogado.setUsuario(usuario);
			return "notafiscal?faces-redirect=true";
		}else {
			usuarioLogado.setUsuario(null);
			return "login?faces-redirect=true";
		}
	}
	
	public String efetuaLogout() {
		usuarioLogado.setUsuario(null);
		return "login?faces-redirect=true";
	}
	
	public boolean isLogado() {
		return usuarioLogado.isLogado();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
