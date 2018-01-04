package com.adaming.projetJsf.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.projetJsf.entity.Categorie;

@Repository
public class CategorieDaoImpl implements CategorieDao {

	@Autowired
	private SessionFactory sf;

	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> getAllCategories() {
		Session session = sf.openSession();
		List<Categorie> categories = (List<Categorie>) session.createQuery("FROM Categorie").list();
		session.close();
		return categories;
	}

	@Override
	public Categorie getCategorieByName(String nom) {
		Session session = this.sf.getCurrentSession();
		Query query = session.createQuery("FROM Categorie c WHERE c.nomCategorie LIKE :nom");
		query.setParameter("nom", "%" + nom + "%");
		return (Categorie) query.uniqueResult();
	}

}
