package com.adaming.projetJsf.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adaming.projetJsf.entity.Client;

@Repository
public class ClientDaoImpl implements ClientDao{

	@Autowired
	private SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Client getClientByEmailAndPassword(String email, String mdp) {
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Client c WHERE c.emailClient = :email "
				+ "AND c.mdpClient = :mdp");
		query.setParameter("email", email);
		query.setParameter("mdp", mdp);
		Client client = (Client) query.uniqueResult();
		session.close();
		return client;
	}

	@Override
	public Client getClientByUsername(String username) {
		Session session = sf.openSession();
		Query query = session.createQuery("FROM Client c WHERE c.username = :username");
		query.setParameter("username", username);
		Client client = (Client) query.uniqueResult();
		session.close();
		return client;
	}

}
