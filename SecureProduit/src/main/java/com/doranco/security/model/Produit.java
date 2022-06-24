package com.doranco.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String type;
	@Column(nullable = false)
	private String titre;
	@Column(nullable = false)
	@Size(max=500)
	private String description;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Produit() {
		super();
	}
	public Produit( String type, String titre, @Size(max = 500) String description) {
		super();
		
		this.type = type;
		this.titre = titre;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Produit [id=" + id + ", type=" + type + ", titre=" + titre + ", description=" + description + "]";
	}
	
	
	
}
