package algo.ds.segmenttree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SegmentTree1dTest {

    private static final int[] ARRAY = new int[] {1, 3, -2, 8, -7};

    @Test
    public void sumTest() {
        SegmentTree1d tree = new SegmentTree1d(SegmentTree1d.Type.SUM, ARRAY);

        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(-2, tree.calc(2, 2));
        Assertions.assertEquals(-7, tree.calc(4, 4));
        Assertions.assertEquals(4, tree.calc(0, 1));
        Assertions.assertEquals(1, tree.calc(1, 2));
        Assertions.assertEquals(9, tree.calc(1, 3));
        Assertions.assertEquals(3, tree.calc(0, 4));

        tree.update(2, -5);

        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(-5, tree.calc(2, 2));
        Assertions.assertEquals(-7, tree.calc(4, 4));
        Assertions.assertEquals(4, tree.calc(0, 1));
        Assertions.assertEquals(-2, tree.calc(1, 2));
        Assertions.assertEquals(6, tree.calc(1, 3));
        Assertions.assertEquals(0, tree.calc(0, 4));
    }


    @Test
    public void minTest() {
        SegmentTree1d tree = new SegmentTree1d(SegmentTree1d.Type.MIN, ARRAY);

        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(1, tree.calc(0, 1));
        Assertions.assertEquals(-2, tree.calc(0, 2));
        Assertions.assertEquals(-2, tree.calc(0, 3));
        Assertions.assertEquals(-7, tree.calc(0, 4));
        Assertions.assertEquals(-2, tree.calc(1, 3));
        Assertions.assertEquals(-7, tree.calc(2, 4));

        tree.update(1, 0);
        tree.update(3, -3);

        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(0, tree.calc(0, 1));
        Assertions.assertEquals(-2, tree.calc(0, 2));
        Assertions.assertEquals(-3, tree.calc(0, 3));
        Assertions.assertEquals(-7, tree.calc(0, 4));
        Assertions.assertEquals(-3, tree.calc(1, 3));
        Assertions.assertEquals(-7, tree.calc(2, 4));
    }


    @Test
    public void maxTest() {
        SegmentTree1d tree = new SegmentTree1d(SegmentTree1d.Type.MAX, ARRAY);

        Assertions.assertEquals(1, tree.calc(0, 0));
        Assertions.assertEquals(3, tree.calc(0, 1));
        Assertions.assertEquals(3, tree.calc(0, 2));
        Assertions.assertEquals(8, tree.calc(0, 3));
        Assertions.assertEquals(8, tree.calc(0, 4));
        Assertions.assertEquals(8, tree.calc(1, 3));
        Assertions.assertEquals(8, tree.calc(2, 4));

        tree.update(0, 4);
        tree.update(4, 10);

        Assertions.assertEquals(4, tree.calc(0, 0));
        Assertions.assertEquals(4, tree.calc(0, 1));
        Assertions.assertEquals(4, tree.calc(0, 2));
        Assertions.assertEquals(8, tree.calc(0, 3));
        Assertions.assertEquals(10, tree.calc(0, 4));
        Assertions.assertEquals(8, tree.calc(1, 3));
        Assertions.assertEquals(10, tree.calc(2, 4));
    }

}
