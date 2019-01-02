package uk.mm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

    public Long countDaysBetween(String nameA, String nameB) {
        Optional<AddressBookEntry> personA = findPerson(nameA);
        Optional<AddressBookEntry> personB = findPerson(nameB);

        LocalDate dobA = personA.get().getDob();
        LocalDate dobB = personB.get().getDob();

        return ChronoUnit.DAYS.between(dobA, dobB);
    }

    private Optional<AddressBookEntry> findPerson(String name) {
        return addresses.stream()
                .filter(person -> person.getName().equals(name))
                .findFirst();
    }
}
