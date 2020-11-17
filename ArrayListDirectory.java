/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 14:36 10 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * ArrayListDirectory class
 */


import java.util.ArrayList;
import java.io.*;

/**
 * Implements a Company directory using ArrayLists to manage {@code Contacts}.
 * <p> This class implements the {@code ICompanyDirectory} and {@code DirectoryDisplay} interfaces.
 */
public class ArrayListDirectory implements ICompanyDirectory, DirectoryDisplay {
    private ArrayList<Contact> allContacts;
    private ArrayList<Contact> workers;
    private ArrayList<Contact> managers;
    private ArrayList<Contact> executives;
    File dataFile;

    /**
     * Default constructor. Creates an empty list
     * of all contacts, and empty lists for the workers, managers, and
     * executives in the list.
     */
    public ArrayListDirectory(File file) {
        allContacts = new ArrayList<>();
        workers     = new ArrayList<>();
        managers    = new ArrayList<>();
        executives  = new ArrayList<>();
        dataFile = file;
    }

    public void writeToFile() throws Exception {
        // write contacts to file
        try 
        (
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(dataFile));
        )
        {
            output.writeObject(allContacts);
        }
    }


    public void readFromFile(boolean overwrite) throws Exception {
        // read contacts from a file 
        try (
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(dataFile));
        )
        {

            Object readObj = input.readObject();

            if (readObj instanceof ArrayList<?>) {
                ArrayList<Contact> readList = (ArrayList<Contact>) readObj;
                if(overwrite) {
                    allContacts = readList;
                }
                else {
                    for (int i = 0; i < readList.size(); i++) {
                        try 
                        {
                            addContact(readList.get(i));
                        }
                        catch (Exception ex)
                        {
                            // pass
                        }
                    }
                }
            }
            else {
                throw new Exception(String.format("Data read from file '%s' is not compatible!", dataFile.getName()));
            }


        }

    }

    /**
     * Add a {@code Contact} object to the list. New contact must be unique on basis of {@code id}.
     * @param contact the contact to add to the list, will be automatically added
     * to appropriate sublist as well. 
     * @throws Exception if desired contact to add is already in the lists.
     */
    @Override
    public void addContact(Contact contact) throws Exception {
        if (allContacts.contains(contact))
            throw new Exception(String.format("Contact with id = {0} already exists", contact.getId()));
        
            // add to master list
        allContacts.add(contact);

        // if worker, add to worker list
        if (contact instanceof Worker)
            workers.add(contact);

        // if manager, add to manager list
        else if (contact instanceof Manager)
            managers.add(contact);

        // if executive, add to executive list
        else
            executives.add(contact);
    }

    /**
     * Remove a contact from the list using the contact's {@code id}.
     * @param id the unique id of contact to remove.
     */
    @Override
    public void removeContact(String id) {
        for (int i = 0; i < allContacts.size(); i++)
            if (allContacts.get(i).getId().equalsIgnoreCase(id)) {
                allContacts.remove(i);
                break;
            }
    }

    /**
     * Returns the {@code Contact} from the list by specified {@code id}. If not in the list,
     * returns {@code null} reference.
     * @param id the id to search for contact by
     * @return the contact with specified id or {@code null}
     */
    @Override
    public Contact getContact(String id) {
        for (Contact c : allContacts)
            if (c.getId().equalsIgnoreCase(id))
                return c;
        
        return null;
    }

    /**
     * Search for contact(s) by a criteria. If the {@code toString()} method
     * of a contact contains the specified criteria, it is added to the
     * {@code ArrayList} that is returned. 
     * @param criteria the search criteria to use for matches
     * @return {@code ArrayList} of {@code Contact} objects that match specified criteria
     */
    @Override
    public ArrayList<Contact> searchContact(String criteria) {
        
        // create list to hold matches
        ArrayList<Contact> matchingItems = new ArrayList<>();

        // iterate through list and obtain matches
        for (int i = 0; i < allContacts.size(); i++) {
            Contact next = allContacts.get(i);
            // if toString() contains criteria, add to match list
            if (next.toString().contains(criteria))
                matchingItems.add(next);        
        }

        return matchingItems;
    }


    /**
     * Returns a String that represents a display of the entire directory.
     * @return a string presentation of the directory.
     */
    @Override
    public String getDisplay() {
        // use StringBuilder to be mroe efficient with appending
        StringBuilder sb = new StringBuilder();
        sb.append("DIRECTORY\n");
        sb.append("--------\n");

        // add each contact's toString()
        for (Contact c : allContacts) {

            sb.append(c.toString());
            sb.append("\n\n");
        }

        sb.append("-------");

        return sb.toString();
    }

    /**
     * Return a String that represents a list of all workers in the directory
     * @return a string with information from all workers in list
     */
    public String getWorkerDisplay() {
            // use StringBuilder to be mroe efficient with appending
            StringBuilder sb = new StringBuilder();
            sb.append("DIRECTORY - WORKERS\n");
            sb.append("--------\n");
    
            // add each contact's toString()
            for (Contact c : workers) {
    
                sb.append(c.toString());
                sb.append("\n\n");
            }
    
            sb.append("-------");
    
            return sb.toString();
    }

    /**
     * Return a String that represents a list of all managers in the directory
     * @return a string with information from all managers in list
     */
    public String getManagerDisplay() {
        // use StringBuilder to be mroe efficient with appending
        StringBuilder sb = new StringBuilder();
        sb.append("DIRECTORY - MANAGERS\n");
        sb.append("--------\n");

        // add each contact's toString()
        for (Contact c : managers) {

            sb.append(c.toString());
            sb.append("\n\n");
        }

        sb.append("-------");

        return sb.toString();
    }

    /**
     * Return a String that represents a list of all executives in the directory
     * @return a string with information from all executives in list
     */
    public String getExecutiveDisplay() {
        // use StringBuilder to be mroe efficient with appending
        StringBuilder sb = new StringBuilder();
        sb.append("DIRECTORY - EXECUTIVES\n");
        sb.append("--------\n");

        // add each contact's toString()
        for (Contact c : executives) {

            sb.append(c.toString());
            sb.append("\n\n");
        }

        sb.append("-------");

        return sb.toString();
    }
    
}
