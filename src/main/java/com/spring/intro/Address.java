package com.spring.intro;

/**
 * Address class.
 */
public class Address {

    /** Street. */
    private String street;

    /** Post code. */
    private String postcode;

    /** Default constructor. */
    public Address() { }

    /**
     * Default constructor.
     * @param newStreet new street
     * @param newPostcode new postcode

     */
    public Address(final String newStreet, final String newPostcode) {
        this.street = newStreet;
        this.postcode = newPostcode;
    }

    /** Global bean init method specified in the bean.xml. */
    public void init() {
        System.out.println("Bean created: " + this);
    }

    /** toString method. */

    @Override
    public String toString() {
        return "Address{" + "street = '" + street + '\'' + ", postcode = '"
                + postcode + '\'' + '}';
    }

    /**
     *  Set the street.
     *  @param newStreet newStreet
     */
    public void setStreet(final String newStreet) {
        this.street = newStreet;
    }

    /**
     *  Set the post code.
     *  @param newPostcode newPostcode
     */
    public void setPostcode(final String newPostcode) {
        this.postcode = newPostcode;
    }
}
