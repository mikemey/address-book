package uk.mm;

import java.io.IOException;
import java.util.List;

public class AddressBook {
    private static List<AddressBookEntry> addresses;

    public AddressBook(String addressBookFile) throws IOException {
        addresses = AddressBookParser.parse((addressBookFile));
    }

    public long countSex(AddressBookEntry.SEX sex) {
        return addresses.stream()
                .filter(entry -> entry.getSex() == sex)
                .count();
    }
}
