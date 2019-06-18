package Save;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import Control.InstallFeatures;

public class DataWell {
	private final Path[] filepaths;
	private final List<SaveSlot> slots;
	
	public DataWell() {
		filepaths = InstallFeatures.getSaveDataPath();
		slots = createSlots();	
	}

	private List<SaveSlot> createSlots() {
		List<SaveSlot> list = new ArrayList<SaveSlot>();
		for (Path path : filepaths) {
			list.add(new SaveSlot(path));
		}
		return list;
	}
	
	public List<SaveSlot> getSaveList() {
//	
		return this.slots;
	}
}
