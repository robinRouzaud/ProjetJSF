package com.adaming.projetJsf.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalIdCache;

@Entity
@Table(name="paniers")
@NaturalIdCache
public class Panier {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_panier")
	private int idPanier;
	
	@Column(name="date_panier")
	private String datePanier;
	
//	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinTable(name="produit_panier",
//			   joinColumns = @JoinColumn(name="fk_panier", referencedColumnName="id_panier"),
//			   inverseJoinColumns = @JoinColumn(name="fk_produit", referencedColumnName="id_produit"))
	@OneToMany( mappedBy="produit",
				cascade=CascadeType.ALL,
				orphanRemoval=true)
	private List<ProduitPanier> produits = new ArrayList<ProduitPanier>();

	@OneToOne(mappedBy="panier")
	private Client client;

	public Panier() {
		super();
	}
	
	public Panier(int idPanier) {
		this.idPanier = idPanier;
	}

	public Panier(String datePanier, List<ProduitPanier> produits, Client client) {
		super();
		this.datePanier = datePanier;
		this.produits = produits;
		this.client = client;
	}

	public Panier(int idPanier, String datePanier, List<ProduitPanier> produits, Client client) {
		super();
		this.idPanier = idPanier;
		this.datePanier = datePanier;
		this.produits = produits;
		this.client = client;
	}

	@Override
	public String toString() {
		return "Panier [idPanier=" + idPanier + ", datePanier=" + datePanier + ", produits=" + produits + ", client="
				+ client + "]";
	}

	public int getIdPanier() {
		return idPanier;
	}

	public void setIdPanier(int idPanier) {
		this.idPanier = idPanier;
	}

	public String getDatePanier() {
		return datePanier;
	}

	public void setDatePanier(String datePanier) {
		this.datePanier = datePanier;
	}

	public List<ProduitPanier> getProduits() {
		return produits;
	}

	public void setProduits(List<ProduitPanier> produits) {
		this.produits = produits;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addProduit(Produit produit) {
		ProduitPanier produitPanier = new ProduitPanier(produit, this);
		produits.add(produitPanier);
		produit.getPaniers().add(produitPanier);
	}
	
	public void removeProduit(Produit produit) {
		for (Iterator<ProduitPanier> iterator = produits.iterator(); iterator.hasNext();) {
			ProduitPanier produitPanier = iterator.next();
			if(produitPanier.getProduit().equals(produit) && produitPanier.getPanier().equals(this)) {
				iterator.remove();
				produitPanier.getPanier().getProduits().remove(produitPanier);	
				produitPanier.setProduit(null);
				produitPanier.setPanier(null);
			}
		}
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Panier panier = (Panier) o;
		return Objects.equals(idPanier, panier.idPanier);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idPanier);
	}
}
