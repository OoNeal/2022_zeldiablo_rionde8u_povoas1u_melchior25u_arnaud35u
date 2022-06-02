package gameLaby.laby;

/**
 * classe representant une potion
 */
public class Potion extends ObjetRamassable {

    /**
     * Constructeur de la classe Potion
     * @param dx position x de la potion
     * @param dy position y de la potion
     */
    public Potion(int dx, int dy) {
        super(dx, dy);
    }

    /**
     * methode permettant d'afficher que c'est une potion
     * @return une chaine de caractere disant que c'est une potion
     */
    public String toString() {
        return "C'est une potion";
    }
}
