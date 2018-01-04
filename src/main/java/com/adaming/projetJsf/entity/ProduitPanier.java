package com.adaming.projetJsf.entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="produit_panier")
public class ProduitPanier {

	@EmbeddedId
	private ProduitPanierId id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@MapsId("idProduit")
	private Produit produit;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@MapsId("idPanier")
	private Panier panier;
	
	@Column(name="created_on")
	private Date createdOn = new Date();

	private ProduitPanier() {
		super();
	}

	public ProduitPanier(Produit produit, Panier panier) {
		super();
		this.produit = produit;
		this.panier = panier;
		this.id = new ProduitPanierId(produit.getIdProduit(), panier.getIdPanier());
	}

	public ProduitPanierId getId() {
		return id;
	}

	public void setId(ProduitPanierId id) {
		this.id = id;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		ProduitPanier that = (ProduitPanier) o;
		
		return Objects.equals(produit, that.produit) && Objects.equals(panier, that.panier);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(produit, panier);
	}
	
}
