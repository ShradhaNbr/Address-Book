import java.util.List;

public class AddressBook {
    public enum  IOService{
        DB_IO
    }
    private final AddressBookDB addressBookDB;
    private List<Contact> contacts;

    public AddressBook() {
        addressBookDB = AddressBookDB.getInstance();
    }
    public List<Contact> readPersonInfoData(IOService ioService) {
        if(ioService.equals(IOService.DB_IO))
            this.contacts = addressBookDB.readData();
        return this.contacts;
    }

    public void updateContact(String name, String address) {
        int result = addressBookDB.updateContact(name, address);
        if (result == 0)
            return;
        Contact contacts = this.getcontacts(name);
        if (contacts != null)
            contacts.address = address;
    }

    private Contact getcontacts(String name) {
        return this.contacts.stream()
                    .filter(Contact -> Contact.firstName.equals(name))
                    .findFirst()
                    .orElse(null);
    }

    public boolean checkPersonInfoInSyncWithDB(String name) {
        List<Contact> personInfoDataList = addressBookDB.getPersonInfoData(name);
        return personInfoDataList.get(0).equals(addressBookDB.getPersonInfoData(name));
    }
    }



   