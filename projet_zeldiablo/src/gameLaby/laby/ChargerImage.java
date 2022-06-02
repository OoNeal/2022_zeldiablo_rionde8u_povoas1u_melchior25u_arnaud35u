package gameLaby.laby;

import javafx.scene.image.Image;

public class ChargerImage {

    private Image imageMur;
    private Image imagePerso;
    private Image imageMonstre;
    private Image imageEpee;
    private Image imageDague;
    private Image imagePotion;

    public ChargerImage() {
        imageMur = new Image("file:images/wall.png", 50, 50, false, false);
        imagePerso = new Image("file:images/perso.png", 50, 50, false, false);
        imageMonstre = new Image("file:images/monstre.png", 50, 50, false, false);
        imageEpee = new Image("file:images/relic-blade.png", 50, 50, false, false);
        imageDague = new Image("file:images/plain-dagger.png", 50, 50, false, false);
        imagePotion = new Image("file:images/potion.png", 50, 50, false, false);
    }

    public Image getImageMur() {
        return this.imageMur;
    }

    public Image getImagePerso() {
        return this.imagePerso;
    }

    public Image getImageMonstre() {
        return this.imageMonstre;
    }

    public Image getImageEpee() {
        return this.imageEpee;
    }

    public Image getImageDague() {
        return this.imageDague;
    }

    public Image getImagePotion() {
        return this.imagePotion;
    }
}
