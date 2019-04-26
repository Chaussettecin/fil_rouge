package rpg_filrouge;

public class combat_degats {

	private int bloquer, nonBloquer;

	combat_degats (int tempBloque, int tempNonBloque) {
			
		bloquer = (tempBloque > 0 ? tempBloque : 0);
		nonBloquer = (tempNonBloque > 0 ? tempNonBloque : 0);
	
	}
	
	int getBloquer() {
		return bloquer;
	}
	
	int getnonBloquer() {
		return nonBloquer;
	}
	
	public String toString() {
		return Integer.toString(bloquer + nonBloquer);
	}
}
