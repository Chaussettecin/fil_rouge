package perso;


public abstract class job{


    private int xp;                       // point d'experience relatif au metier permet de monter de niveau
    private int niveau;                   // niveau relatif au metier incrmente de 1 tout les 20 pts d'xp
    protected int bonusAttaqueMetier ;    // bonus/malus (en attaque) donné au personnage lors de sa creation
    protected int bonusDefenceMetier ;    // bonus/malus (en defence) donné au personnage lors de sa creation
    protected int bonusPvMetier ;         // bonus/malus (au pv) donné au personnage lors de sa creation

    protected job (){
    	 // perso / def niv 1 avec 0xp

        xp = 0 ;
        niveau = 1 ;
        bonusAttaqueMetier = 0 ;
        bonusDefenceMetier = 0 ;
        bonusPvMetier = 0 ;
    }

  
    protected job (int xp){
    		// perso total xp = le niveau
    		// niv +1 tt les 20 pts d'xp (level up = 60xp)
        this.xp = xp;
        this.niveau = (getXp()/20)+1;
        bonusAttaqueMetier = 0 ;
        bonusDefenceMetier = 0 ;
        bonusPvMetier = 0 ;

    }

   //donne les gold
    public void gainXp (int gain){

        setXp(getXp()+gain);
        setNiveau((getXp()/20)+1);

    }

    
    //capacitié du metiers 
    public int secondSouffle(){
        return 0 ;

    }

    @Override
    // retourne une String decrivant le metier les xp et le niveau
    public String toString() {
        return (getClass().getSimpleName()+", tu as un niveau "+this.niveau+" avec "+xp+" d'XP.");
    }

    // e fonction du metier
    protected void competence (perso perso, perso enemi){
        System.out.println("Go Go ! Go ! Go...");
    }

 //-- getter
    public int getXp() {
        return xp;
    }

    public int getNiveau() {
        return niveau;
    }

    public int getBonusAttaqueMetier() {
        return bonusAttaqueMetier;
    }

    public int getBonusDefenceMetier() {
        return bonusDefenceMetier;
    }

    public int getBonusPvMetier() {
        return bonusPvMetier;
    }

// setter
    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public void setBonusAttaqueMetier(int bonusAttaqueMetier) {
        this.bonusAttaqueMetier = bonusAttaqueMetier;
    }

    public void setBonusDefenceMetier(int bonusDefenceMetier) {
        this.bonusDefenceMetier = bonusDefenceMetier;
    }

    public void setBonusPvMetier(int bonusPvMetier) {
        this.bonusPvMetier = bonusPvMetier;
    }
}
