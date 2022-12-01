package algo.algebra;

import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EuclidTest {

    @Test
    public void gcdTest() {
        Assertions.assertEquals(1, Euclid.gcd(1, 1));
        Assertions.assertEquals(2, Euclid.gcd(2, 2));
        Assertions.assertEquals(3, Euclid.gcd(12, 9));
        Assertions.assertEquals(100, Euclid.gcd(100, 0));
        Assertions.assertEquals(1, Euclid.gcd(13, 7));
    }


    @Test
    public void lcmTest() {
        Assertions.assertEquals(1, Euclid.lcm(1, 1));
        Assertions.assertEquals(3, Euclid.lcm(3, 3));
        Assertions.assertEquals(10, Euclid.lcm(2, 5));
        Assertions.assertEquals(36, Euclid.lcm(12, 9));
    }


    @Test
    public void gcdExtTest() {
        AtomicInteger x = new AtomicInteger();
        AtomicInteger y = new AtomicInteger();

        Assertions.assertEquals(1, Euclid.gcdExt(1, 1, x, y));
        Assertions.assertEquals(1, x.get());
        Assertions.assertEquals(0, y.get());

        Assertions.assertEquals(2, Euclid.gcdExt(2, 2, x, y));
        Assertions.assertEquals(1, x.get());
        Assertions.assertEquals(0, y.get());

        Assertions.assertEquals(3, Euclid.gcdExt(12, 9, x, y));
        Assertions.assertEquals(1, x.get());
        Assertions.assertEquals(-1, y.get());

        Assertions.assertEquals(100, Euclid.gcdExt(100, 0, x, y));
        Assertions.assertEquals(1, x.get());
        Assertions.assertEquals(0, y.get());

        Assertions.assertEquals(1, Euclid.gcdExt(13, 7, x, y));
        Assertions.assertEquals(-1, x.get());
        Assertions.assertEquals(2, y.get());
    }


    @Test
    public void diophantineTest() {
        AtomicInteger x = new AtomicInteger();
        AtomicInteger y = new AtomicInteger();

        Assertions.assertTrue(Euclid.diophantine(100, x, -256, y, 36));
        Assertions.assertEquals(-207, x.get());
        Assertions.assertEquals(-81, y.get());

        Assertions.assertFalse(Euclid.diophantine(100, x, -256, y, 37));
    }

}
