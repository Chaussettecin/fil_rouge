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




@Entity(name="people")
@Table(name="people")
public class People{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_people;
	
	
	@OneToMany(mappedBy="people")
	@JsonIgnore
	private Set<People> people;
	
		
	@Column
	private String nom;


	public People(Set<People> people, String nom) {
		super();
		this.people = people;
		this.nom = nom;
	}


	public People() {
		// TODO Auto-generated constructor stub
	}


	public int getId_people() {
		return id_people;
	}


	public void setId_people(int id_people) {
		this.id_people = id_people;
	}


	public Set<People> getPeople() {
		return people;
	}


	public void setPeople(Set<People> people) {
		this.people = people;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	
	
}
