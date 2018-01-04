package com.adaming.projetJsf.control;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adaming.projetJsf.entity.Categorie;
import com.adaming.projetJsf.entity.Client;
import com.adaming.projetJsf.service.CategorieService;
import com.adaming.projetJsf.service.ClientService;

@ManagedBean
@Component
public class CategorieCtrl {

	@Autowired
	private CategorieService service;
	private Categorie categorie;
	private Client c;
	@Autowired
	private ClientService clientService;

//	public Client afficheUser() {
//		SecurityContext sc = SecurityContextHolder.getContext();
//		Object obj = sc.getAuthentication().getPrincipal();
//		c = clientService.getClientByUsername(((UserDetails)obj).getUsername());
//		return c;
//	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public void setService(CategorieService service) {
		this.service = service;
	}

	public CategorieService getService() {
		return service;
	}

	public List<Categorie> getCategorieList() {
		return service.getAllCategories();
	}

	public String goTo(Categorie categorie, Client client) {
		c = client;
		this.categorie = categorie;
		if(c.getRole().equals("ROLE_USER"))
			return "/pages/user/categorie.xhtml";
		else if (c.getRole().equals("ROLE_ADMIN"))
			return "/pages/admin/categorie.xhtml";
		else
			return "/index";
	}
}
