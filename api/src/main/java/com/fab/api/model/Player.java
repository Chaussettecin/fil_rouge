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




@Entity(name="player")
@Table(name="player")
public class Player{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_player;
	
	
	@ManyToOne
    @JoinColumn(name = "id_utilisateur",nullable=false)
//	@JsonIgnore
	private Utilisateur utilisateur;
	
	@OneToMany(mappedBy="player")
	private Set<Player> player;
	
	
	@Column
	private String avatar;
	
	@Column
	private int pt_vie;
	
	@Column
	private int level;
	
	@Column
	private int xp;
	
	@Column
	private int xpos;
	
	@Column
	private int ypos;

	public Player( Utilisateur utilisateur, String avatar, int pt_vie, int level, int xp, int xpos,
			int ypos) {
		super();
		this.utilisateur = utilisateur;
		this.avatar = avatar;
		this.pt_vie = pt_vie;
		this.level = level;
		this.xp = xp;
		this.xpos = xpos;
		this.ypos = ypos;
	}

	
	public Player() {
		super();
	}


	public int getId_player() {
		return id_player;
	}

	public void setId_player(int id_player) {
		this.id_player = id_player;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getPt_vie() {
		return pt_vie;
	}

	public void setPt_vie(int pt_vie) {
		this.pt_vie = pt_vie;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	

	
	
}