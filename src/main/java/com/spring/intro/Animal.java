package com.spring.intro;

/**
 *  Animal class.
 */
public class Animal {

    /** Name. */
    private String name;
    /** Type. */
    private String type;

    /**
     * equals method.
     * @param o object
     * @return true if objects are equal; false otherwise
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Animal animal = (Animal) o;

        if (!name.equals(animal.name)) {
            return false;
        }
        return type.equals(animal.type);
    }

    /**
     * hashcode method.
     * @return hash
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }

    /**
     *  Get the name.
     *  @return name
     */
    public String getName() {
        return name;
    }

    /**
     *  Set the name.
     *  @param newName name
     *  */
    public void setName(final String newName) {
        this.name = name;
    }

    /**
     *  Get the type.
     *  @return the type.
     */
    public String getType() {
        return type;
    }

    /**
     *  Set the type.
     *  @param newType type
     */
    public void setType(final String newType) {
        this.type = newType;
    }

    /**
     *  toString method.
     *  @return data as a String
     */
    @Override
    public String toString() {
        return "Animal [name=" + name + ", type=" + type + "]";
    }
}
