package br.com.jobmanager.dao;

import java.util.List;

import br.com.jobmanager.model.Sistema;

public interface SistemaDao {

	void adicionar(Sistema sistema);
	
	List<Sistema> localizar(String sigla);

}