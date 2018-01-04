package com.adaming.projetJsf.dao;

import com.adaming.projetJsf.entity.Client;

public interface ClientDao {

	public Client getClientByEmailAndPassword(String email, String mdp);
	
	public Client getClientByUsername(String username);
	
}
