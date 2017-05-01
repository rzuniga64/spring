package com.spring.web.dao;

import com.spring.web.validators.ValidEmail;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/** User class. */
public class User {
    /** User name. */
    @NotBlank(message = "Username cannot be blank.")
    @Size(min = 8, max = 15, message = "Username must be between 8 and 15"
            + "characters long")
    @Pattern(regexp = "^\\w{8,}$", message = "Username can only consist of "
            + "numbers, letters and the underscore character.")
    private String username;

    /** Password. */
    @NotBlank(message = "Password cannot be blank.")
    @Pattern(regexp = "^\\S+$", message = "Password cannot contain spaces.")
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 "
            + "characters long.")
    private String password;

    /** Email. */
    private String email;
    /** enabled? */
    private boolean enabled = false;
    /** Authority. */
    private String authority;

    /** Constructor. */
    public User() { }

    /**
     * Constructor.
     * @param newUsername newUsername
     * @param newPassword newPassword
     * @param newEmail newEmail
     * @param newEnabled newEnabled
     * @param newAuthority newAuthority
     * */
    public User(final String newUsername,
                final String newPassword,
                final String newEmail,
                final boolean newEnabled,
                final String newAuthority) {
        this.username = newUsername;
        this.password = newPassword;
        this.email = newEmail;
        this.enabled = newEnabled;
        this.authority = newAuthority;
    }

    /**
     * getUsername.
     * @return user name
     */
    public String getUsername() {
        return username;
    }

    /**
     * setUserName.
     * @param newUsername newUsername
     */
    public void setUsername(final String newUsername) {
        this.username = newUsername;
    }

    /**
     * getPassword.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * setPassword.
     * @param newPassword newPassword
     */
    public void setPassword(final String newPassword) {
        this.password = newPassword;
    }

    /**
     * isEnabled?
     * @return true if enabled;false otherwise
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * setEnabled.
     * @param newEnabled newEnabled
     */
    public void setEnabled(final boolean newEnabled) {
        this.enabled = newEnabled;
    }

    /**
     * getAuthority.
     * @return authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * setAuthority.
     * @param newAuthority newAuthority
     */
    public void setAuthority(final String newAuthority) {
        this.authority = newAuthority;
    }

    /**
     * getEmail.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setEmail.
     * @param newEmail newEmail
     */
    public void setEmail(final String newEmail) {
        this.email = newEmail;
    }
}

