package gameLaby.laby;


import java.util.ArrayList;

/**
 * gere un personnage situe en x,y
 */
public class Perso extends Entite {

    private ArrayList<ObjetRamassable> inventaire;

    /**
     * constructeur
     *
     * @param dx position selon x
     * @param dy position selon y
     */
    public Perso(int dx, int dy, int v, int atq) {
        super(dx, dy, v, atq);
        inventaire = new ArrayList<ObjetRamassable>();
    }

    /**
     * permet de savoir si le personnage est en x,y
     *
     * @param dx position testee
     * @param dy position testee
     * @return true si le personnage est bien en (dx,dy)
     */
    public boolean etrePresent(int dx, int dy) {

        return (super.getX() == dx && super.getY() == dy);
    }



    public ArrayList<ObjetRamassable> getInventaire() {
        return inventaire;
    }
}
