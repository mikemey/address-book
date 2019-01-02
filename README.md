# address-book

- Build/Run:

Execute helper script `answerQuestios.sh` to execute program with default address-book file (from `src/main/resources`)

or manually:

```bash
mvn compile
mvn exec:java -q -Dexec.mainClass="uk.mm.AddressBookMain" -Dexec.args="src/main/resources/AddressBook"
```

- Assumptions:
   - only basic input validation (on address book file). No precaution taken when address book
   doesn't comply with specified format. Would discuss with story owner how to handle these situations 
   (ie not all columns present - should only the line be rejected or the whole address book), these
   exceptions should come up earlier during a story planning- or kick-off session.