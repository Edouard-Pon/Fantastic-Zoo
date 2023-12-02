package org.example.model;

import org.example.model.creatures.Lycanthrope;
import org.example.model.spaces.Enclosure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnclosureTest {
    @Test
    public void testAddCreatures() {
        Lycanthrope l1 = new Lycanthrope("L1", true, 50, 25, 20);
        Lycanthrope l2 = new Lycanthrope("L2", false, 35, 22, 15);
        Lycanthrope l3 = new Lycanthrope("L3", true, 55, 20, 25);

        Enclosure e1 = new Enclosure("Lycanthropes Enclosure", "150x150", 5);

        e1.addCreatures(l1, l2, l3);

        assertEquals(3, e1.getNumberOfCreatures(), "Number of creatures in enclosure");

        Lycanthrope l4 = new Lycanthrope("L4", true, 55, 20, 25);

        e1.addCreatures(l4);

        assertEquals(4, e1.getNumberOfCreatures(), "Number of creatures in enclosure");

        Lycanthrope l5 = new Lycanthrope("L5", true, 55, 20, 25);
        Lycanthrope l6 = new Lycanthrope("L6", true, 55, 20, 25);

        e1.addCreatures(l5, l6);

        assertEquals(5, e1.getMaxCreaturesNumber(), "Max creatures number in enclosure");
        assertEquals(5, e1.getNumberOfCreatures(), "Number of creatures in enclosure");
    }

    @Test
    public void testRemoveCreatures() {
        Lycanthrope l1 = new Lycanthrope("L1", true, 50, 25, 20);
        Lycanthrope l2 = new Lycanthrope("L2", false, 35, 22, 15);
        Lycanthrope l3 = new Lycanthrope("L3", true, 55, 20, 25);

        Enclosure e1 = new Enclosure("Lycanthropes Enclosure", "150x150", 5);

        e1.addCreatures(l1, l2, l3);
        e1.removeCreatures();

        assertEquals(0, e1.getNumberOfCreatures(), "Number of creatures");
        assertTrue(e1.getCreaturesList().isEmpty());
    }
}
