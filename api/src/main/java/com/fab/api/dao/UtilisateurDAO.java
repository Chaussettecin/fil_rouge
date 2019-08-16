package com.fab.api.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.fab.api.model.Utilisateur;

public interface UtilisateurDAO extends CrudRepository<Utilisateur, Integer>{

	Utilisateur findByLogin(String login);

	Utilisateur findByMail(String mail);

	Utilisateur findByMdp(String mdp);
	
}
