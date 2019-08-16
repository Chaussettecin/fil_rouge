package com.fab.api.administration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fab.api.dao.PlayerDAO;
import com.fab.api.dao.UtilisateurDAO;
import com.fab.api.model.Player;
import com.fab.api.model.Utilisateur;
import com.google.common.math.Stats;
import com.google.common.math.StatsAccumulator;



@Controller
@RequestMapping("/")
public class MainController {
 
     
    		
    		//new ArrayList<Utilisateur>();
 
    @Autowired
	private UtilisateurDAO uDao;
    
    @Autowired
    private PlayerDAO pDao;
    
    private List<Utilisateur> u;
    
    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;
 
    @Value("${error.message}")
    private String errorMessage;

    @Value("${doublon.message}")
    private String errordoublon;
 
    
    
    @RequestMapping(value = { "/", "/indexi" }, method = RequestMethod.GET)
    public String index(Model model) {
 
        model.addAttribute("message", message);
 
        return "index";
    }
 
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String personList(Model model) {
    	u = (List<Utilisateur>) uDao.findAll();
        model.addAttribute("persons", u);
 
        return "personList";
    }
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String addperson(Model model) {
    	
    	Utilisateur personForm = new Utilisateur();
        model.addAttribute("personForm", personForm);
 
    	return "addPerson";
    }
 
    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
            @ModelAttribute("personForm") Utilisateur personForm,@RequestParam("conf") String mdp2) {
 
        String login = personForm.getLogin();
        String mail = personForm.getMail();
        String mdp = personForm.getMdp();
        String nom = personForm.getNom();

        
        if (mdp.equals(mdp2)) {
            Utilisateur newPerson = new Utilisateur(login,nom,mail,mdp,false);
            Player p = new Player(newPerson,"default",100,1,0,17,17);
            
            try{
            	uDao.save(newPerson);
            	pDao.save(p);
            }catch(Exception e) {
            	model.addAttribute("errorMessage", errordoublon);
            	return "addPerson";
            }
            
            return "redirect:/personList";
        }
 
        model.addAttribute("errorMessage", errorMessage);
        return "addPerson";
    }
//    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
//    public String showAddPersonPage(Model model) {
// 
//        PersonForm personForm = new PersonForm();
//        model.addAttribute("personForm", personForm);
// 
//        return "addPerson";
//    }
 
//    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
//    public String savePerson(Model model, //
//            @ModelAttribute("personForm") PersonForm personForm) {
// 
//        String firstName = personForm.getFirstName();
//        String lastName = personForm.getLastName();
// 
//        if (firstName != null && firstName.length() > 0 //
//                && lastName != null && lastName.length() > 0) {
//            Person newPerson = new Person(firstName, lastName);
//            persons.add(newPerson);
// 
//            return "redirect:/personList";
//        }
// 
//        model.addAttribute("errorMessage", errorMessage);
//        return "addPerson";
//    }
// 
}