package uk.mm;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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

    public Optional<String> getOldestPersonName() {
        return addresses.stream()
                .min(Comparator.comparing(AddressBookEntry::getDob))
                .map(AddressBookEntry::getName);
    }
}
