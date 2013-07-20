package br.com.caelum.notasfiscais.mb;

import javax.faces.bean.ManagedBean;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
public class ProdutoBean {
		
	private Produto produto = new Produto();

	public void grava(){
		DAO<Produto> dao = new DAO<>(Produto.class);
		dao.adiciona(this.produto);
		this.produto = new Produto();
	}
	
	public Produto getProduto() {
		return produto;
	}
	
}
