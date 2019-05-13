
import java.util.LinkedList;


public class MonsterArea {

	public final int minx, maxx;
	public final int miny, maxy;
	
	private LinkedList<MonsterSetup> monsterSetups;
	private LinkedList<Float> setupWeights;
	
	public final float encounterChance;
	
	public MonsterArea(int minx, int maxx, int miny, int maxy, float encounterChance){
		this.minx = minx;
		this.miny = miny;
		this.maxx = maxx;
		this.maxy = maxy;
		this.monsterSetups = new LinkedList<MonsterSetup>();
		this.setupWeights = new LinkedList<Float>();
		this.encounterChance = encounterChance;
	}
	
	public void addMonsterSetup(MonsterSetup setup, float setupWeight){
		monsterSetups.add(setup);
		setupWeights.add(setupWeight);
	}
	
	public boolean isInside(int posx, int posy){
		return (posx >= minx && posx <= maxx && posy >= miny && posy <= maxy);
	}
	
	public MonsterSetup getRandomSetup(){
		return monsterSetups.get((int) Math.random()*monsterSetups.size());
	}
}
