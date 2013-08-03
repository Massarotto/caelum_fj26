package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.Item;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;
import br.com.caelum.notasfiscais.modelo.Produto;

@ManagedBean
@ViewScoped
public class NotaFiscalBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Item item = new Item();
	private NotaFiscal notaFiscal = new NotaFiscal();
	private Long idProduto;
	
	public void guardaItem() {
		DAO<Produto> dao = new DAO<>(Produto.class);
		Produto produto = dao.buscaPorId(idProduto);
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		
		notaFiscal.addItens(item);
		item = new Item();
	}
	
	public void adiciona() {
		DAO<NotaFiscal> dao = new DAO<>(NotaFiscal.class);
		dao.adiciona(notaFiscal);
		
		this.notaFiscal = new NotaFiscal();
		this.item = new Item();
	}
	
	public Item getItem() {
		return item;
	}
	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}
	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
}
