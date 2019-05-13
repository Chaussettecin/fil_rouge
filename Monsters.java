

public class Monsters {

	public static final MonsterType Orc = new MonsterType("Orc", 5, 1, 1, 1, 1, 1, 1, 6.66667f, 1.66667f);
	public static final MonsterType Humain = new MonsterType("Humain", 10, 13, 2, 3, 4, 9, 4, 11.11111f, 5.5555f);
	public static final MonsterType ElfeNight = new MonsterType("Elfe de la nuit", 20, 12, 9, 6, 5, 14, 8, 33.333333f, 23.8095f);
	public static final MonsterType Nain = new MonsterType("Nain", 20, 12, 9, 6, 5, 14, 8, 33.333333f, 23.8095f);
	
	
	protected final static void initiate(){ 
	
// -- Orc -- 
		Orc.addCombatAction(ZombieLord.BITE,1);
		
// -- Humain -- 
		Humain.addCombatAction(ZombieLord.BITE,1);
		Humain.addCombatAction(ZombieLord.PUNCH,1);
		Humain.addCombatAction(ZombieLord.TWINFIST,7);
		Humain.addCombatAction(ZombieLord.REGROWTH,9);

// -- ElfeN  --
		ElfeNight.addCombatAction(ZombieLord.BITE,1);
		ElfeNight.addCombatAction(ZombieLord.ROULETTE_STING,13);
		ElfeNight.addCombatAction(ZombieLord.GRAND_CLAW,5);
		ElfeNight.addCombatAction(ZombieLord.MAGIC_ARROW,9);

// -- Nain --
		Nain.addCombatAction(ZombieLord.BITE,1);
		Nain.addCombatAction(ZombieLord.ROULETTE_STING,13);
		Nain.addCombatAction(ZombieLord.GRAND_CLAW,5);
		Nain.addCombatAction(ZombieLord.MAGIC_ARROW,9);
	}
	
	
}
