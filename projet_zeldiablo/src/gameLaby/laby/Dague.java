package gameLaby.laby;

/**
 * classe representant une dague
 */
public class Dague extends Arme{

    /**
     * creer une dague
     * @param x position x de la dague
     * @param y position y de la dague
     */
    public Dague(int x, int y) {
        super(x, y, 2);
    }

    /**
     * methode permettant d'afficher que c'est une dague
     * @return une chaine de caractère qui dit que c'est une dague
     */
    public String toString() {
        return "C'est une dague";
    }
}
