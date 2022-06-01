package gameLaby.laby;

public class Entite extends Position{

    private int vie;

    private int attaque;

    public Entite(int x, int y, int v, int atq) {
        super(x, y);
        this.vie = v;
        this.attaque = atq;
    }

    public void subirDegats(int dgts){
        this.vie -= dgts;
    }

    public int getVie() {
        return this.vie;
    }

    public int getAttaque() {
        return this.attaque;
    }



}
