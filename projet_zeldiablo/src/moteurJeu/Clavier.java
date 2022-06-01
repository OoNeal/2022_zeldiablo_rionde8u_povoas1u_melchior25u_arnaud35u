package moteurJeu;

import javafx.scene.input.KeyEvent;

public class Clavier {

    /**
     * controle appuyes
     */
    public boolean haut, bas, gauche, droite, ramasser, attaquer;

    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void appuyerTouche(KeyEvent event) {

        switch (event.getCode()) {

            // si touche bas
            case S:
                this.bas = true;
                break;

            // si touche haut
            case Z:
                this.haut = true;
                break;

            // si touche gauche
            case Q:
                this.gauche = true;
                break;

            // si touche droite
            case D:
                this.droite = true;
                break;

            // si touche ramasser
            case E:
                this.ramasser = true;
                break;

            // si touche attaquer
            case SPACE:
                this.attaquer = true;
                break;

        }

    }

    /**
     * stocke les commandes
     *
     * @param event evenement clavier
     */
    public void relacherTouche(KeyEvent event) {

        switch (event.getCode()) {

            // si touche bas
            case S:
                this.bas = false;
                break;

            // si touche haut
            case Z:
                this.haut = false;
                break;

            // si touche gauche
            case Q:
                this.gauche = false;
                break;

            // si touche droite
            case D:
                this.droite = false;
                break;

            // si touche ramasser
            case E:
                this.ramasser = false;
                break;

            // si touche attaquer
            case SPACE:
                this.attaquer = false;
                break;

        }
    }
}
