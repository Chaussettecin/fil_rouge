package Utils;

import java.util.Random;

/**
 * Méthode Random
 */
public class SingleTonRandom extends Random{
	
	private static final long serialVersionUID = 1L;
	
	private static SingleTonRandom Instance;
	
	public static SingleTonRandom getInstance() {
		
		if (Instance == null) 
			Instance = new SingleTonRandom();
		return Instance;
		
	}

	public static int getRandom(int rand) {
		return rand;
	}

}
