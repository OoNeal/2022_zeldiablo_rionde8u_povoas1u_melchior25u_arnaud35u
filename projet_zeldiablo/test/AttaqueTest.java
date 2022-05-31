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
        Labyrinthe laby = new Labyrinthe("labySimple/labyMonstre.txt");

        // verification

        assertEquals(2, laby.monster.getY());
        assertEquals(4, laby.monster.getX());

    }

    /**
     * test ramasserObjet lorsqu'il n'y a pas d'objet sur la case
     */
    @Test
    public void test1_attaqueMonstre_sansArme() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyMonstre.txt");

        // methode testee
        laby.ramasserObjet();


        // verification
        assertEquals(2, laby.objets.size(), "Il devrai y avoir 2 objets sur le labyrinthe");
        assertEquals(0, laby.pj.getInventaire().size(), "L inventaire devrait etre vide");
    }

    /**
     * test ramasserObjet lorsqu'il y a un objet sur la case
     */
    @Test
    public void test2_RamasserObjet_CaseObjet() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyObjet.txt");
        laby.deplacerPerso("Haut");

        // methode testee
        laby.ramasserObjet();

        // verification
        assertEquals(1, laby.objets.size(), "Il devrai y avoir 1 objets sur le labyrinthe");
        assertEquals(1, laby.pj.getInventaire().size(), "Il devrai y avoir 1 objets dans l inventaire");

    }

    /**
     * test ramasserObjet lorsqu'il y a un objet sur la case et que l'on deja un objet
     */
    @Test
    public void test3_RamasserObjet_2CaseObjet() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyObjet.txt");
        laby.deplacerPerso("Haut");
        laby.ramasserObjet();
        laby.deplacerPerso("Haut");
        laby.deplacerPerso("Gauche");

        // methode testee
        laby.ramasserObjet();

        // verification
        assertEquals(0, laby.objets.size(), "Il devrai y avoir 0 objets sur le labyrinthe");
        assertEquals(2, laby.pj.getInventaire().size(), "Il devrai y avoir 2 objets dans l inventaire");


    }



}
