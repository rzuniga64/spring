package com.spring._01_intro;

import java.util.List;

/**
 *  FruitBasket class.
 */
public class FruitBasket {

    /** Name. */
    private String name;
    /** List of fruits. */
    private List<String> fruits;

    /** Default constructor. */
    public FruitBasket() { }

    /**
     *  Constructor.
     * @param newName newName
     * @param newFruits newFruits
     */
    public FruitBasket(final String newName, final List<String> newFruits) {
        this.name = newName;
        this.fruits = newFruits;
    }

    /**
     *  toString method.
     *  @return data as a string
     */
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" contains:\n");

        for (final String fruit: fruits) {
            sb.append(fruit);
            sb.append("\n");
        }

        return sb.toString();
    }
}
