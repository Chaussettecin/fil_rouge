package TerminalOverflow;


/* 
 * Classe Vector2d : Gestion des directions -
 */
public class Vector2d {

	public int dx;
	public int dy;
	
	public Vector2d(){
		this.dx=this.dy=0;
	}
	
	public Vector2d(int x, int y){
		this.dx=x;
		this.dy=y;
	}
	
	public boolean Compare(Vector2d v2) {
		
		if (this.dx==v2.dx && this.dy==v2.dy) {
			return true;
		}
		
		return false;
	}

}
