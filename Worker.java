/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 11:15 10 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * Worker class
 */


import java.util.Date;
import utilities.DataValidation;

/**
 * Class to implement a Worker from {@code Contact}.
 * <p> A {@code Worker} has a department that they are enlisted in.
 */
public class Worker extends Contact {

    private String department;

    /**
     * Constructor that takes arguments for {@code Contact} as well as the {@code Worker} object's department
     * @param firstName first name of contact
     * @param lastName last name of contact
     * @param email contact's email address
     * @param telephoneNumber contact's primary phone number
     * @param id contact's employee ID number, as a {@code String}
     * @param hireDate {@code java.util.Date} object for when employee was hired
     * @param department the worker's department
     * @throws Exception if any {@code String} parameter is empty
     */
    public Worker(String firstName, String lastName, String email, String telephoneNumber, String id, Date hireDate, String department) 
        throws Exception
    {
        super(firstName, lastName, email, telephoneNumber, id, hireDate);
        setDepartment(department);
    }

    /**
     * Returns the worker's department
     * @return string of department
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Set the department of the worker.
     * @param department string of new department
     * @throws Exception if {@code department} is empty or {@code null}
     */
    public void setDepartment(String department) throws Exception {
        DataValidation.ensureValidString("Department", department);
        this.department = department;
    }

    /**
     * Returns textual representation of the object.
     * @return string representation of object, including data from {@code Contact}
     */
    @Override
    public String toString() {
        return 
            super.toString() + ", department='" + getDepartment() + "'";
    }

    /**
     * Returns the role.
     * @return string "Worker"
     */
    @Override
    public String getRole() {
        return "Worker";
    }
    
}
