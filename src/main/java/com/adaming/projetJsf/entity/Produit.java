package com.adaming.projetJsf.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produits")
public class Produit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_produit")
	private int idProduit;
	
	@Column(name="nom_produit")
	private String nomProduit;
	
	@Column(name="ref_produit")
	private String ref;
	
	@Column(name="prix_produit")
	private float prixProduit;
	
	// Represente la quantite dans le diagramme de classes
	@Column(name="stock_produit")
	private int stockProduit;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="fk_categorie", referencedColumnName="id_categorie")
	private Categorie categorie;
	@OneToMany(mappedBy="produit",
				cascade=CascadeType.ALL,
				orphanRemoval=true,
				fetch=FetchType.EAGER)
	private List<ProduitPanier> paniers = new ArrayList<ProduitPanier>();

	public Produit() {
		super();
	}

	public Produit(String nomProduit) {
		super();
		this.nomProduit = nomProduit;
	}
	

	public Produit(String nomProduit, String ref, float prixProduit, int stockProduit, Categorie categorie) {
		super();
		this.nomProduit = nomProduit;
		this.ref = ref;
		this.prixProduit = prixProduit;
		this.stockProduit = stockProduit;
		this.categorie = categorie;
	}

	public Produit(String nomProduit, String ref, float prixProduit, int stockProduit, Categorie categorie,
			List<ProduitPanier> paniers) {
		super();
		this.nomProduit = nomProduit;
		this.ref = ref;
		this.prixProduit = prixProduit;
		this.stockProduit = stockProduit;
		this.categorie = categorie;
		this.paniers = paniers;
	}

	public Produit(int idProduit, String nomProduit, String ref, float prixProduit, int stockProduit, Categorie categorie,
			List<ProduitPanier> paniers) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.ref = ref;
		this.prixProduit = prixProduit;
		this.stockProduit = stockProduit;
		this.categorie = categorie;
		this.paniers = paniers;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", ref=" + ref + ", prixProduit="
				+ prixProduit + ", stockProduit=" + stockProduit + ", categorie=" + categorie + ", paniers=" + paniers
				+ "]";
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public String getNomProduit() {
		return nomProduit;
	}

	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public float getPrixProduit() {
		return prixProduit;
	}

	public void setPrixProduit(float prixProduit) {
		this.prixProduit = prixProduit;
	}

	public int getStockProduit() {
		return stockProduit;
	}

	public void setStockProduit(int stockProduit) {
		this.stockProduit = stockProduit;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<ProduitPanier> getPaniers() {
		return paniers;
	}

	public void setPaniers(List<ProduitPanier> paniers) {
		this.paniers = paniers;
	}
	
	
}