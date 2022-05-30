package gameLaby.laby;

import moteurJeu.MoteurJeu;

import java.io.IOException;

/**
 * lance un jeu de type arkanoid en 10 frames par second
 */
public class MainLaby {

    public static void main(String[] args) throws IOException {
        int width = 500;
        int height = 350;
        int pFPS = 10;

        // creation des objets
        LabyJeu jeuLaby = new LabyJeu("labySimple/labyObjet.txt");
        LabyDessin dessinLaby = new LabyDessin();

        // parametrage du moteur de jeu
        MoteurJeu.setTaille(width,height);
        MoteurJeu.setFPS(pFPS);

        // lancement du jeu
        MoteurJeu.launch(jeuLaby, dessinLaby);
    }
}
