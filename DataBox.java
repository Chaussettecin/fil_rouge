package Save;

import java.util.List;

import UI.Enquirer;
import UI.Observer;

public class DataBox implements Enquirer {
	
//-- Slot de sauvegarde
	private List<SaveSlot> fileslots;
	private Observer observer;
	
	public DataBox() {
		this.fileslots = new DataWell().getSaveList();
	}
	
	public void saveRequest() {
		this.fileslots = new DataWell().getSaveList();
		this.observer.update();
	}
	
	@Override
	public void addObserver(Observer o) {
		this.observer = o;
	}	

	public SaveSlot[] getSlots() {
		return fileslots.toArray(new SaveSlot[this.fileslots.size()]);
	}
}
