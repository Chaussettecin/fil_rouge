package com.fab.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fab.api.model.People;
import com.fab.api.model.Player;
import com.fab.api.model.Utilisateur;


public interface PeopleDAO extends JpaRepository<People, Integer>{

	
	

}
