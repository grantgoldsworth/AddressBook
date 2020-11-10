/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 11:15 10 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * Contact class
 */


import java.util.*;
import utilities.DataValidation;

/**
 * Abstract class to implement a Contact, with information about
 * contact's name, email, phone number, ID number, and hiring date. 
 * <p> A method to return role of contact must be implemented by any subclasses of {@code Contact}.
 * <p> {@code Contact} objects are comparable on terms of {@code id} ({@code 0} if identical), or by full name. 
 * <p> {@code Contact} objects are cloneable.
 */
public abstract class Contact implements Comparable<Contact>, Cloneable {
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private String id;
    private Calendar hireDate;

    /**
     * Constructor that takes parameters for Contact's name, email, telephone number, unique ID, and hire date.
     * @param firstName a string, first name
     * @param lastName a string, last name
     * @param email a string, email address
     * @param telephoneNumber a string, hyphens optional
     * @param id a string, must be unique to each contact in directory
     * @param hDate a Calendar object representing date of hiring
     * @throws Exception if any String parameters are empty or null, or if hire date is before Jan 1 2000
     */
    public Contact(String firstName, String lastName, String email, String telephoneNumber, String id, Calendar hDate)
            throws Exception {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setTelephoneNumber(telephoneNumber);
        setId(id);
        setHireDate(hDate);
    }

    /**
     * Abstract method that returns the contact's role within their directory
     * @return a string representation of role
     */
    public abstract String getRole();

    /**
     * Returns reference to the contact's hire date
     * @return a {@code Calendar} reference
     */
    public Calendar getHireDate() {
        return hireDate;
    }

    /**
     * Sets {@code hireDate} to the {@code Calendar} parameter passed.
     * @param hireDate new hire date
     * @throws Exception if {@code hireDate} is null or before January 1 2000
     */
    public void setHireDate(Calendar hireDate) throws Exception {
        DataValidation.ensureValidDate("hDate", hireDate);
        this.hireDate = hireDate;
    }

    /**
     * Returns the full name of the contact, in format {@code lastName, firstName}.
     * @return a String, full name of contact
     */
    public String getFullName() {
        return getLastName() + ", " + getFirstName();
    }

    /**
     * Returns contact's first name
     * @return a string
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets contact's first name
     * @param firstName a String
     * @throws Exception if {@code firstName} is empty or {@code null}
     */
    public void setFirstName(String firstName) throws Exception {
        DataValidation.ensureValidString("FirstName", firstName);
        this.firstName = firstName;
    }

    /**
     * Returns the contact's last name
     * @return a String
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Set the contact's last name
     * @param lastName a String
     * @throws Exception if {@code lastName} is empty or {@code null}
     */
    public void setLastName(String lastName) throws Exception {
        DataValidation.ensureValidString("LastName", lastName);
        this.lastName = lastName;
    }

    /**
     * Returns contact's email address
     * @return a String
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the contact's email address
     * @param email a String
     * @throws Exception if {@code email} is empty or {@code null}
     */
    public void setEmail(String email) throws Exception {
        DataValidation.ensureValidString("Email", email);
        this.email = email;
    }

    /**
     * Returns contact's telephone number
     * @return a string
     */
    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    /**
     * Sets the contact's telephone number.
     * @param telephoneNumber a String
     * @throws Exception if {@code telephoneNumber} is empty or {@code null}
     */
    public void setTelephoneNumber(String telephoneNumber) throws Exception {
        DataValidation.ensureValidString("Telephone", telephoneNumber);
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Returns the contact's Id
     * @return a String
     */
    public String getId() {
        return this.id;
    }

    /**
     * Set the contact's ID.
     * <p> NOTE: this method does not check for uniqueness of the ID within
     * any directory the Contact is in.
     * @param id a String
     * @throws Exception if {@code id} is empty or {@code null}
     */
    public void setId(String id) throws Exception {
        DataValidation.ensureValidString("Id", id);
        this.id = id;
    }

    /**
     * {@code equals} method override. 
     * <p> Checks for equality first on basis of reference, then by ID.
     * If other object is not a {@code Contact}, returns {@code false}.
     * @param o other {@code Object}
     * @return a boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Contact))
            return false;
        
        Contact contact = (Contact) o;
        return id.equalsIgnoreCase(contact.id);
    }

    /**
     * Returns a hash of the id.
     * @return an integer
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Returns a textual representation of the {@code Contact}.
     * Includes name, email, phone, id, and hire date (format M/D/YYYY).
     */
    @Override
    public String toString() {
        String hireInfo = (1 + hireDate.get(Calendar.MONTH)) + "/" + hireDate.get(Calendar.DATE) + "/" + hireDate.get(Calendar.YEAR);
        return
            "firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", telephoneNumber='" + getTelephoneNumber() + "'" +
            ", id='" + getId() + "'" + 
            ", hire date='" + hireInfo + "'";
    }

    /**
     * Compare to another {@code Contact} and return an integer based on result.
     * <p> Checks for equality of IDs and returns 0 id identical IDs. Otherwise, 
     * compares full names and returns 1 if caller is greater, 0 if equal, and -1 if less than.
     * @return an integer 1, 0, or -1
     */
    @Override
    public int compareTo(Contact o) {
        if (getId().equalsIgnoreCase(o.getId()))
            return 0;
        
        return getFullName().compareTo(o.getFullName());
    }

    /**
     * Creates and returns a clone of the object.
     * @return a clone of the {@code Contact}. {hireDate} field is cloned as well.
     * @throws CloneNotSupportedException if cloning isn't supported among member fields.
     */
    @Override
    public Object clone() throws CloneNotSupportedException
    {
        Contact copy = (Contact) super.clone();
        copy.hireDate = (Calendar) this.hireDate.clone();
        return copy;
    }




}
