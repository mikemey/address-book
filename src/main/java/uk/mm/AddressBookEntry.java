package uk.mm;

import com.google.common.base.Splitter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

public class AddressBookEntry {
    private static final Splitter addressLineSplitter = Splitter.on(",").trimResults();
    private static final DateTimeFormatter dtFormatter = new DateTimeFormatterBuilder()
            .appendPattern("dd/MM/")
            .appendValueReduced(ChronoField.YEAR, 2, 2, 1920)
            .toFormatter();

    public enum SEX {
        MALE, FEMALE
    }

    private final String name;
    private final SEX sex;
    private final LocalDate dob;

    public AddressBookEntry(String addressLine) {
        List<String> entryColumns = addressLineSplitter.splitToList(addressLine);
        name = entryColumns.get(0);
        sex = SEX.valueOf(entryColumns.get(1).toUpperCase());
        dob = LocalDate.parse(entryColumns.get(2), dtFormatter);
    }

    public String getName() {
        return name;
    }

    public SEX getSex() {
        return sex;
    }

    public LocalDate getDob() {
        return dob;
    }
}
