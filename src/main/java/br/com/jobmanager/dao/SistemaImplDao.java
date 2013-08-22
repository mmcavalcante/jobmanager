package br.com.jobmanager.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.jobmanager.model.Sistema;


public class SistemaImplDao implements SistemaDao {

	private final Session session;

	public SistemaImplDao(Session session) {
		this.session = session;
	}

	public void adicionar(Sistema sistema) {
		session.save(sistema);
	}
	
	@SuppressWarnings("unchecked")
	public List<Sistema> localizar(String sigla) {

		return session.createCriteria(Sistema.class).add(
				Restrictions.ilike("title", "%" + sigla + "%")).list();
	}

}
