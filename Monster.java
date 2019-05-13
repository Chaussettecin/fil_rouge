
import java.util.Collections;
import java.util.LinkedList;


public class Monster extends Combatant{


	public String textureName;
	public MonsterType monsterType;

	public static final float ALPHA_START = 1f;
	public float fadeSpeed = 0.5f;
	public float alpha = ALPHA_START;

	
	private LinkedList<Float> combatActionWeights;
	
	public Monster(MonsterType monsterType, int level){
		super(monsterType.getName(), monsterType.getHealth(level), monsterType.getHealth(level),
				monsterType.getMana(level), monsterType.getMana(level), monsterType.getExperience(level), level,
				monsterType.getStrength(level), monsterType.getVitality(level), monsterType.getAgility(level),
				monsterType.getIntelligence(level), monsterType.getWisdom(level), monsterType.getSpirit(level),
				monsterType.getLuck(level));
	
		this.monsterType = monsterType;
		this.combatActionWeights = new LinkedList<Float>();
		for(CombatAction action : monsterType.getCombatActions(level)){
			super.addCombatAction(action);
		}
	}
	
	public CurrentAction getMonsterAction(Party party, Combat combat){
		// Uses all the information available to make a decission for the monster.
		//TODO: use info, write function
		
		LinkedList<CombatAction> viableActions = (LinkedList<CombatAction>) this.getCombatActions().clone();
		
		CombatAction chosenAction = null;
		CombatAction mediocreChoice = null;
		Combatant mediocreTarget = null;
		Combatant chosenTarget = null;
		
		boolean wantHealing = false;
		boolean singleEnemy = false;
		
		if(this.health < this.getHealthMax()/2){
			//-- Moin de 50 % de santé... Possibilité de se soigner
			wantHealing = true;
			System.out.println("heal me!");
		}
		
		if(combat.getLivePlayers().size() == 1){
			singleEnemy = true;
			
		}
		
		Collections.shuffle(viableActions);
		
		if(wantHealing){
			// Cherche pour une action de heal - 
			
			for(int i = 0; i < viableActions.size(); i++){
				if(chosenAction != null) 
					break;
				CombatAction current = viableActions.get(i);
				if((!current.combatEffect.isDamaging()) && current.mpCost <= this.mana){ 
				//-- Check si les autres menbres de l'equipe
					
					switch(current.targetType){ // switch case 
						case Targeting.TARGET_ALLY_ALL:
						case Targeting.TARGET_ALLY_SINGLE:
						case Targeting.TARGET_SELF:
							//--- "perfect one"  -
							chosenAction = current;
							chosenTarget = this;
							break;
						case Targeting.TARGET_ALL:
						case Targeting.TARGET_RANDOM:
							
						    if(combat.getLiveMonsters().size() == 1 && this.health < this.getHealthMax()/4f){// last enemy and with critical health = critical measures
								// TODO: decide if monsters should be suicidal.
								// if they are, it makes the game harder.. as monster could suicide to trigger a game over..
								mediocreChoice = current;
								mediocreTarget = this;
							}
							break;
						default:
						//-- Ne peut pas être utiliser
					}
				}
			}
		}
			while(chosenAction == null){ // didnt want healing, so loop untill we find something else..
				for(int i = 0; i < viableActions.size(); i++){
					if(chosenAction != null) // dont keep looking if we already found a good one
						break;
					CombatAction current = viableActions.get(i);
					if(current.combatEffect.isDamaging() && current.mpCost <= this.mana){ // we want to deal damage
						// Check if it can be used on me and my allies :>
						
						switch(current.targetType){ // switch case from hell
							case Targeting.TARGET_ENEMY_ALL:
								// Good, unless theres only a single enemy..?
								if(!singleEnemy || (Math.random()*100f) >= 70  ){ // 30% chance to use against single enemy
									chosenAction = current;
									chosenTarget = combat.getLivePlayers().getFirst();
								}
								break;
							case Targeting.TARGET_ENEMY_RANDOM:
							case Targeting.TARGET_ENEMY_SINGLE:
								//--
								int numPlayers = combat.getLivePlayers().size();
								int chosenPlayer = (int)Math.floor((Math.random()*numPlayers));
								chosenAction = current;
								chosenTarget = combat.getLivePlayers().get(chosenPlayer);
								break;
							case Targeting.TARGET_ALL_OTHERS:
							case Targeting.TARGET_RANDOM:
							    if(combat.getLiveMonsters().size() == 1 || this.health < getHealthMax()/4f){// last enemy and with critical health = critical measures
									mediocreChoice = current;
									mediocreTarget = this;
								}
								break;
							case Targeting.TARGET_ALL:
							    if(Math.random()*100 > 80 || (combat.getLiveMonsters().size() == 1 && this.health > getHealthMax()/3f)){
									mediocreChoice = current;
									mediocreTarget = this;
								}
								break;
							default:
								//Not good
						}
					}
				}
			}
		
		
		if(chosenAction == null){
			chosenAction = mediocreChoice;
			chosenTarget = mediocreTarget;
		}
		if(chosenAction == null){
			System.err.println("Cette action n'est pas possible "+this.getName()+" lvl"+this.level);
			return new CurrentAction(null, this, null);
		}
		
		LinkedList<Combatant> target = new LinkedList<Combatant>();
		target.add(chosenTarget);
		
		Targeting t = new Targeting(chosenAction.targetType, target, this, true);
		
		return new CurrentAction(chosenAction, this, t);
	}
	
	public int getBaseDelay(){
		return 200/level;
	}

}
