package com.fab.api.controller;

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

import com.fab.api.dao.PlayerDAO;
import com.fab.api.dao.UtilisateurDAO;
import com.fab.api.model.Player;
import com.fab.api.model.Utilisateur;



//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/user")   //Url d'accès au controlleur
public class UserController {
	
	@Autowired
	private UtilisateurDAO uDao;
	
	@Autowired 
	private PlayerDAO pDao; //utilisation des DAO pour les players et les utilisateurs afin d'accéder au méthodes de récupérations des données
	
	
	 @GetMapping(path="/all") //Recupère tous les utilisateurs
		public @ResponseBody Iterable<Utilisateur> getAllUsers() {
			// This returns a JSON or XML with the users
			return uDao.findAll();
			
		}
	 @GetMapping(path="/add/{login}/{nom}/{mail}/{mdp}/{manager}") //Ajout d'un utilisateur
	 public @ResponseBody String addUsers(@PathVariable("login")String login,@PathVariable("nom")String nom,@PathVariable("mail")String mail,@PathVariable("mdp")String mdp,@PathVariable("manager")boolean manager) {
		 Utilisateur u = new Utilisateur(login, nom, mail, mdp, manager);
		 try {
			 uDao.save(u);
			 return login + " enregistré!";
		 }catch(Exception e) {
			 
			 return e.getMessage();
			 
		 }
		

	 }
	 
	 
	 @GetMapping(path="/getbyid/{id_utilisateur}")
	 	public @ResponseBody Optional<Utilisateur> getUserById(@PathVariable("id_utilisateur") int id_utilisateur) {
		 return uDao.findById(id_utilisateur);
	 }
	 @GetMapping(path="/getbylogin/{login}")
	 public @ResponseBody Utilisateur getUserByLogin(@PathVariable("login") String login) {
		 return uDao.findByLogin(login);
	 }
	 @GetMapping(path="/getbymail/{mail}")
	 public @ResponseBody Utilisateur getUserByMail(@PathVariable("mail") String mail) {
		 return uDao.findByMail(mail);
	 }
	 
	 @PostMapping(path = "/del")
	 public String delMember(@RequestParam("mail") String member) {
		 Utilisateur u = uDao.findByMail(member);
		 uDao.delete(u);
		 return u.getLogin()+" a été supprimé";
	 }
	 
	 @PostMapping(path = "/changepass")
	 public String change(@RequestParam("mail") String member, @RequestParam("mdp") String mdp) {
		 Utilisateur u = uDao.findByMail(member);
		 u.setMdp(mdp);
		 uDao.save(u);
		 return u.getLogin()+", le mot de pass a été changé";
	 }
//	 @GetMapping(path="/getbymdp/{mdp}")
//	 public @ResponseBody Utilisateur getUserByMdp(@PathVariable("mail") String mdp) {
//		 return uDao.findByMdp(mdp);
//	 }
	 
	 @GetMapping(path="/test")
	 public @ResponseBody Player getTest() {
		// String reponse="OK";
		 Utilisateur u = new Utilisateur("befa","gruni","fab57fr@hoil.com","didi",false);
		 Player p = new Player(u,"daemon",100,1,0,15,15);
		 uDao.save(u);
		 pDao.save(p);
		 return p;
	 }
	 
	 @GetMapping(path="getbyplayer/{avatar}")
	 public @ResponseBody Player getUserByavatar(@PathVariable("avatar") String avatar) {
		 return pDao.findByAvatar(avatar);
	 }
	 
}
