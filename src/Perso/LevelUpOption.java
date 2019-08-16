package Perso;

public abstract class LevelUpOption {
	
	
	protected String name;
	
	public String name() { return name; }

	
	public LevelUpOption(String name){ this.name = name; }
	
	
	public abstract void invoke(Perso perso);


}
