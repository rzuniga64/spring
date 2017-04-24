package com.spring._01_intro;

/**
 * PersonFactory class.
 */
public class PersonFactory {

    /**
     * Create Person method. This method must be non-static in the factory.s
     * @param newId newId
     * @param newName newName
     * @return a Person
     */
    public Person createPerson(final int newId, final String newName) {

        System.out.println("Using factory to create person.");
        return new Person(newId, newName);
    }
}
