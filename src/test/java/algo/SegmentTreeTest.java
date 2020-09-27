package algo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SegmentTreeTest {

    @Test
    public void test() {
        SegmentTree t = new SegmentTree();

        int[] a = new int[] {1, 3, -2, 8, -7};
        t.build(a);

        Assertions.assertEquals(1, t.sum(0, 0));
        Assertions.assertEquals(-2, t.sum(2, 2));
        Assertions.assertEquals(-7, t.sum(4, 4));
        Assertions.assertEquals(4, t.sum(0, 1));
        Assertions.assertEquals(1, t.sum(1, 2));
        Assertions.assertEquals(9, t.sum(1, 3));
        Assertions.assertEquals(3, t.sum(0, 4));

        t.update(2, -5);

        Assertions.assertEquals(1, t.sum(0, 0));
        Assertions.assertEquals(-5, t.sum(2, 2));
        Assertions.assertEquals(-7, t.sum(4, 4));
        Assertions.assertEquals(4, t.sum(0, 1));
        Assertions.assertEquals(-2, t.sum(1, 2));
        Assertions.assertEquals(6, t.sum(1, 3));
        Assertions.assertEquals(0, t.sum(0, 4));
    }

}
