package com.fab.api.model;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity(name="equipement")
@Table(name="equipement")
public class Equipement{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_equipement;
	
	
	@OneToMany(mappedBy="equipement")
	@JsonIgnore
	private Set<Equipement> equipement;

		
	@Column
	private String nom;


	public Equipement(Set<Equipement> equipement, String nom) {
		super();
		this.equipement = equipement;
		this.nom = nom;
	}


	public Equipement() {
		// TODO Auto-generated constructor stub
	}


	public int getId_equipement() {
		return id_equipement;
	}


	public void setId_equipement(int id_equipement) {
		this.id_equipement = id_equipement;
	}


	public Set<Equipement> getEquipement() {
		return equipement;
	}


	public void setEquipement(Set<Equipement> equipement) {
		this.equipement = equipement;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	
}