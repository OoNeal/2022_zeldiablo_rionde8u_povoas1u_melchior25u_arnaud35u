package gameLaby.laby;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * classe labyrinthe. represente un labyrinthe avec
 * <ul> des murs </ul>
 * <ul> un personnage (x,y) </ul>
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char PJ = 'P';
    public static final char VIDE = '.';
    public static final char POTION = 'B';
    public static final char EPEE = 'E';
    public static final char MONSTRE = 'M';
    public static final char DAGUE = 'D';


    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    /**
     * attribut du personnage
     */
    private Perso pj;

    /**
     * attribut du monstre
     */
    private ArrayList<Monstre> monstres;

    /**
     * attribut representant les murs du labyrinthe
     */
    private boolean[][] murs;

    /**
     * attribut representant les objets presents sur le labyrinthe
     */
    private ArrayList<ObjetRamassable> objets;

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        int[] res = {x, y};
        return res;
    }

    /**
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @return labyrinthe cree
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        nbLignes = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        nbColonnes = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.murs = new boolean[nbColonnes][nbLignes];
        this.pj = null;
        this.objets = new ArrayList<ObjetRamassable>();
        this.monstres = new ArrayList<Monstre>();

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.murs[colonne][numeroLigne] = true;
                        break;
                    case VIDE:
                        this.murs[colonne][numeroLigne] = false;
                        break;
                    case PJ:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute PJ
                        this.pj = new Perso(colonne, numeroLigne);
                        break;
                    case EPEE:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute Epee
                        this.objets.add(new Epee(colonne, numeroLigne));
                        break;
                    case POTION:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute Potion
                        this.objets.add(new Potion(colonne, numeroLigne));
                        break;
                    case MONSTRE:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute Monstre
                        this.monstres.add(new Monstre(colonne, numeroLigne));
                        break;
                    case DAGUE:
                        // pas de mur
                        this.murs[colonne][numeroLigne] = false;
                        // ajoute Dague
                        this.objets.add(new Dague(colonne, numeroLigne));
                        break;

                    default:
                        throw new Error("caractere inconnu " + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }

        // ferme fichier
        bfRead.close();
    }


    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {
        // case courante
        int[] courante = {this.pj.getX(), this.pj.getY()};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!this.murs[suivante[0]][suivante[1]]) {
            if (!this.monstres.isEmpty()) {
                boolean bouge = true;
                for (Monstre monster : this.monstres) {
                    if (monster.equals(new Position(suivante[0], suivante[1]))) {
                        bouge = false;
                        break;
                    }
                }

                if (bouge) {
                    // on met a jour personnage
                    this.pj.setX(suivante[0]);
                    this.pj.setY(suivante[1]);
                }

            } else {
                // on met a jour personnage
                this.pj.setX(suivante[0]);
                this.pj.setY(suivante[1]);
            }

        }


    }

    /**
     * ramasse un objet ramassable
     */
    public void ramasserObjet() {
        for (ObjetRamassable oR : this.objets) {
            if (this.pj.equals(oR) && this.pj.getInventaire().size() < 6) {
                this.objets.remove(oR);
                this.pj.getInventaire().add(oR);
                this.pj.changerMeilleureArme();
                break;
            }
        }
    }


    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * return taille selon Y
     *
     * @return int
     */
    public int getLengthY() {
        return this.murs[0].length;
    }

    /**
     * return taille selon X
     *
     * @return int
     */
    public int getLength() {
        return this.murs.length;
    }

    /**
     * return mur en (i,j)
     *
     * @param x
     * @param y
     * @return
     */
    public boolean getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.murs[x][y];
    }

    /**
     * return le personnage
     *
     * @return Perso
     */
    public Perso getPj() {
        return this.pj;
    }

    /**
     * return les monstres
     *
     * @return ArrayList<Monstre>
     */
    public ArrayList<Monstre> getMonstres() {
        return this.monstres;
    }

/**
     * return les objets ramassables
     *
     * @return ArrayList<ObjetRamassable>
     */
    public ArrayList<ObjetRamassable> getObjets() {
        return this.objets;
    }

    /**
     * methode permettant d'attaquer un monstre
     */
    public void attaquerMonstre() {
        if (!this.monstres.isEmpty()) {
            for (int i = this.monstres.size()-1; i >= 0; i--) {
                Monstre m = this.monstres.get(i);
                if (m.getX() == this.pj.getX() + 1 && m.getY() == this.pj.getY()) {
                    m.subirDegats(this.pj.getMeilleureDegats());
                }
                if (m.getX() == this.pj.getX() - 1 && m.getY() == this.pj.getY()) {
                    m.subirDegats(this.pj.getMeilleureDegats());
                }
                if (m.getX() == this.pj.getX() && m.getY() == this.pj.getY() + 1) {
                    m.subirDegats(this.pj.getMeilleureDegats());
                }
                if (m.getX() == this.pj.getX() && m.getY() == this.pj.getY() - 1) {
                    m.subirDegats(this.pj.getMeilleureDegats());
                }
                if (m.getVie() <= 0) {
                    this.monstres.remove(m);
                }
            }
        }
    }
}
