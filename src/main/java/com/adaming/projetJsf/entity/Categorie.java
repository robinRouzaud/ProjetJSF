package com.adaming.projetJsf.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categorie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_categorie")
	private int idCategorie;
	
	@Column(name="nom_categorie")
	private String nomCategorie;
	
	@Column(name="description_categorie")
	private String descriptionCategorie;

	public Categorie() {
		super();
	}

	public Categorie(String nomCategorie, String descriptionCategorie) {
		super();
		this.nomCategorie = nomCategorie;
		this.descriptionCategorie = descriptionCategorie;
	}

	public Categorie(int idCategorie, String nomCategorie, String descriptionCategorie) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.descriptionCategorie = descriptionCategorie;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nomCategorie=" + nomCategorie + ", descriptionCategorie="
				+ descriptionCategorie + "]";
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public String getDescriptionCategorie() {
		return descriptionCategorie;
	}

	public void setDescriptionCategorie(String descriptionCategorie) {
		this.descriptionCategorie = descriptionCategorie;
	}
}
