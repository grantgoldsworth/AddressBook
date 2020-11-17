
/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 14:36 10 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * AddressBook Class - main demonstration method
 */

import java.io.File;
import java.util.*;

/**
 * Contains main() to run the entire project
 */
public class AddressBook {
    public static void main(String[] args) throws Exception {
        File dataFile = new File("data.dat");
        // create new directory
        ArrayListDirectory directory = new ArrayListDirectory(dataFile);

        Contact manager1 = new Manager("Joe", "Manager", "joe@company.com", "9490000000", "1237653", new GregorianCalendar(), 3);

        directory.addContact(manager1);
        directory.writeToFile();

        ArrayListDirectory directory2 = new ArrayListDirectory(dataFile);
        directory2.readFromFile(true);
        System.out.print(directory2.getDisplay());
    }    
}
