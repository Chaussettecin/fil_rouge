package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JList;

import Save.SaveSlot;
import UI.SaveMenu;


public class DataListener implements ActionListener {
	
	private Save.SaveSlot filemenu;
	private JList savelist;
	
	public DataListener(SaveSlot sm, JList sl) {
		
		this.filemenu = sm;
		this.savelist = sl;	
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		String cmd = evt.getActionCommand();
		
		SaveSlot saveselect = (SaveSlot) this.savelist.getSelectedValue();
		
		/*if (saveselect!=null && filemenu(saveselect.isEmpty(),cmd)) {
			
			if (cmd == "Supprimer") {
				saveselect.overwrite(null);
			
			} else if (cmd == "Sauvegarde") {
				saveselect.overwrite(this.savelist.getSelectedIndex());
			
			} else if (cmd == "Load") {
				System.out.println("Ta partie est chargee\n please continue playing like if it had really worked");
			}
		}*/
		
	}

}
