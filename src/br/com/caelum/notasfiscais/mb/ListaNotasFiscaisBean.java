package br.com.caelum.notasfiscais.mb;

import java.io.Serializable;

import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.datamodel.DataModelNotasFiscais;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

@Named
public class ListaNotasFiscaisBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private LazyDataModel<NotaFiscal> dataModel;
	
	public ListaNotasFiscaisBean() {
		this.dataModel = new DataModelNotasFiscais();
		DAO<NotaFiscal> dao = new DAO<>(NotaFiscal.class);
		this.dataModel.setRowCount(dao.contaTodos());
	}

	public LazyDataModel<NotaFiscal> getDataModel() {
		return dataModel;
	}
	
}
