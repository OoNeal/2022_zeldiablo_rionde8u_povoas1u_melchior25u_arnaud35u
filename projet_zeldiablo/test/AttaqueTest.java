import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * classe de test permettant de tester la classe Telecommande
 */
public class AttaqueTest {

    /**
     * test que le monstre soit bien creer
     */
    @Test
    public void test0_CreationLabyrinthe() throws Exception{
        // methode testee
        Labyrinthe laby = new Labyrinthe("labySimple/labyMonstreTest.txt");

        // verification

        assertEquals(2, laby.getMonstres().get(1).getX());
        assertEquals(4, laby.getMonstres().get(1).getY());
        assertEquals(10, laby.getMonstres().get(1).getVie(), "Le monstre devrait avoir 10 pv");

    }

    /**
     * test attaquerMonstre lorsque le perso n'a pas d'arme
     */
    @Test
    public void test1_attaqueMonstre_sansArme() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyMonstreTest.txt");
        laby.deplacerPerso("Haut");
        laby.deplacerPerso("Gauche");
        laby.deplacerPerso("Gauche");

        // methode testee
        laby.attaquerMonstre();

        // verification
        assertEquals(7, laby.getMonstres().get(1).getVie(), "Le monstre devrait avoir 7 pv");

    }

    /**
     * test attaquerMonstre lorsque le perso a une dague
     */
    @Test
    public void test2_attaqueMonstre_avecDague() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyMonstreTest.txt");
        laby.deplacerPerso("Haut");
        laby.deplacerPerso("Gauche");
        laby.ramasserObjet();
        laby.deplacerPerso("Gauche");

        // methode testee
        laby.attaquerMonstre();

        // verification
        assertEquals(5, laby.getMonstres().get(1).getVie(), "Le monstre devrait avoir 5 pv");

    }

    /**
     * test attaquerMonstre lorsque le perso a une epee
     */
    @Test
    public void test3_attaqueMonstre_avecEpee() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyMonstreTest.txt");
        laby.deplacerPerso("Haut");
        laby.ramasserObjet();
        laby.deplacerPerso("Gauche");
        laby.deplacerPerso("Gauche");

        // methode testee
        laby.attaquerMonstre();

        // verification
        assertEquals(4, laby.getMonstres().get(1).getVie(), "Le monstre devrait avoir 4 pv");

    }

    /**
     * test attaquerMonstre lorsque le perso a une epee et une dague (et attaque donc avec l epee)
     */
    @Test
    public void test4_attaqueMonstre_avecEpeeEtDague() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyMonstreTest.txt");
        laby.deplacerPerso("Haut");
        laby.ramasserObjet();
        laby.deplacerPerso("Gauche");
        laby.ramasserObjet();
        laby.deplacerPerso("Gauche");

        // methode testee
        laby.attaquerMonstre();

        // verification
        assertEquals(4, laby.getMonstres().get(1).getVie(), "Le monstre devrait avoir 4 pv");

    }

    /**
     * test deplacerPerso quand il y a un monstre sur son chemin (devant lui)
     */
    @Test
    public void test4_deplacerPerso_MonstreDevant() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyMonstreTest.txt");
        laby.deplacerPerso("Haut");
        laby.deplacerPerso("Gauche");
        laby.deplacerPerso("Gauche");

        // methode testee
        laby.deplacerPerso("Gauche");

        // verification
        assertEquals(3, laby.getPj().getX(), "Le perso devrait etre a la coordonne X 3");
        assertEquals(4, laby.getPj().getY(), "Le perso devrait etre a la coordonne Y 4");


    }

    /**
     * test attaquerMonstre lorsque le perso a une epee et une dague (et attaque donc avec l epee)
     */
    @Test
    public void test4_attaqueMonstre_persoPasACoteMonstre() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyMonstreTest.txt");
        laby.deplacerPerso("Haut");
        laby.deplacerPerso("Gauche");

        // methode testee
        laby.attaquerMonstre();

        // verification
        assertEquals(10, laby.getMonstres().get(1).getVie(), "Le monstre devrait avoir 10 pv");

    }


}
