package uk.mm;

import com.google.common.base.Splitter;

import java.util.List;

public class AddressBookEntry {
    public enum SEX {
        MALE, FEMALE
    }

    private final Splitter addressLineSplitter = Splitter.on(",").trimResults();
    private final SEX sex;

    public AddressBookEntry(String addressLine) {
        List<String> entryColumns = addressLineSplitter.splitToList(addressLine);
        sex = SEX.valueOf(entryColumns.get(1).toUpperCase());
    }

    public SEX getSex() {
        return sex;
    }
}
