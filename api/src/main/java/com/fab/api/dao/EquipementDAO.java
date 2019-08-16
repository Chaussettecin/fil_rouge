package com.fab.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.fab.api.model.Equipement;
import com.fab.api.model.Inventaire;
import com.fab.api.model.Player;
import com.fab.api.model.Utilisateur;


public interface EquipementDAO extends JpaRepository<Equipement, Integer>{




}
