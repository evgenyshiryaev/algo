package algo.algebra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class BinomTest {

    @Test
    public void cTest() {
        Assertions.assertEquals(1, Binom.c(1, 0));
        Assertions.assertEquals(1, Binom.c(1, 1));

        Assertions.assertEquals(1, Binom.c(2, 0));
        Assertions.assertEquals(2, Binom.c(2, 1));
        Assertions.assertEquals(1, Binom.c(2, 2));

        Assertions.assertEquals(1, Binom.c(3, 0));
        Assertions.assertEquals(3, Binom.c(3, 1));
        Assertions.assertEquals(3, Binom.c(3, 2));
        Assertions.assertEquals(1, Binom.c(3, 3));
    }


    @Test
    public void fastCTest() {
        Assertions.assertEquals(1, Binom.fastC(1, 0));
        Assertions.assertEquals(1, Binom.fastC(1, 1));

        Assertions.assertEquals(1, Binom.fastC(2, 0));
        Assertions.assertEquals(2, Binom.fastC(2, 1));
        Assertions.assertEquals(1, Binom.fastC(2, 2));

        Assertions.assertEquals(1, Binom.fastC(3, 0));
        Assertions.assertEquals(3, Binom.fastC(3, 1));
        Assertions.assertEquals(3, Binom.fastC(3, 2));
        Assertions.assertEquals(1, Binom.fastC(3, 3));
    }

}
