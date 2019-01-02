package uk.mm;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AddressBookParser {
    public static List<AddressBookEntry> parse(String addressBookFile) throws IOException {
        try {
            Stream<String> abStream = Files.lines(Paths.get(addressBookFile));
            List<AddressBookEntry> addresses = abStream.map(AddressBookEntry::new).collect(toList());
            System.out.printf("Address book file loaded: %s%n", addressBookFile);
            return addresses;
        } catch (IOException ioe) {
            System.out.printf("Error reading file: %s%n", ioe.getMessage());
            throw ioe;
        }
    }
}
