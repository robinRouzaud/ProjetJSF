package com.adaming.projetJsf.service;

import com.adaming.projetJsf.entity.Client;

public interface ClientService {

	public Client getClientByEmailAndPassword(String email, String mdp);
	
	public Client getClientByUsername(String username);
	
	//public boolean ajouterProduitPanier(Client client, Produit produit);
	
	//public String stockInsuffisant();
}
