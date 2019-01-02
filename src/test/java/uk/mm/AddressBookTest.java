package uk.mm;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AddressBookTest {
    private static AddressBook addressBook;
    private static final String ADDRESS_BOOK_FILE = "src/main/resources/AddressBook";

    @BeforeClass
    public static void setupAddressBook() throws Exception {
        addressBook = new AddressBook(ADDRESS_BOOK_FILE);
    }

    @Test
    public void testCountMales() {
        assertEquals(addressBook.countSex(AddressBook.SEX.MALE), 3);
    }

//    @Test
//    public void testFindOldestPerson() {
//    }
//
//    @Test
//    public void testDaysBetweenPersons() {
//    }
}
