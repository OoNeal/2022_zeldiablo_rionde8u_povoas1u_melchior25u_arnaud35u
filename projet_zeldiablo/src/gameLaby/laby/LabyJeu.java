package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

/**
 * classe qui charge et affiche un labyrinthe
 */
public class LabyJeu implements Jeu {

    /**
     * attribut representant le labyrinthe a afficher
     */
    private final Labyrinthe laby;

    /**
     * attribut represenant un booleen qui permet de savoir si le joueur peut attaquer ou non
     */
    private boolean pretAttaquer = true;

    /**
     * Constructeur de la classe LabyJeu
     * @param nom nom du fichier contenant le labyrinthe
     * @throws IOException si le fichier n'existe pas
     */
    public LabyJeu(String nom) throws IOException {
        this.laby = new Labyrinthe(nom);
    }

    @Override
    public void update(double secondes, Clavier clavier) {
        // deplace le perso en fonction des touches
        if (clavier.droite) {
            this.laby.deplacerPerso("Droite");
        }

        if (clavier.gauche) {
            this.laby.deplacerPerso("Gauche");
        }

        if (clavier.bas) {
            this.laby.deplacerPerso("Bas");
        }

        if (clavier.haut) {
            this.laby.deplacerPerso("Haut");
        }

        // si on ramasse
        if (clavier.ramasser) {
            this.laby.ramasserObjet();
        }

        // si on attaque et qu'on est pret a attaquer
        if (clavier.attaquer && pretAttaquer) {
            this.laby.attaquerMonstre();
        }
        pretAttaquer = !clavier.attaquer;

    }

    /**
     * methode qui initialise le jeu
     */
    @Override
    public void init() {
        // pas d'initialisation particuliere
    }

    /**
     * methode qui termine le jeu
     * @return true si le jeu est termine, false sinon
     */
    @Override
    public boolean etreFini() {
        // le jeu ne s'arrete jamais
        return false;
    }

    /**
     * getter du labyrinthe
     * @return le labyrinthe
     */
    public Labyrinthe getLaby() {
        return this.laby;
    }


}
