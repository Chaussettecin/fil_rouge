package Inventory;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

import Battle.Sort;
import Battle.Effect;
import Inventory.ItemType;



public class Item {
	
	protected static Integer id;
	protected static String nom;
	protected static Integer prix;
	
	protected Color color;
	private int foodValue;
	private int attackValue;
	private int defenseValue;
	private String appearance;
	private Effect quaffEffect;
	 
	private int attaqueDistanceVal;
	private int attaqueMeleeVal;
	private List<Sort> writtenSpells;
	 
	 
//--- Constructor --    
	public Item(Integer id,ItemType armeDistance, String nom, 
				Integer prix, String nivDexterite) {
		
		 Item.id = id;
		 nom = nom;
	     this.color = color;
	     Item.prix = prix;
	     nivDexterite =nivDexterite;
	     this.attaqueDistanceVal = 1;
	     this.appearance = appearance == null ? nivDexterite : appearance;
	     this.writtenSpells = new ArrayList<Sort>();
	}


	public  String details() {
			String details = "";
		
		if (attackValue != 0)
			details += "Attaque:" + attackValue;

		if (attaqueDistanceVal != 1)
			details += "Lancer :" + attaqueDistanceVal;
		
		if (attaqueMeleeVal > 0)
			details += "Distance:" + attaqueMeleeVal;
		
		if (defenseValue != 0)
			details += "Defence:" + defenseValue;

		if (foodValue != 0)
			details += "Aliment:" + foodValue;
		
		return details;
	}
	
	
	public Color color() { return color; }
	
	public String appearance() { return appearance; }
	

	public int foodValue() { return foodValue; }
	public void modifyFoodValue(int amount) { foodValue += amount; }

	
	public int attackValue() { return attackValue; }
	public void modifyAttackValue(int amount) { attackValue += amount; }


	public int defenseValue() { return defenseValue; }
	public void modifyDefenseValue(int amount) { defenseValue += amount; }
		
	public int thrownAttackValue() { return attaqueDistanceVal; }
	public void modifyThrownAttackValue(int amount) { attaqueDistanceVal += amount; }

	
	public int rangedAttackValue() { return attaqueMeleeVal; }
	public void modifyRangedAttackValue(int amount) { attaqueMeleeVal += amount; }
	

	public Effect quaffEffect() { return quaffEffect; }
	public void setQuaffEffect(Effect effect) { this.quaffEffect = effect; }
	
	
	public List<Sort> writtenSpells() { return writtenSpells; }
	
	public void addWrittenSpell(String name, int manaCost, Effect effect){
		writtenSpells.add(new Sort(manaCost, name, manaCost, name, effect, manaCost));
	}	
	

//--- SETTER & GETTER Nom	
	public String getNom() { return nom; }

	public void setNom(String nom) { this.nom = nom; }
  

//--- SETTER & GETTER Prix
	public Integer getPrix() { return prix; }

	public void setPrix(Integer prix) { this.prix = prix; }

	
	public ItemType getType() { return getType(); }

	public Integer getID() { return id; }
	     

}
