package org.example.model;

import org.example.model.creatures.Dragon;
import org.example.model.creatures.Lycanthrope;
import org.example.model.spaces.Aviary;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AviaryTest {
    @Test
    public void testAddCreatures() {
        Lycanthrope l1 = new Lycanthrope("L1", true, 50, 25, 20);
        Lycanthrope l2 = new Lycanthrope("L2", false, 35, 22, 15);
        Dragon d1 = new Dragon("D1", true, 450, 350, 250);
        Dragon d2 = new Dragon("D2", false, 450, 350, 250);

        Aviary a1 = new Aviary("A1", "1000x1000", 5, 1000);

        a1.addCreatures(l1, d1, d2, l2);

        assertEquals(2, a1.getNumberOfCreatures(), "Number of creatures");
        assertEquals(d1.getClass().getName(), a1.getCreaturesList().get(0).getClass().getName(), "Creature Type");
        assertEquals(d2.getClass().getName(), a1.getCreaturesList().get(1).getClass().getName(), "Creature Type");

        Lycanthrope l3 = new Lycanthrope("L3", false, 35, 22, 15);
        Dragon d3 = new Dragon("D3", true, 450, 350, 250);

        a1.addCreatures(d3, l3);

        assertEquals(3, a1.getNumberOfCreatures(), "Number of creatures");
        assertEquals(d1.getClass().getName(), a1.getCreaturesList().get(0).getClass().getName(), "Creature Type");
        assertEquals(d2.getClass().getName(), a1.getCreaturesList().get(1).getClass().getName(), "Creature Type");
        assertEquals(d3.getClass().getName(), a1.getCreaturesList().get(2).getClass().getName(), "Creature Type");
    }

    @Test
    public void testMaintain() {
        Dragon d1 = new Dragon("D1", true, 450, 350, 250);
        Dragon d2 = new Dragon("D2", false, 450, 350, 250);

        Aviary a1 = new Aviary("A1", "1000x1000", 5, 1000);

        a1.addCreatures(d1, d2);

        assertFalse(a1.isRoofBroken(), "Roof is not broken");

        a1.setRoofBroken(true);

        assertTrue(a1.isRoofBroken(), "Roof is broken");

        a1.maintain();

        assertTrue(a1.isRoofBroken(), "Roof is broken");

        a1.removeCreatures();
        a1.setClean(false);
        a1.maintain();

        assertFalse(a1.isRoofBroken(), "Roof is not broken");
        assertEquals(0, a1.getNumberOfCreatures(), "Aviary is empty with 0 creatures");
    }
}
