package gameLaby.laby;

import javafx.scene.image.Image;

public class ChargerImage {

    private Image imageMur;
    private Image imagePerso;
    private Image imageMonstre;
    private Image imageEpee;
    private Image imageDague;
    private Image imagePotion;

    /**
     * Constructeur vide de ChargerImage qui permet de charger toutes les images
     */
    public ChargerImage() {
        imageMur = new Image("file:images/wall.png", 50, 50, false, false);
        imagePerso = new Image("file:images/perso.png", 50, 50, false, false);
        imageMonstre = new Image("file:images/monstre.png", 50, 50, false, false);
        imageEpee = new Image("file:images/relic-blade.png", 50, 50, false, false);
        imageDague = new Image("file:images/plain-dagger.png", 50, 50, false, false);
        imagePotion = new Image("file:images/potion.png", 50, 50, false, false);
    }

    /**
     * Methode permettant de recuperer l'image du mur
     * @return image du mur
     */
    public Image getImageMur() {
        return this.imageMur;
    }

    /**
     * Methode permettant de recuperer l'image du personnage
     * @return image du personnage
     */
    public Image getImagePerso() {
        return this.imagePerso;
    }

    /**
     * Methode permettant de recuperer l'image du monstre
     * @return image du monstre
     */
    public Image getImageMonstre() {
        return this.imageMonstre;
    }

    /**
     * Methode permettant de recuperer l'image de l'epee
     * @return image de l'epee
     */
    public Image getImageEpee() {
        return this.imageEpee;
    }

    /**
     * Methode permettant de recuperer l'image de la dague
     * @return image de la dague
     */
    public Image getImageDague() {
        return this.imageDague;
    }

    /**
     * Methode permettant de recuperer l'image de la potion
     * @return image de la potion
     */
    public Image getImagePotion() {
        return this.imagePotion;
    }
}
