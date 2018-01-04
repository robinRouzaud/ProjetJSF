package com.adaming.projetJsf.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.projetJsf.dao.ClientDao;
import com.adaming.projetJsf.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	ClientDao clientDao ;
	
//	@Autowired
//	ProduitDao produitDao;
	
	@Override
	public Client getClientByEmailAndPassword(String email, String mdp) {
		return clientDao.getClientByEmailAndPassword(email, mdp);
	}

	@Override
	public Client getClientByUsername(String username) {
		return clientDao.getClientByUsername(username);
	}

//	@Override
//	public boolean ajouterProduitPanier(Client client, Produit produit) {
//		int nbProduitDispo = produit.getStockProduit();
//		nbProduitDispo -= 1;
//		if (nbProduitDispo >= 0) {
//			client.getPanier().addProduit(produit);
//			produit.setStockProduit(produit.getStockProduit() - 1);
//			produitDao.updateStockProduit(produit);
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	@Override
//	public String stockInsuffisant() {
//		return "Cet article n'est plus disponible";
//	}

}
