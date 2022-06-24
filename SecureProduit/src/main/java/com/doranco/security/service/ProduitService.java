package com.doranco.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doranco.security.dao.ProduitRepository;

import com.doranco.security.model.Produit;


@Service
public class ProduitService {
	@Autowired
ProduitRepository produitRepository;
	
	public Produit addProduit(Produit produit)
	{
		return produitRepository.save(produit);
		
	}
	public List<Produit> getProduits()
	{
		return produitRepository.findAll();
	}
	

}
