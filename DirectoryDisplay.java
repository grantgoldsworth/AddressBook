/**
 * Grant Goldsworth 1164709 
 * CS4A 
 * Last Modified 11:15 10 November 2020 
 * Address Book OOP Project 
 * ------------------------------------------------ 
 * DirectoryDisplay interface
 */


import java.util.Comparator;

/**
 * Directories that implement this interface must override the {@code String getDisplay()} method,
 * intended to create an easy to read display of the directory's contents as a String.
 */
public interface DirectoryDisplay {
    String getDisplay();
}
