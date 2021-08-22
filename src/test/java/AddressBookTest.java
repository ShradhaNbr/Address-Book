import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AddressBookTest {
    AddressBook addressBook ;

    @Before
    public void setUp() throws Exception {
        addressBook = new AddressBook();
    }
    /**
     * Purpose : To test whether the number of records present in the database matches with the expected value
     */
    @Test
    public void givenAddressBookInDB_WhenRetrieved_ShouldMatchContact() {
        List<Contact> contacts = addressBook.readPersonInfoData(AddressBook.IOService.DB_IO);
        Assertions.assertEquals(5, contacts.size());
    }
    /**
     * Purpose : To test whether when address is updated in db it should sync
     */
    @Test
    public void givenNewAddressForContact_WhenUpdated_ShouldSyncWithDB() {
        addressBook.readPersonInfoData(AddressBook.IOService.DB_IO);
        addressBook.updateContact("Shradha","Abc");
        boolean result = addressBook.checkPersonInfoInSyncWithDB("Shradha");
        Assertions.assertTrue(result);
    }
}
