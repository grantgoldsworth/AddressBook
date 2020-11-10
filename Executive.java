/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 14:08 8 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * Executive Class
 */

import java.util.*;

public class Executive extends Contact {
    private int directReports;
    private int indirectReports;

    /**
     * Constructor that takes arguments for {@code Contact} as well as the {@code Executive} object's direct and indirect reports.
     * @param firstName first name of contact
     * @param lastName last name of contact
     * @param email contact's email address
     * @param telephoneNumber contact's primary phone number
     * @param id contact's employee ID number, as a {@code String}
     * @param hireDate {@code java.util.Date} object for when employee was hired
     * @param directReports number of directly reporting people for manager
     * @param indirectReports number of indirectly reporting people
     * @throws Exception if any {@code String} parameter is empty or {@code null}, and if any report is negative.
     */
    public Executive(String firstName, String lastName, String email, String telephoneNumber, String id, Date hireDate, int directReports, int indirectReports) 
        throws Exception {
        super(firstName, lastName, email, telephoneNumber, id, hireDate);
        setDirectReports(directReports);
        setIndirectReports(indirectReports);
    }

    /**
     * Returns the number of directly reporting people for Executive
     * @return number of direct reports
     */
    public int getDirectReports() {
        return this.directReports;
    }

    /**
     * Sets the number of direct reports for the executive
     * @param directReports number of direct reports
     * @throws Exception if {@code directReports} is negative
     */
    public void setDirectReports(int directReports) throws Exception {
        if (directReports < 0)
            throw new Exception("directReports cannot be less than 0.");
        this.directReports = directReports;
    }

    /**
     * Returns the number of indirect reports for the executive
     * @return indirect reports
     */
    public int getIndirectReports() {
        return this.indirectReports;
    }
    
    /**
     * Sets the number of indirect reports for the executive
     * @param directReports number of indirect reports
     * @throws Exception if {@code indirectReports} is negative
     */
    public void setIndirectReports(int indirectReports) throws Exception {
        if (directReports < 0)
            throw new Exception("directReports cannot be less than 0.");

        this.indirectReports = indirectReports;
    }

    /**
     * Compares to another object and returns true if identical by reference
     * or by member
     * @param o Other object to compare to
     * @return true if identical reference or same number of indirect/direct reports
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Executive)) {
            return false;
        }
        Executive executive = (Executive) o;
        return directReports == executive.directReports && indirectReports == executive.indirectReports;
    }

    /**
     * Returns hash codes for {@code directReports, indirectReports}
     */
    @Override
    public int hashCode() {
        return Objects.hash(directReports, indirectReports);
    }

    /**
     * Returns a textual representation of the object.
     * @return String representation of the object, including data from {@code Contact}
     */
    @Override
    public String toString() {
        return super.toString() + 
            ", directReports='" + getDirectReports() + "'" +
            ", indirectReports='" + getIndirectReports();
    }


    /**
     * Returns the role.
     * @return string "Executive"
     */
    @Override
    public String getRole() {
        return "Executive";
    }
}
