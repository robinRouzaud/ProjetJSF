package com.adaming.projetJsf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.projetJsf.dao.ProduitDao;
import com.adaming.projetJsf.entity.Categorie;
import com.adaming.projetJsf.entity.Produit;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	ProduitDao produitDao ;

	@Override
	public List<Produit> getAllProduits() {
		return produitDao.getAllProduits();
	}

	@Override
	public List<Produit> getAllProduitsByCategorie(Categorie categorie) {
		return produitDao.getAllProduitsByCategorie(categorie);
	}

	@Override
	public Produit getProduitById(int id) {
		return produitDao.getProduitById(id);
	}

	@Override
	public void updateStockProduit(Produit produit) {
		produitDao.updateStockProduit(produit);
	}

	@Override
	public List<Produit> getProduitsByMC(String motCle) {
		return produitDao.getProduitsByMC(motCle);
	}

}
