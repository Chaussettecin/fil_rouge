package rpg_filrouge;

public class banque_pret {

	//Possibilit� aux joeux qui n'ont pas assez de golds de faire cr�dit � la boutique / BQ

	private static final double INTERET_TX = 0.15;
	private static int credit;
	private static int sommeCredit;

	public static void menu() {
		  
		while (true) {
		       
			ui.cls();
		    ui.println("-------------------------------");
		    ui.println("        *** Credits ***        ");
		    ui.println();
		    ui.println("Current interest rate: " + INTERET_TX);
	        ui.println("Cr�dit Maximum : " + getMaxLoan());
		    ui.println("Tes cr�dits en courts : " + credit);
		    ui.println("-------------------------------");
		    ui.println("Somme de tes cr�dits : " + sommeCredit);
		    ui.println("Int�r�ts : " + (sommeCredit * INTERET_TX));
	        ui.println("Somme d�e : " + getGrossDue());
	        ui.println("-------------------------------");
		    ui.println("1) Cr�dits : ");
		    ui.println("2) R�gle tes cr�dits :");
		    ui.println("3) Retour");
		            
		    switch (ui.getValidInt()) {
		         case 1:
		              newPret();
		              break;
		         case 2:
		               payerPret();
		               break;
		         case 3:
		               return;
		       }
		    }//fin while
		}// fin menu

		private static void newPret() {

		      if (hasLoan()) {
		         ui.msg("La maison ne peut pas te mettre deux cr�dits sur le dos.");
		         return;
		      }

		      ui.cls();
		      ui.println("Entres le montant que tu as besoin :");
		      ui.println("Emprunter.");
		      ui.println("Le montant maximum d'un cr�dit : " + getMaxLoan());
		      int demandes = ui.getValidInt();

		      if (demandes > getMaxLoan()) {
		         ui.msg("Le montant que tu peux emprunter : " + getMaxLoan() + "!");
		         return;
		      }
		      if (demandes <= 0) {
		         ui.msg("N'est pas peur. Donnes moi le montant de Golds dont tu as besoin ?.");
		         return;
		      }

		  //Donner pr�t
		      gold.set(demandes, true);
		      credit = demandes;
		      sommeCredit = demandes;
		      ui.cls();
		      ui.println("Tu as demand�s  " + demandes + " de la banque.");
		      ui.println("Tu ne peux pas d�poser de pi�ces � la banque tant que ton pr�t n�est pas enti�rement rembours�..");
		      ui.pause();
		}// fin new pret

		private static void payerPret() {
		        
			if (getGrossDue() == 0) {
		      ui.println("N'est pas peur. Donnes moi le montant de Golds dont tu as besoin ?.");
		      ui.pause();
		      return;
		    }

		    ui.cls();
		    ui.println("Tu nous dois" + getGrossDue() + "Gold(s), et" + gold.get() + "avec toi.");
		    ui.println("H� h� ! Les golds que tu d�poses � la banque tant que tu es un pr�t en court. Seras garder pour nosu");
		    ui.println("Combien tu voudrais nous donner?");
		    int montantCredit = ui.getValidInt();

		    ui.cls();
		    if (gold.get() < montantCredit) {
		        ui.println("hop hop ! tu n'a pas assez d'argent pour.");
		        ui.pause();
		        return;
		     }

		    if (montantCredit <= 0) {
		        ui.println("Tu dois au moins me donner 1 Gold pour emprunter, rien n'est gratuit.");
		        ui.pause();
		        return;
		    }

		    if (montantCredit > getGrossDue()) {
		        ui.println("heu " + getGrossDue() + "! Entres une somme plus petite. GOURMAND !");
		        ui.pause();
		    }
		    sommeCredit = getGrossDue() - montantCredit;
		    gold.set(-montantCredit, true);

		    ui.println("Tu dois payer " + montantCredit + " Golds.\n Maintenant tu as " + getGrossDue() + " restant.");
		    if (getGrossDue() == 0) credit = 0;
		       ui.pause();
		   	}

		    private static int getMaxLoan() {
		        return perso_xp.getLevel() * 100;
		    }

		    public static int getCredit() {
		        return credit;
		    }

		    public static void setPretenCourt() {
		        credit = sommeCredit;
		    }

		    public static boolean hasLoan() {
		        return getCredit() > 0;
		    }

		    public static int getGrossDue() {
		        return (int) (credit + (credit * INTERET_TX));
		    }

		    public static int getCreditSomme() {
		        return sommeCredit;
		    }

		    public static void setCredit(int du) {
		        credit = du;
		    }
}
