package com.adaming.projetJsf.service;
import java.util.List;

import com.adaming.projetJsf.entity.Categorie;
import com.adaming.projetJsf.entity.Produit;

public interface ProduitService {

	public List<Produit> getAllProduits();

	public List<Produit> getAllProduitsByCategorie(Categorie categorie);

	public Produit getProduitById(int id);

	public void updateStockProduit(Produit produit);

	public List<Produit> getProduitsByMC(String motCle);
}
