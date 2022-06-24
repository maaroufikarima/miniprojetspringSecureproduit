package com.doranco.security.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doranco.security.model.Produit;
import com.doranco.security.service.ProduitService;


@RestController
public class ProduitController {
@Autowired
ProduitService produitService;
@GetMapping("/produit")
public List<Produit> getAll()
{
	return produitService.getProduits();
}
@PostMapping("/produit")
public Produit addOne(@RequestBody @Valid Produit produit)
{
return produitService.addProduit(produit);	

}
@GetMapping("")
public String welcomePage()
{
return "<h2>Bienvenu</h2><a href='/produit'>Voir les produits cosmétiques</a>";	
}




}
