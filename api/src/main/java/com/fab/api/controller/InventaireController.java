package com.fab.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fab.api.dao.EquipementDAO;
import com.fab.api.dao.InventaireDAO;
import com.fab.api.dao.PlayerDAO;
import com.fab.api.dao.UtilisateurDAO;
import com.fab.api.model.Equipement;
import com.fab.api.model.Inventaire;
import com.fab.api.model.Player;
import com.fab.api.model.Utilisateur;



//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/inventaire")   //Url d'accès au controlleur
public class InventaireController {
	
	@Autowired
	private UtilisateurDAO uDao;
	
	@Autowired
	private InventaireDAO iDao;
	
	@Autowired
	private EquipementDAO eDao;
	
	@Autowired 
	private PlayerDAO pDao; //utilisation des DAO pour les players et les utilisateurs afin d'accéder au méthodes de récupérations des données
	
	
	 @GetMapping(path="/all") 
		public @ResponseBody Iterable<Equipement> getEquipement() {
			// Retourne un JSON
				 
		 return eDao.findAll();
			
		}

	 @GetMapping(path="/getbyloginandavatar/{login}/{avatar}") 
	 public @ResponseBody Iterable<Inventaire> getbyLandA(@PathVariable String login,@PathVariable String avatar) {
		 
		
		 		 
		 return iDao.findAllByPlayer(pDao.findByAvatarAndUtilisateur(
	 avatar, uDao.findByLogin(login)));
	 } 
	 
	


	 
}
