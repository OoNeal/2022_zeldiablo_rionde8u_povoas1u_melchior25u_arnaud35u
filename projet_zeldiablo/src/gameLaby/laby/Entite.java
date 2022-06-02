package gameLaby.laby;

/**
 * classe representant une entite
 */
public class Entite extends Position{

    /**
     * attribut representant la vie de l'entite
     */
    private int vie;

    /**
     * attribut representant les degats de l'entite
     */
    private int attaque;

    /**
     * creer une entite
     * @param x position de l'entite
     * @param y position de l'entite
     * @param v vie de l'entite
     * @param atq degats de l'entite
     */
    public Entite(int x, int y, int v, int atq) {
        super(x, y);
        this.vie = v;
        this.attaque = atq;
    }

    /**
     * methode permettant a l'entite de subir des degats
     * @param dgts degats subis
     */
    public void subirDegats(int dgts){
        this.vie -= dgts;
    }

    /**
     * getter de la vie de l'entite
     * @return vie de l'entite
     */
    public int getVie() {
        return this.vie;
    }

    /**
     * getter de l'attaque de l'entite
     * @return degats de l'entite
     */
    public int getAttaque() {
        return this.attaque;
    }



}
