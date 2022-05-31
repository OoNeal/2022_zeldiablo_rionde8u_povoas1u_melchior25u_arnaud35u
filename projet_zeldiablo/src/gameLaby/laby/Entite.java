package gameLaby.laby;

public class Entite extends Position{

    private int vie;
    private int attaque;

    public Entite(int x, int y, int v, int atq) {
        super(x, y);
        this.vie = v;
        this.attaque = atq;
    }


}
