package com.adaming.projetJsf.service;

import java.util.List;

import com.adaming.projetJsf.entity.ProduitPanier;

public interface ProduitPanierService {

	public void validerCommande(List<ProduitPanier> produitPanier);
//	public void ajoutPanier(Produit Produit);
}
