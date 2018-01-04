package com.adaming.projetJsf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.projetJsf.entity.Categorie;
import com.adaming.projetJsf.entity.Produit;

@Repository
public class ProduitDaoImpl implements ProduitDao {

	@Autowired
	SessionFactory sf;


	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getAllProduits() {
		Session session = this.sf.getCurrentSession();
		return (List<Produit>) session.createQuery("FROM Produit").list();
	}

	@Override
	public List<Produit> getAllProduitsByCategorie(Categorie categorie) {
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Produit p WHERE p.categorie.idCategorie = :idCategorie");
		query.setParameter("idCategorie", categorie.getIdCategorie());
		@SuppressWarnings("unchecked")
		List<Produit> result = query.list();
		session.close();
		return result;
	}

	@Override
	public Produit getProduitById(int id) {
		Session session = this.sf.getCurrentSession();
		Query query = session.createQuery("FROM Produit p WHERE p.idProduit = :id");
		query.setParameter("id", id);
		return (Produit) query.uniqueResult();
	}

	@Override
	public void updateStockProduit(Produit produit) {
		Session session = sf.openSession();
		session.update(produit);
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Produit> getProduitsByMC(String motCle) {
		Session session = this.sf.getCurrentSession();
		Query query = session.createQuery("FROM Produit p WHERE p.nomProduit LIKE :motCle");
		query.setParameter("motCle", "%" + motCle + "%");
		return (List<Produit>) query.list();
	}

}
