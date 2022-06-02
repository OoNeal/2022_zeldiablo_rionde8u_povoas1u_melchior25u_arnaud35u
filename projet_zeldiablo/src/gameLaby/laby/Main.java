package gameLaby.laby;

import java.io.IOException;

/**
 * classe qui charge et affiche un labyrinthe
 */
public class Main {
    /**
     * methode principale
     * @param args arguments de la ligne de commande
     * @throws IOException si le fichier n'existe pas
     */
    public static void main(String[] args) throws IOException {

        // charge le labyrinthe
        Labyrinthe laby = new Labyrinthe("labySimple/laby0.txt");

        //affiche le labyrinthe charge
        for (int y = 0; y < laby.getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLength(); x++) {
                if (laby.getMur(x, y))
                    System.out.print('X');
                else
                    System.out.print('.');
            }
            // saut de ligne
            System.out.println();
        }
    }
}
