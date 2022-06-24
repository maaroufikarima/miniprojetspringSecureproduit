package com.doranco.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doranco.security.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}
