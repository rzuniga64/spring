package com.spring.models;

/**
 *  Offer class.
 */
public final class Offer {

    /** ID. */
    private int id;
    /** Name. */
    private String name;
    /** Email. */
    private String email;
    /** Text. */
    private String text;

    /** Default Constructor. */
    public Offer() { }

    /**
     * Constructor.
     *  @param newId newId
     *  @param newName newName
     *  @param newEmail newEmail
     *  @param newText newText
     */
    public Offer(final int newId, final String newName,
                 final String newEmail, final String newText) {

        this.id = newId;
        this.name = newName;
        this.email = newEmail;
        this.text = newText;
    }

    /**
     * Constructor.
     *  @param newName newName
     *  @param newEmail newEmail
     *  @param newText newText
     */
    public Offer(final String newName, final String newEmail,
                  final String newText) {
        this.name = newName;
        this.email = newEmail;
        this.text = newText;
    }

    /**
     * Get the id.
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     *  Set the id.
     * @param newId newId
     */
    public void setId(final int newId) {
        this.id = newId;
    }

    /**
     *  Get the name.
     *  @return the name
     */
    public String getName() {
        return name;
    }

    /**
     *  Set the name.
     *  @param newName newName
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     *  Get the email.
     *  @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email.
     * @param newEmail newEmail
     */
    public void setEmail(final String newEmail) {
        this.email = newEmail;
    }

    /**
     *  Get the text.
     * @return the text.
     */
    public String getText() {
        return text;
    }

    /**
     *  Set text.
     *  @param newText newText
     */
    public void setText(final String newText) {
        this.text = newText;
    }

    /**
     * toString method.
     * @return data as a String.
     */
    @Override
    public String toString() {
        return "Offer [id=" + id + ", name=" + name + ", email=" + email
                + ", text=" + text + "]";
    }
}
