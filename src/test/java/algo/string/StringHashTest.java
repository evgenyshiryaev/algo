package algo.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringHashTest {

    @Test
    public void polynomialRollingHashTest() {
        char[] s = "fkanr".toCharArray();

        int hash0 = StringHash.polynomialRollingHash(s, 0, 3);

        int hash1 = StringHash.polynomialRollingHash(hash0, 'f', 'n');
        Assertions.assertEquals(StringHash.polynomialRollingHash(s, 1, 4), hash1);

        int hash2 = StringHash.polynomialRollingHash(hash1, 'k', 'r');
        Assertions.assertEquals(StringHash.polynomialRollingHash(s, 2, 5), hash2);
    }

}
