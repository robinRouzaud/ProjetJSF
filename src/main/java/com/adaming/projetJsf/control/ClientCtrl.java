package com.adaming.projetJsf.control;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.adaming.projetJsf.entity.Client;
import com.adaming.projetJsf.entity.Panier;
import com.adaming.projetJsf.entity.Produit;
import com.adaming.projetJsf.entity.ProduitPanier;
import com.adaming.projetJsf.service.ClientService;
import com.adaming.projetJsf.service.ProduitPanierService;

@ManagedBean
@Component
public class ClientCtrl {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ProduitPanierService produitPanierService;

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService detailsService;

	private String email;
	private String mdp;
	private Client client;

//	public String init() {
//		String page = null;
//		SecurityContext sc = SecurityContextHolder.getContext();
//		Object obj = sc.getAuthentication().getPrincipal();
//		if (obj instanceof Client) {
//			client = clientService.getClientByUsername(((Client) obj).getUsername());
//			if (client != null) {
//				page = "/pages/accueil.xhtml";
//			}
//		}
//		return page;
//	}

	public Client afficheUser() {
		SecurityContext sc = SecurityContextHolder.getContext();
		Object obj = sc.getAuthentication().getPrincipal();
		client = clientService.getClientByUsername(((UserDetails)obj).getUsername());
		Panier panier = new Panier();
		client.setPanier(panier);
		return client;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public ClientService getService() {
		return clientService;
	}

	public void setService(ClientService clientService) {
		this.clientService = clientService;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String grantAccessFromEmailAndPassword() {
		client = new Client();
		client = clientService.getClientByEmailAndPassword(email, mdp);
		Panier panier = new Panier();
		client.setPanier(panier);
		if (client != null) {
			return "/pages/accueil.xhtml";
		} else {
			return "wrong-password";
		}
	}

	public void ajoutProduit(Produit produit) {
		client.getPanier().addProduit(produit);
	}

	public void retraitProduit(Produit produit) {
		client.getPanier().removeProduit(produit);
	}

	public List<ProduitPanier> afficherPanier() {
		return client.getPanier().getProduits();
	}

	public String goToPanier() {
		if(client.getRole().equals("ROLE_USER"))
			return "/pages/user/panier";
		else if (client.getRole().equals("ROLE_ADMIN"))
			return "/pages/admin/panier";
		else
			return "/index";
	}

	public String goToAccueil() {
		if(client.getRole().equals("ROLE_USER"))
			return "/pages/user/accueil.xhtml";
		else if (client.getRole().equals("ROLE_ADMIN"))
			return "/pages/admin/accueil.xhtml";
		else
			return "/index";
	}

	public void validerCommande(List<ProduitPanier> produitPanier) {
		produitPanierService.validerCommande(produitPanier);
	}

	// public void ajoutProduitPanier(Produit produit) {
	// boolean ajout = service.ajouterProduitPanier(client, produit);
	// if (ajout == false) {
	// service.stockInsuffisant();
	// }
	// }
}
