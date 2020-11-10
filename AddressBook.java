/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 11:15 10 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * AddressBook Class - main demonstration method
 */

import java.util.*;

/**
 * Contains main() to run the entire project
 */
public class AddressBook {
    public static void main(String[] args) throws Exception {
        // create new directory
        ArrayListDirectory directory = new ArrayListDirectory();

        Contact manager1 = new Manager("Joe", "Manager", "joe@company.com", "9490000000", "1237653", new GregorianCalendar(), 3);

        directory.addContact(manager1);

        System.out.print(directory.getDisplay());
    }    
}
