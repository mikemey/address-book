package uk.mm;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;

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

    public Optional<Long> countDaysBetween(String nameA, String nameB) {
        Optional<AddressBookEntry> personA = findPerson(nameA);
        Optional<AddressBookEntry> personB = findPerson(nameB);

        if (personA.isPresent() && personB.isPresent()) {
            LocalDate dobA = personA.get().getDob();
            LocalDate dobB = personB.get().getDob();

            return Optional.of(DAYS.between(dobA, dobB));
        }
        return Optional.empty();
    }

    private Optional<AddressBookEntry> findPerson(String name) {
        return addresses.stream()
                .filter(person -> person.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
