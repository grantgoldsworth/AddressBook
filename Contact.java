/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 11:15 10 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * Contact class
 */


import java.util.Date;
import java.util.Objects;

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
    private Date hireDate;

    public Contact(String firstName, String lastName, String email, String telephoneNumber, String id, Date hirDate)
            throws Exception {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
        setTelephoneNumber(telephoneNumber);
        setId(id);
        setHireDate(hireDate);
    }

    public abstract String getRole();

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) throws Exception {
        DataValidation.ensureValidDate("HireDate", hireDate);
        this.hireDate = hireDate;
    }

    public String getFullName() {
        return getLastName() + ", " + getFirstName();
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) throws Exception {
        DataValidation.ensureValidString("FirstName", firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) throws Exception {
        DataValidation.ensureValidString("LastName", lastName);
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) throws Exception {
        DataValidation.ensureValidString("Email", email);
        this.email = email;
    }

    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) throws Exception {
        DataValidation.ensureValidString("Telephone", telephoneNumber);
        this.telephoneNumber = telephoneNumber;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) throws Exception {
        DataValidation.ensureValidString("Id", id);
        this.id = id;
    }

    
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Contact))
            return false;
        
        Contact contact = (Contact) o;
        return id.equalsIgnoreCase(contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return
            " firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", telephoneNumber='" + getTelephoneNumber() + "'" +
            ", id='" + getId() + "'";
    }

    @Override
    public int compareTo(Contact o) {
        if (getId().equalsIgnoreCase(o.getId()))
            return 0;
        
        return getFullName().compareTo(o.getFullName());
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        Contact copy = (Contact) super.clone();
        copy.hireDate = (Date) this.hireDate.clone();
        return copy;
    }




}
