package fantasy_RPG;

public class Degats {
	
	private int bloquer, nonBloquer;

	Degats(int tempBloque, int tempNonBloque) {
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
