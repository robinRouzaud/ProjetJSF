package com.adaming.projetJsf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.projetJsf.dao.ProduitPanierDao;
import com.adaming.projetJsf.entity.ProduitPanier;

@Service
public class ProduitPanierServiceImpl implements ProduitPanierService {

	@Autowired
	ProduitPanierDao produitPanierDao;
	
	@Override
	public void validerCommande(List<ProduitPanier> produitPanier) {
		produitPanierDao.validerCommande(produitPanier);		
	}

//	@Override
//	public void ajoutPanier(Produit Produit) {
//				
//	}

}
