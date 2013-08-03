package br.com.caelum.notasfiscais.datamodel;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.caelum.notasfiscais.dao.DAO;
import br.com.caelum.notasfiscais.modelo.NotaFiscal;

public class DataModelNotasFiscais extends LazyDataModel<NotaFiscal>{

	@Override
	public List<NotaFiscal> load(int inicio, int quantidade, String campoOrdenacao,
			SortOrder tipo, Map<String, String> filtros) {
		DAO<NotaFiscal> dao = new DAO<>(NotaFiscal.class);
		return dao.listaTodosPaginada(inicio, quantidade);
	}

}
