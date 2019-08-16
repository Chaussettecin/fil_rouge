package Perso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Inventory.Item;

public class PersoAi {
	
	protected Perso perso;
	private Map<String, String> itemNames;
	
	/*public PersoAi(Perso perso){
		
		this.perso = perso;
		this.perso.setCreatureAi(this);
		this.itemNames = new HashMap<String, String>();
	}
	

	public String getName(Item item){
		
		String name = itemNames.get(item.getNom());
		return name == null ? item.appearance() : name;
	}
	
	
	public void setName(Item item, String name){
		itemNames.put(item.getNom(), name);
	}
	
	
	public void onEnter(int x, int y, int z, Tile tile){
		
		if (tile.isGround()){
			perso.x = x;
			perso.y = y;
			perso.z = z;
		
		} else {
			perso.doAction("bump into a wall");
		}
	}

	
	public void onUpdate(){ }
	
	public void onNotify(String message){ }

	public boolean canSee(int wx, int wy, int wz) {
		
		if (creature.z != wz)
			return false;
		
		if ((creature.x-wx)*(creature.x-wx) + (creature.y-wy)*(creature.y-wy) > creature.visionRadius()*creature.visionRadius())
			return false;
		
		for (Point p : new Line(creature.x, creature.y, wx, wy)){
			if (creature.realTile(p.x, p.y, wz).isGround() || p.x == wx && p.y == wy)
				continue;
			
			return false;
		}
		
		return true;
	}
	
	public void wander(){
		
		int mx = (int)(Math.random() * 3) - 1;
		int my = (int)(Math.random() * 3) - 1;
		
		 other = creature.creature(creature.x + mx, creature.y + my, creature.z);
		
		if (other != null && other.name().equals(creature.name()) 
				|| !creature.tile(creature.x+mx, creature.y+my, creature.z).isGround())
			return;
		else
			creature.moveBy(mx, my, 0);
	}

	public void onGainLevel() {
		new LevelUpController().autoLevelUp(perso);
	}

	public Tile rememberedTile(int wx, int wy, int wz) {
		return Tile.UNKNOWN;
	}

	protected boolean canThrowAt(Perso perso) {
		return perso.canSee(perso.x, perso.y, perso.z)
			&& getWeaponToThrow() != null;
	}

	protected Item getWeaponToThrow() {
		
		Item toThrow = null;
		
		for (Item item : perso.inventory().getItems()){
			if (item == null || perso.Arme== item || perso.getArmure() == item)
				continue;
			
			if (toThrow == null || item.thrownAttackValue() > toThrow.attackValue())
				toThrow = item;
		}
		
		return toThrow;
	}

	protected boolean canRangedWeaponAttack(Perso perso) {
		return perso.weapon() != null
		    && perso.weapon().rangedAttackValue() > 0
		    && perso.canSee(other.x, other.y, other.z);
	}

	protected boolean canPickup() {
		return creature.item(creature.x, creature.y, creature.z) != null
			&& !creature.inventory().isFull();
	}

	

	protected boolean canUseBetterEquipment() {
		
		int currentWeaponRating.perso.weapon() == null ? 0 : perso.weapon().attackValue() + perso.weapon().rangedAttackValue();
		int currentArmorRating = perso.armor() == null ? 0 : perso.armor().defenseValue();
		
		for (Item item : perso.inventory().getItems()){
			if (item == null)
				continue;
			
			boolean isArmor = item.attackValue() + item.rangedAttackValue() < item.defenseValue();
			
			if (item.attackValue() + item.rangedAttackValue() > currentWeaponRating
					|| isArmor && item.defenseValue() > currentArmorRating)
				return true;
		}
		
		return false;
	}

	
	protected void useBetterEquipment() {
		
		int currentWeaponRating = perso.weapon() == null ? 0 : perso.weapon().attackValue() + perso.weapon().rangedAttackValue();
		int currentArmorRating = perso.armor() == null ? 0 : perso.armor().defenseValue();
		
		for (Item item : perso.inventory().getItems()){
			
			if (item == null)
				continue;
			
			boolean isArmor = item.attackValue() + item.rangedAttackValue() < item.defenseValue();
			
			if (item.attackValue() + item.rangedAttackValue() > currentWeaponRating
					|| isArmor && item.defenseValue() > currentArmorRating) {
				perso.equip(item);
			}
		}
	}*/
}
