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




@Entity(name="metpeople")
@Table(name="metpeople")
public class Metpeople{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_metpeople;
	
	
	@ManyToOne
    @JoinColumn(name = "id_people",nullable=false)
	private People people ;
	
	@ManyToOne
    @JoinColumn(name = "id_player",nullable=false)
	@JsonIgnore
	private Player player;

	public Metpeople(People people, Player player) {
		super();
		this.people = people;
		this.player = player;
	}

	public Metpeople() {
		// TODO Auto-generated constructor stub
	}

	public int getId_metpeople() {
		return id_metpeople;
	}

	public void setId_metpeople(int id_metpeople) {
		this.id_metpeople = id_metpeople;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer2(Player player2) {
		this.player = player;
	}

	
	
}