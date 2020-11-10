/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 14:08 8 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * Manager Class
 */

import java.sql.Date;
import java.util.*;

/**
 * Class to implement a Manager from a {@code Contact}.
 * <p> A {@code Manager} has a number of direct reports, represented by
 * field {directReports}.
 */
public class Manager extends Contact {
    private int directReports;

    /**
     * Constructor that takes arguments for {@code Contact} as well as the {@code Manager} object's direct reports number.
     * @param firstName first name of contact
     * @param lastName last name of contact
     * @param email contact's email address
     * @param telephoneNumber contact's primary phone number
     * @param id contact's employee ID number, as a {@code String}
     * @param hireDate {@code java.util.Date} object for when employee was hired
     * @param directReports number of directly reporting workers for manager
     * @throws Exception if any {@code String} parameter is empty or {@code null} and if reports is less than 0.
     */
    public Manager(String firstName, String lastName, String email, String telephoneNumber, String id, Date hireDate, int directReports) 
    throws Exception 
    {
        super(firstName, lastName, email, telephoneNumber, id, hireDate);
        setDirectReports(directReports);
    }

    /**
     * Returns the manager's direct reports
     * @return direct reports
     */
    public int getDirectReports() {
        return this.directReports;
    }

    /**
     * Set direct reports of the manager
     * @param directReports 
     */
    public void setDirectReports(int directReports) throws Exception {
        if (directReports < 0)
            throw new Exception("Error: directReports cannot be less than 0.");
        this.directReports = directReports;
    }

    /**
     * Tests for equality with another {@code Manager} object.
     * @param o other manager
     * @return {@code true} if identical manager (same direct reports), false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)  // same reference?
            return true;
        if (!(o instanceof Manager)) {  // not a manager?
            return false;
        }
        // compare memberwise
        Manager manager = (Manager) o;
        return directReports == manager.directReports;
    }

    /**
     * Return the hash code for the direct reports
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(directReports);
    }

    /**
     * Convert the {@code Manager} object into textual format
     * @return string representation of manager (includes {@code Contact} information)
     */
    @Override
    public String toString() {
        return String.format("{0}, direct reports: {1}", super.toString(), getDirectReports());
    }


    /**
     * Return the role
     * @return the string "Manager"
     */
    @Override 
    public String getRole() {
        return "Manager";
    }

}
