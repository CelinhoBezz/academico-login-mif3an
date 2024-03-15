package com.itb.mif3an.academicologinmif3an.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="papeis")
public class Papel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Column(name="nomePapel")
	private String nomePapel;
	
	//@Column(name="descricaoPapel")
	private String descricaoPapel;

	private boolean codStatusPapel;

	public Papel() {
		
	}
	
	public Papel(String nomePapel) {
		this.nomePapel = nomePapel;
	}
	
	public Papel(Long id, String nomePapel) {
		this.id = id;
		this.nomePapel = nomePapel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomePapel() {
		return nomePapel;
	}

	public void setNomePapel(String nomePapel) {
		this.nomePapel = nomePapel;
	}

	public String getdescricaoPapel() {
		return descricaoPapel;
	}

	public void setdescricaoPapel(String descricaoPapel) {
		this.descricaoPapel = descricaoPapel;
	}

	public boolean isCodStatusPapel() {
		return codStatusPapel;
	}

	public void setCodStatusPapel(boolean codStatusPapel) {
		this.codStatusPapel = codStatusPapel;
	}
	
	
	
	
}
