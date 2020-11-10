import java.util.ArrayList;

public interface ICompanyDirectory {
    void addContact(Contact contact) throws Exception;
    void removeContact(String id);
    Contact getContact(String id);
    ArrayList<Contact> searchContact(String criteria);
}