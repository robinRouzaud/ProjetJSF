package com.adaming.projetJsf.dao;

import java.util.List;

import com.adaming.projetJsf.entity.Categorie;

public interface CategorieDao {

	public List<Categorie> getAllCategories();
	public Categorie getCategorieByName(String nom);
	
}
