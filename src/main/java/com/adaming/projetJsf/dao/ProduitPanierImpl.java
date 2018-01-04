package com.adaming.projetJsf.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.projetJsf.entity.ProduitPanier;

@Repository
public class ProduitPanierImpl implements ProduitPanierDao {

	@Autowired
	private SessionFactory sf;
	
	@Override
	public void validerCommande(List<ProduitPanier> produitPanier) {
		Session session = sf.openSession();
		session.save(produitPanier);
		session.close();
	}

}
