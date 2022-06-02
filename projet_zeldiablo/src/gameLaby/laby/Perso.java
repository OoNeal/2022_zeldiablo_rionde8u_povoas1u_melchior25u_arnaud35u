package gameLaby.laby;


import java.util.ArrayList;

/**
 * classe qui gere un personnage situe en x,y
 */
public class Perso extends Entite {

    /**
     * attribut representant la liste des objets ramassables possédés par le personnage
     */
    private ArrayList<ObjetRamassable> inventaire;

    /**
     * constructeur
     *
     * @param x position selon x
     * @param y position selon y
     */
    public Perso(int x, int y) {
        super(x, y, 10, 3);
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

    /**
     * methode permettant de connaitre les meilleurs degats possibles que le perso peut faire
     * @return meilleurs degats possibles
     */
    public int getMeilleureDegats() {
        int meilleureDegats = 0;
        for (ObjetRamassable arme : inventaire) {
            if (meilleureDegats < arme.getDegats()) {
                meilleureDegats = arme.getDegats();
            }

        }
        return this.getAttaque() + meilleureDegats;
    }

    /**
     * getter de l'inventaire du personnage
     * @return inventaire du personnage
     */
    public ArrayList<ObjetRamassable> getInventaire() {
        return inventaire;
    }
}
