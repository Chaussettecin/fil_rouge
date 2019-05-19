package Degat;

public class degat {

	private int bloquer, nonBloquer;

		public degat(int tempBloque, int tempNonBloque) {
			bloquer = (tempBloque > 0 ? tempBloque : 0);
			nonBloquer = (tempNonBloque > 0 ? tempNonBloque : 0);
	}
	
	public int getBloquer() {
		return bloquer;
	}
	
	public int getnonBloquer() {
		return nonBloquer;
	}
	
	public String toString() {
		return Integer.toString(bloquer + nonBloquer);
	}

}
