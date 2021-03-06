import gameLaby.laby.Labyrinthe;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * classe de test permettant de tester la classe Telecommande
 */
public class InventaireTest {

    /**
     * test que les objets soi bien creer et sont a la bonne position lors de la creation du labyrinthe
     */
    @Test
    public void test0_CreationLabyrinthe() throws Exception{
        // methode testee
        Labyrinthe laby = new Labyrinthe("labySimple/labyObjetTest.txt");

        // verification
        assertEquals(laby.getObjets().size(), 2, "Il devrai y avoir 2 objets sur le labyrinthe");

        assertEquals(3, laby.getObjets().get(0).getY());
        assertEquals(4, laby.getObjets().get(0).getX());

        assertEquals(4, laby.getObjets().get(1).getY());
        assertEquals(5, laby.getObjets().get(1).getX());

    }

    /**
     * test ramasserObjet lorsqu'il n'y a pas d'objet sur la case
     */
    @Test
    public void test1_RamasserObjet_CaseVide() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyObjetTest.txt");

        // methode testee
        laby.ramasserObjet();

        // verification
        assertEquals(2, laby.getObjets().size(), "Il devrai y avoir 2 objets sur le labyrinthe");
        assertEquals(0, laby.getPj().getInventaire().size(), "L inventaire devrait etre vide");
    }

    /**
     * test ramasserObjet lorsqu'il y a un objet sur la case
     */
    @Test
    public void test2_RamasserObjet_CaseObjet() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyObjetTest.txt");
        laby.deplacerPerso("Haut");

        // methode testee
        laby.ramasserObjet();

        // verification
        assertEquals(1, laby.getObjets().size(), "Il devrai y avoir 1 objets sur le labyrinthe");
        assertEquals(1, laby.getPj().getInventaire().size(), "Il devrai y avoir 1 objets dans l inventaire");

    }

    /**
     * test ramasserObjet lorsqu'il y a un objet sur la case et que l'on deja un objet
     */
    @Test
    public void test3_RamasserObjet_2CaseObjet() throws Exception{
        // preparation des donnees
        Labyrinthe laby = new Labyrinthe("labySimple/labyObjetTest.txt");
        laby.deplacerPerso("Haut");
        laby.ramasserObjet();
        laby.deplacerPerso("Haut");
        laby.deplacerPerso("Gauche");

        // methode testee
        laby.ramasserObjet();

        // verification
        assertEquals(0, laby.getObjets().size(), "Il devrai y avoir 0 objets sur le labyrinthe");
        assertEquals(2, laby.getPj().getInventaire().size(), "Il devrai y avoir 2 objets dans l inventaire");


    }



}
