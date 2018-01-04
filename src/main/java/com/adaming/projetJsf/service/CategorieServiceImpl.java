package com.adaming.projetJsf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.projetJsf.dao.CategorieDao;
import com.adaming.projetJsf.entity.Categorie;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	CategorieDao categorieDao ;

	@Override
	public List<Categorie> getAllCategories() {
		return categorieDao.getAllCategories();
	}

	@Override
	public Categorie getCategorieByName(String nom) {
		return categorieDao.getCategorieByName(nom);
	}

}
