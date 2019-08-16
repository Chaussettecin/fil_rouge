package com.fab.api.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="utilisateur")
@Table(name="utilisateur",uniqueConstraints={@UniqueConstraint(columnNames={"login"})})
public class Utilisateur {
	 
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_utilisateur;
	
	
	@Column
	private String login;
	
	@Column
	private String nom;
	
	@Column
	private String mail;
	
	@Column
//	@JsonIgnore
	private String mdp;
	
	@Column
	private boolean manager;
	
	@OneToMany(mappedBy="utilisateur")
	private Set<Player> player;
	
	
	public Utilisateur(String login, String nom, String mail, String mdp,boolean manager) {
		super();
		
		this.login = login;
		this.nom = nom;
		this.mail = mail;
		this.mdp = mdp;
		this.manager=manager;
	}

	public Utilisateur() {
		super();
	}

	public int getId_utilisateur() {
		return id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
		
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}
	

}
