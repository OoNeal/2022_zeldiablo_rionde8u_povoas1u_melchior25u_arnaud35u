package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * lance un jeu de type arkanoid en 10 frames par second
 */
public class MainLaby {

    /**
     * methode principale
     * @param args arguments de la ligne de commande
     * @throws IOException si le fichier n'existe pas
     */
    public static void main(String[] args) throws IOException {
        int pFPS = 20;

        // creation des objets
        LabyJeu jeuLaby = new LabyJeu("labySimple/labyJeu.txt");
        LabyDessin dessinLaby = new LabyDessin();

        int width = 50*jeuLaby.getLaby().getLength();
        int height = 50*jeuLaby.getLaby().getLengthY()+70;

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);

        // lancement du jeu
        MoteurJeu.launch(jeuLaby, dessinLaby);
    }
}
