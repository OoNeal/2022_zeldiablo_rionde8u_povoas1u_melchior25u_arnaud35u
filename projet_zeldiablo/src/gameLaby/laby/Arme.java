package gameLaby.laby;

/**
 * classse representant une arme
 */
public class Arme extends ObjetRamassable {

    /**
     * attribut representant les degats de l'arme
     */
    private int degats;

    /**
     * creer une arme
     * @param x position x de l'arme
     * @param y position y de l'arme
     * @param dgts degats de l'arme
     */
    public Arme(int x, int y, int dgts) {
        super(x, y);
        this.degats = dgts;
    }

    /**
     * getter de l'attaque de l'arme
     * @return degats de l'arme
     */
    public int getDegats() {
        return this.degats;
    }
}
