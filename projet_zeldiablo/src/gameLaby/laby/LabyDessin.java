package gameLaby.laby;

import gameArkanoid.ArkanoidJeu;
import gameArkanoid.Balle;
import gameArkanoid.Raquette;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu labyJeu = (LabyJeu) jeu;

        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();

        // dessin fond
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // dessin murs

        int lengthX = labyJeu.getLaby().getLength();
        int lengthY = labyJeu.getLaby().getLengthY();

        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                if (labyJeu.getLaby().getMur(i, j)) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i*50, j*50, i*50 + 50, j*50 + 50);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillRect(i*50, j*50, i*50 + 50, j*50 + 50);
                }
            }
        }

        // dessin perso
        gc.setFill(Color.RED);
        Perso p = labyJeu.getLaby().pj;
        double px = p.x;
        double py = p.y;
        gc.fillOval(50*px, 50*py, 50, 50);

    }

}
