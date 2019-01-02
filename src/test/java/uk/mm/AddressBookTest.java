package uk.mm;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Optional;

import static org.testng.Assert.assertEquals;

public class AddressBookTest {
    private static AddressBook addressBook;
    private static final String ADDRESS_BOOK_FILE = "src/main/resources/AddressBook";
    private static final String EMPTY_ADDRESS_BOOK_FILE = "src/test/resources/emptyAddressBook";

    @BeforeClass
    public static void setupAddressBook() throws Exception {
        addressBook = new AddressBook(ADDRESS_BOOK_FILE);
    }

    @Test
    public void testCountMales() {
        assertEquals(addressBook.countSex(AddressBookEntry.SEX.MALE), 3);
    }

    @Test
    public void testFindOldestPerson() {
        assertEquals(addressBook.getOldestPersonName(), Optional.of("Wes Jackson"));
    }

    @Test
    public void testFindOldestPerson_emptyAddressBook() throws IOException {
        AddressBook emptyAddressBook = new AddressBook(EMPTY_ADDRESS_BOOK_FILE);
        assertEquals(emptyAddressBook.getOldestPersonName(), Optional.empty());
    }

//    @Test
//    public void testDaysBetweenPersons() {
//    }
}
