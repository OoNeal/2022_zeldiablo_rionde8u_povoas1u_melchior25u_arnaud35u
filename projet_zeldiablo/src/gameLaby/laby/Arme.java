package gameLaby.laby;

public class Arme extends ObjetRamassable {
    private int degats;

    public Arme(int x, int y, int dgts) {
        super(x, y);
        this.degats = dgts;
    }

    public int getDegats() {
        return this.degats;
    }
}
