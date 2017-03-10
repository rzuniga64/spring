package com.spring.intro;

import java.util.List;

/**
 *  JungleFoods class.
 */
public class Jungle {

    /** Largest animal. */
    private Animal largest;
    /** List of animals. */
    private List<Animal> animals;

    /**
     * Get the largest animal.
     * @return the largest animal
     */
    public Animal getLargest() {
        return largest;
    }

    /**
     * Set the largest animal.
     * @param newLargest largest animal
     */
    public void setLargest(final Animal newLargest) {
        this.largest = newLargest;
    }

    /**
     *  Get the list of animals.
     * @return the list of animals.
     */
    public List<Animal> getAnimals() {
        return animals;
    }

    /**
     *  Set the list of animals.
     * @param newAnimals animals
     */
    public void setAnimals(final List<Animal> newAnimals) {
        this.animals = newAnimals;
    }

    /**
     *  toString method.
     * @return data as a String
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("Largest: " + this.getLargest());
        sb.append("\n");
        sb.append("Others:\n");

        for (Animal animal: this.getAnimals()) {
            sb.append(animal);
            sb.append("\n");
        }

        return sb.toString();
    }
}
