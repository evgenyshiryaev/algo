package algo.algebra;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EratosthenesTest {

    @Test
    public void getPrimesTest() {
        Assertions.assertEquals(Arrays.asList(), Eratosthenes.getPrimes(1));
        Assertions.assertEquals(Arrays.asList(2), Eratosthenes.getPrimes(2));
        Assertions.assertEquals(Arrays.asList(2, 3), Eratosthenes.getPrimes(3));
        Assertions.assertEquals(Arrays.asList(2, 3, 5, 7), Eratosthenes.getPrimes(10));
        Assertions.assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19), Eratosthenes.getPrimes(20));
    }

}
