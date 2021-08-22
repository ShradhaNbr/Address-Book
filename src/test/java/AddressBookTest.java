import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {
    AddressBook addressBook ;
    private Assertions Assert;

    @Before
    public void setUp() throws Exception {
        addressBook = new AddressBook();
    }
    /**
     * Purpose : To test whether the number of records present in the database matches with the expected value
     */
    @Test
    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchContact() {
        List<Contact> contacts = addressBook.readDataFromContact(AddressBook.IOService.DB_IO);
        Assert.assertEquals(5, contacts.size());
    }

}
