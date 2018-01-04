package com.adaming.projetJsf.control;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.projetJsf.entity.Categorie;
import com.adaming.projetJsf.entity.Produit;
import com.adaming.projetJsf.service.ProduitService;

@ManagedBean
@Component
public class ProduitCtrl {

	@Autowired
	private ProduitService service;
	private Produit produit;

	public void setService(ProduitService service) {
		this.service = service;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public List<Produit> getProduitList(Categorie categorie) {
		return service.getAllProduitsByCategorie(categorie);
	}
}
