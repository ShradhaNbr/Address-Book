import java.util.List;

public class AddressBook {
    private final AddressBookDB addressBookDB;
    private List<Contact> contacts;

    public AddressBook() {
        addressBookDB = AddressBookDB.getInstance();
    }


    public enum IOService {
        DB_IO;
    }

    /**
     * * Purpose : To get the list of employee payroll from the database
     */
    public List<Contact> readDataFromContact(IOService ioService) {
        if (ioService.equals(IOService.DB_IO))
            this.contacts = addressBookDB.readData();
        return this.contacts;
    }
}