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
import com.fab.api.dao.MetpeopleDAO;
import com.fab.api.dao.PeopleDAO;
import com.fab.api.dao.PlayerDAO;
import com.fab.api.dao.UtilisateurDAO;
import com.fab.api.model.Equipement;
import com.fab.api.model.Inventaire;
import com.fab.api.model.Metpeople;
import com.fab.api.model.People;
import com.fab.api.model.Player;
import com.fab.api.model.Utilisateur;



//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/rencontre")   //Url d'accès au controlleur
public class MetpeopleController {
	
	@Autowired
	private UtilisateurDAO uDao;
	
	@Autowired
	private MetpeopleDAO mDao;
	
	@Autowired
	private PeopleDAO ppDao;
	
	@Autowired 
	private PlayerDAO pDao; //utilisation des DAO pour les players et les utilisateurs afin d'accéder au méthodes de récupérations des données
	
	
	 @GetMapping(path="/all") 
		public @ResponseBody Iterable<People> getEquipement() {
			// Retourne un JSON
				 
		 return ppDao.findAll();
			
		}

	 @GetMapping(path="/getbyloginandavatar/{login}/{avatar}") 
	 public @ResponseBody Iterable<Metpeople> getbyLandA(@PathVariable String login,@PathVariable String avatar) {
		 
		
		 		 
		 return mDao.findAllByPlayer(pDao.findByAvatarAndUtilisateur(
	 avatar, uDao.findByLogin(login)));
	 } 
	 
	
	 
//	 @GetMapping(path="/getbyloginandavatar/{login}/{avatar}") 
//	 public @ResponseBody Iterable<Equipement> getbyLandA(@PathVariable String login,@PathVariable String avatar) {
//		 
//		 List<Inventaire> list = (ArrayList<Inventaire>) iDao.findAllByPlayer(pDao.findByAvatarAndUtilisateur(
//				 avatar, uDao.findByLogin(login)));
//		 
//		 for(int i=0;i<list.size();i++) {
//			 System.out.println(list.get(i).getEquipement().getNom());
//		 }
//		 
//		 return list;
//		 
//	 }
	 

	 
}
