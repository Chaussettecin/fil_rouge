package rpg_filrouge;

import java.util.ArrayList;
import javax.swing.*;

public class equipement_arme {

// --- Liste d'armes --- 
public static final ArrayList<equipement_arme> arrayArmes = new ArrayList<>();
public static final String estAchetable = null;
public static equipement_arme start;    
private static equipement_arme actuelle = null;
	
public static boolean possede;
public static int prix;
public static int level;
public boolean contact;
private int degatsMini;
private int degatsMax;
private double chancePerdue;
private String nom;
private static boolean achetable;
  	  	
    
	public equipement_arme(String nom, int prix, int amuniPrix, boolean achetable,int level, 
							double chancePerdue, boolean firstInit, boolean changeDif) {

        this.nom = nom;
        this.achetable = achetable;
        this.prix = prix;
        this.level = level;
        this.chancePerdue = chancePerdue;
        this.contact = false;
        
        if (!changeDif) {
        	arrayArmes.add(this);
        }

        if (firstInit) {
            this.possede = false;
        }
	}

	public equipement_arme (String nom, boolean armesStart, boolean achetable, int prix, int level, 
    						int degatsMini, int degatsMax, boolean firstInit, boolean changeDif) {
    	
		this.nom = nom;
		this.achetable = achetable;
		this.prix = prix;
		this.level = level;
		this.degatsMini = degatsMini;
		this.degatsMax = degatsMax;
		this.contact = true;

		if (!changeDif) {
			arrayArmes.add(this);
		}

		if (firstInit) {
         
			if (armesStart) {
				this.possede = true;
				actuelle = this;
				start = this;
			} else {
				this.possede = false;
			}
		}
	} //fin equipement armes

    public static equipement_arme get() {
    	return actuelle;
    }

    static int getIndex(equipement_arme i) {
    	return arrayArmes.indexOf(i);
    }

    public static void set(equipement_arme x) {
    	actuelle = x;
    }

    public static void set(int i) {
        actuelle = arrayArmes.get(i);
    }

    public static void choix() {
    	
        while (true) {
            ui.cls();
            ui.println("---------------------------------------------");
            ui.println("    ***** Nouvelle armes ****                ");
            ui.println();
            ui.println("Munitions dispo : " + actuelle.getMunition());
            ui.println("Ton équipement est de : " + actuelle.getNom());
            ui.println("---------------------------------------------");
            int j = 0;
            int[] offset = new int[arrayArmes.size()];
            for (int i = 0; i < arrayArmes.size(); i++) {
                if (arrayArmes.get(i).possede()) {
                    ui.println((j + 1) + ") " + arrayArmes.get(i).getNom());
                    offset[j] = i - j;
                    j++;
                }
            }
            ui.println((j + 1) + ") retour");

            while (true) {
            	
                int menuObjets = ui.getValidInt();

                try {
                  //Choix des autres options
                  if (menuObjets == (j + 1) || menuObjets > j)
                     return;

                  ///retour armes
                   menuObjets--;
                   menuObjets = menuObjets + offset[menuObjets];

                 if (!arrayArmes.get(menuObjets).possede()) {
                        ui.msg("Vous ne possédez pas cette armes!");
                    return;
                 }

                 actuelle = arrayArmes.get(menuObjets);
                 ui.msg("Vous êtes équipés : " + arrayArmes.get(menuObjets).getNom());
                 return;

                } catch (Exception e) {
                    ui.println();
                    ui.println(menuObjets + " no ! no ! no !");
                }
            }
        }
    } // fin choix 

    private static void sansMunitions() {
        ui.popup("Hop hop tu n'as plus de munitions","Attention ", JOptionPane.WARNING_MESSAGE);
        	equipement_armes.actuelle = equipement_armes.start;
    }

    public static void afficheMunitions() {
        if (!(equipement_armes.get().contact)) {
            ui.println("Munitions : " + equipement_armes.get().getMunition());
        }
    }

    public String getNom() {
        return nom;
    }

    public static boolean possede() {
        return possede();
    }

    public void setMunitions(int montant, boolean add) {
        if (this.contact) return;
        if (add) {
            this.munitions += montant;
        } else {
            this.munitions = montant;
        }
    }

    public int getMunition() {
        return this.munitions;
    }
    

    public void dealDam() {
        int degatsDonner = 0;
     
        if (this.contact) {
            
        	//attaque de contact 
        	degatsDonner = random.RInt(this.degatsMini, this.degatsMax);
        } else {

        //munitions
           if (getMunition() >= this.muniUtiliser) {
               for (int i = 1; i <= this.muniUtiliser; i++) {
                   if (random.RInt(100) > this.chancePerdue) {
                	   degatsDonner += JOURNAL_DEGATS;
                       stats.bulletsThatHit++;
                    }

          //Resultat
                setMunitions(-1, true);
                stats.bulletsFired += 1;
               }

           } else {
        	   sansMunitions();
        	   degatsDonner = 0;
           }
        }

       //Affichage
       stats.totalDegats += degatsDonner;
       joueurs_xp.set(degatsDonner, true);
        if(!joueurs_ennemis.get().prendDegats(degatsDonner)) { // !KO
        	
	        ui.cls();
	        ui.println("------------------------------------------------------------------");
	        ui.println("Tu viens de poutrer " + joueurs_ennemis.get().getNom() + "!");
	        ui.println("Tu lui a fait" + degatsDonner + " de dégats à" + this.nom);
	        ui.println("------------------------------------------------------------------");
	        ui.println("Ta santé est de :" + joueurs_sante.getStr());
	        ui.println("Santé de ta victime : " + joueurs_ennemis.get().getSante());
	        ui.println("------------------------------------------------------------------");
	        ui.pause();
	
	        if (joueurs_ennemis.get().getSante() <= joueurs_ennemis.get().getSantemax() / 3){
	        	joueurs_ennemis.get().usepremierSoin();
	        }
        } 
   }

   public void aPropos() {
	   
       final int BORDER_LENGTH = 39;

       //Start info armes
        ui.cls();
        for (int i = 0; i < BORDER_LENGTH; i++) ui.print("-");
        ui.println();
        for (int i = 0; i < ((BORDER_LENGTH / 2) - (this.getNom().length() / 2)); i++)
        ui.print(" ");
        ui.println(this.getNom());
        ui.println("Prix : " + this.prix + " Golds");
        ui.println("Chance de perdre " + this.chancePerdue + "%");
        ui.println("Munitions utilisées : " + this.muniUtiliser);
        ui.println("Dégats : " + this.getDegats());
        for (int i = 0; i < BORDER_LENGTH; i++) ui.print("-");
        ui.pause();
        ui.cls();
    }//apropos

    private String getDegats() {
    	
        if (this.contact) {
            return (this.degatsMini + " - " + this.degatsMax);
        } else {
            if (this.chancePerdue == 0) {
                return String.valueOf((JOURNAL_DEGATS * this.muniUtiliser));
            } else {
                return ("0 - " + String.valueOf((JOURNAL_DEGATS * this.muniUtiliser)));
            }
        }
    }

    public boolean estAchetable() {
        return this.achetable;
    }	

	public void achat() {
        if (!estAchetable()) {
            ui.msg("Désolée ! objet non dispo");
            return;
        }
        if (possede()) {
            ui.msg("Vous possédez deja cette arme.");
            return;
        }
        if (level > joueurs_xp.getLevel()) {
            ui.msg("Vous n'avez pas le niveau pour posséder cette arme.");
            return;
        }
        if (prix > gold.get()) {
            ui.msg("La maison ne fait pas crédit.");
            return;
        }

        //achat
        joueurs_mission.achatObjets = true;
        gold.set(-prix, true);
        stats.totalGoldepenserprArmes += prix;
        this.possede = true;
        actuelle = this;
        ui.println("Tu as acheté " + this.getNom() + "pour" + this.prix + "Golds.");
        ui.println("Golds : " + gold.get());
        ui.pause();

        //donne munitions
        munitions += this.muniIncluseAchat;
    }

    //Acheter les munitons. Verifie le niveau And co 
    public void acheterMunitions() {
       ui.cls();
       if (joueurs_xp.getLevel() < this.level) {
            ui.println("Vous n'avez pas le bon niveau " + this.level + ".");
            ui.pause();
            return;
       }
       ui.println("Tu veux combien de munition petit(e) ?");
       ui.println("1 Muniton côute " + this.muniPrix + " Golds.");
       ui.println("Tu as " +gold.get() + " Golds.");
       
       int muniHA = ui.getValidInt();
       int cout = muniHA * muniPrix;

       if (gold.get() < (cout)) {
           ui.println("La maison ne fait pas crédit ! " + (cout - gold.get()) + " + de Golds.");
           ui.pause();
           return;
       }

       this.munitions += muniHA;
       gold.set(-cout, true);
       stats.totalGoldepenserprArmes += cout;
       ui.println("Vous avez acheter " + muniHA + " munitions.");
       ui.pause();
   } //fin achat munitions

  
  public int getMunitionsprix() {
        return this.muniPrix;
    }
}
