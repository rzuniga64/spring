package com.spring.propertymaps;

import com.spring._01_intro.Animal;

import java.util.HashMap;
import java.util.Map;

/**
 *  JungleFoods class.
 *  Implementing equals and hashcode allows object to be used as a key in map.
 */
public class JungleFoods {

    /** A food map with key and value as Strings. */
    private Map<String, String> foods = new HashMap<String, String>();

    /** A animals map with key as String and value as Animal type. */
    private Map<String, Animal> animals = new HashMap<String, Animal>();

    /**
     *  Set the map of foods.
     *  @param newFoods newFoods
     */
    public void setFoods(final Map<String, String> newFoods) {
        this.foods = newFoods;
    }

    /**
     *  Set the map of animals.
     *  @param newAnimals newAnimals
     */
    public void setAnimals(final Map<String, Animal> newAnimals) {
        this.animals = newAnimals;
    }

    /**
     *  toString method.
     *  @return data as a String.
     */
    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry: this.foods.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        sb.append("\n");

        for (Map.Entry<String, Animal> entry: animals.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }

        return sb.toString();
    }
}
