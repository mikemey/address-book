package uk.mm;

import java.io.IOException;
import java.util.Optional;

import static org.apache.commons.lang3.ArrayUtils.isEmpty;

public class AddressBookMain {
    public static void main(String... args) throws IOException {
        if (isEmpty(args)) {
            System.out.println("Input file parameter required.");
        } else {
            String addressBookFile = args[0];
            AddressBook addressBook = new AddressBook(addressBookFile);
            long maleCount = addressBook.countSex(AddressBookEntry.SEX.MALE);
            Optional<String> oldestPerson = addressBook.getOldestPersonName();
            Optional<Long> daysBetween = addressBook.countDaysBetween("Bill McKnight", "Paul Robinson");

            System.out.printf("# of males: %s%n", maleCount);
            System.out.printf("Oldest person: %s%n", oldestPerson.get());
            System.out.printf("Days Bill is older than Paul: %s%n", daysBetween.get());
        }
    }
}
