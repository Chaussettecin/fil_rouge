package Maps;

import java.util.ArrayList;

import Mouvement.Vector2d;


/**
* Classe gestion des positions dans la maps
**/
public class MapPosition extends ArrayList<Vector2d>{
	
	private static final long serialVersionUID = 1L;
	
	public MapPosition(){}
		
	
	//Random de 2 
	
	public ArrayList<Vector2d> getCultMonde1() {
		this.clear();
		this.add(new Vector2d(43,65));
		this.add(new Vector2d(102,49));
		this.add(new Vector2d(88,28));
		this.add(new Vector2d(159,64));
		this.add(new Vector2d(118,76));
		this.add(new Vector2d(108,87));
		this.add(new Vector2d(167,96));
		this.add(new Vector2d(239,57));
		this.add(new Vector2d(223,87));
		this.add(new Vector2d(203,97));
		return this;
	
	}
	

	public ArrayList<Vector2d> getNpcMonde1() {
		
		this.clear();
		this.add(new Vector2d(110,87));
		this.add(new Vector2d(200,95));
		
		return this;
	
	}


	public Vector2d getBossMonde1() { return new Vector2d(305,74);}

	

	/*public ArrayList getEnnemiesMonde2() {
		
		this.clear();
		this.add(new Vector2d(43,65));
		this.add(new Vector2d(102,49));
		this.add(new Vector2d(88,28));
		this.add(new Vector2d(159,64));
		this.add(new Vector2d(118,76));
		this.add(new Vector2d(108,87));
		this.add(new Vector2d(167,96));
		this.add(new Vector2d(239,57));
		this.add(new Vector2d(223,87));
		this.add(new Vector2d(203,97));
	
		return this;
	}*/

	/*public Vector2d getBossMonde2() {return new Vector2d(305,74);
	}*/

	/*public ArrayList getEnnemiesMonde3() {
	
		this.clear();
		this.add(new Vector2d(43,65));
		this.add(new Vector2d(102,49));
		this.add(new Vector2d(88,28));
		this.add(new Vector2d(159,64));
		this.add(new Vector2d(118,76));
		this.add(new Vector2d(108,87));
		this.add(new Vector2d(167,96));
		this.add(new Vector2d(239,57));
		this.add(new Vector2d(223,87));
		this.add(new Vector2d(203,97));
		return this;
	}*/

	/*public Vector2d getBossMonde3() {
		return new Vector2d(305,74);
	}

	/*public ArrayList getEnnemiesMonde4() {
		
		this.clear();
		this.add(new Vector2d(43,65));
		this.add(new Vector2d(102,49));
		this.add(new Vector2d(88,28));
		this.add(new Vector2d(159,64));
		this.add(new Vector2d(118,76));
		this.add(new Vector2d(108,87));
		this.add(new Vector2d(167,96));
		this.add(new Vector2d(239,57));
		this.add(new Vector2d(223,87));
		this.add(new Vector2d(203,97));
		return this;
	}*/

	/*public Vector2d getBossMonde4() { return new Vector2d(305,74); }*/

	public static long getSerialversionuid() { return serialVersionUID; }


}
