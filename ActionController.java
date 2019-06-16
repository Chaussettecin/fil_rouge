package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.Game;
import Perso.Perso;
import UI.GameDisplay;


public class ActionController implements KeyListener  {
	
	private Perso PersoAction;
	
	
	public ActionController(Game game) {
		this.PersoAction = game.getPlayer();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

	//-- Verif keycode après l'event
		switch (keyCode) {
		
			case KeyEvent.VK_ESCAPE:
				System.out.print("ESC - pour sortir du jeux - System.Exit");
				System.exit(0);
				break;
		// -- Mouvement
			/*case KeyEvent.VK_UP:
				// System.out.println("pressed: HAUT");
				this.PersoAction.move(1);
				break;
		
			case KeyEvent.VK_RIGHT:
				// System.out.println("pressed: GAUCHE");
				this.PersoAction.move(2);
				break;
				
			case KeyEvent.VK_DOWN:
				// System.out.println("pressed: BAS");
				this.PersoAction.move(3);
				break;
			case KeyEvent.VK_LEFT:
				// System.out.println("pressed: DROIT");
				this.PersoAction.move(4);
				break; */
		
//-- Sorts ****** 
			case KeyEvent.VK_Q:
				System.out.println("presser : Q - Sort 1");
				break;
		
			case KeyEvent.VK_W:
				System.out.println("presser: W - Sort 2");
				break;
			case KeyEvent.VK_E:
				System.out.println("presser : E - Sort 3");
				break;
			case KeyEvent.VK_R:
				System.out.println("presser : R - Sort 4");
				break;
			case KeyEvent.VK_D:
				System.out.println("presser : D - Sort 5");
				break;
			case KeyEvent.VK_F:
				System.out.println("presser : F - Sort 6");
				break;

		//-- Manipulation des objets et inventaire -
			/*case KeyEvent.VK_X:
				//System.out.println("pressed: X - Item aufgenommen!");
				this.PersoAction.pickUpItem();
				break;
			case KeyEvent.VK_B:
				//System.out.println("pressed: B - Zeige Inventory");
				this.PersoAction.openInventory();
				break;
			default:
				System.out.println("pressée");
				break;*/
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	@Override
	public void keyReleased(KeyEvent e) {}
		

	public void addDisplay(GameDisplay boardDisplay) {	}
}
