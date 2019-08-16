package Inventory;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

import Battle.Effect;
import Inventory.Sort;
import Inventory.ItemType;



public class Item {
	
	private Integer id;
	
	protected String nom;
	static String desc;

	private int defValeur;
	private int foodValeur;
	private int attaqueValeur;

	private String apparence;
	private Effect quaffEffect;
	
	protected static Color color;
	protected static Integer prix;
	
	private int attaqueMeleeVal;
	private int attaqueDistanceVal;
	
	private List<Sort> writtenSpells;
	 
	 
//--- Constructor --    
	public Item(Integer id,ItemType type, String nom,  
				Integer prix, Color color, String desc) {
		
		 this.id = id;
		 this.nom = nom;
		 this.desc = desc;
	     Item.color = color;
	     this.prix = prix;
	     this.attaqueDistanceVal = 1;
	     
	     this.apparence = apparence == null ? nom : apparence;
	     
	     this.writtenSpells = new ArrayList<Sort>();
	
	}


	public  String details() {
			String details = "";
		
		if (attaqueValeur != 0)
			details += "Attaque:" + attaqueValeur;

		if (attaqueDistanceVal != 1)
			details += "Lancer :" + attaqueDistanceVal;
		
		if (attaqueMeleeVal > 0)
			details += "Distance:" + attaqueMeleeVal;
		
		if (defValeur != 0)
			details += "Defence:" + defValeur;

		if (foodValeur != 0)
			details += "Aliment:" + foodValeur;
		
		return details;
	}
	
	
	public Color color() { return getColor(); }
	
	public String apparence() { return apparence; }
	

	public int valeurFood() { return foodValeur; }
	public void modifValeurFood(int amount) { foodValeur += amount; }

	
	public int valAttaque() { return attaqueValeur; }
	public void modifValAttaque(int amount) { attaqueValeur += amount; }


	public int valDefence() { return defValeur; }
	public void modifValDef(int amount) { defValeur += amount; }
		
	public int thrownAttackValue() { return attaqueDistanceVal; }
	public void modifyThrownAttackValue(int amount) { attaqueDistanceVal += amount; }

	
	public int rangedAttackValue() { return attaqueMeleeVal; }
	public void modifyRangedAttackValue(int amount) { attaqueMeleeVal += amount; }
	

	public Effect quaffEffect() { return quaffEffect; }
	public void setQuaffEffect(Effect effect) { this.quaffEffect = effect; }
	
	
	public List<Sort> writtenSpells() { return writtenSpells; }
	
	public void addWrittenSpell(String name, int manaCost, Effect effect){
		writtenSpells.add(new Sort(manaCost, name, name, effect, manaCost));
	}	
	

//--- SETTER & GETTER -- 	
	
	public Integer getID() { return id; }
	
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }
	
	public ItemType getType() { return getType(); }
  
	public Integer getPrix() { return prix; }
	public void setPrix(Integer prix) { this.prix = prix; }

	public Color getColor() { return color;}
	public void setColor(Color color) { this.color = color; }
	     

}
