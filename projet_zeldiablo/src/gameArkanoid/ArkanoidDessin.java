package gameArkanoid;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.awt.*;

/**
 * permet d'afficher un jeu de type arkanoid
 */
public class ArkanoidDessin implements DessinJeu {

    /**
     * affichage d'un jeu de type arkanoid
     * @param jeu jeu a afficher
     * @param canvas dessin dans lequel dessin
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        ArkanoidJeu arkanoid = (ArkanoidJeu) jeu;


        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // dessin raquette
        gc.setFill(Color.BLACK);
        Raquette raquette = arkanoid.getRaquette();
        double px = raquette.getPx() - Raquette.RAQUETTE_TAILLE / 2;
        double py = raquette.getPy();
        gc.fillRect(px, py, Raquette.RAQUETTE_TAILLE, 10);

        // dessin balle
        gc.setFill(Color.RED);
        Balle balle = arkanoid.getBalle();
        double bx = balle.getPx();
        double by = balle.getPy();
        gc.fillOval(bx - 5, by - 5, 10, 10);

    }
}
