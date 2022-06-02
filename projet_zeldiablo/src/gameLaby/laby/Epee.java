package gameLaby.laby;

/**
 * classe representant une epee
 */
public class Epee extends Arme {
    /**
     * creer une epee
     * @param dx position x de l'epee
     * @param dy position y de l'epee
     */
    public Epee(int dx, int dy) {
        super(dx, dy, 3);
    }

    /**
     * methode permettant d'afficher que c'est une epeee
     * @return une chaine de caractère qui dit que c'est une epee
     */
    public String toString() {
        return "C'est une epee";
    }
}
