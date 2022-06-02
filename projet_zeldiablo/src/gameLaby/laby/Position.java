package gameLaby.laby;

import java.util.Objects;

/**
 * classe representant une position
 */
public class Position {

    /**
     * attribut representant une position x
     */
    private int x;

    /**
     * attribut representant une position y
     */
    private int y;

    /***
     * creer une position
     * @param x position x
     * @param y position y
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * getter de la position x
     * @return position x
     */
    public int getX() {
        return x;
    }

    /**
     * getter de la position y
     * @return position y
     */
    public int getY() {
        return y;
    }

    /**
     * setter de la position x
     * @param x position x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * setter de la position y
     * @param y position y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * methode permettant de comparer deux positions
     * @param p position a comparer
     * @return true si les positions sont egales, false sinon
     */
    public boolean equals(Position p) {
        return this.x == p.x && this.y == p.y;
    }
}
