package com.fab.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fab.api.model.Player;
import com.fab.api.model.Utilisateur;


public interface PlayerDAO extends JpaRepository<Player, Integer>{

	Player findByutilisateur(int utilisateur);
	
	Player findByAvatar(String avatar);
	Player findByAvatarAndUtilisateur(String avatar, Utilisateur utilisateur);
	
	

}
