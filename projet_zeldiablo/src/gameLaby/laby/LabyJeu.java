package gameLaby.laby;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.IOException;

public class LabyJeu implements Jeu {

    private final Labyrinthe laby;

    public LabyJeu(String nom) throws IOException {
        this.laby = new Labyrinthe(nom);
    }


    @Override
    /**
     * met a jour l'etat du jeu
     */
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

        if (clavier.ramasser) {
            this.laby.ramasserObjet();
        }

        // affichage console (facultatif)
        for (ObjetRamassable oR : this.laby.pj.getInventaire()) {
            System.out.println(oR);
        }

    }


    @Override
    public void init() {
        // pas d'initialisation particuliere
    }

    @Override
    public boolean etreFini() {
        // le jeu ne s'arrete jamais
        return false;
    }

    public Labyrinthe getLaby() {
        return this.laby;
    }


}
