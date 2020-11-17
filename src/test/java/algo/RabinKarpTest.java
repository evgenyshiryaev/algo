package algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RabinKarpTest {

    @Test
    public void findTest() {
        Assertions.assertEquals(0, RabinKarp.find("dummy", ""));
        Assertions.assertEquals(0, RabinKarp.find("dummy", "dum"));
        Assertions.assertEquals(1, RabinKarp.find("dummy", "um"));
        Assertions.assertEquals(-1, RabinKarp.find("dummy", "umy"));

        Assertions.assertEquals(3, RabinKarp.find("SuperLongString", "erLo"));
        Assertions.assertEquals(6, RabinKarp.find("SuperLongString", "ong"));
        Assertions.assertEquals(-1, RabinKarp.find("SuperLongString", "long"));
    }

}
