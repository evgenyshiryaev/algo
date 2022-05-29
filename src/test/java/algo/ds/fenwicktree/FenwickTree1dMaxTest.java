package algo.ds.fenwicktree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FenwickTree1dMaxTest {

    @Test
    public void test() {
        FenwickTree1dMax t = new FenwickTree1dMax();

        int[] a = new int[] {1, 3, -2, 8, -7};
        t.build(a);

        Assertions.assertEquals(1, t.max(0));
        Assertions.assertEquals(3, t.max(1));
        Assertions.assertEquals(3, t.max(2));
        Assertions.assertEquals(8, t.max(3));
        Assertions.assertEquals(8, t.max(4));

        t.update(0, 4);
        t.update(4, 10);

        Assertions.assertEquals(4, t.max(0));
        Assertions.assertEquals(4, t.max(1));
        Assertions.assertEquals(4, t.max(2));
        Assertions.assertEquals(8, t.max(3));
        Assertions.assertEquals(10, t.max(4));
    }

}
