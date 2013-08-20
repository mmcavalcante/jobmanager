package br.com.jobmanager.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

@Entity
@Component
@SessionScoped
public class Sistema {

	@Id
	@NotNull
	private int idSistema;

	@NotNull
	@Length(min = 1, max = 5)
	private String siglaSistema;

	@NotNull
	@Length(min = 3, max = 100)
	private String nomeSistema;

	public int getIdSistema() {
		return idSistema;
	}

	public void setIdSistema(int idSistema) {
		this.idSistema = idSistema;
	}

	public String getSiglaSistema() {
		return siglaSistema;
	}

	public void setSiglaSistema(String siglaSistema) {
		this.siglaSistema = siglaSistema;
	}

	public String getNomeSistema() {
		return nomeSistema;
	}

	public void setNomeSistema(String nomeSistema) {
		this.nomeSistema = nomeSistema;
	}

}
