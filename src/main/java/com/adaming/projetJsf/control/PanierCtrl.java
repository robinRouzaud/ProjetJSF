package com.adaming.projetJsf.control;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.projetJsf.entity.Client;
import com.adaming.projetJsf.entity.Produit;
import com.adaming.projetJsf.entity.ProduitPanier;
import com.adaming.projetJsf.service.ProduitPanierService;

@ManagedBean
@Component
public class PanierCtrl {

	@Autowired
	private ProduitPanierService service;
	private Produit produit;
	private ProduitPanier produitPanier;
	//private Panier panier;
	private Client client;
	
	public ProduitPanier getProduitPanier() {
		return produitPanier;
	}
	public void setProduitPanier(ProduitPanier produitPanier) {
		this.produitPanier = produitPanier;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ProduitPanierService getService() {
		return service;
	}
	public void setService(ProduitPanierService service) {
		this.service = service;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
//	public void ajoutProduit(Produit produit) {
//		client.getPanier().addProduit(produit);
//	}
//	
//	public void retraitProduit(Produit produit) {
//		client.getPanier().removeProduit(produit);
//	}
//	
//	public void validerCommande(ProduitPanier produitPanier) {
//		service.validerCommande(produitPanier);
//	}
}
