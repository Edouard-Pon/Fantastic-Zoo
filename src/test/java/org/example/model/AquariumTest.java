package org.example.model;

import org.example.model.creatures.Dragon;
import org.example.model.creatures.Kraken;
import org.example.model.spaces.Aquarium;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AquariumTest {
    @Test
    public void testAddCreatures() {
        Dragon d1 = new Dragon("D1", true, 450, 350, 250);
        Dragon d2 = new Dragon("D2", false, 450, 350, 250);
        Kraken k1 = new Kraken("K1", true, 150, 125, 100);
        Kraken k2 = new Kraken("K2", false, 150, 125, 100);
        Kraken k3 = new Kraken("K3", false, 150, 125, 100);
        Kraken k4 = new Kraken("K4", false, 150, 125, 100);

        Aquarium a1 = new Aquarium("A1", "150x150", 3, 150, 25.0);

        a1.addCreatures(k1, d1, k2, d2);

        assertEquals(k1.getClass().getName(), a1.getCreaturesList().get(0).getClass().getName(), "Creature Type");
        assertEquals(2, a1.getNumberOfCreatures());
        assertTrue(a1.getCreaturesList().contains(k1));
        assertTrue(a1.getCreaturesList().contains(k2));

        a1.addCreatures(d1, k3, k4);

        assertEquals(k1.getClass().getName(), a1.getCreaturesList().get(0).getClass().getName(), "Creature Type");
        assertEquals(3, a1.getNumberOfCreatures());
        assertTrue(a1.getCreaturesList().contains(k1));
        assertTrue(a1.getCreaturesList().contains(k2));
        assertTrue(a1.getCreaturesList().contains(k3));
    }
}
