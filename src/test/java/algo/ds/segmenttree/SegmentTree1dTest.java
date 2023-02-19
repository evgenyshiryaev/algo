package algo.ds.segmenttree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SegmentTree1dTest {

    private static final int[] ARRAY = new int[] {1, 3, -2, 8, -7};

    @Test
    public void sumTest() {
        SegmentTree1d tree = new SegmentTree1d(SegmentTree1d.Type.SUM, ARRAY);

        // [1, 3, -2, 8, -7]
        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(-2, tree.calc(2, 2));
        Assertions.assertEquals(-7, tree.calc(4, 4));
        Assertions.assertEquals(4, tree.calc(0, 1));
        Assertions.assertEquals(1, tree.calc(1, 2));
        Assertions.assertEquals(9, tree.calc(1, 3));
        Assertions.assertEquals(3, tree.calc(0, 4));

        tree.update(2, -3);

        // [1, 3, -5, 8, -7]
        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(-5, tree.calc(2, 2));
        Assertions.assertEquals(-7, tree.calc(4, 4));
        Assertions.assertEquals(4, tree.calc(0, 1));
        Assertions.assertEquals(-2, tree.calc(1, 2));
        Assertions.assertEquals(6, tree.calc(1, 3));
        Assertions.assertEquals(0, tree.calc(0, 4));

        tree.update(1, 3, -2);

        // [1, 1, -7, 6, -7]
        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(-7, tree.calc(2, 2));
        Assertions.assertEquals(-7, tree.calc(4, 4));
        Assertions.assertEquals(2, tree.calc(0, 1));
        Assertions.assertEquals(-6, tree.calc(1, 2));
        Assertions.assertEquals(0, tree.calc(1, 3));
        Assertions.assertEquals(-6, tree.calc(0, 4));
    }


    @Test
    public void minTest() {
        SegmentTree1d tree = new SegmentTree1d(SegmentTree1d.Type.MIN, ARRAY);

        // [1, 3, -2, 8, -7]
        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(1, tree.calc(0, 1));
        Assertions.assertEquals(-2, tree.calc(0, 2));
        Assertions.assertEquals(-2, tree.calc(0, 3));
        Assertions.assertEquals(-7, tree.calc(0, 4));
        Assertions.assertEquals(-2, tree.calc(1, 3));
        Assertions.assertEquals(-7, tree.calc(2, 4));

        tree.update(1, -3);
        tree.update(3, -11);

        // [1, 0, -2, -3, -7]
        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(0, tree.calc(0, 1));
        Assertions.assertEquals(-2, tree.calc(0, 2));
        Assertions.assertEquals(-3, tree.calc(0, 3));
        Assertions.assertEquals(-7, tree.calc(0, 4));
        Assertions.assertEquals(-3, tree.calc(1, 3));
        Assertions.assertEquals(-7, tree.calc(2, 4));

        tree.update(0, 2, -6);

        // [-5, -6, -8, -3, -7]
        Assertions.assertEquals(-5, tree.calc(0, 0));
        Assertions.assertEquals(-6, tree.calc(0, 1));
        Assertions.assertEquals(-8, tree.calc(0, 2));
        Assertions.assertEquals(-8, tree.calc(0, 3));
        Assertions.assertEquals(-8, tree.calc(0, 4));
        Assertions.assertEquals(-8, tree.calc(1, 3));
        Assertions.assertEquals(-8, tree.calc(2, 4));
        Assertions.assertEquals(-7, tree.calc(3, 4));
    }


    @Test
    public void maxTest() {
        SegmentTree1d tree = new SegmentTree1d(SegmentTree1d.Type.MAX, ARRAY);

        // [1, 3, -2, 8, -7]
        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(3, tree.calc(0, 1));
        Assertions.assertEquals(3, tree.calc(0, 2));
        Assertions.assertEquals(8, tree.calc(0, 3));
        Assertions.assertEquals(8, tree.calc(0, 4));
        Assertions.assertEquals(8, tree.calc(1, 3));
        Assertions.assertEquals(8, tree.calc(2, 4));

        tree.update(0, 3);
        tree.update(4, 17);

        // [4, 3, -2, 8, 10]
        Assertions.assertEquals(4, tree.calc(0, 0));
        Assertions.assertEquals(4, tree.calc(0, 1));
        Assertions.assertEquals(4, tree.calc(0, 2));
        Assertions.assertEquals(8, tree.calc(0, 3));
        Assertions.assertEquals(10, tree.calc(0, 4));
        Assertions.assertEquals(8, tree.calc(1, 3));
        Assertions.assertEquals(10, tree.calc(2, 4));

        tree.update(1, 4, 2);

        // [4, 5, 0, 10, 12]
        Assertions.assertEquals(4, tree.calc(0, 0));
        Assertions.assertEquals(5, tree.calc(0, 1));
        Assertions.assertEquals(5, tree.calc(0, 2));
        Assertions.assertEquals(10, tree.calc(0, 3));
        Assertions.assertEquals(12, tree.calc(0, 4));
        Assertions.assertEquals(10, tree.calc(1, 3));
        Assertions.assertEquals(12, tree.calc(2, 4));
    }

}
