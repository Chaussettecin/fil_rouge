package rpg_filrouge;

import java.util.ArrayList;

public class equipement_food {
	//Liste Aliments qui permet au joueur d'avoir des boost (force / dexiterité) augmente les capacités
	
		public static final ArrayList<equipement_food> arrayFood = new ArrayList<>();
    	public static int totalAlimentsConso;
    	private String nom;
    	private String desc;
    	private int quantite = 1;
    	private static perso_statusEffect.type effetsStats;
    	private int effetsNiv;
    	private type AlimentType;
    	private boolean viewedAbout;

    
    	public equipement_food(String nom, String desc, perso_statusEffect.type effetsStats,
		  						type AlimentType, int effetsNiv) {
        
    		this.nom = nom;
    		this.desc = desc;
    		this.effetsStats = effetsStats;
    		this.AlimentType = AlimentType;
    		this.effetsNiv = effetsNiv;
    		arrayFood.add(this);
   
    	}// fin equipement aliments

    
    	public static void liste() {
    		
    		while (true) {
    			
    			ui.cls();
    			int j = 0;
    			int[] offset = new int[arrayFood.size()];
            
    			for (int i = 0; i < arrayFood.size(); i++) {
    				
    				if (arrayFood.get(i).quantite > 0) {
    					ui.println((j + 1) + ") " + arrayFood.get(i).getNom() + "(" + arrayFood.get(i).quantite + ")");
    					offset[j] = i - j;
    					j++;
    				}//fin IF
    			}//fin for
            
    			ui.println((j + 1) + ") Retour");
    			
    			while (true) {//retourner sur le menu des équipements "menuObjets"
   			
    				int menuObjets = ui.getValidInt();

    				try { //Autres choix dispo dans le tab
                  
    					if (menuObjets == (j + 1) ||menuObjets > j)
    						return;

    					//Retour dans le menu objets / armes
    					menuObjets--;
    					menuObjets = menuObjets + offset[menuObjets];
                    
                 //--- un effet de 1 sur le status est selectionne utiliser Switch pour voir si ok -
    					if (arrayFood.get(menuObjets).geteffetsStat() ==perso_statusEffect.type.SANTE && perso_sante.get() == perso_sante.getOutOf()) {
    						ui.msg("Tu es beau comme un sous neuf. Tu ne peux pas utiliser cet objet!");
    						return;
    					}

                 //--- Resultats - 
    					if (arrayFood.get(menuObjets).quantite > 0) {
    						equipement_food.arrayFood.get(menuObjets).manger();
    					}
    					return;

                	} catch (Exception e) {
                		ui.println();
                		ui.println(menuObjets + " Oupss ceci n'est pas une option !");
                	}
            	} // fin while 2
      		} //fin while
    }//fin liste

//--- Getter --    
    public String getNom() {
        return this.nom;
    }


    public int getEffetsNiv() {
        return effetsNiv;
    }


    public perso_statusEffect.type geteffetsStat() {
       return effetsStats;
    }

    
    public int getQuantite() {
        return quantite;
    }

    
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    
 //--- Consommation de l'event -
    public void manger() {
      
    	ui.cls();
    	ui.println("Tu as avalé(e) : " + getNom());
    	ui.println("Tu as gagné(e) " + effetsNiv + " " + effetsStats.toString() + " points.");
      	this.quantite--;
      	totalAlimentsConso++;
      	ui.pause();

      	switch (this.effetsStats) {
            case SANTE:
                perso_sante.gains(this.effetsNiv);
                break;
            case TAILLE:
                break;
            case CHANCE:
                break;
        }//switch

   }//fin classe manger

    public void viewPropos() {
    	
    	final int BORDER_LENGTH = 39;

    	//fin des informations sur les aliments
        ui.cls();
        
        for (int i = 0; i < BORDER_LENGTH; i++) ui.print("-");
        ui.print(" ");
        
        for (int i = 0; i < ((BORDER_LENGTH / 2) - (this.getNom().length() / 2)); i++)
        ui.print(" ");
        ui.println(this.getNom());
        ui.println(this.desc);
        ui.println("Catégories : " + this.AlimentType.toString());
        ui.println("Donnes les effets : " + equipement_food.effetsStats.toString());
        ui.println("Level: " + this.getEffetsNiv());
        
        for (int i = 0; i < BORDER_LENGTH; i++) ui.print("-");
        ui.pause();
        ui.cls();
       
        this.setViewed(true);
  	}//fin vue a propos

 
    public boolean affichagePropos() {
        return this.viewedAbout;
    }

    public void setViewed(boolean v) {
        this.viewedAbout = v;
    }
   
    public enum type {
        VIANDE_POISSONS,
        VIANDE_HUMAINE,
        FRUIT_MAGIQUE,
        AUTRES;
        
	  @Override
      public String toString() {
            String effectString = super.toString();
            effectString = effectString.replace("_", " ");
            effectString = effectString.replace("Viande séchée", "");
            effectString = effectString.trim();
            return effectString.substring(0, 1) + effectString.substring(1).toLowerCase();
      }
    }//fin enum aliments
}
