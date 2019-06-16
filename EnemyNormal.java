package Enemy;



// --- Cultiste --- 
public abstract class EnemyNormal extends Enemy {
	
	public boolean Boss = false; // Ce nest pas un BOSS

	
//-- Constructor -- 
	public EnemyNormal(String Nom, int ptv, int Degat) {
		super(Nom, ptv, Degat);
		
	
		// -- Verifie si c'est un boss ou un simple cultiste -     
	        if (Boss) Nom = "[boss] " + Nom;
	}


}
