package Enemy;


//--- Dans notre jeux 4/5 Boss
public abstract class EnemyBoss extends Enemy {

	public static int bossId;  
	

//-- Constructor -- 
	public EnemyBoss(String Nom, int ptv, int Degat) {
		super(Nom, ptv, Degat);
		
	}


//-- Permet d'identifier le boss ---
	   public void boss(String id, int bossId) {
    		EnemyBoss.bossId = bossId;
	   }
    

}
