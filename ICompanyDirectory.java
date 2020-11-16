/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 11:15 10 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * ICompanyDirectory Interface
 */


import java.util.ArrayList;

public interface ICompanyDirectory {
    void addContact(Contact contact) throws Exception;
    void removeContact(String id);
    Contact getContact(String id);
    ArrayList<Contact> searchContact(String criteria);
}