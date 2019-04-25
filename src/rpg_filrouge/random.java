package rpg_filrouge;

public class random {

	public static int RInt(int max) {
	    java.util.Random ran = new java.util.Random();

	    return (ran.nextInt(max) + 1);
	}

	public static int RInt(int min, int max) {
	    java.util.Random ran = new java.util.Random();

	    return (ran.nextInt((max - min) + 1) + min);
	 }
}
}
