package com.adaming.projetJsf.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private int idClient;

	@Column(name = "nom_client")
	private String nom;

	@Column(name = "prenom_client")
	private String prenom;

	@Column(name = "email_client")
	private String emailClient;

	@Column(name = "adresse_Client")
	private String adresseClient;

	@Column(name = "mdp_client")
	private String mdpClient;

	@OneToOne
	@JoinColumn(name = "id_panier")
	private Panier panier;
	private String role;
	private String username;

	public Client() {
		super();
	}

	public Client(String nom, String prenom, String emailClient, String adresseClient, Panier panier) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.emailClient = emailClient;
		this.adresseClient = adresseClient;
		this.panier = panier;
	}

	public Client(int idClient, String nom, String prenom, String emailClient, String adresseClient, Panier panier) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.emailClient = emailClient;
		this.adresseClient = adresseClient;
		this.panier = panier;
	}

	public Client(int idClient, String nom, String prenom, String emailClient, String adresseClient, String mdpClient,
			Panier panier) {
		super();
		this.idClient = idClient;
		this.nom = nom;
		this.prenom = prenom;
		this.emailClient = emailClient;
		this.adresseClient = adresseClient;
		this.mdpClient = mdpClient;
		this.panier = panier;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", nom=" + nom + ", prenom=" + prenom + ", emailClient=" + emailClient
				+ ", adresseClient=" + adresseClient + ", panier=" + panier + "]";
	}

	public Client(String nom, String prenom, String emailClient, String adresseClient, String mdpClient, Panier panier,
			String username) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.emailClient = emailClient;
		this.adresseClient = adresseClient;
		this.mdpClient = mdpClient;
		this.panier = panier;
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmailClient() {
		return emailClient;
	}

	public void setEmailClient(String emailClient) {
		this.emailClient = emailClient;
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public String getMdpClient() {
		return mdpClient;
	}

	public void setMdpClient(String mdpClient) {
		this.mdpClient = mdpClient;
	}

}
