
import java.util.LinkedList;

public class MonsterType {
	private final int strength; // strength increase atk
	private final int vitality; // vitality increase health and defense
	private final int agility; // agility increase chance to dodge (evasion)
	private final int intelligence; // intelligence gives magic atk power
	private final int wisdom; // wisdom gives mana
	private final int spirit; // spirit increase magic defense
	private final int luck; // luck increase combat speed
	
	private final String name;
	private final float healthPerLevel;
	private final float expPerLevel;
	
	private final LinkedList<CA> combatActions;
	
	private class CA {
		public final CombatAction action;
		public final int minLevel;
		public CA(CombatAction action, int minLevel){
			this.action = action;
			this.minLevel = minLevel;
		}
	}
	
	
	public String getName(){
		return name;
	}
	
	public MonsterType(String name, int strength, int vitality, int agility, int intelligence, int wisdom, int spirit, int luck, float healthPerLevel, float expPerLevel){
		this.name = name;
		this.strength = strength;
		this.vitality = vitality;
		this.agility = agility;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.spirit = spirit;
		this.luck = luck;
		this.setAttributeGrowth(0.5f, 0.5f, 0.1f, 0.2f, 0.2f, 0.3f, 0.05f);
		//this.setImage("data/monsters/missing.png",128,8);
		this.expPerLevel = expPerLevel;
		this.healthPerLevel = healthPerLevel;
		this.combatActions = new LinkedList<CA>();
	}
	
	public int getHealth(int level){
		return (int)(level*healthPerLevel);
	}
	
	public LinkedList<CombatAction> getCombatActions(int level){
		LinkedList<CombatAction> actions = new LinkedList<CombatAction>();
		
		for(CA ca : this.combatActions){
			if(level >= ca.minLevel)
				actions.add(ca.action);
		}
		
		return actions;
	}
	
	public void addCombatAction(CombatAction action, int minLevel){
		this.combatActions.add(new CA(action, minLevel));
	}
	
	public int getExperience(int level){
		return (int)(level*expPerLevel);
	}
	
	public int getMana(int level){
		return (int)Math.floor((wisdom+wisGrowth*level)*2.5f);
	}
	

	// Attribute growth for this monster
	private float strGrowth;
	private float vitGrowth;
	private float agiGrowth;
	private float intGrowth;
	private float wisGrowth;
	private float sprGrowth;
	private float luckGrowth;
	

	public void setAttributeGrowth(float strength, float vitality, float agility, float intelligence, float wisdom, float spirit, float luck){
		
		this.strGrowth = Math.max(0, strength);
		this.vitGrowth = Math.max(0, vitality);
		this.agiGrowth = Math.max(0, agility);
		this.intGrowth = Math.max(0, intelligence);
		this.wisGrowth = Math.max(0, wisdom);
		this.sprGrowth = Math.max(0, spirit);
		this.luckGrowth = Math.max(0, luck);
	}
	
	public int getStrength(int level){
		return (int)(this.strength + (strGrowth*level));
	}
	
	public int getVitality(int level){
		return (int)(this.vitality + (vitGrowth*level));
	}
	
	public int getAgility(int level){
		return (int)(this.agility + (agiGrowth*level));
	}
	
	public int getIntelligence(int level){
		return (int)(this.intelligence + (intGrowth*level));
	}
	
	public int getWisdom(int level){
		return (int)(this.wisdom + (wisGrowth*level));
	}
	
	public int getSpirit(int level){
		return (int)(this.spirit + (sprGrowth*level));
	}
	
	public int getLuck(int level){
		return (int)(this.luck + (luckGrowth*level));
	}

	
}
