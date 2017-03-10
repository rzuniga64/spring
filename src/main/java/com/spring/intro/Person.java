package com.spring.intro;

/** Person class. */
public class Person {

    /** ID. */
    private int id;

    /** Name. */
    private String name;

    /** taxId. */
    private int taxId;

    /** Address. */
    private Address address;

    /** Default constructor. */
    public Person() { }

    /**
     * Constructor.
     * @param newId new id
     * @param newName new name
     */
    public Person(final int newId, final String newName) {
        this.id = newId;
        this.name = newName;
    }

    /**
     *  Factor bean method getInstance.
     *  A factory method in a bean must be static.
     *  We can tell the bean.XML file to use this factory method to construct
     *  this Person bean instead of the constructor.
     * @param newId newId
     * @param newName newName
     * @return Person object
     */
    public static Person getInstance(final int newId, final String newName) {
        System.out.println("Creating Person using factory method.");
        return new Person(newId, newName);
    }

    /**
     * Set the tax id.
     * @param newTaxId newTaxId
     */
    public void setTaxId(final int newTaxId) {
        this.taxId = newTaxId;
    }

    /**
     * Set address.
     * @param newAddress address.
     */
    public void setAddress(final Address newAddress) {
        this.address = newAddress;
    }

    /** init method is a lifecycle method. */
    public void onCreate() {
        System.out.println("Person created: " + this);
    }

    /** destroy method is a lifecycle method. If bean scope is set to prototype
     *  then the destroy method is not automatically run. It will fun if
     *  scope is set to singleton. */
    public void onDestroy() {
        System.out.println("Person destroyed");
    }

    /** toString method. */
    @Override
    public String toString() {
        return "Person{"
                + "id = " + id
                + ", name = '" + name + '\''
                + ", taxId = " + taxId
                + ", address = " + address + '}';
    }
}
