package com.adaming.projetJsf.service;

import java.util.List;

import com.adaming.projetJsf.entity.Categorie;

public interface CategorieService {

	public List<Categorie> getAllCategories();

	public Categorie getCategorieByName(String nom);
}
