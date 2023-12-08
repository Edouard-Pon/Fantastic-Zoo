package org.example.model.creatures;

import org.example.model.spaces.Enclosure;

import java.util.Random;

/**
 * CreatureFactory is a factory class that creates a new creature based on the type of creature and the two creatures
 * that are being bred.
 */
public class CreatureFactory {
    private Enclosure enclosure;
    private Random random;
    private String name;
    private boolean gender;
    private float weight;
    private float height;
    private int age;

    /**
     * Private constructor for CreatureFactory.
     * @return a new CreatureFactory object.
     */
    public static CreatureFactory getInstance() {
        return new CreatureFactory();
    }

    /**
     * Creates a new creature based on the type of creature and the two creatures that are being bred.
     * @param type the type of creature to be created.
     * @param firstCreature the first creature that is being bred.
     * @param secondCreature the second creature that is being bred.
     * @param enclosure the enclosure that the creature is being added to.
     * @return a new creature based on the type of creature and the two creatures that are being bred.
     */
    public Creature createCreature(String type, Creature firstCreature, Creature secondCreature, Enclosure enclosure) {
        this.random = new Random();
        this.enclosure = enclosure;
        generateCreatureData(firstCreature, secondCreature);
        return switch (type) {
            case "Dragon" -> new Dragon(name, gender, weight, height, age);
            case "Kraken" -> new Kraken(name, gender, weight, height, age);
            case "Lycanthrope" -> new Lycanthrope(name, gender, weight, height, age);
            case "Megalodon" -> new Megalodon(name, gender, weight, height, age);
            case "Nymph" -> new Nymph(name, gender, weight, height, age);
            case "Phoenix" -> new Phoenix(name, gender, weight, height, age);
            case "Siren" -> new Siren(name, gender, weight, height, age);
            case "Unicorn" -> new Unicorn(name, gender, weight, height, age);
            default -> throw new IllegalArgumentException("Invalid creature type: " + type);
        };
    }

    /**
     * Generates the data for the new creature based on the two creatures that are being bred.
     * @param firstCreature the first creature that is being bred.
     * @param secondCreature the second creature that is being bred.
     */
    private void generateCreatureData(Creature firstCreature, Creature secondCreature) {
        name = firstCreature.getName() + secondCreature.getName();
        for (Creature creature : enclosure.getCreaturesList()) {
            if (creature.getName().equals(name)) {
                name = name + "1";
                break;
            }
        }
        gender = random.nextBoolean();
        weight = (firstCreature.getWeight() + secondCreature.getWeight()) / 2;
        height = (firstCreature.getHeight() + secondCreature.getHeight()) / 2;
        age = 0;
    }
}
