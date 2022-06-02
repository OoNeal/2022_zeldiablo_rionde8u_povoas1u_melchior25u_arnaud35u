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

    private int meilleureArme;
    /**
     * constructeur
     *
     * @param x position selon x
     * @param y position selon y
     */
    public Perso(int x, int y) {
        super(x, y, 10, 3);
        inventaire = new ArrayList<ObjetRamassable>();
        this.meilleureArme = -1;
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


    public void changerMeilleureArme() {
        if (this.meilleureArme == -1) {
            if (this.inventaire.get(this.inventaire.size()-1).getDegats() > 0) {
                this.meilleureArme = this.inventaire.size() - 1;
            }
        } else if (this.inventaire.get(this.inventaire.size()-1).getDegats() > this.inventaire.get(this.meilleureArme).getDegats()) {
            this.meilleureArme = this.inventaire.size() - 1;
        }
    }


    public int getMeilleureDegats() {
        int meilleureDegats = 0;
        if (this.meilleureArme != -1) {
            meilleureDegats = this.inventaire.get(this.meilleureArme).getDegats();
        }
        return meilleureDegats + this.getAttaque();
    }

    /**
     * getter de l'inventaire du personnage
     * @return inventaire du personnage
     */
    public ArrayList<ObjetRamassable> getInventaire() {
        return inventaire;
    }

    public int getMeilleureArme() {
        return this.meilleureArme;
    }
}
