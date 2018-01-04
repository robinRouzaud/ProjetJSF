package com.adaming.projetJsf.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProduitPanierId implements Serializable {
	
	@Column(name="id_produit")
	private int idProduit;
	
	@Column(name="id_panier")
	private int idPanier;
	
	private ProduitPanierId() {}

	public ProduitPanierId(int idProduit, int idPanier) {
		super();
		this.idProduit = idProduit;
		this.idPanier = idPanier;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		
		ProduitPanierId that = (ProduitPanierId) o;
		
		return Objects.equals(idProduit, that.idProduit) && Objects.equals(idPanier, that.idPanier);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idProduit, idPanier);
	}
}
