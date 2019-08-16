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




@Entity(name="inventaire")
@Table(name="inventaire")
public class Inventaire{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_inventaire;
	
	
	@ManyToOne
    @JoinColumn(name = "id_equipement",nullable=false)
	
	private Equipement equipement ;
	
	@ManyToOne
    @JoinColumn(name = "id_player",nullable=false)
	@JsonIgnore
	private Player player;

	public Inventaire(Equipement equipement, Player player) {
		super();
		this.equipement = equipement;
		this.player = player;
	}

	public Inventaire() {
		// TODO Auto-generated constructor stub
	}

	public int getId_inventaire() {
		return id_inventaire;
	}

	public void setId_inventaire(int id_inventaire) {
		this.id_inventaire = id_inventaire;
	}

	public Equipement getEquipement() {
		return equipement;
	}

	public void setEquipement(Equipement equipement) {
		this.equipement = equipement;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	
}