package algo.ds.fenwicktree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FenwickTree1dMinTest {

    @Test
    public void test() {
        FenwickTree1dMin t = new FenwickTree1dMin();

        int[] a = new int[] {1, 3, -2, 8, -7};
        t.build(a);

        Assertions.assertEquals(1, t.min(0));
        Assertions.assertEquals(1, t.min(1));
        Assertions.assertEquals(-2, t.min(2));
        Assertions.assertEquals(-2, t.min(3));
        Assertions.assertEquals(-7, t.min(4));

        t.update(1, 0);
        t.update(3, -3);

        Assertions.assertEquals(1, t.min(0));
        Assertions.assertEquals(0, t.min(1));
        Assertions.assertEquals(-2, t.min(2));
        Assertions.assertEquals(-3, t.min(3));
        Assertions.assertEquals(-7, t.min(4));
    }

}
