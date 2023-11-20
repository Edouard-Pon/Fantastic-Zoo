package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FantasticZooTest {
    @Test
    public void testGetNumberOfCreatures() {
        Master m1 = new Master("M1", true, 69);

        FantasticZoo z1 = new FantasticZoo("Z1", m1, 3);

        Enclosure e1 = new Enclosure("E1", "150x150", 2);
        Aviary av1 = new Aviary("AV1", "150x150", 3, 250);
        Aquarium aq1 = new Aquarium("AQ1", "150x150", 1, 15, 15.0);

        Dragon d1 = new Dragon("D1", true, 560, 450, 666);
        Dragon d2 = new Dragon("D2", false, 320, 350, 333);
        Phoenix p1 = new Phoenix("P1", true, 40, 20, 300);
        Phoenix p2 = new Phoenix("P2", false, 40, 20, 300);
        Phoenix p3 = new Phoenix("P3", true, 40, 20, 300);
        Kraken k1 = new Kraken("K1", true, 120, 120, 15);

        e1.addCreatures(d1, d2);
        av1.addCreatures(p1, p2, p3);
        aq1.addCreatures(k1);

        z1.addEnclosure(e1);
        assertEquals(2, z1.getNumberOfCreatures().get(), "Number of creatures in Zoo");

        z1.addEnclosure(av1);
        assertEquals(5, z1.getNumberOfCreatures().get(), "Number of creatures in Zoo");

        z1.addEnclosure(aq1);
        assertEquals(6, z1.getNumberOfCreatures().get(), "Number of creatures in Zoo");

        z1.addEnclosure(e1);
        assertEquals(3, z1.getEnclosureList().size(), "Number of enclosures in Zoo");
    }

    @Test
    public void testGetAllCreatures() {
        Master m1 = new Master("M1", true, 69);

        FantasticZoo z1 = new FantasticZoo("Z1", m1, 3);

        Enclosure e1 = new Enclosure("E1", "150x150", 2);
        Aviary av1 = new Aviary("AV1", "150x150", 3, 250);
        Aquarium aq1 = new Aquarium("AQ1", "150x150", 1, 15, 15.0);

        Dragon d1 = new Dragon("D1", true, 560, 450, 666);
        Dragon d2 = new Dragon("D2", false, 320, 350, 333);
        Phoenix p1 = new Phoenix("P1", true, 40, 20, 300);
        Phoenix p2 = new Phoenix("P2", false, 40, 20, 300);
        Phoenix p3 = new Phoenix("P3", true, 40, 20, 300);
        Kraken k1 = new Kraken("K1", true, 120, 120, 15);

        e1.addCreatures(d1, d2);
        av1.addCreatures(p1, p2, p3);
        aq1.addCreatures(k1);

        z1.addEnclosure(e1);
        assertEquals(2, z1.getAllCreatures().size(), "Number of creatures in zoo");
        assertTrue(z1.getAllCreatures().contains(d1));
        assertTrue(z1.getAllCreatures().contains(d2));

        z1.addEnclosure(av1);
        assertEquals(5, z1.getAllCreatures().size(), "Number of creatures in zoo");
        assertTrue(z1.getAllCreatures().contains(d1));
        assertTrue(z1.getAllCreatures().contains(d2));
        assertTrue(z1.getAllCreatures().contains(p1));
        assertTrue(z1.getAllCreatures().contains(p2));
        assertTrue(z1.getAllCreatures().contains(p3));

        z1.addEnclosure(aq1);
        assertEquals(6, z1.getAllCreatures().size(), "Number of creatures in zoo");
        assertTrue(z1.getAllCreatures().contains(d1));
        assertTrue(z1.getAllCreatures().contains(d2));
        assertTrue(z1.getAllCreatures().contains(p1));
        assertTrue(z1.getAllCreatures().contains(p2));
        assertTrue(z1.getAllCreatures().contains(p3));
        assertTrue(z1.getAllCreatures().contains(k1));
    }
}
