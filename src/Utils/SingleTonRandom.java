package Utils;

import java.util.Random;

public class SingleTonRandom extends Random{
	
	private static SingleTonRandom Instance;
	
	public static SingleTonRandom getInstance() {
		
		if (Instance == null) 
			Instance = new SingleTonRandom();
		return Instance;
		
	}

}
