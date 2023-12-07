package org.example.model.creatures;

import org.example.model.abilities.Running;
import org.example.model.reproduction.Viviparous;

public class Lycanthrope extends Viviparous implements Running {

    private String ageCategory;
    private double impetuosityFactor;
    private int force;
    private int dominationFactor; // Change to int if it represents a discrete value
    private int rank;
    private String level;
    private String pack; // Represents the pack to which the lycanthrope belongs, or if it's solitary

    private static final String YOUNG = "Young";
    private static final String ADULT = "Adult";
    private static final String OLD = "Old";
    private static final String VERY_OLD = "Very old";
    public Lycanthrope(String name, boolean gender, float weight, float height, int age) {
        super(name, gender, weight, height, age);
    }

    public Lycanthrope(String name, boolean gender, float weight, float height, int age, int force, int dominationFactor, int rank,
                       double impetuosityFactor, String pack) {
        super(name, gender, weight, height, age);
        this.ageCategory = calculateAgeCategory();
        this.force = force;
        this.dominationFactor = dominationFactor;
        this.impetuosityFactor = impetuosityFactor;
        this.rank = rank;
        this.pack = pack;
        this.level = calculateLevel();
    }
    public void displayCharacteristics() {
        System.out.println("Lycanthrope Characteristics:");
        System.out.println("Name: " + getName());
        System.out.println("Gender: " + (isGender() ? "Male" : "Female"));
        System.out.println("Age: " + getAge());
        System.out.println("Age Category: " + ageCategory);
        System.out.println("Force: " + force);
        System.out.println("Domination Factor: " + dominationFactor);
        System.out.println("Rank: " + rank);
        System.out.println("Level: " + level);
        System.out.println("Impetuosity Factor: " + impetuosityFactor);
        System.out.println("Pack: " + pack);
    }

    private String calculateLevel() {
        int ageBonus = switch (ageCategory) {
            case YOUNG, VERY_OLD -> 1;
            case ADULT -> 3;
            case OLD -> 2;
            default -> 0;
        };

        int levelValue = (force * 2) + (dominationFactor * 3) + ageBonus;

        // Define level categories based on the calculated value
        String level;
        if (levelValue <= 10) {
            level = "Low";
        } else if (levelValue <= 20) {
            level = "Medium";
        } else {
            level = "High";
        }
        return level;
    }

    private String calculateAgeCategory() {
        int age = this.getAge();
        if (age <= 18) {
            return YOUNG;
        } else if (age <= 40) {
            return ADULT;
        } else if (age <= 70) {
            return OLD;
        } else if (age <= 100) {
            return VERY_OLD;
        } else {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    public void attemptDomination(Lycanthrope target) {
        // Calculate the defending creature's power based on impetuosityFactor
        double defendingPower = target.force * (0.5 + (target.impetuosityFactor / 100.0) * 1.5);

        // Calculate the attacking creature's power based on impetuosityFactor
        double attackingPower = force * (0.5 + (impetuosityFactor / 100.0) * 1.5);

        if (attackingPower >= defendingPower && !target.isAlpha() || target.isOmega()) {
            System.out.println("Lycanthrope is attempting domination on " + target.getName());
            target.beDominanted(this);
            this.dominationFactor++;
            this.rank = target.rank;
        } else {
            System.out.println("Lycanthrope failed to dominate " + target.getName());
            target.beAggressive(this);
        }
    }

    private boolean isAlpha() {
        return rank == 'α';
    }
    private boolean isOmega() {
        return rank == 'ω';
    }

    private void beDominanted(Lycanthrope dominator) {
        System.out.println("Lycanthrope is being dominated by " + dominator.getName());
        this.dominationFactor--;
        this.rank = dominator.rank;
    }

    private void beAggressive(Lycanthrope aggressor) {
        System.out.println("Lycanthrope is aggressive towards " + aggressor.getName());
    }

    public void leavePack() {
        if (pack != null && !pack.isEmpty()) {
            System.out.println("Lycanthrope is leaving the pack.");
            pack = null; // Assuming null represents being solitary
        } else {
            System.out.println("Lycanthrope is already solitary.");
        }
    }

    public void joinPack(String pack) {
        if (this.pack == null || this.pack.isEmpty()) {
            System.out.println("Lycanthrope is joining the pack " + pack);
            this.pack = pack;
        } else {
            System.out.println("Lycanthrope is already part of a pack.");
        }
    }

    public void setRank(char rank) {
        this.rank = rank;
    }

    public int getForce() {
        return force;
    }
    public boolean isFemale() {
        return !super.isGender();
    }

    @Override
    public void run() {
        System.out.println("Lycanthrope is running");
    }
}

