package gameLaby.laby;

/**
 * classe representant un objet ramassable
 */
public class ObjetRamassable extends Position{
    /**
     * creer un objet ramassable
     * @param x position x de l'objet ramassable
     * @param y position y de l'objet ramassable
     */
    public ObjetRamassable(int x, int y){
        super(x, y);
    }

    /**
     * methode permettant de connaitre les degats de l'objet ramassable
     * @return degats de l'objet ramassable
     */
    public int getDegats(){
        return 0;
    }
}
