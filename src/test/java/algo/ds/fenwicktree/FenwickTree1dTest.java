package algo.ds.fenwicktree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FenwickTree1dTest {

    private static final int[] ARRAY = new int[] {1, 3, -2, 8, -7};


    @Test
    public void sumTest() {
        FenwickTree1d tree = new FenwickTree1d(FenwickTree1d.Type.SUM, ARRAY);

        Assertions.assertEquals(1, tree.sum(0, 0));
        Assertions.assertEquals(-2, tree.sum(2, 2));
        Assertions.assertEquals(-7, tree.sum(4, 4));
        Assertions.assertEquals(4, tree.sum(0, 1));
        Assertions.assertEquals(1, tree.sum(1, 2));
        Assertions.assertEquals(9, tree.sum(1, 3));
        Assertions.assertEquals(3, tree.sum(0, 4));

        tree.update(2, -3);

        Assertions.assertEquals(1, tree.sum(0, 0));
        Assertions.assertEquals(-5, tree.sum(2, 2));
        Assertions.assertEquals(-7, tree.sum(4, 4));
        Assertions.assertEquals(4, tree.sum(0, 1));
        Assertions.assertEquals(-2, tree.sum(1, 2));
        Assertions.assertEquals(6, tree.sum(1, 3));
        Assertions.assertEquals(0, tree.sum(0, 4));
    }


    @Test
    public void minTest() {
        FenwickTree1d t = new FenwickTree1d(FenwickTree1d.Type.MIN, ARRAY);

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


    @Test
    public void maxTest() {
        FenwickTree1d t = new FenwickTree1d(FenwickTree1d.Type.MAX, ARRAY);

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
