package uk.mm;

import com.google.common.base.Splitter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AddressBook {
    private static List<AddressBookEntry> addresses;

    public AddressBook(String addressBookFile) throws IOException {
        try {
            Stream<String> abStream = Files.lines(Paths.get(addressBookFile));
            addresses = abStream.map(AddressBookEntry::new).collect(toList());
            System.out.printf("Address book file loaded: %s%n", addressBookFile);
        } catch (IOException ioe) {
            System.out.printf("Error reading file: %s%n", ioe.getMessage());
            throw ioe;
        }
    }

    public long countSex(SEX sex) {
        return addresses.stream()
                .filter(entry -> entry.sex == sex)
                .count();
    }

    public enum SEX {
        MALE, FEMALE
    }

    public class AddressBookEntry {
        private final Splitter addressLineSplitter = Splitter.on(",").trimResults();
        private final SEX sex;

        public AddressBookEntry(String addressLine) {
            List<String> entryColumns = addressLineSplitter.splitToList(addressLine);
            sex = SEX.valueOf(entryColumns.get(1).toUpperCase());
        }
    }
}
