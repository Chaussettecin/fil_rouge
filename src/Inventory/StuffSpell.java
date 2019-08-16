package Inventory;

import java.awt.Color;

import Battle.Effect;
import Inventory.Item;
import Inventory.ItemType;
import Perso.Perso;
import asciiPanel.AsciiPanel;

public class StuffSpell {

	public Item newWhiteMagesSpellbook(int depth) {
		
		Item item = new Item(1,ItemType.SORT, "Sort Blanc",10,  AsciiPanel.brightWhite, "Magie blanche et sort Blanc");
		
		item.addWrittenSpell("Soin Mineur", 4, new Effect(1){
			
			public void start(Perso perso){
				if (perso.ptv() == perso.maxPtv())
					return;
				
				perso.modifPtv(20, "Killed by a minor heal spell?");
				perso.doAction("look healthier");
			}
		
		});
		
		item.addWrittenSpell("Soin important", 8, new Effect(1){
			
			public void start(Perso perso){
				if (perso.ptv() == perso.maxPtv())
					return;
				
				perso.modifPtv(50, "Killed by a major heal spell?");
				perso.doAction("look healthier");
			}
		});
		
		item.addWrittenSpell("Soin lent", 12, new Effect(50){
			
			public void update(Perso perso){
				super.update(perso);
				perso.modifPtv(2, "Killed by a slow heal spell?");
			}
		});

		item.addWrittenSpell("Force intérieure", 16, new Effect(50){
			public void start(Perso perso){
				perso.modifAttaque(2);
				perso.modifDefValeur(2);
				perso.doAction("seem to glow with inner strength");
			}
			
			public void update(Perso perso){
				super.update(perso);
				if (Math.random() < 0.25)
					perso.modifPtv(1, "Killed by inner strength spell?");
			}
			
			public void end(Perso perso){
				
				perso.modifAttaque(-2);
				perso.modifDefValeur(-2);

				perso.modifyRegenHpPer1000(-10);
				perso.modifyRegenManaPer1000(10);
			}
		
		});
		
		//world.addAtEmptyLocation(item, depth);
		return item;
	}
	
	public 	Item newMagieBleuSort() {
			
		Item item = new Item(2, ItemType.SORT, "Magie bleue", 30, AsciiPanel.brightBlue, "Magie bleue du Mana");

			
		item.addWrittenSpell("la force du mana", 1, new Effect(1){
			
			public void start(Perso perso){
				int amount = Math.min(perso.ptv() - 1,  - perso.mana());
				perso.modifPtv(-amount, "Tuer par le sort la force du mana.");
				perso.modifMana(amount);
			}
		
		});
		
		//world.addAtEmptyLocation(item, depth);
		return item;
	
	}
	

	public Item randomSpellBook(int depth){
		
		switch ((int)(Math.random() * 2)){
		
			case 0: return newWhiteMagesSpellbook(depth);
			default: return newBlueMagesSpellbook(depth);
		}
	
	} 
	
}
