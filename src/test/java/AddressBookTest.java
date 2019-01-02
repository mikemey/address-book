import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AddressBookTest {

    @Test
    public void testRunning() {
        assertNotNull(new AddressBook());
    }
}
