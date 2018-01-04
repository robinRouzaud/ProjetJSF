package com.adaming.projetJsf.dao;

import java.util.List;

import com.adaming.projetJsf.entity.ProduitPanier;

public interface ProduitPanierDao {

	public void validerCommande(List<ProduitPanier> produitPanier);
	
}
