package org.example.model.groups;

import org.example.model.creatures.Lycanthrope;

import java.util.ArrayList;
import java.util.List;

public class LycanthropePack {

    private Lycanthrope alphaMale;
    private Lycanthrope alphaFemale;
    private List<Lycanthrope> members;

    public LycanthropePack(Lycanthrope alphaMale, Lycanthrope alphaFemale) {
        this.alphaMale = alphaMale;
        this.alphaFemale = alphaFemale;
        this.members = new ArrayList<>();
        initializePackHierarchy();
    }

    private void initializePackHierarchy() {
        alphaMale.setRank('α');
        alphaFemale.setRank('α');
    }

    public void addLycanthrope(Lycanthrope lycanthrope) {
        members.add(lycanthrope);
    }

    public void removeLycanthrope(Lycanthrope lycanthrope) {
        members.remove(lycanthrope);
    }

    public void displayPackCharacteristics() {
        System.out.println("Pack Characteristics:");
        System.out.println("Alpha Male: " + alphaMale.getName());
        System.out.println("Alpha Female: " + alphaFemale.getName());
        System.out.println("Members:");
        for (Lycanthrope member : members) {
            System.out.println("- " + member.getName());
        }
    }

    public void createNewHierarchy(List<Lycanthrope> newHierarchy) {
        members.clear();
        members.addAll(newHierarchy);
        initializePackHierarchy();
    }

    public void reproduce() {
        // TODO Implement the reproduction logic for the pack
    }

    public void decreaseRanksNaturally() {
        // TODO Implement the logic to decrease ranks naturally over time
    }

    public void declareOmegas() {
        // TODO Implement the logic to declare omegas within the pack
    }
}
