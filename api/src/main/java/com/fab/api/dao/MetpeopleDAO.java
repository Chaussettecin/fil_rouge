package com.fab.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fab.api.model.Inventaire;
import com.fab.api.model.Metpeople;
import com.fab.api.model.Player;
import com.fab.api.model.Utilisateur;


public interface MetpeopleDAO extends JpaRepository<Metpeople, Integer>{

	Iterable<Metpeople> findAllByPlayer(Player player);


	

}
