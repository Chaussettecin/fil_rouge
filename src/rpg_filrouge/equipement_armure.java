package rpg_filrouge;

public class equipement_armure {

	
private static ArrayList<equipement_armure> arrayArmures = new ArrayList<>(3);
private String nom;
private int prix;
private int restDegats; // en %
private int level;
public boolean possede;
public boolean equiper;

public equipement_armure(String nom, int prix, int restDegats, int level) {
	        this.nom = nom;
	        this.prix = prix;
	        this.restDegats = restDegats;
	        this.level = level;
	        equipement_armure.add(this);
	      }

private static void add(equipement_armure equipement_armure) {
		
}

public static equipement_armure getEquiper() {
	   for (equipement_armure i : arrayArmures) {
	        if (i.estEquiper()) return i;
	   }
	   support.error("oupss ! - Pas d'armure sur ton body");
	    return null;
 }

public static ArrayList<equipement_armure> getarmures() {
	 return arrayArmures;
}

public static int get() {
	   return arrayArmures.indexOf(getEquiper());
	}

public static void set(int i) {
	 arrayArmures.get(i).equiper= true;
}

	public static void choix() {
	    
		while (true) {
	        ui.cls();
	        ui.println("-----------------------------------------");
	        ui.println("*** Est-tu Equiper ?");
	        ui.println();
	            ui.println("Equiper: " + getEquiper().toString());
	            ui.println("-------------------------------------");
	            int j = 0;
	            int[] offset = new int[getarmures().size()];
	            
	            for (int i = 0; i < getarmures().size(); i++) {
	            	if (getarmures().get(i).esPossede()) {
	                    ui.println((j + 1) + ") " + getarmures().get(i).getNom());
	                    offset[j] = i - j;
	                    j++;
	            	}
	            }//fin for

	//valide armures index
	    while (true) {
	         int menuObjets = ui.getValidInt();
	            
	           try { 
	        	   	menuObjets--;
	           		menuObjets = menuObjets + offset[menuObjets];

	           //armures.getArmures().get(menuObjets).equiper();
	           return;
	           } catch (Exception e) {
	                ui.println();
	                ui.println((menuObjets + 1) + " Ceci n'est pas une option.");
	           	}
	    }//fin While
	   }//fin while
	 }//fin choix 

	    
	public String getNom() {
	      return this.nom;
	}

	public void setNom(String nom) {
	   if (nom.equals("")) return;
	        
	   		this.nom = nom;
	}

	public int getPrix() {
	       return this.prix;
	}

	public void setPrix(int prix) {
	       this.prix = prix;
	}

	public int getRestDegatst() {
	     return this.restDegats;
	}

	public void setRestDegats(int restDegats) {
	        this.restDegats = restDegats;
	}

	public int getLevel() {
	      return this.level;
	}

	public void setLevel(int level) {
	        this.level = level;
	 }

	public boolean esPossede() {
	        return this.possede;
	}

	public void setPossede(boolean possede) {
	        this.possede= possede;
	 }

	public boolean estEquiper() {
	        return this.equiper;
	}

//-- Permet � l'utilisateur de savoir s'il est �quiper de l'arm
	public void equiper() {
	        
		if (!(this.possede)) {
	            ui.msg("Vous ne poss�dez pas cet �quipement.");
	    return;
	    }
	     	this.equiper = true;
	        getEquiper().unequip();
	        this.equiper = true;
	        ui.msg("Tu es �quip� " + this.toString());
	}// fin equiper

	public void equipSilent() {
	        
		if (!(this.possede)) {
	    return;
	    }
	     this.equiper = true;
	       getEquiper().unequip();
	     this.equiper = true;
	}

	public void unequip() {
	     this.equiper = false;
	}

	public String toString() {
	    if (this.getNom().equals("Non")) return "Sans armure";
	    return this.getNom() + "armure";
	 }

// -- Achat de l'armure possible -	
	public boolean achat() {
		if (joueurs_xp.getLevel() < this.getLevel()) {
	            	ui.println("Tu doit �tre au moins au niveau :" + this.getLevel() + "pour acheter �a!");
	            	ui.pause();
	       return false;
	    } else if (this.esPossede()) {
	            	ui.println("Tu poss�des d�j� cette arme.");
	            	ui.pause();
	       return false;
	    } else if (this.getPrix() <= gold.get()) {
	         gold.set(-this.prix, true);
	         setPossede(true);
	         equipSilent();
	         //NPC.gratitude("Armure", "Acheter");
	            	ui.pause();
	       return true;
	   } else {
	            	ui.println("Oh oh ! la maison ne fait pas cr�dit.");
	            	ui.pause();
	       return false;
	   }
	}// fin achats

	    
public void viewApropos() {
	   final int BORDER_LENGTH = 39;

	  //Lancer les information sur l'armure
	        ui.cls();
	        for (int i = 0; i < BORDER_LENGTH; i++) ui.print("-");
	        	ui.println();
	        for (int i = 0; i < ((BORDER_LENGTH / 2) - (this.getNom().length() / 2)); i++)
	            ui.print(" ");
	        	ui.println(this.toString());
	        	ui.println("Prix : " + this.prix + "Gold");
	        	ui.println("Resistance aux d�gats (%): " + this.restDegats + "%");
	        	ui.println("Level requis : " + this.level);
	        for (int i = 0; i < BORDER_LENGTH; i++) ui.print("-");
	        	ui.pause();
	        //ui.cls();
	    }//Fin des infos de l'armure
}
