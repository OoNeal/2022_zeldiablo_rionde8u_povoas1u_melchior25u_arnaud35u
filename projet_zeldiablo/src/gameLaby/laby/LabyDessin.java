package gameLaby.laby;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.util.ArrayList;

/**
 * classe LabyDessin qui permet de dessiner le labyrinthe
 */
public class LabyDessin implements DessinJeu {

    public ChargerImage images = null;

    /**
     * methode permettant de dessiner le jeu
     * @param jeu jeu a afficher
     * @param canvas canvas dans lequel dessiner l'etat du jeu
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {

        if (images == null) {
            images = new ChargerImage();
        }

        LabyJeu labyJeu = (LabyJeu) jeu;

        // recupere un pinceau pour dessiner
        final GraphicsContext gc = canvas.getGraphicsContext2D();


        // dessin fond
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // dessin murs

        int lengthX = labyJeu.getLaby().getLength();
        int lengthY = labyJeu.getLaby().getLengthY();
        ArrayList<ObjetRamassable> objetsLaby = labyJeu.getLaby().getObjets();

        for (int i = 0; i < lengthX; i++) {
            for (int j = 0; j < lengthY; j++) {
                if (labyJeu.getLaby().getMur(i, j)) {
                    gc.drawImage(images.getImageMur(), 50*i, 50*j);
                } else {
                    for (ObjetRamassable temp : objetsLaby) {
                        if (temp.equals(new Position(i, j))) {
                            switch (temp.getDegats()) {
                                case 0:
                                    gc.drawImage(images.getImagePotion(), 50*i, 50*j);
                                    break;
                                case 2:
                                    gc.drawImage(images.getImageDague(), 50*i, 50*j);
                                    break;
                                case 3:
                                    gc.drawImage(images.getImageEpee(), 50*i, 50*j);
                                    break;
                            }
                        }
                    }
                }
            }
        }



        // dessin perso
        Perso p = labyJeu.getLaby().getPj();
        double px = p.getX();
        double py = p.getY();
        gc.drawImage(images.getImagePerso(), 50*px, 50*py);

        // dessin monstre
        gc.setFill(Color.VIOLET);
        for (Monstre m : labyJeu.getLaby().getMonstres()) {
            double mx = m.getX();
            double my = m.getY();
            gc.drawImage(images.getImageMonstre(), 50*mx, 50*my);
        }


        // dessin des cases de l'inventaire
        for (int i = 0; i < 6; i++) {
            gc.setFill(Color.BLACK);
            gc.fillRect(canvas.getWidth()/2 + 50*i - 150, canvas.getHeight()-50, 50, 50);
            if (i == p.getMeilleureArme()) {
                gc.setFill(Color.RED);
            } else {
                gc.setFill(Color.WHITE);
            }
            gc.fillRect(canvas.getWidth()/2+ 50*i+2 - 150, canvas.getHeight()-48, 46, 46);
        }

        ArrayList<ObjetRamassable> inv = labyJeu.getLaby().getPj().getInventaire();

        for (int i = 0; i < inv.size(); i++) {
            switch (inv.get(i).getDegats()) {
                case 0:
                    gc.drawImage(images.getImagePotion(), canvas.getWidth()/2 + 50*i - 150, canvas.getHeight()-50);
                    break;
                case 2:
                    gc.drawImage(images.getImageDague(), canvas.getWidth()/2 + 50*i - 150, canvas.getHeight()-50);
                    break;
                case 3:
                    gc.drawImage(images.getImageEpee(), canvas.getWidth()/2 + 50*i - 150, canvas.getHeight()-50);
                    break;
            }
        }

    }

}
